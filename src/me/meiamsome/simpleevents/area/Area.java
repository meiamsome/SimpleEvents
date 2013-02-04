package me.meiamsome.simpleevents.area;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;

public abstract class Area {
	private String name;
	private Area parent = null;
	HashMap<String, Area> children = new HashMap<String, Area>();
	HashMap<String, Object> variables = new HashMap<String, Object>();
	List<String> tags = new ArrayList<String>();
	
	public void changeName(String newName) {
		if(parent != null) {
			if(parent.children.containsKey(newName)) {
				throw new IllegalArgumentException("Parent already has an area named '"+newName+"'");
			}
			parent.children.remove(name);
		}
		name = newName;
		if(parent != null) parent.children.put(name, this);
	}
	public String getName() {
		return name;
	}
	public Area getParent() {
		return parent;
	}
	public void setParent(Area newParent) {
		if(newParent != null)
			if(newParent.children.containsKey(name)) throw new IllegalArgumentException("Cannot change parent - new parent has a child of this name already.");
		if(parent != null) parent.children.remove(name);
		parent = newParent;
		if(parent != null) parent.children.put(name, this);//Otherwise this area is an orphan
	}
	public Location getRandomLocation() {//Returns a random Location with equal probability for every block
		return allLocations().get((int) Math.floor(Math.random()*(getSize())));
	}
	public abstract int getSize(); //Returns size in no. blocks
	public abstract List<Location> allLocations(); //List of all Locations

}
