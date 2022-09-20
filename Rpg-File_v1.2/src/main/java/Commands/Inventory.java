package Commands;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static DataBase.FileLogger.pad;

public class Inventory {
    public static boolean allInv(MessageReceivedEvent event, FileLogger fl, String item){
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
        //Changing the directory to the Player file
        fl.toFile("Inv.txt");
        //Changing the directory to the file with the inventory of the player
        ArrayList<String> inv = fl.readAll();
      //This will make it a list of only items the person has
        inv.remove(0);
        //This is removing the first item in the Document
        int index1 = inv.size();
        //this is getting the index of all the items in the document


        int int10 = inv.size();

        int int0 = 0;
        int mark = 0;
        boolean check1 = false;

        while (int0 < int10) {

            if (inv.get(int0).split(";", 5)[0].toLowerCase().equalsIgnoreCase(item.toLowerCase())) {

                mark = int0;

                check1 = true;

            }
            int0++;
        }

        return check1;
    }
    public static boolean checkInv(MessageReceivedEvent event, FileLogger fl, String item, int amount) {
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
        //Changing the directory to the Player file
        fl.toFile("Inv.txt");
        //Changing the directory to the file with the inventory of the player
        ArrayList<String> inv = fl.readAll();

        ArrayList<String> invhas = new ArrayList<String>();
        //This will make it a list of only items the person has
        inv.remove(0);
        //This is removing the first item in the Document
        int index1 = inv.size();
        //this is getting the index of all the items in the document
        int index2 = 0;
        //Another index to start off
        while (index2 < index1) {
            //While the counter is less than the length of the items in the document
            if (!(inv.get(index2).split(";")[1].equalsIgnoreCase("0"))) {
                //If the items counter is not 0
                invhas.add(inv.get(index2));
                //It will add the item to the invhas
            }
            index2++;
            //Continuign the counter
        }

        int int10 = invhas.size();

        int int0 = 0;
        int mark = 0;
        boolean check1 = false;
        boolean check2 = false;
        while (int0 < int10) {

            if (invhas.get(int0).split(";", 5)[0].toLowerCase().equalsIgnoreCase(item.toLowerCase())) {

                mark = int0;

                check1 = true;

            }
            int0++;
        }
        int check = 0;
        try{

             check = Integer.parseInt(invhas.get(mark).split(";")[1]);
        }catch(Exception e){

        }


        if(check<amount){
            check2 = false;
        }if(check>=amount){
            check2 = true;
        }
        boolean check3 = check2 && check1;
        return check3;

    }
    public static void invAdd(MessageReceivedEvent event, FileLogger fl, String item, int amount){
        FileLogger.toDir("C:\\Discord\\Player\\" + event.getAuthor().getId() + event.getGuild().getId());
        FileLogger.toFile("\\" +"Inv.txt");
        ArrayList<String> inv = FileLogger.readAll();


            int int100000 = inv.size();
            int int000000 = 0;
            int markkkkk = 0;
            while (int000000 < int100000) {

                if( inv.get(int000000).split(";", 5)[0].toLowerCase().equalsIgnoreCase(item.toLowerCase())){

                    markkkkk = int000000;

                }
                int000000++;
            }if(!(markkkkk==0)){
            int integer = amount;


            int integer1 = Integer.parseInt(inv.get(markkkkk).split(";", 5)[1]);
            int integer2 = integer + integer1;

            String replacement =fl.read(markkkkk).split(";", 3)[0] + ";" + integer2 +";"+fl.read(markkkkk).split(";", 3)[2] ;


            FileLogger.replace(markkkkk, replacement);
        }else{
                System.out.println("Item does not exist");
        }



    }

        public static boolean checkInvContains (MessageReceivedEvent event, FileLogger fl, String item, int amount) {
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
        //Changing the directory to the Player file
        fl.toFile("Inv.txt");
        //Changing the directory to the file with the inventory of the player
        ArrayList<String> inv = fl.readAll();

        ArrayList<String> invhas = new ArrayList<String>();
        //This will make it a list of only items the person has
        inv.remove(0);
        //This is removing the first item in the Document
        int index1 = inv.size();
        //this is getting the index of all the items in the document
        int index2 = 0;
        //Another index to start off
        while (index2 < index1) {
            //While the counter is less than the length of the items in the document
            if (!(inv.get(index2).split(";")[1].equalsIgnoreCase("0"))) {
                //If the items counter is not 0
                invhas.add(inv.get(index2));
                //It will add the item to the invhas
            }
            index2++;
            //Continuign the counter
        }

        int int10 = invhas.size();

        int int0 = 0;
        int mark = 0;
        boolean check1 = false;
        boolean check2 = false;
        while (int0 < int10) {

            if (invhas.get(int0).split(";", 5)[0].toLowerCase().contains(item.toLowerCase())) {

                mark = int0;

                check1 = true;

            }
            int0++;
        }
        int check = 0;
        try{

            check = Integer.parseInt(invhas.get(mark).split(";")[1]);
        }catch(Exception e){

        }


        if(check<amount){
            check2 = false;
        }if(check>=amount){
            check2 = true;
        }
        boolean check3 = check2 && check1;
        return check3;
    }

    public static void inv(MessageReceivedEvent event, FileLogger fl, String prefix) {
        boolean check = event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "inv") ||
                event.getMessage().getContentRaw().equalsIgnoreCase(prefix + "inventory");
        //This is a boolean to checl to see if the message equals inv or inventory
        boolean Check = event.getMessage().getContentRaw().toLowerCase().contains(prefix + "inv") ||
                event.getMessage().getContentRaw().toLowerCase().contains(prefix + "inventory");
        //This is a boolean to check to see if the message contains inv or inventory
        if (check) {
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());

