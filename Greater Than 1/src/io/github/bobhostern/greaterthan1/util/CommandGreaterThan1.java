package io.github.bobhostern.greaterthan1.util;

import org.bukkit.command.CommandSender;

import io.github.bobhostern.greaterthan1.GreaterThan1;
import io.github.bobhostern.greaterthan1.util.interfaces.CommandResolver;

public final class CommandGreaterThan1 implements CommandResolver {
	private GreaterThan1 plugin;
	private String[][] commandList = {
			{"reloadConfig", "Reloads config.yaml", "reloadConfig"},
			{"action", "Prints out a list of available commands.", "action"},
			{"help", "Prints out help on a command.", "help <action>"}
	};
	
	public CommandGreaterThan1(GreaterThan1 _plugin) {
		plugin = _plugin;
		if(!validateCommandList(commandList)) {
			plugin.getLogger().info("Invalid command list. Please do NOT use this plugin.");
		}
	}
	
	private boolean validateCommandList(String[][] list) {
		for(String[] commandspec : commandList) {
			if(!(commandspec.length == 3)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean resolve(CommandSender sender, String label, String[] args) {
		if(args[0].equalsIgnoreCase(commandList[0][0])) {
			plugin.reloadConfig();
			plugin.getLogger().info("Reloaded configuration file!");
			return true;
		}
		else if(args[0].equalsIgnoreCase(commandList[1][0])) {
			plugin.getLogger().info("Available actions:");
			for(String[] commandspec : commandList) {
				plugin.getLogger().info("\t" + commandspec[0]);
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase(commandList[2][0])) {
			if(args.length > 1) {
				boolean foundCommand = false;
				for(String[] commandspec : commandList) {
					if(commandspec[0].equalsIgnoreCase(args[1])) {
						foundCommand = true;
						plugin.getLogger().info(commandspec[1]);
						plugin.getLogger().info("Usage: " + commandspec[2]);
					}
				}
				if(!foundCommand) {
					plugin.getLogger().info("Action requested not found.");
				}
			}
			else
			{
				plugin.getLogger().info("Help requires an action.");
			}
			return true;
		}
		return false;
	}
}
