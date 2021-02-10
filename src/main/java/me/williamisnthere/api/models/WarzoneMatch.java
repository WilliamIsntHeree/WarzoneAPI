package me.williamisnthere.api.models;

import java.util.ArrayList;
import java.util.List;

public class WarzoneMatch {

    private List<WarzonePlayer> playersLoaded;
    private String winningteam;
    private WarzoneMap map;

    public WarzoneMatch(List<WarzonePlayer> playersLoaded, String winningteam, WarzoneMap map) {
        this.playersLoaded = playersLoaded;
        this.winningteam = winningteam;
        this.map = map;
    }

    public List<WarzonePlayer> getPlayersLoaded() {
        return playersLoaded;
    }

    public String getWinningteam() {
        return winningteam;
    }

    public WarzoneMap getMap() {
        return map;
    }

    public String toString() {
        List<String> names = new ArrayList<>();
        playersLoaded.forEach(r -> names.add(r.getName()));
        return "{playersLoaded=" + names
                +", winningTeam=" + winningteam
                + ", map=" + map.getMapname() + "}";
    }
}
