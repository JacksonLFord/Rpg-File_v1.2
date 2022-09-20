package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/*
The "Prefix" Class will contain all the methods in reference to the
"prefix" that is used by the bot. Each prefix will be specific to each
Guild, i.e server. This contains two methods. findPrefix() is the
method that will determine the prefix of the guild. toPrefix() is the
method that will change the prefix in the guild files.


All credit goes to the unofficial "Jamais Mort" group. The head Project
developer is Jackson Ford(DocileThief#8980)
 */
public class Prefix {

    public static String findPrefix(MessageReceivedEvent event, FileLogger fl) {
        fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId());
        //Changing the Directory to the guild info
        fl.toFile(event.getGuild().getId() + "- Data.txt");
        //Changing the file directory to the Guild Information
        return fl.read(0);
        //returning the prefix
    }

    public static void toPrefix(MessageReceivedEvent event, FileLogger fl, String prefix) {
        fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId());
        //Changing the Directory to the guidl info
       fl.toFile(event.getGuild().getId() + "- Data.txt");
        //Changing the file directory to the guild Information
        String[] split = event.getMessage().getContentRaw().split(" ");
        //This is getting the message and spliting it so we can find the prefix that is in the command
        try {
            //Try method due to it possibly being null
            if (split[0].equalsIgnoreCase(prefix + "prefix") && event.getMember()
                    .hasPermission(Permission.ADMINISTRATOR)) {

                //Checking to see if the Author has admin perms
                fl.replace(0, split[1]);
                //This will put the new prefix in the file
                event.getChannel().sendMessage("Your new prefix is " + split[1] + "!").queue();
                //Telling the person what their new prefix is
            }
            if (!(event.getMember().hasPermission(Permission.ADMINISTRATOR)) && split[0]
                    .equalsIgnoreCase(prefix + "prefix")) {
                //If the person did the correct command, but are not Admin
                event.getChannel().sendMessage("You are not an Admin!").queue();
                //This will respond with a chastizing message, that they are not Admin

            }
        } catch (Exception e) {
            //If it fails, it will most likely be due to null value.
            event.getChannel().sendMessage("Please provide a new prefix!").queue();
            //Responding will request for mentioned prefix
        }

    }

}
