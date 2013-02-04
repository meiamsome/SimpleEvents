package me.meiamsome.simpleevents.events;

import org.bukkit.event.HandlerList;

public class PlayerJoinGameEvent extends SimpleEventEvent {
	private HandlerList handlers = new HandlerList();
	public HandlerList getHandlers() {
		return handlers;
	}

	public PlayerJoinGameEvent() {
		// TODO Auto-generated constructor stub
	}

}
