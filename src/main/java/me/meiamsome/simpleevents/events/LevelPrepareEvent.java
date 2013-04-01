package me.meiamsome.simpleevents.events;

import me.meiamsome.simpleevents.Arena;
import me.meiamsome.simpleevents.GameInstance;

import org.bukkit.event.HandlerList;

public class LevelPrepareEvent extends SimpleEventEvent {
	private HandlerList handlers = new HandlerList();
	GameInstance gInstance;
	Arena arena;
	public HandlerList getHandlers() {
		return handlers;
	}
	public LevelPrepareEvent(GameInstance gInstance, Arena arena) {
		this.gInstance = gInstance;
		this.arena = arena;
	}
	public GameInstance getGameInstance() {
		return gInstance;
	}
	public Arena getArena() {
		return arena;
	}
}
