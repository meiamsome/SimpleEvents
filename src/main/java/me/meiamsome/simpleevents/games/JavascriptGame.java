package me.meiamsome.simpleevents.games;

import java.io.File;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import me.meiamsome.simpleevents.Game;
import me.meiamsome.simpleevents.SimpleEvents;

import org.bukkit.Bukkit;

public class JavascriptGame extends Game {
	//Static information details.
	public Boolean requiresArea;
	public Integer getMinPlayers;
	public Integer getMaxPlayers;
	
	ScriptEngine engine;
	private String scriptName;
	JavascriptGame(File folder) throws Exception {
		super(folder);
		engine = new ScriptEngineManager().getEngineByName(getConfig().getString("ScriptEngine","JavaScript"));
		if(!(engine instanceof Invocable)) {
			throw new Exception("Script Engine must support Invocable!");
		}
		scriptName = getConfig().getString("ScriptName", "script.js");
		engine.put("game", this);
		engine.put("server", Bukkit.getServer());
		File f = new File(baseFolder, scriptName);
		engine.eval(new FileReader(f));
		for(String listener: getConfig().getStringList("Listeners")) {
			SimpleEvents.self.addListener(listener);
		}
	}
	
	@Override
	public JavascriptGameInstance newGame() throws NoSuchMethodException, ScriptException {
		return new JavascriptGameInstance(this, ((Invocable)engine).invokeFunction("createGame"));
	}

	
}
