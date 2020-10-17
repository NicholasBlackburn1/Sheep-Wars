package Sheep.Wars.arena;

import com.moandjiezana.toml.Toml;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import Sheep.Wars.arena.Arena.GameState;

/**
 * This class is for Manaing the Arena
 * @author Nicholas Blackburn 
 */
public class ArenaManager {
    
    private Arena arena;
    private Toml toml = new Toml();
    private int i;

    private void setPlayerSpawn(World world, Double x, Double y, Double z){
        Location location = new Location(world, x, y, z);
        arena = new Arena("Game", location);
    }

    public void arenaSetup(){
        for (i = 0; i<= Bukkit.getMaxPlayers(); i++){
            arena.addPlayer((Player)Bukkit.getOnlinePlayers().stream());
            setPlayerSpawn(Bukkit.getWorld("World"), toml.getDouble(i+"GameSpawnX"), toml.getDouble(i+"GameSpawnY"), toml.getDouble(i+"GameSpawnZ"));

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

            case FINISHED:
               
                break;
            default:
                break;
        }
    }
