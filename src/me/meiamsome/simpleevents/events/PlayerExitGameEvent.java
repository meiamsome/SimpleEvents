package me.meiamsome.simpleevents.events;

import org.bukkit.event.HandlerList;

public class PlayerExitGameEvent extends SimpleEventEvent {
	private HandlerList handlers = new HandlerList();
	public HandlerList getHandlers() {
		return handlers;
	}

	public PlayerExitGameEvent() {
		// TODO Auto-generated constructor stub
	}

}
