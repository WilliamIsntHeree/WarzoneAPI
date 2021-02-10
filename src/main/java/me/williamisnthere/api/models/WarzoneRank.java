package me.williamisnthere.api.models;

import java.util.List;

public class WarzoneRank {

    private List<Object> permissions;
    private List<String> players;
    private String name;
    private String prefix;
    private boolean staff;
    private int priority;


    public WarzoneRank(List<Object> permissions, List<String> players, String name, String prefix, boolean staff, int priority) {
        this.permissions = permissions;
        this.players = players;
        this.name = name;
        this.prefix = prefix;
        this.staff = staff;
        this.priority = priority;
    }

    public List<Object> getPermissions() {
        return permissions;
    }

    public List<String> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isStaff() {
        return staff;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return "{rank=" + name
                + ",permissions=" + permissions
                + ",loadedPlayers=" + players
                + ",prefix=" + prefix
                + ",staff=" + staff
                + ",priority=" + priority +"}";
    }
}
