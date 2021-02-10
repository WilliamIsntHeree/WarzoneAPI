package me.williamisnthere.api.models;

import java.util.ArrayList;
import java.util.List;

public class WarzoneLeaderboard {

    private List<WarzonePlayer> loadedPlayers;
    private String type;

    public WarzoneLeaderboard(List<WarzonePlayer> loadedPlayers, String type) {
        this.loadedPlayers = loadedPlayers;
        this.type = type;
    }

    public List<WarzonePlayer> getLoadedPlayers() {
        return loadedPlayers;
    }

    public String toString() {
        List<String> names = new ArrayList<>();
        loadedPlayers.forEach(r -> names.add(r.getName()));
        return "{playersLoaded=" + names + ",type=" +type + "}";
    }

    public String getType() {
        return type;
    }
}
