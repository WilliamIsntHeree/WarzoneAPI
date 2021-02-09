package me.williamisnthere.api;

import me.williamisnthere.api.models.WarzonePlayer;

public class Test {

    public static void main(String[] args) throws Exception {

        WarzoneAPI api = new WarzoneAPI();

        System.out.println(api.getWarzoneMatch("5e99fb2a53e0d6002fd24d25").getMap().toString());




    }
}
