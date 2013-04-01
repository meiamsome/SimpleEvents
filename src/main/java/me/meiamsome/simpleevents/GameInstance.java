package me.meiamsome.simpleevents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

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
			ErrorHandler.log(Level.SEVERE,"Could not log error in game '"+parent.name+"'",null);
			return;
		}
		try {
			String str = "";
			for(String l: log) str += l + "\r\n";
			out.append(str);
		} catch(IOException e) {
			ErrorHandler.log(Level.SEVERE,"Could not log error in game '"+parent.name+"'",null);
		}
		try {
			out.close();
		} catch (IOException e) {}
	}
        

}
