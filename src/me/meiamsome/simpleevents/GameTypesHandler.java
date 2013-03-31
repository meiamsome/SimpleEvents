package me.meiamsome.simpleevents;

import java.util.List;
import java.util.ArrayList;

public class GameTypesHandler {
	static List<GameType> gameTypes = new ArrayList<GameType>();
	static List<Game> games = new ArrayList<Game>();
	static boolean isLoaded = false;
	
	//add a game type.
	public static void addType(GameType type) {
		gameTypes.add(type);
		if(isLoaded) {
			load(type);
		}
	}
	
	public static void load(GameType type) {
		//TODO: load games
		//type.loadGames(baseFolder)
	}
	
	public static List<Game> getAllGames() {
		if(!isLoaded) throw new IllegalAccessError();
		return games;
	}

}
