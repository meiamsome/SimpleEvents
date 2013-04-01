package me.meiamsome.simpleevents.events;

import me.meiamsome.simpleevents.GameInstance;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerLeaveArenaEvent extends SimpleEventEvent {
	private HandlerList handlers = new HandlerList();
	public HandlerList getHandlers() {
		return handlers;
	}

	public PlayerLeaveArenaEvent(GameInstance ginstance, PlayerMoveEvent pme) {
		// TODO Auto-generated constructor stub
	}
}
