package fr.sweeftyz.patate.discord;

import fr.sweeftyz.patate.Main;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class BotM extends ListenerAdapter {

    private JDA jda;

    private Main main;



    public BotM(Main main){
        this.main = main;
        startBot();
    }


    public void startBot(){
        try {
            jda = JDABuilder.createLight("ODY3ODY2ODgzMjA2NTQ1NDY5.YPnWBQ.X2EfFVm_8n8K5jWq1GnpLvUJnYM", EnumSet.noneOf(GatewayIntent.class))
                    .addEventListeners()
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
