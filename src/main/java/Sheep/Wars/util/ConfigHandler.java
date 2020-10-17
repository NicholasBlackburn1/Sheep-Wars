package Sheep.Wars.util;

import java.io.File;
import java.util.HashMap;

import org.simpleyaml.configuration.file.YamlFile;
import Sheep.Wars.*;

/**
 * This class is for handling Config Creation
 * @author nicholas Blackburn
 */
public class ConfigHandler {
    private static File configFile = new File(Main.plugin.getDataFolder(),"Sheepwars.ymal");
    private HashMap<String,String> sectionData = new HashMap<>();

    // This creates Yaml Config for Plugin
    public void createConfig(){
        YamlFile configYaml = new YamlFile(configFile);

        configYaml.addDefault(, value);
    }

}
