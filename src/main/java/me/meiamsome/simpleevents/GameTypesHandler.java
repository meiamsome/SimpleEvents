package me.meiamsome.simpleevents;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTypesHandler {
	static Map<String, GameType> gameTypes = new HashMap<String, GameType>();
	static List<Game> games = new ArrayList<Game>();
	static File base;
	static boolean isLoaded = false;
	
	//add a game type.
	public static void addType(String name, GameType type) {
		gameTypes.put(name, type);
		if(isLoaded) {
			load(name);
		}
	}
	
	public static void load(File baseFolder) {
		if(isLoaded) return;
		base = baseFolder;
		for(String name: gameTypes.keySet()) {
			load(name);
		}
	}
	
	public static void load(String name) {
		List<Game> ret = gameTypes.get(name).loadGames(new File(base, name));
		if(ret == null || ret.size() == 0) return;
		games.addAll(ret);
	}
	
	public static List<Game> getAllGames() {
		if(!isLoaded) throw new IllegalAccessError();
		return games;
	}

}
