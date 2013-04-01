package me.meiamsome.simpleevents.games;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.meiamsome.simpleevents.Game;
import me.meiamsome.simpleevents.GameType;

public class JavascriptGameType extends GameType {
	@Override
	public List<Game> loadGames(File baseFolder) {
		List<Game> ret = new ArrayList<Game>();
		for(File f: baseFolder.listFiles()) {
			if(f.isDirectory())
				try {
					ret.add(new JavascriptGame(f));
				} catch (Exception e) {
					
				}
		}
		return ret;
	}

}
