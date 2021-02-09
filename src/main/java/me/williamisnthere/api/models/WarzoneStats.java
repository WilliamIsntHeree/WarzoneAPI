package me.williamisnthere.api.models;

public class WarzoneStats {

    private int users;
    private int matches;
    private int deaths;
    private int maps;
    private int punishments;

    public WarzoneStats(int users, int matches, int deaths, int maps, int punishments) {
        this.users = users;
        this.matches = matches;
        this.deaths = deaths;
        this.maps = maps;
        this.punishments = punishments;
    }

    public int getUsers() {
        return users;
    }

    public int getMatches() {
        return matches;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getMaps() {
        return maps;
    }

    public int getPunishments() {
        return punishments;
    }
}
