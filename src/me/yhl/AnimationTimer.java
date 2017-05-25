package me.yhl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;


public class AnimationTimer implements Runnable {

	HashMap<Inventory,Integer> instances = new HashMap<Inventory,Integer>(); 
	HashMap<Inventory,Integer> adding = new HashMap<Inventory,Integer>();
	double nextUpdate = 0L;
	int Progress = 0;
	int add = 1;
	Player p;
	ItemStack[] items;


	
	public void onEnable(){

	        items = new ItemStack[5];
	        
	        items[0] = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	        items[1] = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
	        items[2] = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)12);
	        items[3] = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
	        items[4] = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)10);
		
	}
	
	public static ItemStack getRandom(ItemStack[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
	
	public AnimationTimer(Miner Miner) {
	}
	
	
	
	
//	public void toggleAnimation(Player p, Inventory inv){
//		t.put(p, false);
//			if(inv.getViewers().contains(p)){
//		if(t.get(p) == false){
//		t.put((Player) p, true);
//		} else {
//			t.put((Player) p, false);
//		
//			}
//	}
//}
//	
//	public Boolean getToggle(Player p){
//		
//		return t.get(p);
//		
//	}
	
	public void getItem(Material item, String itemname,Inventory inv, int slot){
		ItemStack itemm = new ItemStack(item);
		ItemMeta tmeta = itemm.getItemMeta();
		tmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemname));
		itemm.setItemMeta(tmeta);
		inv.setItem(slot, itemm);
	}
	public void setItem(ItemStack item, String itemname,Inventory inv, int slot){
		ItemStack itemm = new ItemStack(item);
		ItemMeta tmeta = itemm.getItemMeta();
		tmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemname));
		itemm.setItemMeta(tmeta);
		inv.setItem(slot, itemm);
	}
	
	public void setName(Player p, int slot, Inventory inv, String name){
		
		inv.getItem(slot).getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void setup(Player p)  
	{
		
		
			
			Inventory miner = getMiner(p);
				
			
	

				getItem(Material.COAL, "&4Coal", miner, 31);
			
				getItem(Material.COMMAND, "&cControl Panel", miner,29);
			getItem(Material.PAPER, "&cProgress: &4" + Progress + "&l%", miner, 33);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 10);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 11);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 12);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 13);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 14);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 15);
			setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&c", miner, 16);
			p.openInventory(miner);
			this.instances.put(miner,10); 
			 
			Miner Miner = new Miner();
		       
	        List<ItemStack> items = new ArrayList<>();
	        items.add(make(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)8), colorize("")));
	        items.add(make(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4), colorize("")));
	        items.add(make(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3), colorize("")));
	        items.add(make(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11), colorize("")));
	        if(Miner.messages.getBoolean("Animation")){
	        new BukkitRunnable() {
	            int currentIndex = 0;
	            
	            @SuppressWarnings("static-access")
				@Override
	            public void run() {
	            	if(Miner.getInstance().messages.getBoolean("Animation")){
	            		
	            	
	                if (currentIndex == items.size()) {
	                    currentIndex = 0;
	                }
	                
	                int ii;
	    			for (ii = 0; ii < 9; ii++) {
	    				miner.setItem(ii, items.get(currentIndex));

	    			}
	                int ie;
	    			for (ie = 18; ie < 27; ie++) {
	    				miner.setItem(ie, items.get(currentIndex));

	    			}
	    			int iu;
	    			for (iu = 36; iu < 45; iu++) {
	    				miner.setItem(iu, items.get(currentIndex));

	    			}
	    			
	                miner.setItem(35, items.get(currentIndex));
	                miner.setItem(9, items.get(currentIndex));
	                miner.setItem(17, items.get(currentIndex));
	                miner.setItem(28, items.get(currentIndex));
	                miner.setItem(27, items.get(currentIndex));
	                miner.setItem(30, items.get(currentIndex));
	                miner.setItem(32, items.get(currentIndex));
	                miner.setItem(34, items.get(currentIndex++));
	            	
	            }else{
		        	int i;
	    			for (i = 18; i < 27; i++) {
	    				miner.clear(i);

	    			}
	    			int e;
	    			for (e = 36; e < 45; e++) {
	    				miner.clear(e);

	    			}
	    			int u;
	    			for (u = 0; u < 9; u++) {
	    				miner.clear(u);

	    			}
	    			
	    			miner.clear(35);
	    			miner.clear(9);
	    			miner.clear(17);
	    			miner.clear(28);
	    			miner.clear(27);
	    			miner.clear(30);
	    			miner.clear(32);
	    			miner.clear(34);
	    			
		        }
	            }
	        }.runTaskTimer(Miner.getPlugin(), 0, 5);
	        } else{
	        	int i;
    			for (i = 18; i < 27; i++) {
    				miner.clear(i);

    			}
    			int e;
    			for (e = 36; e < 45; e++) {
    				miner.clear(e);

    			}
    			int u;
    			for (u = 0; u < 9; u++) {
    				miner.clear(u);

    			}
    			
    			miner.clear(35);
    			miner.clear(9);
    			miner.clear(17);
    			miner.clear(28);
    			miner.clear(27);
    			miner.clear(30);
    			miner.clear(32);
    			miner.clear(34);
    			
	        }
	}
	    
	
	
		            
