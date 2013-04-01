package me.meiamsome.simpleevents.games;

import javax.script.Invocable;
import javax.script.ScriptException;

import me.meiamsome.simpleevents.GameInstance;
import me.meiamsome.simpleevents.events.BailEvent;

import org.bukkit.event.Event;


public class JavascriptGameInstance extends GameInstance {
	JavascriptGame game;
	Object actualGame;
	JavascriptGameInstance(JavascriptGame par, Object o) {
		super(par);
		game = par;
		actualGame = o;
	}
	
	public void executeEvent(Event e) throws ScriptException {
		try {
			((Invocable)game.engine).invokeMethod(actualGame, e.getEventName(), e);
		} catch(NoSuchMethodException e1) {}//Do nothing
	}
	@Override
	public void bail(String[] log) {
		try {
			executeEvent(new BailEvent(game));
		} catch (ScriptException e) {
		}
		super.bail(log);
	}
	

}
