package com.lastabyss.bukkit.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import me.meiamsome.simpleevents.SimpleEvents;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Kabir
 * 
 * This class exists to provide simple reusable utilities.
 * 
 */
public class Utilities {
    
    
    /**
     * Temporary help menu.
     * @param sender 
     */
    public void showHelpMenu(CommandSender sender) {
        
        //Replace true with permissions check once permissions is implemented.
        if (true) {
            sender.sendMessage(ChatColor.BLACK + "==========" + ChatColor.DARK_RED + "Simple Events v. " + SimpleEvents.self.getDescription().getVersion() + ChatColor.BLACK + "==========");
            sender.sendMessage(ChatColor.GRAY + "Command aliases: /tpvp, /pvp");
            sender.sendMessage(ChatColor.GRAY + "<> = Mandatory [] = Optional");

        } else {
            //Deny permission message
        }
    }
    
    /**
     * This will display settings to the command sender.
     * @param sender 
     */
    public void showSettings(CommandSender sender) {
        Map<String, Object> values = SimpleEvents.self.getConfig().getValues(true);
        sender.sendMessage(ChatColor.DARK_BLUE + "=====Simple Events Configuration=====");
        
        for (String key : values.keySet()) {
            if (!(SimpleEvents.self.getConfig().isConfigurationSection(key))) {
                sender.sendMessage(ChatColor.RED + key.replace("options.", "") + ChatColor.BLUE + " = " + values.get(key));
            }

        }

    }


    public void showInstructions(final CommandSender sender) throws FileNotFoundException {
        final File file = new File(SimpleEvents.self.getDataFolder(), "instructions.txt");
        final Scanner scanner = new Scanner(file);
        SimpleEvents.self.getServer().getScheduler().runTaskAsynchronously(SimpleEvents.self, new Runnable() {
            public void run() {
                while (scanner.hasNextLine()) {
                    sender.sendMessage(ChatColor.YELLOW + scanner.nextLine().trim());
                }
            }
        });
    }
    
        /**
     * This method will retrieve a string from the currently
     * chosen language file in the configuration.
     * @param string
     * @return 
     */
    public static String getLanguageString(String string){
        String fileName = SimpleEvents.self.getConfig().getString("options.language");
        File file = new File(SimpleEvents.self.getDataFolder(), fileName + ".yml");
        YamlConfiguration languageFile = YamlConfiguration.loadConfiguration(file);
        String sentence = languageFile.getString(string);
        return sentence;
    }
    
    /**
     * The usefulness of this method will become apparent
     * once Bukkit includes armor as being in the inventory.
     * @param player
     * @return 
     */
    public static boolean hasItems(Player player) {
        for (ItemStack i : player.getInventory().getContents()){
            if (i != null){
                return true;
            }
        }
        if (player.getInventory().getHelmet() != null){
            return true;
        }
        if (player.getInventory().getChestplate() != null){
            return true;
        }
        if (player.getInventory().getLeggings() != null){
            return true;
        }
        if (player.getInventory().getBoots() != null){
            return true;
        }
        return false;
    }

    /**
     * A time format method which formats in hours, minutes, and then finally seconds.
     * Example: 6 hour(s), 22 mins(s), 6 second(s)
     * @param seconds
     * @return 
     */
    public static String formatTime(int seconds) {
        String formatted = "N/A";
        int hours = (int) seconds / 3600,
                remainder = (int) (seconds % 3600),
                minutes = remainder / 60,
                sec = remainder % 60;

        if (hours > 0) {
            formatted = String.valueOf(hours + " hour(s), " + minutes + " min(s), " + sec + " second(s)");
        } else if (minutes > 0) {
            formatted = String.valueOf(minutes + " min(s), " + sec + " second(s)");
        } else if (sec > 0) {
            formatted = String.valueOf(sec + " second(s)");
        }
        return formatted;
    }

    /**
     * Saves the exact location in this order: world.getUID().toString(), x, y, z, yaw, pitch
     *
     * @param loc
     * @return
     */
    public static String convertLocationToString(Location loc) {
        String string;
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();
        World world = loc.getWorld();
        string = world.getUID().toString() + ";" + x + ";" + y + ";" + z + ";" + yaw + ";" + pitch;
        return string;
    }

    /**
     * Reads the location in this order: worldUUID(string);x;y;z;yaw;pitch;
     *
     * @param locationString
     * @return
     */
    public static Location convertStringToLocation(String locationString) {
        String[] args = locationString.split(";");
        World world = SimpleEvents.self.getServer().getWorld(UUID.fromString(args[0]));
        double x = Double.valueOf(args[1]);
        double y = Double.valueOf(args[2]);
        double z = Double.valueOf(args[3]);
        float yaw = Float.valueOf(args[4]);
        float pitch = Float.valueOf(args[5]);

        if (world == null) {
            return null;
        }
        Location location = new Location(world, x, y, z, yaw, pitch);

        return location;
    }

    /**
     * This method will convert any string into a properly color coded message.
     * Simply for convenience.
     *
     * @param locationString
     * @return
     */
    public static ChatColor convertStringToChatColor(String colorString) {
        try {
            return ChatColor.valueOf(colorString.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ChatColor.RESET;
        }
    }
}
