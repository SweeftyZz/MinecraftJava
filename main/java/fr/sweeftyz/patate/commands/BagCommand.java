package fr.sweeftyz.patate.commands;

import fr.sweeftyz.patate.BagManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class BagCommand implements CommandExecutor {
    private final String INCORRECT_USAGE = ChatColor.RED + "Usage correct /bag give";
    private static HashMap<Player,BagManager> playerbag = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(args.length == 0) {
                if (label.equalsIgnoreCase("bag")) {
                    player.sendMessage(INCORRECT_USAGE);
                    return false;
                }
            }
            else if(args.length == 1){
                BagManager bag = new BagManager(ChatColor.GREEN + "Sac à patate",1,"first");
                playerbag.put(player,bag);
                bag.give(player);
            }
            else{
                player.sendMessage(INCORRECT_USAGE);

            }
        }
        return false;
    }

    public static HashMap<Player,BagManager> getPlayerBag(){
        return playerbag;
    }
}
