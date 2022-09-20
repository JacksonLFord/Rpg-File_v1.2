package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static Commands.DropTable.checker;
import static Commands.Inventory.checkInvContains;
import static DataBase.FileLogger.pad;

public class Resources {
    public static void resources(MessageReceivedEvent event, FileLogger fl, String prefix) {
        int pad = 22;
        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "resource") ||
                event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "resources")
        ) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            FileLogger.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId() + event.getGuild().getId());
            FileLogger.toFile( "profile.txt");
            if (FileLogger.read(3).equalsIgnoreCase("true")) {
                String file = FileLogger.read(4);
                FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                FileLogger.toFile("\\" + file + ".txt");
                ArrayList<String> resources = FileLogger.readAll();
                //This ArrayList will hold the full file
                ArrayList<String> filled = new ArrayList<String>();
                //This will make it a list of only items the person has


                int index1 = resources.size();
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
                    String subString = pad(filled.get(index4).split(";")[0] + ":" + filled.get(index4).split(";")[1], pad);
                    //This will pad each of the items so it will look neat and nice
                    string = string + "``" + subString + "``" + " | ";
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
                    if (!(filled.size() % 2 == 0)) {
                        //checking to see if the item list is uneven
                        string = string + "``" + pad("", pad) + "``" + " | \n";
                        //if it is uneven it will make it so that another blnk item is added
                    }
                    if (filled.size() + 1 == 2) {
                        //this will check to see if there is not 4. When it is just two spaces, it looks weird
                        string = string + "``" + pad("", pad) + "``" + " | ";
                        //Padding
                        string = string + "``" + pad("", pad) + "``" + " | ";
                        //padding
                    }
                    eb.addField(
                            "Resources around you!",
                            string.split("&")[1],
                            false);


                    //Setting the inv
                } catch (Exception e) {
                    System.out.println(e);

                    String peed = "``" + pad("There is nothing!", pad) + "``" + " | ";
                    //Making it so that the inventory responds with "nothing"
                    String pud = "``" + pad("", pad) + "``" + " | ";
                    //padding
                    eb.addField(
                            "Resources around you!",
                            peed + pud + "\n" + pud + pud,
                            false);


                    //Setting the inv


                }
                event.getChannel().sendMessage(eb.build()).queue();

            }
            if (FileLogger.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started! ~ Resources");
                event.getChannel().sendMessage(edore.build()).queue();


            }
        }

    }
    public static void gather(MessageReceivedEvent event, FileLogger fl, String prefix) {
        if (event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + "gather") ||
                event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + "mine") ||
                event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + "chop")
        ) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            FileLogger.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId() + event.getGuild().getId());
            FileLogger.toFile(  "profile.txt");
            if (FileLogger.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started! ~ Gather");
                event.getChannel().sendMessage(edore.build()).queue();

            }
            if (FileLogger.read(3).equalsIgnoreCase("true")) {
                String file = FileLogger.read(4);
                FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                FileLogger.toFile("\\" + file + ".txt");
                ArrayList<String> resources = FileLogger.readAll();

                //This ArrayList will hold the full file
                ArrayList<String> filled = new ArrayList<String>();

                //This will make it a list of only items the person has


                int index1 = resources.size();
                //this is getting the index of all the items in the document
                int index2 = 0;
                //Another index to start off

                while (index2 < index1) {
                    //While the counter is less than the length of the items in the document
                    String number = resources.get(index2).split(";", 3)[1];
                    if (!(number.equalsIgnoreCase("0"))) {
                        //If the items counter is not 0
                        filled.add(resources.get(index2).split(";")[0].toLowerCase());

                        //It will add the item to the invhas
                    }
                    index2++;
                    //Continuign the counter
                }
                try {
                    String[] split = event.getMessage().getContentRaw().split(" ");
                    int index0 = 1;
                    int index3 = split.length;
                    String words = "";
                    while (index0 < index3) {
                        words = words + " " + split[index0];
                        index0++;
                    }
                    words = words.trim();
                    boolean checkee = false;
                    int index4 = 0;
                    while(index4<filled.size() && (!words.equalsIgnoreCase("rock")) &&(!words.equalsIgnoreCase("ore"))   ){

                        if(filled.get(index4).contains(words.toLowerCase())){
                            checkee = true;
                        }
                        index4++;
                    }
                    if (checkee) {
                        int int10 = resources.size();

                        int int0 = 0;
                        int mark = 0;
                        while (int0 < int10) {

                            if (resources.get(int0).toLowerCase().contains(words.toLowerCase())) {

                                mark = int0;

                            }
                            int0++;
                        }
                        String newitem = "";

                        boolean check1 = false;
                        boolean toolcheck = false;
                        String tool = "";
                        String method = "";
                        if (checkInvContains(event, fl, "axe", 1)) {

                            if (resources.get(mark).split(";")[2].equalsIgnoreCase("axe")) {
                                check1 = true;
                                method = "Chop";

                                if (event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + "chop")) {
                                    toolcheck = true;

                                    tool = "Axe";

                                    String[] strs = resources.get(mark).split(";",3);


                                    int number = Integer.parseInt(strs[1]) -1;
                                    String newstr = strs[0] + ";" + number + ";" + strs[2];
                                    FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                                    FileLogger.toFile("\\" + file + ".txt");
                                    fl.replace(mark, newstr);
                                }
                            }
                        }
                        if (checkInvContains(event, fl, "Pick" , 1)) {
                            if (resources.get(mark).split(";")[2].equalsIgnoreCase("pick")) {
                                check1 = true;
                                method = "mine";
                                if (event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + "mine")) {
                                    toolcheck = true;

                                    tool = "Pick";

                                    String[] strs = resources.get(mark).split(";",3);


                                    int number = Integer.parseInt(strs[1]) -1;
                                    String newstr = strs[0] + ";" + number + ";" + strs[2];
                                    FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                                    FileLogger.toFile("\\" + file + ".txt");
                                    fl.replace(mark, newstr);




                                }
                            }
                        }

                        if (check1 && toolcheck) {
                            FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                            FileLogger.toFile("\\" + file + ".txt");
                            ArrayList<String> resource = FileLogger.readAll();

                            //if they used the right command and tey have the tool
                            ArrayList<String> reward = checker(resources.get(mark).split(";", 5)[0]);
                            int index100 = reward.size();
                            int index1000 = 0;
                            String sentence = "";
                            while (index1000 < index100) {
                                sentence = sentence + "+" + reward.get(index1000).split(";", 2)[1] + " " +
                                        reward.get(index1000).split(";", 5)[0] + "\n";
                                index1000++;
                            }

                            FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
                            FileLogger.toFile("\\" + file + ".txt");
                            int newnumber = Integer.parseInt(resources.get(mark).split(";", 5)[1]) - 1;
                            newitem = resources.get(mark).split(";")[0] + ";" + newnumber + ";" + resources.get(mark).split(";")[2];
                            FileLogger.replace(mark, newitem);
                            EmbedBuilder em = new EmbedBuilder();
                            em.setTitle("You use your " + tool + " to " + method + " a " + resources.get(mark).split(";")[0] + "!");
                            em.setAuthor("Resource update!");
                            em.setDescription(sentence);
                            em.setFooter("Lisa Chan your helpful bot!");
                            em.setColor(new Color(0, 78, 255, 1));
                            event.getChannel().sendMessage(em.build()).queue();
                            FileLogger.toDir("C:\\Discord\\Player\\" + event.getAuthor().getId() + event.getGuild().getId());
                            FileLogger.toFile("\\" +"Inv.txt");
                            ArrayList<String> inv = FileLogger.readAll();
                            int indexof2 = reward.size();
                            int indexof = 0;
                            while (indexof < indexof2) {
                                int int100000 = inv.size();
                                int int000000 = 0;
                                int markkkkk = 0;
                                while (int000000 < int100000) {

                                    if( inv.get(int000000).split(";", 5)[0].toLowerCase().equalsIgnoreCase(reward.get(indexof).split(";", 5)[0].toLowerCase())){

                                        markkkkk = int000000;

                                    }
                                    int000000++;
                                }
                                int integer = Integer.parseInt(reward.get(indexof).split(";", 5)[1]);


                                int integer1 = Integer.parseInt(inv.get(markkkkk).split(";", 5)[1]);
                                int integer2 = integer + integer1;

                                String replacement = reward.get(indexof).split(";", 5)[0] + ";" + integer2 +";"+fl.read(markkkkk).split(";", 3)[2] ;


                                FileLogger.replace(markkkkk, replacement);
                                indexof++;
                            }


                        }
                        if (!check1) {
                            //they do not have the tool
                            EmbedBuilder edore = new EmbedBuilder();
                            edore.setFooter("Lisa Chan your helpful bot!");
                            edore.setColor(new Color(0, 78, 255, 1));
                            edore.setDescription("You do not have the right tool! ~ " + resources.get(mark).split(";", 5)[2]);
                            event.getChannel().sendMessage(edore.build()).queue();

                        }
                        if (check1 && !toolcheck) {
                            //they did not use the right comman
                            EmbedBuilder edore = new EmbedBuilder();
                            edore.setFooter("Lisa Chan your helpful bot!");
                            edore.setColor(new Color(0, 78, 255, 1));
                            edore.setDescription("You did not use the right method! ~ " + method);
                            event.getChannel().sendMessage(edore.build()).queue();

                        }

                    }
                    if (!filled.contains(words.toLowerCase())) {
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa Chan your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("The resource you are looking for isnt here! ~ Resource");
                        event.getChannel().sendMessage(edore.build()).queue();



                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa Chan your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("Please provide a resource! ~ Resources");
                    event.getChannel().sendMessage(edore.build()).queue();


                }
            }
        }
    }
}
