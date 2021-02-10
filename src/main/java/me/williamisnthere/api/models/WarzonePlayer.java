package me.williamisnthere.api.models;

import java.util.List;
import java.util.Locale;

public class WarzonePlayer {

    private String name;
    private String uuid;
    private Object activeTag;
    private int wins;
    private int matches;
    private int kills;
    private int losses;
    private int wool_destroys;
    private List<Object> tags;
    private String initialJoinDate;
    private String lastOnlineDate;
    private int lvl;

    public WarzonePlayer(String name,
                         String uuid,
                         Object activeTag,
                         List<Object> tags,
                         String initialJoinDate,
                         String lastOnlineDate,
                         int wins,
                         int wool_destroys,
                         int kills,
                         int losses,
                         int matches,
                         String level) {


        this.name = name;
        this.uuid = uuid;
        this.activeTag = activeTag;
        this.wins = wins;
        this.matches = matches;
        this.kills = kills;
        this.losses = losses;
        this.wool_destroys = wool_destroys;
        this.tags = tags;
        this.initialJoinDate = initialJoinDate;
        this.lastOnlineDate = lastOnlineDate;
        this.lvl = Integer.parseInt(level);
    }




    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public Object getActiveTag() {
        return activeTag;
    }

    public int getWins() {
        return wins;
    }

    public int getMatches() {
        return matches;
    }

    public int getKills() {
        return kills;
    }

    public int getLosses() {
        return losses;
    }

    public int getWool_destroys() {
        return wool_destroys;
    }

    public List<Object> getTags() {
        return tags;
    }

    public int getLevel() {
        return lvl;
    }


    public String getNameLower() {
        return name.toLowerCase(Locale.ROOT);
    }

    public String toString() {
        return "{name=" + name
                + ",uuid=" + uuid
                + ",activeTag=" + activeTag
                + ",tags=" + tags
                +",wins=" + wins
                + ",kills=" + kills
                + ",wool_destroys=" + wool_destroys
                + ",wins=" + wins
                + ",losses=" + losses
                + ",level=" + lvl + "}";
    }





}
