package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static Combat.Attack.inCombat;
import static Commands.DropTable.GemPro;
import static Commands.Inventory.*;

public class gem {
    public static void prospect(MessageReceivedEvent event, FileLogger fl, String prefix){

            if(event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"prospect")){
                if(inCombat(event,fl)){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("You are in combat!");
                    event.getChannel().sendMessage(edore.build()).queue();
                    return;
                }
                FileLogger.toDir("C:\\Discord\\Player\\" + event.getAuthor().getId() + event.getGuild().getId());
                FileLogger.toFile("profile.txt");
                if (FileLogger.read(3).equalsIgnoreCase("true")) {
                  boolean check = checkInv(event,fl,"Gem", 1);
                  if(check){
                      EmbedBuilder em = new EmbedBuilder();
                      String item = GemPro();
                      em.setAuthor("Crafting successful!");
                      em.setDescription("```+1 "+item+"```" );
                      em.setFooter("Lisa your helpful bot!");
                      em.setColor(new Color(0, 78, 255, 1));
                      event.getChannel().sendMessage(em.build()).queue();
                      invAdd(event,fl,item,1);
                      invAdd(event,fl,"Gem",-1);
                  }if(!check){
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("You do not have a gem to prospect! ~ Prospect");
                        event.getChannel().sendMessage(edore.build()).queue();
                    }


                } if (FileLogger.read(3).equalsIgnoreCase("false")) {
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("You have not already started! ~ prospect");
                    event.getChannel().sendMessage(edore.build()).queue();
                }
            }
    }
}
