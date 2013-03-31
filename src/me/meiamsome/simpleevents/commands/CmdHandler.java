package me.meiamsome.simpleevents.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.meiamsome.simpleevents.SimpleEvents;

public class CmdHandler implements CommandExecutor {
	SimpleEvents plugin;
	public CmdHandler(SimpleEvents plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		if(!cmd.getName().equalsIgnoreCase("events"))
			return false;
		if(args.length == 0)
			return help(sender,cmd,name,args);
		return true;
	}
	private boolean help(CommandSender sender, Command cmd, String name, String[] args) {
		return true;
	}

}
