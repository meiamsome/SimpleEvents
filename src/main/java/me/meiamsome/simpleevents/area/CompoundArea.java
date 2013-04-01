package me.meiamsome.simpleevents.area;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class CompoundArea extends Area {
	List<Area> parts = new ArrayList<Area>();
	
	public void addSubPart() {
		
	}

	@Override
	public int getSize() {
		int size = 0;
		for(Area a: parts) size += a.getSize();
		return size;
	}

	@Override
	public List<Location> allLocations() {
		List<Location> ret = new ArrayList<Location>();
		for(Area a: parts) {
			ret.addAll(a.allLocations());
		}
		return ret;
	}

}
