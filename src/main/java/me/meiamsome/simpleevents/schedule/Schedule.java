package me.meiamsome.simpleevents.schedule;

import com.lastabyss.bukkit.utilities.Utilities;
import java.util.Date;
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
    private String name;
    private Game game;
    private ScheduleHandler handler;
    private int prepareTime = 60;
    private int pTimeLeft = prepareTime;
    private Date date;
    
    //Prepare time and timeLeft are both temporary until we can get this code interpretation sorted.
   
   public Schedule(String name, Game game, Date date, ScheduleHandler handler) {
       this.game = game;
       this.name = name;
       this.date = date;
       this.handler = handler;
   }
        
        
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHandler(ScheduleHandler handler) {
        this.handler = handler;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Game getGame() {
        return game;
    }

    public ScheduleHandler getSchedulerHandler() {
        return handler;
    }

    
    
    
    
    
    
}
