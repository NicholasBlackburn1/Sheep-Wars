package Sheep.Wars;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import kr.entree.spigradle.annotations.SpigotPlugin;
 
@SpigotPlugin
public class Main extends JavaPlugin{

    public static Logger log = Bukkit.getLogger();
    public static String loggerPreFix = "[SheepWars]";
    
    // Runs When Plugin is Loading
    @Override
    public void onLoad(){
        log.severe(loggerPreFix+"IS LOADED\n");
    }

    //Runs When Plugin is Enabled
    @Override
    public void onEnable(){
        log.severe(loggerPreFix+"IS Enabled\n");
    }

    // Runs When Plugin is Disabled
    @Override 
    public void onDisable(){
        log.severe(loggerPreFix+"IS Diabled\n");
    }
}
