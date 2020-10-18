package Sheep.Wars.arena;

import java.util.ArrayList;

import com.moandjiezana.toml.Toml;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import Sheep.Wars.Main;
import Sheep.Wars.arena.Arena.GameState;

/**
 * This class is for Manaing the Arena
 * @author Nicholas Blackburn 
 */
public class ArenaManager {
    
    private Arena arena;
    //private Main plugin = Main.getPlugin(Main.class);

    private ArrayList<Arena> arenas = new ArrayList<>();
    private int i;


    public ArenaManager(){
        
    }
    private void setPlayerSpawn(World world, Double x, Double y, Double z){
        Location location = new Location(world, x, y, z);
        arena = new Arena("Game", location);
    }

    // Sets up arena for Minigame
    private void arenaSetup(){
        Main.log.warning(Main.loggerPreFix + " "+ "Setting Up Arena");
        for (i = 0; i<= Bukkit.getMaxPlayers(); i++){
            arena.addPlayer((Player)Bukkit.getOnlinePlayers().stream());
          //  setPlayerSpawn(Bukkit.getWorld("World"),, plugin..getDouble(i+"GameSpawnY"), toml.getDouble(i+"GameSpawnZ"));

        }
    }



//TODO: Work out Switch and all the fucntions thar eun into 
    public void runArena(){
        arena.setState(GameState.SETUP);

        switch (arena.getState()) {
            case SETUP:
                arenaSetup();
                break;

            case STARTING:
                arenaSetup();
                break;
            case INGAME:
               
                break;

            case DEATHMATCH:
               
                break;
            case FINISHED:
               
                break;
            default:
                break;
        }
    }
}
