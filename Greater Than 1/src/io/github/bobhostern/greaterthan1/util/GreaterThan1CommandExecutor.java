package io.github.bobhostern.greaterthan1.util;

import io.github.bobhostern.greaterthan1.GreaterThan1;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GreaterThan1CommandExecutor implements CommandExecutor {;
	private CommandGreaterThan1 gt1Resolver;
	
	public GreaterThan1CommandExecutor(GreaterThan1 _plugin) {
		gt1Resolver = new CommandGreaterThan1(_plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gt1")) {
			if(args.length > 0) {
				return gt1Resolver.resolve(sender, label, args);
			}
		}
		return false;
	}
}
