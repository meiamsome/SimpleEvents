package me.meiamsome.simpleevents.schedule;

import com.lastabyss.bukkit.utilities.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.meiamsome.simpleevents.Game;
import me.meiamsome.simpleevents.SimpleEvents;
import org.bukkit.ChatColor;

/**
 *
 * @author Kabir
 */
public class Schedule implements Runnable{
    private Game game;
    private ScheduleHandler handler;
    private int prepareTime = 60;
    private int pTimeLeft = prepareTime;
    
    //Prepare time and timeLeft are both temporary until we can get this code interpretation sorted.
    public void run() {
        //Game logic here
        if (prepareTime == pTimeLeft){
            SimpleEvents.self.getServer().broadcastMessage(ChatColor.GOLD + Utilities.formatTime(pTimeLeft) + " " + 
                    Utilities.getLanguageString("timeLeft"));
        } else if (pTimeLeft == prepareTime/2){
            //etc
        } else if (pTimeLeft == 30){
            
        } else if (pTimeLeft == 15){
            
        } else if (pTimeLeft == 10){
            
        } else if (pTimeLeft == 5){
            
        } else if (pTimeLeft == 5){
            
        } else if (pTimeLeft == 5){
            
        } else if (pTimeLeft == 5){
            
        } else if (pTimeLeft == 5){
            
        } else if (pTimeLeft == 0){
            SimpleEvents.self.getServer().broadcastMessage(ChatColor.GREEN + "GO!");
            try {
                game.newGame();
            } catch (Exception ex) {
                Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            }
            handler.getGameTask(this).cancel();
        } 
        
        if (pTimeLeft > 0){
            pTimeLeft--;
        }
        
    }
    
    public Schedule(Game game, ScheduleHandler handler) {
        this.game = game;
    }
    
    
    

    public Game getGame() {
        return game;
    }

    public ScheduleHandler getSchedulerHandler() {
        return handler;
    }

    
    
    
    
    
    
}
