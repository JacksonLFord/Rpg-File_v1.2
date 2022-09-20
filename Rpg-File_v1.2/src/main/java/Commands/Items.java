package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static Commands.Utility.isUtility;
import static Commands.Inventory.*;
import static DataBase.FileLogger.pad;

public class Items {
    public static void itemRecipe(MessageReceivedEvent event, FileLogger fl, String prefix){
        String[] Message = event.getMessage().getContentRaw().split(" ", 2);
        if(Message[0].equalsIgnoreCase(prefix + "recipe") ||Message[0].equalsIgnoreCase(prefix + "recipie")){
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            if(Message.length>1){
                try{
                    String item = Message[1];
                    ArrayList<String> info = recipe(item);
                    String resources = info.get(0);
                    String Utilties = info.get(1);
                    String[] reso = resources.split(",");
                    String[] utili = Utilties.split(",");
                    EmbedBuilder em = new EmbedBuilder();
                    int index1 = 0;
                    String str = " ";
                    while(index1<utili.length){
                        str = str +"```" +utili[index1].split(";")[0] +"```";
                        index1++;
                    }int index2 = 0;
                    String stri = " ";
                    while(index2< reso.length){
                        stri = stri +"```" +reso[index2].split(";")[1]+ " x " +reso[index2].split(";")[0] +"```";
                        index2++;
                    }
                    em.setAuthor("Recipe for "+ Message[1]+ "!");
                    em.addField("Utilities and Tools:",
                            str
                            ,false);
                    em.addField("Required Items",
                            stri
                            ,false);
                    em.setFooter("Lisa your helpful bot!");
                    em.setColor(new Color(0, 78, 255, 1));
                    event.getChannel().sendMessage(em.build()).queue();
                }catch(Exception e){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("The item you provided cannot be crafted! ~ Recipes");
                    event.getChannel().sendMessage(edore.build()).queue();

                }

            }if(Message.length==1){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You did not provide an item! ~ Recipes");
                event.getChannel().sendMessage(edore.build()).queue();


            }

        }

    }
    public static void Craftables(MessageReceivedEvent event, String prefix, FileLogger fl){

        ArrayList<String> c = new ArrayList<String>();
        c.add("Bronze Sword");
        c.add("Lead");
        c.add("Iron");
        c.add("Bronze");
        c.add("Elemental Staff");
        c.add("Wood Longbow");
        c.add("Diamond");
        c.add("Emerald");
        c.add("Sapphire");
        c.add("Topaz");
        c.add("Ruby");
        c.add("Amethyst");
        c.add("Bronze Axe");
        c.add("Bronze Pick");
        c.add("Bronze Blacksmith Tools");
        c.add("Bronze Knife");
        c.add("Adamantium");
        c.add("Titanium");
        c.add("Platnium");
        c.add("Gold");
        c.add("Silver");
        c.add("Mithril");
        c.add("Cobolt");
        c.add("Copper");
        c.add("Coal");

        ArrayList<String> invhas = c;
        int index3 = invhas.size();
        //This is the index of the size of the items that the player has
        int index4 = 0;
        //This is an index of a counter
        int indexco = 0;
        //This is an index so that I will be able to make it so there is only two items per line
        String string = "&";
        //This is the split figure
        int new4 = 0;
        //This is an index of a counter
        int newco = 0;
        int firstcount = 0;
        int secondcount = 0;

        Boolean string22 = false;
        while (index4 < index3) {
            //While the index is less than the size of invhas

                if (indexco == 2) {
                    //If the counter reaches two it will switch lines
                    string = string + "\n";
                    //Adding a \n figure that will force it to go to the next line.
                    indexco = 0;
                    //It will reset the counter
                }

                String subString = pad(invhas.get(index4), 30);
                //This will pad each of the items so it will look neat and nice
                string = string + "``" + subString + "``" + " | ";
                //This is the final formating so that it has blcoks aroudn it
                index4++;
                //continuing the counter
                indexco++;
                //continuion the counter
                firstcount++;





        }
        EmbedBuilder em = new EmbedBuilder();

        //Making the embed builder


        //setting the author
        em.setColor(new Color(0, 78, 255, 1));

        //Setting the footer


        em.setFooter("Lisa, your helpful bot!");

        try {
            //This whole thing is setting up the actual inventory
            boolean bo = (string.split("&")[1] == null);
            //this is checking to see if the item is null. In essesnce it is checking. But what it is really doing
            //is that it will cause the try to fail and it to catch, so it will do catch.
            if (!(firstcount % 2 == 0)) {
                //checking to see if the item list is uneven
                string = string + "``" + pad("", 30) + "``" + " | \n";
                //if it is uneven it will make it so that another blnk item is added
            }
            if (firstcount + 1 == 2) {
                //this will check to see if there is not 4. When it is just two spaces, it looks weird
                string = string + "``" + pad("", 30) + "``" + " | ";
                //Padding
                string = string + "``" + pad("", 30) + "``" + " | ";
                //padding
            }

            em.setDescription(string.split("&")[1]);
            em.setTitle("Craftables");
            //Setting the inv





        } catch (Exception e) {

        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"craftables")){
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            event.getChannel().sendMessage(em.build()).queue();
        }
    }
    public static void craft(MessageReceivedEvent event, FileLogger fl, String prefix){
        String[] Message = event.getMessage().getContentRaw().split(" ", 2);
        if (Message[0].equalsIgnoreCase(prefix + "craft") ||
                Message[0].equalsIgnoreCase(prefix + "forge")
                || Message[0].equalsIgnoreCase(prefix + "smith")
        ) {
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
                try{
                    String item = Message[1];
                    ArrayList<String> infof = recipe(item);
                    String resourcesf = infof.get(0);
                    String Utiltiesf = infof.get(1);
                    String[] resof = resourcesf.split(",");
                    String[] utilif = Utiltiesf.split(",");
                    int index10 = 0;
                    boolean toolcheck = true;
                    boolean utilitycheck = true;
                    String finaltool ="";
                    String finalutility = "";
                    while(index10<utilif.length){

                        String tool = utilif[index10];
                        String[] tools = tool.split(";");
                        String thing = tools[0];
                        String desc = tools[1];
                        if(desc.equalsIgnoreCase("Tool")){
                            toolcheck = checkInvContains(event,fl,thing,1);
                            finaltool = thing;
                        }else if(desc.equalsIgnoreCase("Utility")){
                            utilitycheck = isUtility(event,fl,prefix,thing);
                            finalutility = thing;
                        }
                    index10++;
                    }
                    if(utilitycheck && toolcheck){
                    //if the person has all the tools and all the utilities
                        int index0  = 0;
                        boolean check1 = true;
                        while(index0< resof.length){

                            if(checkInv(event, fl, resof[index0].split(";")[0],Integer.parseInt(resof[index0].split(";")[1]))){

                            } if(!checkInv(event, fl, resof[index0].split(";")[0],Integer.parseInt(resof[index0].split(";")[1]))){
                                check1 = false;

                            }
                            index0++;
                        }if(check1){
                            invAdd(event,fl,item,1);

                            index0 = 0;
                            while(index0< resof.length){
                                invAdd(event,fl, resof[index0].split(";")[0] , -1 * Integer.parseInt(resof[index0].split(";")[1]));
                                index0++;
                            }
                            EmbedBuilder em = new EmbedBuilder();
                            if(finalutility.equalsIgnoreCase("")){
                                em.setTitle("You use your " + finaltool + " to craft a "+item+"!");
                            }if(!finalutility.equalsIgnoreCase("") && !finaltool.equalsIgnoreCase("")){
                                em.setTitle("You use your " + finaltool+ " to craft a "+ item+ " on a "+finalutility+"!");
                            } if(!finalutility.equalsIgnoreCase("") && !finaltool.equalsIgnoreCase("")){
                                em.setTitle("You craft a "+item+"!");
                            }

                            em.setAuthor("Crafting successful!");
                            em.setDescription("```+1 "+item+"```" );
                            em.setFooter("Lisa your helpful bot!");
                            em.setColor(new Color(0, 78, 255, 1));
                            event.getChannel().sendMessage(em.build()).queue();

                        }
                        if(!check1){
                            EmbedBuilder edore = new EmbedBuilder();
                            edore.setFooter("Lisa your helpful bot!");
                            edore.setColor(new Color(0, 78, 255, 1));
                            edore.setAuthor("You do not have all the materials for: "+item);
                            edore.setDescription("Try doing #recipe [item] to find out the recipe." );
                            event.getChannel().sendMessage(edore.build()).queue();


                        }
                    }   if(utilitycheck && !toolcheck){
                        //has utility but not tools
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("You do not have the proper tools! ~ Craft");
                        event.getChannel().sendMessage(edore.build()).queue();
                    }   if(!utilitycheck && toolcheck){
                        //reverse of above
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("You are not at the proper utilities! ~ Craft");
                        event.getChannel().sendMessage(edore.build()).queue();
                    }   if(!utilitycheck && !toolcheck){
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("You are not at the proper utility, nor have the proper tools! ~ Craft");
                        event.getChannel().sendMessage(edore.build()).queue();
                        //They dont have anything
                    }


                }catch(Exception e){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("The item you provided cannot be crafted! ~ Craft");
                    event.getChannel().sendMessage(edore.build()).queue();
                    e.printStackTrace();

                }
            } if (FileLogger.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started! ~ Craft");
                event.getChannel().sendMessage(edore.build()).queue();

            }

        }
    }
    public static ArrayList<String> recipe(String item){
        ArrayList<String> list = new ArrayList<String>();
        if(item.replaceAll(" ", "").equalsIgnoreCase("BronzeSword")){
           list = BronzeSword();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Lead")){
            list = Lead();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Iron")){
            list = Iron();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Bronze")){
            list = Bronze();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("ElementalStaff")){
            list = ElementalStaff();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("WoodLongbow")){
            list = WoodLongBow();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Diamond")){
            list =  Diamond();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Emerald")){
            list = Emerald();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Sapphire")){
            list = Sapphire();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Topaz")){
            list = Topaz();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Ruby")){
            list = Ruby();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Amethyst")){
            list = Amethyst();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("BronzeAxe")){
            list =BronzeAxe();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("BronzePick")){
            list = BronzePick();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("BronzeBlacksmithTools")){
            list = BronzeBlacksmithTools();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("BronzeKnife")){
            list = BronzeKnife();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Adamantium")){
            list = Adamantium();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Titanium")){
            list = Titanium();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Platnium")){
            list = Platnium();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Gold")){
            list = Gold();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Silver")){
            list = Silver();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Mithril")){
            list = Mithril();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Cobolt")){
            list = Cobolt();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Copper")){
            list = Copper();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Lead")){
            list = Lead();
        }if(item.replaceAll(" ", "").equalsIgnoreCase("Coal")){
            list = Coal();
        }
        return list;

    }
    public static ArrayList<String> BronzeSword(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Bronze;2,Wood;1");
        list.add("Anvil;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Lead(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Lead Ore;1");
        list.add("Smithy;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Iron(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Iron Ore;1");
        list.add("Smithy;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Bronze(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Copper Ore;1,Lead Ore;1");
        list.add("Smithy;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> ElementalStaff(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Crystal;1,Wood;3");
        list.add("Knife;Tool");
        return list;
    }public static ArrayList<String> WoodLongBow(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Bowstring;1,Wood;3");
        list.add("Knife;Tool");
        return list;
    }public static ArrayList<String> Diamond(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Uncut Diamond;1");
        list.add("Chisel;Tool");
        return list;
    }public static ArrayList<String> Emerald(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Uncut Emerald;1");
        list.add("Chisel;Tool");
        return list;
    }public static ArrayList<String> Sapphire(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Uncut Sapphire;1");
        list.add("Chisel;Tool");
        return list;
    }public static ArrayList<String> Topaz(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Uncut Topaz;1");
        list.add("Chisel;Tool");
        return list;
    }public static ArrayList<String> Ruby(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Uncut Ruby;1");
        list.add("Chisel;Tool");
        return list;
    }public static ArrayList<String> Amethyst(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Uncut Amethyst;1");
        list.add("Chisel;Tool");
        return list;
    }public static ArrayList<String> BronzeAxe(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Bronze;1,Wood;2");
        list.add("Anvil;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> BronzePick(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Bronze;2,Wood;1");
        list.add("Anvil;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> BronzeBlacksmithTools(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Bronze;5,Wood;2");
        list.add("Anvil;Utility");
        return list;
    }public static ArrayList<String> BronzeKnife(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Bronze;1,Wood;1");
        list.add("Anvil;Utility,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Adamantium(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Adamantium Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Titanium(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Titanium Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Platnium(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Platnium Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Gold(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Gold Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Silver(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Silver Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Mithril(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Mithril Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Cobolt(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Cobolt Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Copper(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Copper Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }public static ArrayList<String> Coal(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Coal Ore;1");
        list.add("Anvil;Smithy,Blacksmith Tools;Tool");
        return list;
    }






}
