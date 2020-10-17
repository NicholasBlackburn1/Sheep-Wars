package Sheep.Wars.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Sheep.Wars.Main;

/**
 * this is an Player Join Lisener
 * 
 * @author Nicholas Blackburn
 */
public class PlayerJoin implements Listener{

    
    //Handles player joining the game
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){

        if(Bukkit.getOnlinePlayers().toArray().length < Bukkit.getMaxPlayers()){

        }

        if(Bukkit.getOnlinePlayers().toArray().length > Bukkit.getMaxPlayers()){

        }

        if(Bukkit.getOnlinePlayers().toArray().length == Bukkit.getMaxPlayers()){

        }

    }

    // Handle Player Leaving the game 
    @EventHandler
    public void playerLeaves(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getName()+ChatColor.RED+"DISCONNECTED");
        Main.log.warning(Main.loggerPreFix + " "+ event.getPlayer().getPlayerListName() + " " + "Dissconnected Game" + " " + "Has 10 sec to Rejoin");
    }

    // removes idle people from the game
    @EventHandler
    public void playerKick(PlayerKickEvent event){
     Bukkit.broadcastMessage( ChatColor.GREEN + event.getPlayer().getDisplayName()+ ChatColor.YELLOW +"Was Kicked for" + "  " + ChatColor.RED +event.getReason());
    }

    /**
     * Handles Player Death to throw person into spectator
     * @param event
     * @param entity
     */
    //TODO: add Check to see if the Sheep is still alive and not dead to see if players can respawn
    @EventHandler
    public void playerDamage(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();

        if(entity instanceof Player) {
            Player player = (Player)entity;

            Main.log.warning(Main.loggerPreFix + "Players heath"+player.getHealth() +player.getName());

            if(player.getHealth() <= 2.5){
                Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() +"  "+ ChatColor.YELLOW + "DeathMessage" +"  "+ChatColor.RED + event.getDamager().getName());
                player.setHealth(12);
                player.setGameMode(GameMode.SPECTATOR);
                Main.log.warning(Main.loggerPreFix+" "+player.getName() + " "+ player.getGameMode().toString());
            }
            else{
                Main.log.warning(Main.loggerPreFix+" "+player.getName()+ "IS not dead but hurt\n");
                
            }
            
        }
       
    }
    
}
