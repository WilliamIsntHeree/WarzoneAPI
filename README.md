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
getWarzoneLeaderboard(VALUE);
getWarzoneRank(NAME);

```
Example Response (Rank)

```
{rank=admin,permissions=[nocheatplus.notify, wz.bypasskick],loadedPlayers=[JorgeberrexMC, BennyDoesStuff, Sqyid],prefix=&c&lADMIN,staff=true,priority=100}
```

Note: I'm terrible at coding and this is in no way good. 
