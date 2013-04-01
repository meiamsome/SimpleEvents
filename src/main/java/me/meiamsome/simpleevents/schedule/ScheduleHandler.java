
package me.meiamsome.simpleevents.schedule;

import java.util.concurrent.ConcurrentHashMap;
import me.meiamsome.simpleevents.Game;
import org.bukkit.configuration.ConfigurationSection;

public class ScheduleHandler {
      private ConcurrentHashMap<Game, Schedule> scheduled = new ConcurrentHashMap<Game, Schedule>();
      private ConfigurationSection config;
    
	public ScheduleHandler(ConfigurationSection config) {
		this.config = config;
	}
        
        
        public void addSchedule(Game game, Schedule schedule){
            if (game != null && schedule != null){
                scheduled.put(game, schedule);
            } else {
                if (game == null) throw new NullPointerException("Game cannot be null!");
                else if (schedule == null) throw new NullPointerException("Schedule cannot be null!");
                else throw new NullPointerException();
            }
        }
        
        /**
         * Returns the schedule of a game.
         * If no schedule was found, then null will be returned.
         * @param game
         * @return 
         */
        public Schedule getSchedule(Game game){
            if (scheduled.containsKey(game)){
                return scheduled.get(game);
            } else {
                return null;
            }
        }
        
        
        

}
