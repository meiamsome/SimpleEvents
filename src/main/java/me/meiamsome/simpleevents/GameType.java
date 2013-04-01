package me.meiamsome.simpleevents;

import java.io.File;
import java.util.List;

public abstract class GameType {
	
	public abstract List<Game> loadGames(File baseFolder);

}
