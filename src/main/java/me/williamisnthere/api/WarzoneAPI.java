package me.williamisnthere.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import me.williamisnthere.api.models.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class WarzoneAPI {



        private final String apiurl;
        private final ObjectMapper mapper;
        public WarzoneAPI() {
                mapper = new ObjectMapper();
                this.apiurl = "https://api.warzone.network/";

                Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
                        @Override
                        public <T> T readValue(String s, Class<T> aClass) {
                                try {
                                        return mapper.readValue(s, aClass);
                                } catch (JsonProcessingException e) {
                                        e.printStackTrace();
                                }
                                return null;
                        }

                        @Override
                        public String writeValue(Object o) {
                                try {
                                        return mapper.writeValueAsString(o);
                                } catch (JsonProcessingException e) {
                                        e.printStackTrace();
                                }
                                return null;
                        }
                });
        }


        /**
         *
         * Get warzone players by NAME
         * @param name
         * @return WarzonePlayer
         * @throws Exception
         */
        public WarzonePlayer getWarzonePlayer(String name) throws Exception {

                URL url = new URL(this.apiurl + "mc/player/" + name);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int code = connection.getResponseCode();
                StringBuffer response = new StringBuffer();
                if (code == connection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream())
                        );
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                                response.append(inputLine);

                        }
                        reader.close();
                }
                JSONObject obj = new JSONObject(response.toString());

                JSONObject object = (JSONObject) obj.get("user");
                try {
                        String name2 = "";
                        String uuid = "";
                        String level = "";
                        Object activeTag = "";
                        int wins = 0;
                        int matches = 0 ;
                        int kills = 0 ;
                        int losses = 0 ;
                        int wool_destroyed = 0 ;
                        List<Object> tags = new ArrayList<>();

                        if(object.has("name")) {
                                name2 = object.getString("name");
                        }

                        if(object.has("uuid")) {
                                uuid = object.getString("uuid");
                        }
                        if(object.has("activeTag")) {
                                activeTag = object.get("activeTag");
                        }
                        if(object.has("wins")) {
                                wins = object.getInt("wins");
                        }
                        if(object.has("matches")) {
                                matches = object.getInt("matches");
                        }
                        if(object.has("kills")) {
                                kills = object.getInt("kills");
                        }
                        if(object.has("losses")) {

                                losses = object.getInt("losses");
                        }
                        if(object.has("wool_destroys")) {
                                wool_destroyed = object.getInt("wool_destroys");
                        }
                        if(object.has("tags")) {
                                tags = object.getJSONArray("tags").toList();
                        }

                        if(object.has("level")) {
                                level = String.valueOf(object.get("level"));
                        }




                        return new WarzonePlayer(name2, uuid, activeTag, tags, "", "", wins, wool_destroyed, kills, losses, matches, level);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return null;
        }


        /**
         * Get previous warzone match by ID
         *
         * @param matchID
         * @return WarzoneMatch
         * @throws Exception
         */
        public WarzoneMatch getWarzoneMatch(String matchID) throws Exception {
                URL url = new URL(this.apiurl + "mc/match/" + matchID);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int code = connection.getResponseCode();
                StringBuffer response = new StringBuffer();
                if (code == connection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream())
                        );
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                                response.append(inputLine);
                        }


                        reader.close();

                }

                JSONObject obj = new JSONObject(response.toString());
                JSONArray playersLoaded = (JSONArray) obj.get("playersLoaded");
                List<Object> loadedPlayers = playersLoaded.toList();
                JSONObject mapLoaded = (JSONObject) obj.get("mapLoaded");
                JSONArray authorsLoaded = (JSONArray) mapLoaded.get("authors");
                List<WarzonePlayer> players = new ArrayList<>();
                for(int i =0; i < loadedPlayers.size(); i++) {
                        JSONObject object = playersLoaded.getJSONObject(i);
                        String name2 = "";
                        String uuid = "";
                        String level = "";
                        Object activeTag = "";
                        int wins = 0;
                        int matches = 0 ;
                        int kills = 0 ;
                        int losses = 0 ;
                        int wool_destroyed = 0 ;
                        List<Object> tags = new ArrayList<>();

                        if(object.has("name")) {
                                name2 = object.getString("name");
                        }

                        if(object.has("uuid")) {
                                uuid = object.getString("uuid");
                        }
                        if(object.has("activeTag")) {
                                activeTag = object.get("activeTag");
                        }
                        if(object.has("wins")) {
                                wins = object.getInt("wins");
                        }
                        if(object.has("matches")) {
                                matches = object.getInt("matches");
                        }
                        if(object.has("kills")) {
                                kills = object.getInt("kills");
                        }
                        if(object.has("losses")) {

                                losses = object.getInt("losses");
                        }
                        if(object.has("wool_destroys")) {
                                wool_destroyed = object.getInt("wool_destroys");
                        }
                        if(object.has("tags")) {
                                tags = object.getJSONArray("tags").toList();
                        }

                        if(object.has("level")) {
                                level = String.valueOf(object.get("level"));
                        }


                        players.add(new WarzonePlayer(name2, uuid, activeTag, tags, "", "", wins, wool_destroyed, kills, losses, matches, level));
                }

                String gametype = mapLoaded.getString("gametype");
                String name = mapLoaded.getString("name");
                String version = mapLoaded.getString("version");

                List<Object> loadedAuthors = mapLoaded.getJSONArray("authors").toList();
                List<String> authornames = new ArrayList<>();

                for(int i =0; i < loadedAuthors.size(); i++) {
                        JSONObject object = authorsLoaded.getJSONObject(i);

                        String name2 = object.getString("username");
                        authornames.add(name2);
                }


                WarzoneMap map = new WarzoneMap(authornames, gametype, name, version);
                WarzoneMatch match = new WarzoneMatch(players, "none", map);
                return match;

        }

        /**
         * Get a warzone rank by name
         *
         * @param rank name
         * @return WarzoneRank
         * @throws Exception
         */
        public WarzoneRank getWarzoneRank(String rank) throws Exception {
                URL url = new URL(this.apiurl + "mc/rank/" + rank + "/players");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int code = connection.getResponseCode();
                StringBuffer response = new StringBuffer();
                if (code == connection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream())
                        );
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                                response.append(inputLine);
                        }


                        reader.close();

                }

                JSONObject obj = new JSONObject(response.toString());
                JSONObject object = (JSONObject) obj.get("rank");
                JSONArray users =  obj.getJSONArray("users");
                List<Object> u = users.toList();
                List<Object> permissions = object.getJSONArray("permissions").toList();
                List<String> names = new ArrayList<>();
                for(int i =0; i < u.size(); i++) {
                        JSONObject object2 = users.getJSONObject(i);
                        String name2 = object2.getString("name");
                        names.add(name2);
                }
                return new WarzoneRank(permissions, names, object.getString("name"), object.getString("prefix"), object.getBoolean("staff"), object.getInt("priority"));
        }

        /**
         *
         * Get the warzone leaderboard
         * @param aspect (XP/WINS/KILLS/LOSSES)
         * @return WarzoneLeaderboard
         * @throws Exception
         */
        public WarzoneLeaderboard getWarzoneLeaderboard(String aspect) throws Exception {
                        URL url = new URL(this.apiurl + "mc/leaderboard/" + aspect);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        int code = connection.getResponseCode();
                        StringBuffer response = new StringBuffer();
                        if (code == connection.HTTP_OK) {
                                BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(connection.getInputStream())
                                );
                                String inputLine;
                                while ((inputLine = reader.readLine()) != null) {
                                        response.append(inputLine);
                                }


                                reader.close();

                        }

                        JSONArray obj = new JSONArray(response.toString());

                        List<WarzonePlayer> leaderboard = new ArrayList<>();
                        for(int i =0; i < obj.length(); i++) {
                                JSONObject object = (JSONObject) obj.get(i);
                                String name2 = "";
                                String uuid = "";
                                String level = "";
                                Object activeTag = "";
                                int wins = 0;
                                int matches = 0 ;
                                int kills = 0 ;
                                int losses = 0 ;
                                int wool_destroyed = 0 ;
                                List<Object> tags = new ArrayList<>();

                                if(object.has("name")) {
                                        name2 = object.getString("name");
                                }

                                if(object.has("uuid")) {
                                        uuid = object.getString("uuid");
                                }
                                if(object.has("activeTag")) {
                                        activeTag = object.get("activeTag");
                                }
                                if(object.has("wins")) {
                                        wins = object.getInt("wins");
                                }
                                if(object.has("matches")) {
                                        matches = object.getInt("matches");
                                }
                                if(object.has("kills")) {
                                        kills = object.getInt("kills");
                                }
                                if(object.has("losses")) {

                                        losses = object.getInt("losses");
                                }
                                if(object.has("wool_destroys")) {
                                        wool_destroyed = object.getInt("wool_destroys");
                                }
                                if(object.has("tags")) {
                                        tags = object.getJSONArray("tags").toList();
                                }

                                if(object.has("level")) {
                                        level = String.valueOf(object.get("level"));
                                }

                                leaderboard.add(new WarzonePlayer(name2, uuid, activeTag, tags, "", "", wins, wool_destroyed, kills, losses, matches, level));
                        }



                return new WarzoneLeaderboard(leaderboard, aspect);
        }

        /**
         *  Get warzone Sever Stats
         *
         * @return WarzoneStats
         * @throws Exception
         */
        public WarzoneStats getServerStats() throws Exception {
                URL url = new URL(this.apiurl + "mc/stats");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int code = connection.getResponseCode();
                StringBuffer response = new StringBuffer();
                if (code == connection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream())
                        );
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                                response.append(inputLine);
                        }


                        reader.close();

                }

                JSONObject obj = new JSONObject(response.toString());


                int users = obj.getInt("users");
                int matches = obj.getInt("matches");
                int deaths = obj.getInt("deaths");
                int maps = obj.getInt("maps");
                int punishments = obj.getInt("punishments");
                return new WarzoneStats(users, matches, deaths, maps, punishments);
        }


        /**
         * Get warzone server heartbeat
         *
         * @return WarzoneServer
         * @throws Exception
         */
        public WarzoneServer getServerData() throws Exception{
                URL url = new URL(this.apiurl + "mc/server/warzone");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int code = connection.getResponseCode();
                StringBuffer response = new StringBuffer();
                if (code == connection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream())
                        );
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                                response.append(inputLine);
                        }


                        reader.close();


                }

                JSONObject obj = new JSONObject(response.toString());


                WarzoneServer data = new WarzoneServer(
                        obj.getString("motd"),
                        obj.getString("name"),
                        obj.getInt("playerCount"),
                        obj.getInt("spectatorCount"),
                        obj.getInt("maxPlayers"),
                        obj.getString("map"),
                        obj.getString("gametype"));

                return data;
        }


        //TODO - Add at a later date. Should return players latest match
        public WarzoneMatch getLatestMatchForPlayer(String name) {
                return null;
        }

}
