package com.github.portalblock;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by portalBlock on 23/12/13.
 */
public class ItemFrameFix extends JavaPlugin implements Listener {
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("ItemFrameFix has been enabled!");
    }

    @EventHandler
    public void hBE(HangingBreakByEntityEvent e){
       Entity en = e.getRemover();
       if(en instanceof Player){
           e.setCancelled(true);
       }
    }
}
