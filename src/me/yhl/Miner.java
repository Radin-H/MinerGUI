package me.yhl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Miner extends JavaPlugin {
	
	public static Plugin plugin;
	public static Miner instance;
	AnimationTimer at;
	public MyConfig messages;
	public MyConfigManager man;  
	
	public void onEnable(){

        man = new MyConfigManager(this);
        messages = man.getNewConfig("Miner.yml", new String[] {"Main Config for >Miner<", "Creds to dNiym for helping me out"});
        at = new AnimationTimer(this);
		plugin = this;
		instance = this;
		registerEvents(this, new ListenerClass());
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, at, 0L, 20L);
	}
	

	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.AQUA + "");
			return true;
		}

		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("Miner")) {
			if(player.hasPermission("Miner.miner")){
			at.setup(player);
			
			} else{
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to do this.");
				return false;
			}
			
		} else if (cmd.getName().equalsIgnoreCase("Miner2")) {
			
			
		
		}
		return true;
	}
	
	public static Plugin getPlugin() {
		return plugin;
		}
	
    public static Miner getInstance() {
        return instance;
    }
}
	

