package me.meiamsome.simpleevents.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SimpleEventEvent extends Event {
	private static HandlerList handlers = new HandlerList();
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
}