package Sheep.Wars;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Sheep.Wars.arena.ArenaManager;
import Sheep.Wars.listeners.PlayerJoin;
import Sheep.Wars.util.ConfigHandler;
import kr.entree.spigradle.annotations.SpigotPlugin;

 
@SpigotPlugin
public class Main extends JavaPlugin{

    private static Main instance;
    public static Logger log = Bukkit.getLogger();
    public static String loggerPreFix = "[SheepWars]";
    private File configToml = new File(getDataFolder()+"/config.toml");
    private ConfigHandler config;
    private ArenaManager manager = new ArenaManager();

    // Runs When Plugin is Loading
    @Override
    public void onLoad() {
        log.severe(loggerPreFix + " IS LOADED\n");
        loadConfigManager();
    }

    // Runs When Plugin is Enabled
    @Override
    public void onEnable() {
        log.severe(loggerPreFix + " IS Enabled\n");
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        
    }

    // Runs When Plugin is Disabled
    @Override
    public void onDisable() {
        log.severe(loggerPreFix + " IS Diabled\n");
    }

    public void loadConfigManager(){
        config = new ConfigHandler();
        config.createConfig();
    }
    public static Main getInstance() {
        return instance;
    }

   
}
