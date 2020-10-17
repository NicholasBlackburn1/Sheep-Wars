package Sheep.Wars;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Sheep.Wars.listeners.PlayerJoin;
import Sheep.Wars.util.ConfigHandler;
import kr.entree.spigradle.annotations.SpigotPlugin;

 
@SpigotPlugin
public class Main extends JavaPlugin{
    public static 
    public static Logger log = Bukkit.getLogger();
    public static String loggerPreFix = "[SheepWars]";
    private ConfigHandler config = new ConfigHandler();

    
    // Runs When Plugin is Loading
    @Override
    public void onLoad(){
        log.severe(loggerPreFix+" IS LOADED\n");
        config.createConfig();
        
    }

    //Runs When Plugin is Enabled
    @Override
    public void onEnable(){
        log.severe(loggerPreFix+" IS Enabled\n");
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
    
    }

    // Runs When Plugin is Disabled
    @Override 
    public void onDisable(){
        log.severe(loggerPreFix+" IS Diabled\n");
    }
}
