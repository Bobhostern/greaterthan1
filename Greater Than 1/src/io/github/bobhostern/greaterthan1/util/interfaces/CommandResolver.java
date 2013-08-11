package io.github.bobhostern.greaterthan1.util.interfaces;

import org.bukkit.command.CommandSender;

public interface CommandResolver {
	public boolean resolve(CommandSender sender, String label, String[] args);
}
