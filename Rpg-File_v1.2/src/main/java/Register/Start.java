package Register;

import Combat.Person;
import DataBase.FileLogger;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Start {
    public static void start(MessageReceivedEvent event, FileLogger fl, String prefix)  {
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

        fl.toFile("profile.txt");
        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "start") && fl.read(3).equalsIgnoreCase("true")) {
            event.getChannel().sendMessage("You have already started!").queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "start") && fl.read(3).equalsIgnoreCase("false")) {



            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

            fl.toFile("profile.txt");
            fl.write(3, "true");
            fl.write(4, "Cottage");

            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
            fl.makeFile("Inv");
            fl.toFile("Inv");
            fl.Copy("Inv","C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId(),"C:\\Discord\\Player", "Base-in"  );
            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
            Person pl = new Person();
            pl.newPlayer(event,fl);
            pl.push(event,fl);





        }
    }
}
