package fr.sweeftyz.patate.listeners;

import fr.sweeftyz.patate.BagManager;
import fr.sweeftyz.patate.commands.BagCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BagListeners implements Listener {


    @EventHandler
    public void OnInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();
        BagManager bag = BagCommand.getPlayerBag().get(player);
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Sac à patate") && action == Action.RIGHT_CLICK_AIR){
            bag.add(64,player);
        }
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Sac à patate") && action == Action.LEFT_CLICK_AIR){
            bag.remove(64,player);

        }
    }
}
