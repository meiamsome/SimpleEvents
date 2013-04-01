
package me.meiamsome.simpleevents.schedule;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author Kabir
 */
public class ScheduleHandler {
      private ConcurrentLinkedQueue<Schedule> scheduled = new ConcurrentLinkedQueue<Schedule>();
      private ConcurrentHashMap<Schedule, BukkitTask> currentGameTasks = new ConcurrentHashMap<Schedule, BukkitTask>();
      private ConfigurationSection config;
      
    
	public ScheduleHandler(ConfigurationSection config) {
		this.config = config;
	}
        
        public void addSchedule(Schedule schedule){
            scheduled.offer(schedule);
        }
        
        public void removeSchedule(Schedule schedule){
            if (schedule != null){
                scheduled.remove(schedule);
            } else {
                if (schedule == null) throw new NullPointerException("Schedule cannot be null!");
                else throw new NullPointerException();
            }
        }
        
        /**
         * Polls the next schedule in the queue
         * If no schedule was found, will return null.
         * @param game
         * @return 
         */
        public Schedule getNextSchedule(){
            return scheduled.poll();
        }
        
        /**
         * Retrieves the game task from the gameTask hashmap.
         * @param schedule
         * @return 
         */
        public BukkitTask getGameTask(Schedule schedule){
            if (currentGameTasks.containsKey(schedule))
                return currentGameTasks.get(schedule);
            else
                return null;
        }
        
        public Collection getCurrentGameTasks() {
        return currentGameTasks.values();
        }
        
        /**
         * This will finish the repeating sync task.
         */
        public void finishCurrentGameTask(Schedule schedule){
            if (currentGameTasks.containsKey(schedule))
            currentGameTasks.get(schedule).cancel();
        }
        
        
        
        
        
        
        

}
