package me.williamisnthere.api.models;

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
}
