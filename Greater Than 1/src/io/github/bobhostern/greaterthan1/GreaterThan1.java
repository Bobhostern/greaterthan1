package io.github.bobhostern.greaterthan1;

import io.github.bobhostern.greaterthan1.util.GreaterThan1CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class GreaterThan1 extends JavaPlugin {
	@Override
	public void onEnable()
	{
		getConfig();
		getCommand("gt1").setExecutor(new GreaterThan1CommandExecutor(this));
	}
	
	@Override
	public void onDisable()
	{
		saveConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    // Uses equalsIgnoreCase() over equals() to accept "ignite" and "IgNiTe."
	    if (cmd.getName().equalsIgnoreCase("ignite")) {
	        // Make sure that the player specified exactly one argument (the name of the player to ignite).
	        if (args.length != 2) {
	            // When onCommand() returns false, the help message associated with that command is displayed.
	            return false;
	        }
	 
	        // Get the player who should be set on fire. Remember that indecies start with 0, not 1.
	        Player target = Bukkit.getServer().getPlayer(args[0]);
	 
	        // Make sure the player is online.
	        if (target == null) {
	            sender.sendMessage(args[0] + " is not currently online.");
	            return true;
	        }
	 
	        // There are ~20 ticks in a second.
	        int ticks = Integer.parseInt(args[1]) * 20;
	        target.setFireTicks(ticks);
	        return true;
	    }
	    return false;
	}
}
