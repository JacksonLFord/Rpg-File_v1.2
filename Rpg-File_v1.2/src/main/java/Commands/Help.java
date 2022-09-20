package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static Commands.Prefix.findPrefix;

/*
The "Help" Class is all the methods that will send the user a guide
to the bot and how it works. The "Help" Class contains two methods,
helpEmbed() and help(). helpEmbed() will return the embed with an embed
with the information to help. help() contains the checking for the code
words or other triggers in the message.


All credit goes to the unofficial "Jamais Mort" group. The head Project
developer is Jackson Ford(DocileThief#8980)
 */
public class Help {
    public static EmbedBuilder helpEmbed(MessageReceivedEvent event, FileLogger fl, String prefix) {
        //This method will produce an general embed
        EmbedBuilder embed = new EmbedBuilder()//Creating a new embed builder
                .setAuthor("Lisa")//Setting the Author to Lisa
                .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                .setTitle("This servers prefix is: "+ findPrefix(event, fl))//Setting the title.
                .setFooter("Lisa, your helpful bot!")//Setting the footer
                .addField(//creating a new field
                        "```" + prefix + "help```",//Setting the title of the field
                        "This will provide you a list of helpful commands! \n ",//Setting the desc
                        false)//false is a setting to do with placemnet
                .addField(//creating a new field
                        "```" + prefix + "help [command name]```",//Setting the name
                        "This will provide detailed help for a command!\n ",//setting desc
                        false)//false is a setting to do with placemnet
                .addField(//creating new field
                        "```" + "prefix [prefix]```- ```"//adding commands
                               + prefix + "map```- ```"
                                + prefix + "gather```- ```"
                                + prefix + "chop```- ```"
                                + prefix + "mine```\n ```"
                                + prefix + "go```- ```"
                                + prefix + "start```- ```"
                                + prefix + "inv```- ```"
                                + prefix + "craft [item]```- ```"
                                + prefix + "resources```\n ```"
                                + prefix + "utility```- ```"
                                + prefix + "craftables```- ```"
                                + prefix + "Recipe [item]```"
                        ,//adding commands
                        "[ ] are parameters, you do not need to type []",//setting the desc to null
                        false);//false is a setting to do with placemnet
        return embed;//returning the final embed
    }

    public static void help(MessageReceivedEvent event, FileLogger fl, String prefix) {
        //This method will return the help command
        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "help")) {
            //if the message equals prefix + "help"
            event.getChannel().sendMessage(helpEmbed(event, fl, prefix).build()).queue();
            //sending the embed

        }

        if (event.getMessage().getMentionedUsers().contains(event.getJDA().getSelfUser())) {
            //if the message contains a mention to the Bot
            event.getChannel().sendMessage(helpEmbed(event, fl, prefix).build()).queue();
            //sending the embed

        }
    }
    public static void superHelp(MessageReceivedEvent event, FileLogger fl, String prefix){
        EmbedBuilder em = new EmbedBuilder();
        String pre = prefix + "help ";

        if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"prefix")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "prefix")//Setting the title.
                    .addField("Aliases: None","This command will allow\n this server to change \nits prefix!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"map")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "map")//Setting the title.
                    .addField("Aliases: localmap and local","This allows a player to see nearby\n locations!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"gather")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "gather")//Setting the title.
                    .addField("Aliases: None","This allows a player to gather items\n with their hand",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"chop")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "chop")//Setting the title.
                    .addField("Aliases: None","This allows a player to chop resources!",false)
                    .setFooter("Lisa, your helpful bot!");
        }if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"mine")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "mine")//Setting the title.
                    .addField("Aliases: None","This allows a player to mine resources!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"go")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "go")//Setting the title.
                    .addField("Aliases: None","This allows a player to go to nearby\n locations!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"start")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "start")//Setting the title.
                    .addField("Aliases: None","This allows a player to start playing!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"inv")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "inv")//Setting the title.
                    .addField("Aliases: Inventory","This allows a player to see their items!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"craft")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "craft [item]")//Setting the title.
                    .addField("Aliases: Forge and Smith","This allows a player to craft, forge, and smith",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"resources")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "resources")//Setting the title.
                    .addField("Aliases: Resource","This allows a player to see the surrounding resources!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"utility")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "Utility")//Setting the title.
                    .addField("Aliases: Utilities","This allows a player to see the utilities around them!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"craftables")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "None")//Setting the title.
                    .addField("Aliases: None","This allows a player to see craftable items!",false)
                    .setFooter("Lisa, your helpful bot!");
        } if(event.getMessage().getContentRaw().equalsIgnoreCase(pre+"recipe")){
            em
                    .setColor(new Color(0, 78, 255, 1))//Setting the color scheme to blue
                    .setTitle(prefix + "recipe [item]")//Setting the title.
                    .addField("Aliases: recipie","This allows a player to see a recipe for an item!",false)
                    .setFooter("Lisa, your helpful bot!");
        }
        try{
            event.getChannel().sendMessage(em.build()).queue();
        }catch(Exception e){

        }

    }


}
