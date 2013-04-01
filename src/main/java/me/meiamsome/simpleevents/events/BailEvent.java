package me.meiamsome.simpleevents.events;

import me.meiamsome.simpleevents.Game;

import org.bukkit.event.HandlerList;

public class BailEvent extends SimpleEventEvent {
	public static HandlerList handlers = new HandlerList();
	Game game;
	public BailEvent(Game game) {
		this.game = game;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public Game getGame() {
		return game;
	}
}
