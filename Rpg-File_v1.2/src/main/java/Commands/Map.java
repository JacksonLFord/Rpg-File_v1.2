package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static Commands.Location.mainLocation;
import static DataBase.FileLogger.padboth;


public class Map {
    public static void localMap(MessageReceivedEvent event, FileLogger fl, String prefix) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "localMap") || event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "local") || event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "map")) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());


            fl.toFile("profile.txt");

            if (fl.read(3).equalsIgnoreCase("true")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor("Sublocation ~ Location");

                eb.setColor(new Color(0, 78, 255, 1));
                eb.setFooter("Lisa Chan, your helpful bot!");
                eb.setThumbnail(event.getAuthor().getAvatarUrl());
                String localmap = "";
                if (mainLocation(fl.read(4)).equalsIgnoreCase("Forest")) {
                    ArrayList<String> fm = new ArrayList<String>();

                    fm.add("| ``" +padboth("Cottage ~ Forest", 20) + "`` |\n" );
                    fm.add("| ``" +padboth("Center ~ Forest", 20) + "`` |\n" );
                    fm.add("| ``" +padboth("North ~ Forest", 20) + "`` |\n" );
                    fm.add("| ``" +padboth("East ~ Forest", 20) + "`` |\n" );
                    fm.add("| ``" +padboth("West ~ Forest", 20) + "`` |\n" );
                    fm.add("| ``" +padboth("South ~ Forest", 20) + "`` |\n" );
                    int index0 = 0;

                    while(index0<fm.size()){
                        localmap = localmap+fm.get(index0);  System.out.println(localmap);
                        index0++;

                    }

                }

                eb.setDescription(localmap);
                event.getChannel().sendMessage(eb.build()).queue();
            }
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started! ~ Map");
                event.getChannel().sendMessage(edore.build()).queue();

            }

        }

    }

    public static void go(MessageReceivedEvent event, FileLogger fl, String prefix) {

        if (event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + "go")) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

            fl.toFile("profile.txt");
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started! ~ Go");
                event.getChannel().sendMessage(edore.build()).queue();

            }
            String scnd = "";
            try {
                scnd = event.getMessage().getContentRaw().split(" ")[1];
                if (scnd.equalsIgnoreCase(FileLogger.read(4))) {
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa Chan your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("You are already there! ~ Go");
                    event.getChannel().sendMessage(edore.build()).queue();


                } else {
                    if (FileLogger.read(3).equalsIgnoreCase("true")) {
                        if (mainLocation(FileLogger.read(4)).equalsIgnoreCase("Forest")) {
                            if (scnd.equalsIgnoreCase("cottage")) {
                                fl.replace(4, "Cottage");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();
                            } else if (scnd.equalsIgnoreCase("east")) {
                                fl.replace(4, "East");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();

                            } else if (scnd.equalsIgnoreCase("west")) {
                                fl.replace(4, "West");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();

                            } else if (scnd.equalsIgnoreCase("north")) {
                                fl.replace(4, "North");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();

                            } else if (scnd.equalsIgnoreCase("south")) {
                               fl.replace(4, "South");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();

                            } else if (scnd.equalsIgnoreCase("center")) {
                               fl.replace(4, "Center");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();

                            } else if (scnd.equalsIgnoreCase("exit")) {
                                fl.replace(4, "Exit");
                                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();

                            } else {
                                EmbedBuilder edore = new EmbedBuilder();
                                edore.setFooter("Lisa Chan your helpful bot!");
                                edore.setColor(new Color(0, 78, 255, 1));
                                edore.setDescription("That is not a valid place in the Forest! ~ Go");
                                event.getChannel().sendMessage(edore.build()).queue();

                            }
                        }
                    }
                }

            } catch (Exception e) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("Please provide a location to go! ~ Go");
                event.getChannel().sendMessage(edore.build()).queue();
            }

        }


    }
    public static void location(MessageReceivedEvent event, FileLogger fl, String prefix) {
        boolean check = event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "location");
        //This is a boolean to checl to see if the message equals location
        boolean Check = event.getMessage().getContentRaw().toLowerCase().contains(prefix + "location");
        //This is a boolean to check to see if the message contains inv or inventory
        if (check) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

            fl.toFile("profile.txt");
            if (fl.read(3).equalsIgnoreCase("true")) {
                //Checking to see if they player has started
                event.getChannel().sendMessage(locationEmbed(event.getAuthor(), event, fl).build()).queue();
            }
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa Chan your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not already started ~ Location");
                event.getChannel().sendMessage(edore.build()).queue();
            }
        }
        if ((!check) && Check) {
            try {
                User user = event.getMessage().getMentionedMembers().get(0).getUser();
                if(inCombat(event,fl)){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa Chan your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("You are in combat!");
                    event.getChannel().sendMessage(edore.build()).queue();
                    return;
                }
                fl.toDir("C:\\Discord\\Player\\"+user.getId()+event.getGuild().getId());

                fl.toFile("profile.txt");

                if (fl.read(3).equalsIgnoreCase("true")) {
                    event.getChannel().sendMessage(locationEmbed(user, event, fl).build()).queue();

                }
                if (fl.read(3).equalsIgnoreCase("false")) {
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa Chan your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("Mentioned Player has not started ~ Location");
                    event.getChannel().sendMessage(edore.build()).queue();
                }
            } catch (Exception e) {

            }
        }
    }
    public static EmbedBuilder locationEmbed(User user, MessageReceivedEvent event, FileLogger fl) {
        EmbedBuilder eb = new EmbedBuilder();
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

        fl.toFile("profile.txt");

        String MainDesc = "";
        String SubDesc = "";
        String sub = FileLogger.read(4);
        String main = "";
        if (FileLogger.read(4).equalsIgnoreCase("Cottage")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestCottage();
            main = "Forest";
        }
        if (FileLogger.read(4).equalsIgnoreCase("Center")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestCenter();
            main = "Forest";
        }
        if (FileLogger.read(4).equalsIgnoreCase("North")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestNorth();
            main = "Forest";
        }
        if (FileLogger.read(4).equalsIgnoreCase("South")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestSouth();
            main = "Forest";
        }
        if (FileLogger.read(4).equalsIgnoreCase("East")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestEast();
            main = "Forest";
        }
        if (FileLogger.read(4).equalsIgnoreCase("West")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestWest();
            main = "Forest";
        }
        if (FileLogger.read(4).equalsIgnoreCase("Exit")) {
            MainDesc = Location.Forest();
            SubDesc = Location.ForestExit();
            main = "Forest";
        }//"Cottage", "Center", "North", "South", "East", "West", "Exit");

        eb.setAuthor(user.getName() + "'s Location!");

        eb.setColor(new Color(0, 78, 255, 1));
        eb.setFooter("Lisa Chan, your helpful bot!");
        eb.addField(
                "```Location ~ " + main + "```",
                MainDesc,
                false);
        eb.addField(
                "```Sublocation ~ " + sub + "```",
                SubDesc,
                false);

        return eb;
    }
}
