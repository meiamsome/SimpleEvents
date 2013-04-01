package me.meiamsome.simpleevents;

import java.io.File;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

/*
 * Abstract Game class
 * This represents a Game Type. All extensions are Games.
 * When they are started, a GameInstance is generated.
 */
public abstract class Game implements Listener {
	public File baseFolder;
	private Configuration baseConfig;
	public String name;

	// Constructor. Every Game Type will have their own folder.
	public Game(SimpleEvents parent, File folder) throws Exception {
		baseFolder = folder;
		baseConfig = YamlConfiguration.loadConfiguration(new File(folder, "Config.yml"));
		name = baseConfig.getString("Name");
	}
	
	// Used for the extensions of this class.
	public Configuration getConfig() {
		return baseConfig;
	}

	//Used to start a game.
	public abstract GameInstance newGame() throws Exception;
}
