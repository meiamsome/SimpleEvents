
package me.meiamsome.simpleevents.schedule;

import java.util.concurrent.ConcurrentHashMap;
import me.meiamsome.simpleevents.Game;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author Kabir
 */
public class ScheduleHandler {
      private ConcurrentHashMap<Schedule, Game> scheduled = new ConcurrentHashMap<Schedule, Game>();
      private ConfigurationSection config;
      private BukkitTask currentGameTask = null;
      
    
	public ScheduleHandler(ConfigurationSection config) {
		this.config = config;
	}
        
        
        
        
        public void addSchedule(Schedule schedule, Game game){
            if (game != null && schedule != null){
                scheduled.put(schedule, game);
            } else {
                if (game == null) throw new NullPointerException("Game cannot be null!");
                else if (schedule == null) throw new NullPointerException("Schedule cannot be null!");
                else throw new NullPointerException();
            }
        }
        
        public void removeSchedule(Schedule schedule){
            if (schedule != null){
                scheduled.remove(schedule);
            } else {
                if (schedule == null) throw new NullPointerException("Game cannot be null!");
                else throw new NullPointerException();
            }
        }
        
        /**
         * Returns a scheduled game
         * If no game was found, then null will be returned.
         * @param game
         * @return 
         */
        public Game getScheduledGame(Schedule schedule){
            if (scheduled.containsKey(schedule)){
                return scheduled.get(schedule);
            } else {
                return null;
            }
        }
        
        public BukkitTask getCurrentGameTask() {
        return currentGameTask;
        }
        
        /**
         * This will finish the repeating sync task.
         */
        public void finishCurrentGameTask(){
            currentGameTask.cancel();
            currentGameTask = null;
        }
        
        
        
        
        
        
        

}
