package me.meiamsome.simpleevents;

import java.io.File;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class Game implements Listener {
	//Static information details.
	public Boolean requiresArea;
	public Integer getMinPlayers;
	public Integer getMaxPlayers;
	public String name;
	
	File baseFolder;
	private Configuration baseConfig;
	SimpleEvents parent;
	ScriptEngine engine;
	private String scriptName;
	Game(SimpleEvents parent, File folder) throws Exception {
		baseFolder = folder;
		baseConfig = YamlConfiguration.loadConfiguration(new File(folder, "Config.yml"));
		engine = new ScriptEngineManager().getEngineByName(baseConfig.getString("ScriptEngine","JavaScript"));
		if(!(engine instanceof Invocable)) {
			throw new Exception("Script Engine must support Invocable!");
		}
		scriptName = baseConfig.getString("ScriptName", "script.js");
		name = baseConfig.getString("Name");
		engine.put("game", this);
		engine.put("server", parent.getServer());
		File f = new File(baseFolder, scriptName);
		engine.eval(new FileReader(f));
		this.parent = parent;
		for(String listener: baseConfig.getStringList("Listeners")) {
			parent.addListener(listener);
		}
	}
	
	public GameInstance newGame() throws NoSuchMethodException, ScriptException {
		return new GameInstance(this, ((Invocable)engine).invokeFunction("createGame"));
	}

	
}
