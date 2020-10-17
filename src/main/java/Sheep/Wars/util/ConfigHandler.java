package Sheep.Wars.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.simpleyaml.configuration.file.YamlFile;
import Sheep.Wars.*;

/**
 * This class is for handling Config Creation
 * @author nicholas Blackburn
 */
public class ConfigHandler {
   
    private static Map<String,Double> WorldData = new HashMap<>();
    private int i;

    // This creates Yaml Config for Plugin
    public void createConfig(){
        YamlFile configYaml = new YamlFile(configFile);

        if(!configYaml.exists()){

        Main.log.warning(Main.loggerPreFix+ " Creating Config");

        WorldData.put("x", 0.0);
        WorldData.put("y", 0.0);
        WorldData.put("z", 0.0);
        
        configYaml.setComment("Teams", "Team color Selection");

        configYaml.addDefault("Team1", "Red");
        configYaml.addDefault("Team2", "Greem");
        configYaml.addDefault("Team3", "blue");
        configYaml.addDefault("Team4", "yello");
        configYaml.addDefault("Team5", "orange");
        configYaml.addDefault("Team6", "cyan");

        for(i=0; i<= 10; i++){
            configYaml.createSection(Integer.toString(i), WorldData);
        }
        // Finally, save changes!
        try {
            configYaml.save();
            // If your file has comments inside you have to save it with yamlFile.saveWithComments()
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    }

}
