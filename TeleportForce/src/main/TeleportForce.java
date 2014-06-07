package main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TeleportForce extends JavaPlugin
{
	public static TeleportForce plugin;
	public TeleportForce()
	{
	}

	@Override
	public void onEnable()
	{
		getLogger().info("Booted.");
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player psender = (Player) sender;
			
			if(label.equalsIgnoreCase("tpf"))
			{
				if(args.length == 0)
				{
					if(psender.hasPermission("tpf.command"))
					{
						psender.sendMessage(ChatColor.RED + "Too few arguments.\n/tpf <username> <username1>");
					} else
						psender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
				} else if(args.length == 1)
				{
					if(psender.hasPermission("tpf.use"))
					{
						Player tp = psender.getServer().getPlayer(args[0]);
						Location tl = tp.getLocation();
						psender.teleport(tl);
						psender.sendMessage(ChatColor.GOLD + "Teleporting...");
					} else
						psender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
				} else if(args.length == 2)
				{
					if(psender.hasPermission("tpf.tpother"))
					{
						Player tp = psender.getServer().getPlayer(args[0]);
						Player tp1 = psender.getServer().getPlayer(args[1]);
						Location tl1 = tp1.getLocation();
						
						tp.teleport(tl1);
						psender.sendMessage(ChatColor.GOLD + "Teleporting...");
					} else
						psender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
				} else
					psender.sendMessage(ChatColor.RED + "Too many arguments.\n/tpf <username> <username1>");
			}
		} else
			if(label.equalsIgnoreCase("tpf"))
			{
				sender.sendMessage(ChatColor.RED + "Command could not be executed. Invalid sender.");
			}
		return false;
	}

}
