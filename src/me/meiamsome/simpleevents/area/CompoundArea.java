package me.meiamsome.simpleevents.area;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.v1_4_R1.AABBPool;

import org.bukkit.Location;

public class CompoundArea extends Area {
	List<Area> parts = new ArrayList<Area>();
	
	public void addSubPart() {
		
	}

	@Override
	public int getSize() {
		int size = 0;
		for(Area a: parts) size += a.getSize();
		return size;O
	}

	@Override
	public List<Location> allLocations() {
		// TODO Auto-generated method stub
		return null;
	}

}
