package me.williamisnthere.api.models;


import java.util.List;

public class WarzoneMap {

    private List<String> authors;
    private String gametype;
    private String mapname;
    private String version;

    public WarzoneMap(List<String> authors, String gametype, String mapname, String version) {
        this.authors = authors;
        this.gametype = gametype;
        this.mapname = mapname;
        this.version = version;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getGametype() {
        return gametype;
    }

    public String getMapname() {
        return mapname;
    }

    public String getVersion() {
        return version;
    }

    public String toString() {
        return "{authors=" + authors
                +", gametype=" + gametype
                + ", map=" + mapname
                + ", version=" + version + "}";
    }
}
