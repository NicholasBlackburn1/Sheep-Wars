package Sheep.Wars.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * this is an Player Join Lisener
 * 
 * @author Nicholas Blackburn
 */
public class PlayerJoin implements Listener{
    
    //Handles player joining the game
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){

    }

    // Handle Player Leaving the game 
    @EventHandler
    public void playerLeaves(PlayerQuitEvent event){

    }

    // removes idle people from the game
    @EventHandler
    public void playerKick(PlayerKickEvent event){

    }

    @EventHandler
    public void playerDamage(EntityDamageEvent event, Entity entity){
        entity = event.getEntity();
        
        if(entity instanceof Player) {
            Player player = (Player)entity;
            
        }
       
    }
}
