package me.meiamsome.simpleevents;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandler {
	private static Logger log = Logger.getLogger("Minecraft");
	
	public static void log(Level level, String msg, Throwable thrown) {
		log.log(level, msg, thrown);
	}

}
