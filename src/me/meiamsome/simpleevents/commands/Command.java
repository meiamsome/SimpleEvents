package me.meiamsome.simpleevents.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;

public class Command {
	HashMap<Command, Permission> subs = new HashMap<Command, Permission>();
	List<String> names = new ArrayList<String>();
	String name;
	Command(String name) {
		this.name = name;
		addName(name);
	}
	// Execute the command
	public void execute(CommandSender sender, String[] args) {
		help(sender, args);//This class is just a container for more commands.
	}
	
	public void help(CommandSender sender, String[] args) {
		sender.sendMessage("Subcommands:");
		for(Command c: getAble(sender)) {
			sender.sendMessage(c.name);
		}
	}
	
	// Add a command under this one.
	public void addSubCommand(Command command, Permission perm) {
		subs.put(command, perm);
	}
	
	// Add a name that this is known by
	public void addName(String name) {
		names.add(name);		
	}
	
	// Is this command known by that name?
	public boolean isCalled(String name) {
		for(String s: names)
			if(s.equalsIgnoreCase(name)) return true;
		return false;
	}
	
	// Gets a Command object relating to the String array passed in.
	public Command getCommand(String[] cmds) {
		return getCommand(null, cmds, 0);
	}
	public Command getCommand(Permissible permis, String[] cmds, int depth) {
		if(depth == cmds.length)
			return this;
		for(Command c: subs.keySet())
			if(c.isCalled(cmds[depth])) {
				if(subs.get(c) == null || permis.hasPermission(subs.get(c)))
					return c;
				return null; // Null => no permission.
			}
		return this; // No sub command, return self and assume the rest are arguments.
	}
	
	// Gets a list of sub commands we have access to.
	public List<Command> getAble(Permissible permis) {
		List<Command> ret = new ArrayList<Command>();
		for(Command c: subs.keySet())
			if(subs.get(c) == null || permis.hasPermission(subs.get(c))) ret.add(c);
		return ret;
	}
}
