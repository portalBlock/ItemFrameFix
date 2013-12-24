package com.github.portalblock.itemframefix;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by portalBlock on 23/12/13.
 */
public class ItemFrameFix extends JavaPlugin implements Listener {
    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("ItemFrameFix has been enabled!");
    }
    @EventHandler
    public void hBE(EntityDamageEvent e){
         if(e instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent ev = (EntityDamageByEntityEvent)e;
            if(ev.getEntity() instanceof Entity){
                Entity damagee = (Entity)ev.getEntity();
                if(damagee instanceof ItemFrame){
                    if(e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE){
                        e.setCancelled(true);
                    }else
                    if(ev.getDamager() instanceof Player){
                        Player p = (Player) ev.getDamager();
                        if(p.getGameMode() != GameMode.CREATIVE||!p.hasPermission("itemframefix.break")){
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}