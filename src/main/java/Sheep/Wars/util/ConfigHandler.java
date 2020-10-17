package Sheep.Wars.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;


import Sheep.Wars.*;

/**
 * This class is for handling Config Creation
 * 
 * @author nicholas Blackburn
 */
public class ConfigHandler {
    
    private static Map<String, Object> data = new HashMap<>();
    private int i;

    // This creates Yaml Config for Plugin
    
    public void createConfig(File config) {
        TomlWriter tomlWriter = new TomlWriter.Builder().build();
        
        data.put("teams", 0);

        data.put("lobbySpawnX",0);
        data.put("lobbySpawnY",0);
        data.put("lobbySpawnZ",0);

        for(i=0; i<=Bukkit.getMaxPlayers(); i++){
            data.put(i+"GameSpawnX",0);
            data.put(i+"GameSpawnY",0);
            data.put(i+"GameSpawnZ",0);
        }
        Main.log.warning(Main.loggerPreFix + "MAp of Yoml "+ data.toString());    
        try {
            tomlWriter.write(data, config);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
