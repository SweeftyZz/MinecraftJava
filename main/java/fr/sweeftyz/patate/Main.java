package fr.sweeftyz.patate;

import fr.sweeftyz.patate.commands.BagCommand;
import fr.sweeftyz.patate.discord.BotM;
import fr.sweeftyz.patate.listeners.BagListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;


    @Override
    public void onEnable() {
        instance = this;
        getServer().getConsoleSender().sendMessage("Activation...");
        initcommands();
        initlisteners();
        new BotM(this);

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Désactivation...");

    }

    public static Main getInstance(){
        return instance;
    }
    public void initcommands(){
        getCommand("bag").setExecutor(new BagCommand());
    }
    public void initlisteners(){
        PluginManager pmanager = Bukkit.getPluginManager();
        pmanager.registerEvents(new BagListeners(),this);
    }


}
