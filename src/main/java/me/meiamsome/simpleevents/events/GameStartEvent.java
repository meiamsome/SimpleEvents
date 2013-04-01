package me.meiamsome.simpleevents.events;

import me.meiamsome.simpleevents.Game;
import me.meiamsome.simpleevents.GameInstance;

import org.bukkit.event.HandlerList;

public class GameStartEvent extends SimpleEventEvent {
	private HandlerList handlers = new HandlerList();
	GameInstance gInstance;
	Game game;
	public HandlerList getHandlers() {
		return handlers;
	}

	public GameStartEvent(GameInstance ginstance, Game game) {
		gInstance = ginstance;
		this.game = game;
	}
	
	public GameInstance getGameInstance() {
		return gInstance;
	}
	
	public Game getGame() {
		return game;
	}

}
