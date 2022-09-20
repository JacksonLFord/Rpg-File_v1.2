package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static DataBase.FileLogger.pad;

public class Utility {
    public static boolean isUtility(MessageReceivedEvent event, FileLogger fl, String prefix, String item) {
        FileLogger.toDir("C:\\Discord\\Player\\" + event.getAuthor().getId() + event.getGuild().getId());
        ArrayList<String> filled = new ArrayList<String>();
        FileLogger.toFile("profile.txt");
        boolean check = false;
        if (FileLogger.read(3).equalsIgnoreCase("true")) {
            String file = FileLogger.read(4);
            FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
            FileLogger.toFile("\\" + file + " - Utility.txt");
            ArrayList<String> resources = FileLogger.readAll();
            //This ArrayList will hold the full file

            int index1 = resources.size();
            //this is getting the index of all the items in the document
            int index2 = 0;
            //Another index to start off

            while (index2 < index1) {
                //While the counter is less than the length of the items in the document
                String number = resources.get(index2).split(";", 5)[1];
                String iteme = resources.get(index2).split(";", 5)[0];
                if (!(number.equalsIgnoreCase("0"))) {
                    //If the items counter is not 0
                    filled.add(resources.get(index2));
                    if(iteme.equalsIgnoreCase(item)){
                        check = true;
                    }
                    //It will add the item to the invhas
                }
                index2++;
                //Continuign the counter
            }

        }
        return check;


    }
    public static void Utilities(MessageReceivedEvent event, FileLogger fl, String prefix) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "utility") ||
                event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "utilities")
        ) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            int pad = 6;
            FileLogger.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId() + event.getGuild().getId());
            FileLogger.toFile( "profile.txt");
            if (FileLogger.read(3).equalsIgnoreCase("true")) {
                String file = FileLogger.read(4);
                FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                FileLogger.toFile("\\" + file + " - Utility.txt");
                ArrayList<String> resources = FileLogger.readAll();
                //This ArrayList will hold the full file
                ArrayList<String> filled = new ArrayList<String>(); int index1 = resources.size();
                //this is getting the index of all the items in the document
                int index2 = 0;
                //Another index to start off

                while (index2 < index1) {
                    //While the counter is less than the length of the items in the document
                    String number = resources.get(index2).split(";", 3)[1];

                    if (!(number.equalsIgnoreCase("0"))) {
                        //If the items counter is not 0
                        filled.add(resources.get(index2));

                        //It will add the item to the invhas
                    }
                    index2++;
                    //Continuign the counter
                }
                EmbedBuilder eb = new EmbedBuilder();

                eb.setColor(new Color(0, 78, 255, 1));
                eb.setFooter("Lisa Chan, your helpful bot!");

                int index3 = filled.size();
                //This is the index of the size of the items that the player has
                int index4 = 0;
                //This is an index of a counter
                int indexco = 0;
                //This is an index so that I will be able to make it so there is only two items per line
                String string = "&";
                //This is the split figure


                while (index4 < index3) {
                    //While the index is less than the size of invhas
                    if (indexco == 2) {
                        //If the counter reaches two it will switch lines
                        string = string + "\n";
                        //Adding a \n figure that will force it to go to the next line.
                        indexco = 0;
                        //It will reset the counter
                    }
                    String subString = pad(filled.get(index4).split(";")[0] , pad);
                    //This will pad each of the items so it will look neat and nice
                    string = string + "```" + subString + "```" + "";
                    //This is the final formating so that it has blcoks aroudn it
                    index4++;
                    //continuing the counter
                    indexco++;
                    //continuion the counter


                }

                try {
                    //This whole thing is setting up the actual inventory
                    boolean bo = (string.split("&")[1] == null);
                    //this is checking to see if the item is null. In essesnce it is checking. But what it is really doing
                    //is that it will cause the try to fail and it to catch, so it will do catch.

                    eb.addField(
                            "Utilities around you!",
                            string.split("&")[1],
                            false);


                    //Setting the inv
                } catch (Exception e) {
                    System.out.println(e);

                    String peed = "```" + pad("There are none!", pad) + "```" + "  ";
                    //Making it so that the inventory responds with "nothing"

                    //padding
                    eb.addField(
                            "Utilities around you!",
                            peed ,
                            false);


                    //Setting the inv


                }
                event.getChannel().sendMessage(eb.build()).queue();

            }else if (FileLogger.read(3).equalsIgnoreCase("false")){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started! ~ Utilities");
                event.getChannel().sendMessage(edore.build()).queue();


            }
        }

    }
}
