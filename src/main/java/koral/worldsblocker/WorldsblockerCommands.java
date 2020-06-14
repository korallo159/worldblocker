package koral.worldsblocker;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class WorldsblockerCommands implements CommandExecutor {


    public static boolean cmds = true;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {

            Player player = (Player) sender;
            if (label.equalsIgnoreCase("worldsblocker")) {
                if (args.length == 0 || args.length > 1) {

                    player.sendMessage(ChatColor.YELLOW + "Uzycie: /worldsblocker on lub off");
                    return true;
                } else {
                    if (args[0].equalsIgnoreCase("on")) {
                        if (cmds) {
                            player.sendMessage(ChatColor.GREEN + "Plugin jest już włączony");
                        } else {
                            player.sendMessage(ChatColor.GREEN + "Dzialanie pluginu wlaczone");
                            cmds = true;

                            return true;
                        }

                    }
                }
                if (args[0].equalsIgnoreCase("off")) {
                    if (!cmds) {
                        player.sendMessage(ChatColor.RED + "Plugin jest już wyłączony");
                    } else {
                        player.sendMessage(ChatColor.RED + "Dzialanie pluginu wylaczone");
                        cmds = false;

                        return true;
                    }

                }
            }

        }
        return false;
    }
}