            fl.toFile("profile.txt");
            if (fl.read(3).equalsIgnoreCase("true")) {
                //Checking to see if they player has started

                int index = 0;
                ArrayList<EmbedBuilder> embeds = invEmbed(event.getAuthor(), event, fl);
                int index1 = embeds.size();
                while(index<index1){
                    event.getChannel().sendMessage(embeds.get(index).build()).queue();
                    index++;
                }
            }
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not already started! ~ Inventory");
                event.getChannel().sendMessage(edore.build()).queue();

            }
        }
        if ((!check) && Check) {
            try {
                User user = event.getMessage().getMentionedMembers().get(0).getUser();
                fl.toDir("C:\\Discord\\Player\\"+user.getId()+event.getGuild().getId());

                fl.toFile("profile.txt");

                if (fl.read(3).equalsIgnoreCase("true")) {
                    int index = 0;
                    ArrayList<EmbedBuilder> embeds = invEmbed(user, event, fl);
                    int index1 = embeds.size();
                    while(index<index1){
                        event.getChannel().sendMessage(embeds.get(index).build()).queue();
                        index++;
                    }


                }
                if (fl.read(3).equalsIgnoreCase("false")) {
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("Mentioned player has not started! ~ Inventory");
                    event.getChannel().sendMessage(edore.build()).queue();

                }
            } catch (Exception e) {

            }
        }
    }
    public static ArrayList<EmbedBuilder> invEmbed(User user, MessageReceivedEvent event, FileLogger fl) {
        fl.toDir("C:\\Discord\\Player\\"+user.getId()+event.getGuild().getId());

        fl.toFile("Inv.txt");
        //Changing the directory to the file with the inventory of the player
        ArrayList<String> inv = fl.readAll();
        //This ArrayList will hold the full file
        ArrayList<String> invhas = new ArrayList<String>();
        //This will make it a list of only items the person has
        inv.remove(0);
        //This is removing the first item in the Document
        int index1 = inv.size();
        //this is getting the index of all the items in the document
        int index2 = 0;
        //Another index to start off
        while (index2 < index1) {
            //While the counter is less than the length of the items in the document
            if (!(inv.get(index2).split(";")[1].equalsIgnoreCase("0"))) {
                //If the items counter is not 0
                invhas.add(inv.get(index2));
                //It will add the item to the invhas
            }
            index2++;
            //Continuign the counter
        }
        EmbedBuilder ec = new EmbedBuilder();
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
        String string2 = "&";
        Boolean string22 = false;
        while (index4 < index3) {
            //While the index is less than the size of invhas
            if(string.length()>2000){
                string22 = true;
                if (newco == 2) {
                    //If the counter reaches two it will switch lines
                    string2 = string2 + "\n";
                    //Adding a \n figure that will force it to go to the next line.
                    newco = 0;
                    //It will reset the counter
                }
                String subString = pad(invhas.get(index4).split(";")[0] + ":" + invhas.get(index4).split(";")[1], 30);
                //This will pad each of the items so it will look neat and nice
                string2 = string2 + "``" + subString + "``" + " | ";
                //This is the final formating so that it has blcoks aroudn it
                secondcount++;
                newco++;
                index4++;
            }if(string.length()<2000){
                if (indexco == 2) {
                    //If the counter reaches two it will switch lines
                    string = string + "\n";
                    //Adding a \n figure that will force it to go to the next line.
                    indexco = 0;
                    //It will reset the counter
                }
                String subString = pad(invhas.get(index4).split(";")[0] + ":" + invhas.get(index4).split(";")[1], 30);
                //This will pad each of the items so it will look neat and nice
                string = string + "``" + subString + "``" + " | ";
                //This is the final formating so that it has blcoks aroudn it
                index4++;
                //continuing the counter
                indexco++;
                //continuion the counter
                firstcount++;
            }



        }
        EmbedBuilder em = new EmbedBuilder();

        //Making the embed builder

        //setting the author
        ec.setColor(new Color(0, 78, 255, 1));
        //setting the author
        em.setColor(new Color(0, 78, 255, 1));

        //Setting the footer


        if(string22){
            em.setFooter("Lisa, your helpful bot!");
        }if(!string22){
            ec.setFooter("Lisa, your helpful bot!");
        }
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

            ec.setDescription(string.split("&")[1]);
            ec.setTitle(user.getName() + "'s Inventory!");
            //Setting the inv

            if(string22){
                string2 = string2.split("&")[1];
                //This whole thing is setting up the actual inventory

                //this is checking to see if the item is null. In essesnce it is checking. But what it is really doing
                //is that it will cause the try to fail and it to catch, so it will do catch.
                if (!(secondcount % 2 == 0)) {
                    //checking to see if the item list is uneven
                    string2 = string2 + "``" + pad("", 30) + "``" + " | \n";
                    //if it is uneven it will make it so that another blnk item is added
                }
                if (secondcount + 1 == 2) {
                    //this will check to see if there is not 4. When it is just two spaces, it looks weird
                    string2 = string2 + "``" + pad("", 30) + "``" + " | ";
                    //Padding
                    string2 = string2 + "``" + pad("", 30) + "``" + " | ";
                    //padding
                }
            }
            em.setDescription(string2);


        } catch (Exception e) {
            System.out.println(e);
            String pad = "``" + pad("You Have Nothing!", 30) + "``" + " | ";
            //Making it so that the inventory responds with "nothing"
            String pud = "``" + pad("", 30) + "``" + " | ";
            //padding
            ec.setTitle(user.getName() + "'s Inventory!");
            ec.setDescription(pad + pud + "\n" + pud + pud);

        }
        ArrayList<EmbedBuilder> embeds = new ArrayList<>();
        embeds.add(ec);
        if(string22){
            embeds.add(em);
        }

        return embeds;
    }
}
