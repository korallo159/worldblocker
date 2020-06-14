package koral.worldsblocker;


import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class Worldsblocker extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("worldsblocker").setExecutor(new WorldsblockerCommands());
        WorldsblockerCommands cmds = new WorldsblockerCommands();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        Player p = event.getPlayer();

        if (WorldsblockerCommands.cmds) {
            if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
                if (p.hasPermission("worldend.bypass"))
                    event.setCancelled(false);
                else event.setCancelled(true);
            }
            if (event.getCause() == PlayerPortalEvent.TeleportCause.NETHER_PORTAL) {
                if (p.hasPermission("worldnether.bypass"))
                    event.setCancelled(false);
                else event.setCancelled(true);
            }
        }
    }

    }
