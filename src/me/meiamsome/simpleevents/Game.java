package me.meiamsome.simpleevents;

import java.io.File;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public abstract class Game implements Listener {
	public File baseFolder;
	private Configuration baseConfig;
	public String name;

	public Game(SimpleEvents parent, File folder) throws Exception {
		baseFolder = folder;
		baseConfig = YamlConfiguration.loadConfiguration(new File(folder, "Config.yml"));
		name = baseConfig.getString("Name");
	}
	
	public Configuration getConfig() {
		return baseConfig;
	}

	public abstract GameInstance newGame() throws Exception;
}
