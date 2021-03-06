package fr.sweeftyz.patate;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BagManager {

    private String name;

    private int level;

    private String id;

    private int potatoes;

    private ItemStack item;

    private int maxslot;

    private final int minslot = 200;

    public ItemStack bag;

    private boolean isCompleted;



    public BagManager(String name, int level, String id){
        this.name = name;
        this.level = level;
        this.id = id;
        this.potatoes = 0;
        this.item = new ItemStack(Material.POTATO_ITEM);
        this.bag = new ItemStack(Material.COMPASS,1);
        this.maxslot = minslot + (level*(minslot/2));
    }

    public void give(Player player){
        if(!player.getInventory().contains(bag)) {
            ItemMeta meta = bag.getItemMeta();
            meta.setDisplayName(name);
            bag.setItemMeta(meta);
            player.getInventory().addItem(bag);
            player.sendMessage(ChatColor.GREEN + "Vous avez reçu un sac à patate !");
        }else{
            player.sendMessage(ChatColor.RED + "Vous possédez déjà un sac à patate sur vous !");

        }

    }


    public void add(int num, Player player) {
        if (player.getInventory().contains(Material.POTATO_ITEM) || player.getInventory().contains(Material.POTATO)) {
            if (num < 0) {
                num = 0;
            }
            if ((this.potatoes + num) > maxslot) {
                int added = (this.potatoes + num) -maxslot;
                player.sendMessage(ChatColor.GREEN + "Vous avez reçu " + added + "patates !(" + this.potatoes + ")");
                this.potatoes += added;
                item.setAmount(added);
                AddAction(player);
                return;
            }


                if (this.potatoes == maxslot) {
                player.sendMessage(ChatColor.RED + "Vous avez atteint la limite ! Améliorez votre sac pour avoir un espace supplémentaire !");
                return;
            }
                this.potatoes += num;
                player.sendMessage(ChatColor.GREEN + "Votre sac a reçu " + num + "patates !(" + this.potatoes + ")");
                item.setAmount(num);
                AddAction(player);

        }else{
            player.sendMessage(ChatColor.RED + "Vous n'avez pas de patate sur vous !");
        }
    }

    public void remove(int num,Player player){
        if(num < 0){
            num = 0;
        }else if(this.potatoes == 0){
            player.sendMessage(ChatColor.RED + "Votre sac est déjà vide !");
            return;

        }
        else {
            this.potatoes -= num;
            if((this.potatoes- num) < 0){
                int result = this.potatoes - num;
                num = result + (result *2);
                this.potatoes = 0;
            }
            if(this.potatoes == 0){
                player.sendMessage(ChatColor.RED+ "Votre sac est vide ! ");
                return;
            }
            player.sendMessage(ChatColor.GREEN + "Vous avez retiré " + num + "patates !(" + this.potatoes + ")");
            item.setAmount(num);
            player.getInventory().addItem(item);
        }

    }

    public void AddAction(Player player){
        isCompleted = false;
        player.getInventory().all(this.item).forEach((key, value) -> {
            if(isCompleted){
                return;
            }
            System.out.println(key);
            System.out.println(value);

            if (!isCompleted) {
                player.getInventory().setItem(key, new ItemStack(Material.AIR));
                isCompleted = true;

            }  else{
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        });

    }
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    public String getId(){
        return id;
    }
    public int getMaxSlot(){
        return maxslot;
    }
    public int getMinSlot(){
        return minslot;
    }


}
