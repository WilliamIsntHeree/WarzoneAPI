# WarzoneAPI
Simple Java API for [Warzone](https://github.com/Warzone) 



How to use:

Using this api is pretty simple.

```
WarzoneAPI api = new WarzoneAPI();

System.out.println(api.getWarzoneMatch(MATCHID)); 
```

Current Methods

```
getWarzoneMatch(MATCHID);
getWarzonePlayer(PLAYERNAME);
getServerStats();
getSeverData();
```
