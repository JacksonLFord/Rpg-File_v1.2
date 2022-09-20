package Combat;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Enemy.pullAll;

public class Attack {
    public static boolean inCombat(MessageReceivedEvent event, FileLogger fl){
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

        fl.toFile("profile.txt");
        boolean check = false;

        if(fl.read(24).equalsIgnoreCase("true")){
            check = true;

        }

        return check;
    }
    public static void attack(MessageReceivedEvent event, FileLogger fl, String prefix){
        String[] message = event.getMessage().getContentRaw().split(" ");
        if(message[0].equalsIgnoreCase(prefix+"Attack")){
            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

            fl.toFile("profile.txt");
            if (fl.read(3).equalsIgnoreCase("true")) {
                //Checking to see if they player has started

                    if(inCombat(event,fl)){
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("You are in combat!");
                        event.getChannel().sendMessage(edore.build()).queue();
                        return;
                    }

                fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

                fl.toFile("profile.txt");
                String file = FileLogger.read(4);
                ArrayList<String> Enemies = pullAll(event,fl,file);
                try{
                    int number = Integer.parseInt(message[1]);

                    String enemy =  Enemies.get(number);
                    Enemy enem = new Enemy();
                    enem.set(event,enemy);

                    fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

                    fl.toFile("profile.txt");
                    fl.replace(24, "True");
                    fl.replace(25,enemy);
                    fl.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                    fl.toFile("\\" + file + " - Enemy.txt");
                    fl.clear(number);

                    //they are now in combat
                    String[] array = enemy.split(";", 17);
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setTitle("You are now battling a level "+array[1]+ " "+array[0]);
                    event.getChannel().sendMessage(edore.build()).queue();
                    enem.build(event);

                    
                }catch(Exception e){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("Please provide a number!");
                    event.getChannel().sendMessage(edore.build()).queue();
                    return;
                }






            }
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not already started! ~ Combat");
                event.getChannel().sendMessage(edore.build()).queue();

            }
        }
    }




}
