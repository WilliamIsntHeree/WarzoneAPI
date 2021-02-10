package me.williamisnthere.api.models;

public class WarzoneServer {

    private String MOTD;
    private String name;
    private int playerCount;
    private int spectatorCount;
    private int maxPlayers;
    private String map;
    private String gametype;

    public WarzoneServer(String motd, String name, int playerCount, int spectatorCount, int maxPlayers, String map, String gametype) {
        MOTD = motd;
        this.name = name;
        this.playerCount = playerCount;
        this.spectatorCount = spectatorCount;
        this.maxPlayers = maxPlayers;
        this.map = map;
        this.gametype = gametype;
    }

    public String getMOTD() {
        return MOTD;
    }

    public String getName() {
        return name;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getSpectatorCount() {
        return spectatorCount;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getMap() {
        return map;
    }

    public String getGametype() {
        return gametype;
    }


    public String toString() {
        return "{MOTD=" + MOTD +
                ", playerCount=" + playerCount
                + ",spectatorCount=" + spectatorCount
                + ",gametype=" + gametype
                + ",map=" + map
                + ",name=" + name + "}";
    }
}
