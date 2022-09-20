package Combat;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static Combat.Attack.inCombat;
import static DataBase.FileLogger.padboth;

public class Classes {
    public static boolean sClass(MessageReceivedEvent event, FileLogger fl, String prefix){
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

        fl.toFile("profile.txt");
        fl.read(29);
        boolean check = false;
        if(fl.read(29).equalsIgnoreCase("true")){
            check = true;
        }
        return check;
    }
    public static void classes(MessageReceivedEvent event, FileLogger fl,String prefix){
        if(event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"classes")){

            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

            fl.toFile("profile.txt");
            if (fl.read(3).equalsIgnoreCase("true")) {
                if(inCombat(event,fl)){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("You are in combat!");
                    event.getChannel().sendMessage(edore.build()).queue();
                    return;
                }
                if(fl.read(29).equalsIgnoreCase("true")){
                    EmbedBuilder eb = new EmbedBuilder();

                    if(fl.read(30).equalsIgnoreCase("true")){
                        eb.setAuthor("Subclasses of "+fl.read(26));
                        String str = "";
                        String[] list = fl.read(28).split(";");
                        int index0 = 0;
                        while(index0<list.length){
                            str = str+"| ``" +padboth(list[index0], 25) + "`` |\n" ;
                            index0++;


                        }eb.setDescription(str);
                    }else{
                        eb.setAuthor("Subclass of NONE");
                    }
                    eb.setColor(new Color(0, 78, 255, 1));
                    eb.setFooter("Lisa, your helpful bot!");
                    eb.setThumbnail(event.getAuthor().getAvatarUrl());
                    event.getChannel().sendMessage(eb.build()).queue();


                }else{
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("You do not have a class! ~ Class");
                    event.getChannel().sendMessage(edore.build()).queue();
                }




            }
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not already started! ~ Class");
                event.getChannel().sendMessage(edore.build()).queue();

            }
        }

    }
}
