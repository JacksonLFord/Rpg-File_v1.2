package Register;

import Combat.Enemy;
import DataBase.FileLogger;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Player {
    public static boolean isGuild(MessageReceivedEvent event, FileLogger fl) {
        //This will return whether or not the guild is registered
        fl.toDir("C:\\Discord\\Guild");
        //This is the location of the Guild files.
        fl.toFile("GuildList.txt");
        //This is the file with the guild info
        return fl.readAll().contains(event.getGuild().getId());
        //returning the final value
    }

    public static void regGuild(MessageReceivedEvent event, FileLogger fl) {
        //This method will see if the guild is registered.
        //It will also register the guild if it is not.
        if (isGuild(event, fl)) {//if the guild is registered
            //do nothing
        }
        if (!(isGuild(event, fl))) {
            //response for if the guild is not registered
            fl.toDir("C:\\Discord\\Guild");
            //This is the location of the Guild files.
            fl.toFile("GuildList.txt");
            //This is the file with the guild info.
            fl.write(event.getGuild().getId());
            //This will add the guild id to the register
            fl.toDir("C:\\Discord\\Guild\\");
            fl.makeFolder(event.getGuild().getId());
            fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId());
            fl.makeFile(event.getGuild().getId() + "- Players");
            //Creating a new Guild File with the player list
            fl.makeFile(event.getGuild().getId() + "- Data");
            //This will make a file with all the data for the server
            fl.toFile(event.getGuild().getId() + "- Data.txt");
            //Changing the file destination to the guild info.
            int index100 = 0;
            int index200 = 40; //preparing the indexes
            while (index100 < index200) {
                //While statment to iterate 40 times so that there will be 40 "falses"
                fl.write("false");
                //This will write false
                index100++;//this will continue the index
            }
            fl.replace(0, "#");
            //this will change the first item on the guild info to the default prefix
            fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId());
            fl.makeFolder("Info");
            try{
                fl.copyDirectory("C:\\Discord\\Guild\\Info",
                        "C:\\Discord\\Guild\\" + event.getGuild().getId() +  "\\info" );
            }catch(Exception e){
                e.printStackTrace();
            }

            fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId()+"\\Info");
            fl.toFile("East - Enemy.txt");
            int index = 0;
            int index2 = 100;
            while(index<index2){
                Enemy enemy = new Enemy();
                int dice1 = (int) (Math.random() * 15 + 1);

                enemy.genGoblin(dice1);
                enemy.push(event,fl,"East");
                index++;
            }




        }

    }

    public static boolean isPlayer(MessageReceivedEvent event, FileLogger fl) {
        fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId());
        fl.toFile(event.getGuild().getId() + "- Players.txt");

            return fl.readAll().contains(event.getAuthor().getId());
            //returning check
        }

        public static void regPlayer(MessageReceivedEvent event, FileLogger fl) {
            if (!isPlayer(event, fl)){
                fl.toDir("C:\\Discord\\Guild\\"+event.getGuild().getId());
                fl.toFile(event.getGuild().getId() + "- Players.txt");
                fl.write(event.getAuthor().getId());
                fl.toDir("C:\\Discord\\Player");
                fl.makeFolder(event.getAuthor().getId()+event.getGuild().getId());
                fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

                fl.makeFile("profile");
                fl.toFile("profile.txt");
                fl.write(event.getAuthor().getName());
                int index100 = 0;
                int index200 = 39; //preparing the indexes
            while (index100 < index200) {
                //While statment to iterate 40 times so that there will be 40 "falses"
                fl.write("false");
                //This will write false
                index100++;//this will continue the index
            }
        }

    }



}
