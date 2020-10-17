package Sheep.Wars.arena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import Sheep.Wars.Main;

/** 
 * this class is for Creating the constructoe for our Arena for the miniGame.
 * @author Nicholas Blackbutn
 */
//TODO: Setup arena code 
public class Arena {

    private String name;
    private List<Player> players;
    private Location spawnPoint;
    private GameState state;

    enum GameState{
       SETUP, INGAME, STARTING, FINISHED;
    }

    public Arena(String name, Location spawnPoint){
        this.name = name;
        this.players = new ArrayList<Player>();
        this.spawnPoint = spawnPoint;
        this.state = GameState.STARTING;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        player.setHealth(20);
        player.setFoodLevel(20);
        this.players.add(player);
        Main.log.info(Main.loggerPreFix + " "+" Here is the Num of Players in The Arrena" + players.size());
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }

    public Location getSpawnPoint() {
        return spawnPoint;
    }

    public void setSpawnPoint(Location spawnPoint) {
        this.spawnPoint = spawnPoint;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

}
