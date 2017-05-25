package me.yhl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ListenerClass implements Listener {
AnimationTimer at = new AnimationTimer(Miner.getInstance());
	
public void setItem(Material item, String itemname,Inventory inv2, int slot){
	ItemStack itemm = new ItemStack(item);
	ItemMeta tmeta = itemm.getItemMeta();
	tmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemname));
	itemm.setItemMeta(tmeta);
	inv2.setItem(slot, itemm);
}

	public void onEnable(){
		Miner.getInstance().messages.set("Animation", false);
	}

	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void onInventoryInteract(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		Inventory cpanel = Bukkit.createInventory(null, 45, ChatColor.GOLD + "" + ChatColor.BOLD + "Control Panel");
		
		
		
		
		if(e.getInventory().getTitle().equals(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + "'s Miner")){
			
//			if(e.getSlot() == 29){
//				
//				
//				if(p.hasPermission("Miner.use")){
//				if(!at.t.get(p)){
//					p.sendMessage(": " + at.t.get(p));
//					e.setCancelled(true);
//					at.toggleAnimation(p, inv);
//					p.sendMessage(": " + at.t.get(p));
//				} else if(at.t.get(p)){
//					e.setCancelled(true);
//					p.sendMessage(": " + at.t.get(p));
//					at.toggleAnimation(p, inv);
//					p.sendMessage(": " + at.t.get(p));
//				}
//				} else{
//					p.sendMessage(ChatColor.DARK_RED + "You do not have permission to do this.");
//					e.setCancelled(true);
//					return;
//				}
//			}
			
		if(e.getSlot() == 31){
			
			
			
			if(e.getCurrentItem().getType() == Material.COAL){
				
				setItem(Material.IRON_INGOT, "&7Iron", e.getInventory(), 31);
					p.updateInventory();
				} else if(e.getCurrentItem().getType() == Material.IRON_INGOT){
					
					setItem(Material.GOLD_INGOT, "&6Gold", e.getInventory(), 31);
				} else if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
				
					setItem(Material.DIAMOND, "&3Diamond", e.getInventory(), 31);
				} else if(e.getCurrentItem().getType() == Material.DIAMOND){
				
					setItem(Material.COAL, "&4Coal", e.getInventory(), 31);
				}
			}
		
		if(e.getSlot() == 29){
		p.closeInventory();
		p.openInventory(cpanel);
		setItem(Material.GOLD_BARDING, "&3&lAnimation", cpanel, 13);
		setItem(Material.BARRIER, "&c&lBack", cpanel, 44);
		}
		
		
		e.setCancelled(true);
		}if(e.getInventory().getTitle().equals(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + "'s Miner (Control Panel)")){
			
			if(e.getSlot() == 13){
				e.setCancelled(true);
					if(Miner.getInstance().messages.getBoolean("Animation")){
					Miner.getInstance().messages.set("Animation", false);
				} else{
					Miner.getInstance().messages.set("Animation", true);
				}{
					
				}
			} else if(e.getSlot() == 44) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
		
	}
	
}