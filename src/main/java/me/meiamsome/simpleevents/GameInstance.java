package me.meiamsome.simpleevents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class GameInstance {
	Game parent;

	public GameInstance(Game par) {
		parent = par;
	}
	
	//public abstract void bail(String[] log);
	// Bail is used if there's an error in the code interpretation.
	public void bail(String[] log) {
		File f = new File(parent.baseFolder, "errors.log");
		FileWriter out;
		try {
			out = new FileWriter(f);
		} catch (IOException e1) {
			SimpleEvents.log.severe("Could not log error in game '"+parent.name+"'");
			return;
		}
		try {
			String str = "";
			for(String l: log) str += l + "\r\n";
			out.append(str);
		} catch(IOException e) {
			SimpleEvents.log.severe("Could not log error in game '"+parent.name+"'");
		}
		try {
			out.close();
		} catch (IOException e) {}
	}

}