public static Inventory getMiner(Player p) {
		
	Inventory miner = Bukkit.createInventory(p, 45, ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + "'s Miner");
	return miner;
	}

public void open(Player p) {
	
	Inventory miner = getMiner(p);
	p.openInventory(miner);
	p.updateInventory();
	}

private String colorize(String input) {
    return ChatColor.translateAlternateColorCodes('&', input);
}
	
public ItemStack make(ItemStack item, String itemname){
	ItemStack itemm = new ItemStack(item);
	ItemMeta tmeta = itemm.getItemMeta();
	tmeta.setDisplayName(itemname);
	itemm.setItemMeta(tmeta);
	return itemm;
}

    @Override
    public void run() {
       

           
        HashMap<Inventory,Integer> updatedMap = new HashMap<Inventory,Integer>();
       
        if(System.currentTimeMillis() <= this.nextUpdate)  //not time to update, do nothing.  Note ALL players would be on the same time delay not a per player delay.
            return;
       
        double seconds = Miner.getInstance().getConfig().getInt("seconds");   //change this to how many seconds of delay per update.
               
       
        this.nextUpdate = System.currentTimeMillis() + (1000 * seconds);  //update the timestamp
       
        //now check for inventories we need to process  if there are none the loop wont run and nothing happens.
        for(Inventory inv:instances.keySet())  //gets the list of inventories then pulls them out 1 by 1
        {
            
 
           
            int currentSlot = instances.get(inv);   //gets the current slot from the hash map.
            if(inv.getViewers().isEmpty())  //if this returns true nobody is viewing the inventory. or all slots have been changed.
                continue;   //this one was invalid, skip it and do the next one.
            if (currentSlot > 16) {
                resetBar(inv);
                currentSlot = 10;
                add = 1;
                }
           
            Player p = (Player) inv.getViewers().get(0);   //should only ever be one viewer using this method.
           
            setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.PURPLE.getDyeData()), "&c", inv, currentSlot); //update the item
            p.updateInventory();  //update the player inventory
           
            updatedMap.put(inv, currentSlot+1);
            adding.put(inv, add+1);
            Progress = add*14;
           
           
            ItemStack itemm = new ItemStack(Material.PAPER);
            ItemMeta tmeta = itemm.getItemMeta();
            tmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cProgress: &4" + Progress + "&l%"));
 
           
            inv.getItem(33).setAmount(add);
            setName(p, 33, inv, "&cProgress: &4" + Progress + "&l%");
            inv.getItem(33).setItemMeta(tmeta);
 
            if(inv.getItem(33).getAmount() > 1 && currentSlot == 10){
            	currentSlot = 10;
            	Progress = 0;
            	add = 1;
            }
           if(currentSlot == 10){
               
               currentSlot = 10;
               add = 1;
               inv.getItem(33).setAmount(1);
               Progress = 14;
           }
            p.updateInventory();
            add++;
            if(currentSlot == 9){
                add = 1;
            }
            //write the new slot to a map and increment it +1.
            //*NOTE* it would be cleaner if we had an object to store the inv, player, slot etc but for simplictys sake i just used a hashmap.
            //NEVER edit a hash map while you are iterating over it.
            if(currentSlot == 16){
               
                    p.getInventory().addItem(new ItemStack(inv.getItem(31).getType()));
               
        }
       
        //now we update the map
        this.instances.clear();  //wipe out the old list
        this.instances.putAll(updatedMap); //update the map, it will NOT include the closed inventories or the finished ones.
        }
        }

   
 

   
    public void resetBar(Inventory miner){
        miner.setItem(10, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
        miner.setItem(11, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
        miner.setItem(12, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
        miner.setItem(13, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
        miner.setItem(14, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
        miner.setItem(15, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
        miner.setItem(16, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14));
    }
    
   
}