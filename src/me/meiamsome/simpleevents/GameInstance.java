package me.meiamsome.simpleevents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptException;

import me.meiamsome.simpleevents.events.BailEvent;

import org.bukkit.event.Event;


public class GameInstance {
	Game game;
	Object actualGame;
	GameInstance(Game par, Object o) {
		game = par;
		actualGame = o;
	}
	
	public void executeEvent(Event e) throws ScriptException {
		try {
			((Invocable)game.engine).invokeMethod(actualGame, e.getEventName(), e);
		} catch(NoSuchMethodException e1) {}//Do nothing
	}
	
	public void bail(String[] log) {
		File f = new File(game.baseFolder, "errors.log");
		FileWriter out;
		try {
			out = new FileWriter(f);
		} catch (IOException e1) {
			game.parent.log.severe("Could not log error in game '"+game.name+"'");
			return;
		}
		try {
			String str = "";
			for(String l: log) str += l + "\r\n";
			out.append(str);
		} catch(IOException e) {
			game.parent.log.severe("Could not log error in game '"+game.name+"'");
		}
		try {
			executeEvent(new BailEvent(game));
		} catch (ScriptException e) {
			try {
				out.append("Error while bailing!");
			} catch (IOException e2) {
				
			}
			
		}
		try {
			out.close();
		} catch (IOException e) {}
	}

}
