package me.williamisnthere.api;

import me.williamisnthere.api.models.WarzonePlayer;

public class Test {

    public static void main(String[] args) throws Exception {

        WarzoneAPI api = new WarzoneAPI();

        System.out.println(api.getWarzoneRank("admin").toString());




    }
}
