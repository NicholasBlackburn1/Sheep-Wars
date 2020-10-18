package Sheep.Wars.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Sheep.Wars.*;

/**
 * This class is for handling Config Creation
 * 
 * @author nicholas Blackburn
 */
public class ConfigHandler {
    
    private Main plugin = Main.getPlugin(Main.class);

    private Map<String,Double> map = new HashMap<>();

    public FileConfiguration gamecfg;
    public FileConfiguration worldcfg;
    public File gameFile= new File(plugin.getDataFolder(), "gameConfig.yml");
    public File worldFile= new File(plugin.getDataFolder(), "worldConfig.yml");
    

    /// Creates file for config
    public void createConfig() {
       if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
       }
       if(!gameFile.exists()){
           try{
               gamecfg = YamlConfiguration.loadConfiguration(gameFile);
               worldcfg = YamlConfiguration.loadConfiguration(worldFile);

               gameFile.createNewFile();
               worldFile.createNewFile();
               addDefaults(gamecfg,worldcfg);

           } catch(IOException e){
               Main.log.severe(Main.loggerPreFix + "" + " Could not Create File!");
           }
       }
       gamecfg = YamlConfiguration.loadConfiguration(gameFile);
       Main.log.warning(Main.loggerPreFix + " Config Loaded!");

    }

    public void saveConfig(){
        try{
            gamecfg.save(gameFile);
        }catch(IOException e){
            Main.log.severe(Main.loggerPreFix + " CANNOT SAVE FILE");
        }
    }

    public FileConfiguration getConfig(){
        return gamecfg;
    }
    public FileConfiguration getWorldCofig(){
        return worldcfg;
    }

    private void addDefaults(FileConfiguration gameConfig, FileConfiguration worldConfig){
        Main.log.info(Main.loggerPreFix + " "+ " Adding Default Config");
        
        gameFile.setWritable(true);
        gameFile.setReadable(true);
        worldFile.setWritable(true);
        worldFile.setReadable(true);

        gameConfig.addDefault("database.user", "username");
        gameConfig.addDefault("database.pass", "pass");
        gameConfig.addDefault("database.ip", "ip");
        gameConfig.addDefault("database.port", 0);

        worldConfig.addDefault("Lobby.X", 0);
        worldConfig.addDefault("Lobby.Y", 0);
        worldConfig.addDefault("Lobby.Z", 0);

        map.put("Spawn.X", 0.0);
        map.put("Spawn.Y", 0.0);
        map.put("Spawn.Z", 0.0);

        for(int i = 0; i<=plugin.getServer().getMaxPlayers(); i++){
        worldConfig.createSection(Integer.toString(i), map);
        }
        Main.log.warning(Main.loggerPreFix + " "+ " Added Default Config");

        try {
            gameConfig.save(gameFile);
            worldConfig.save(worldFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
