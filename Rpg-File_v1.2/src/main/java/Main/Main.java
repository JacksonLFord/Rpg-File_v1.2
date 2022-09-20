package Main;


import DataBase.FileLogger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

import static Combat.Attack.attack;
import static Combat.Classes.classes;
import static Combat.Enemy.enemies;
import static Combat.Person.*;
import static Commands.Resources.gather;
import static Commands.Utility.Utilities;
import static Commands.Help.help;
import static Commands.Help.superHelp;

import static Commands.Inventory.*;
import static Commands.Items.*;
import static Commands.Map.*;
import static Commands.Prefix.findPrefix;
import static Commands.Prefix.toPrefix;
import static Commands.Resources.resources;
import static Commands.gem.prospect;

import static Register.Player.regGuild;
import static Register.Player.regPlayer;
import static Register.Start.start;


public class Main extends ListenerAdapter {


    FileLogger fl = new FileLogger();
    //Creating a new instance of my FileLogger

    public static void main(String[] args) {
        //The main method of the program. This will initalize the JDA that will track the code

        try {
            //Surrounding with try method due to errors
            JDA jda = JDABuilder.createDefault("TOKEN")
                    //This is the code for connection to the bot
                    //Creating a new JDA from the JDA Builder
                    .addEventListeners(new Main())
                    //Adding an event listener to handle the events i.e. messages and such
                    .setStatus(OnlineStatus.ONLINE)
                    //Setting bot as online
                    .setActivity(Activity.playing("Nothing Suspicious"))
                    //Setting the activity to my Username to promote me
                    .build();
            //Calling .build() on the JDA so it will build
            //Failed to map data for input 161808 for index idindex
            jda.awaitReady();
            //Waits for the JDA to finish its build.
            System.out.println("Finished Building JDA!");
            //Just a little signal to help me know when to start testing
        } catch (LoginException e) {

            e.printStackTrace();
            //the error if I fail at loging in
        } catch (InterruptedException e) {
            e.printStackTrace();
            //the error for other reasons.
        }



    }



    @Override
    public void onMessageReceived(MessageReceivedEvent event) {



        if (!event.getAuthor().isBot()) {
            try{
                regGuild(event,fl);
            }catch(Exception e){
                regGuild(event,fl);
            }

            regPlayer(event,fl);
            String prefix = findPrefix(event, fl);
            toPrefix(event, fl, prefix);
            start(event,fl, prefix);
            go(event,fl,prefix);
            localMap(event,fl,prefix);
            location(event,fl,prefix);
            inv(event,fl,prefix);
            resources(event,fl,prefix);
            gather(event,fl,prefix);
            help(event,fl,prefix);
            superHelp(event,fl,prefix);
            itemRecipe(event,fl,prefix);
            Utilities(event,fl,prefix);
            craft(event,fl, prefix);
            Craftables(event,prefix,fl);
            prospect(event,fl,prefix);
            stats(event,fl,prefix);
            sp(event,fl,prefix);
            enemies(event,fl,prefix);
            attack(event,fl,prefix);
            classes(event,fl,prefix);
            if(event.getMessage().getContentRaw().equalsIgnoreCase("#test")){

            }

        }
        if (event.getAuthor().isBot()) {

        }

    }
}
