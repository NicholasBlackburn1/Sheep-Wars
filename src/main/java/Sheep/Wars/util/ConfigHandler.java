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

    private Map<String,Double> spawnMap = new HashMap<>();
    private Map<String,Double> lobbyspawnMap = new HashMap<>();
    private Map<String,Object> gameMap = new HashMap<>();

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

       

        lobbyspawnMap.put("X", 0.0);
        lobbyspawnMap.put("Y", 0.0);
        lobbyspawnMap.put("Z", 0.0);

        spawnMap.put("Spawn.X", 0.0);
        spawnMap.put("Spawn.Y", 0.0);
        spawnMap.put("Spawn.Z", 0.0);

        gameMap.put("database.user", "username");
        gameMap.put("database.pass", "pass");
        gameMap.put("database.ip", "ip");
        gameMap.put("database.port", 0);

        for(int i = 0; i<=plugin.getServer().getMaxPlayers(); i++){
            worldConfig.createSection("Lobby",lobbyspawnMap);
            worldConfig.createSection(Integer.toString(i), spawnMap);
            gameConfig.createSection("Database",gameMap);
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
