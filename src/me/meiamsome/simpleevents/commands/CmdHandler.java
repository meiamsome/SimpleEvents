package me.meiamsome.simpleevents.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import me.meiamsome.simpleevents.SimpleEvents;

public class CmdHandler implements CommandExecutor {
	SimpleEvents plugin;
	Command base;
	public CmdHandler(SimpleEvents plugin) {
		this.plugin = plugin;
		base = new Command("events");
		Command region = new Command("region");
		region.addName("reg");
		base.addSubCommand(region, new Permission("SimpleEvents.region"));
		Command regionSub1 = new Command("test") {
			@Override
			public void execute(CommandSender sender, String[] args) {
				sender.sendMessage("Test");
			}
		};
		region.addSubCommand(regionSub1, null);
		
	}
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String name, String[] args) {
		if(!cmd.getName().equalsIgnoreCase("events"))
			return false;
		Command c = base.getCommand(args);
		if(c == null) {
			sender.sendMessage("You do not have permission to do that");
			return true;
		}
		c.execute(sender, args);
		return true;
	}

}
