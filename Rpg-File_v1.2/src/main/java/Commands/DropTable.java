package Commands;

import java.util.ArrayList;
import java.util.Random;

public class DropTable {
    public static ArrayList<String> Tree() {
        //100% to get 1 wood
        //33% to get another 1 wood
        //16.6% to get another
        //10% to get an apple
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();
        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 75) {
            Woo = 1;
        }
        if (76 < Wood && Wood < 125) {
            Woo = 2;
        }
        if (126 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Wood;" + Woo);
        Random rander = new Random();
        int type = rand.nextInt((100 - 0) + 1);
        if (type < 10) {
            list.add("Apple;1");
        }
        System.out.println(list);
        return list;
    }

    public static ArrayList<String> Rock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 75) {
            Woo = 1;
        }
        if (75 < Wood && Wood < 125) {
            Woo = 2;
        }
        if (125 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Stone;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> IronRock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Iron Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {

        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> CoalRock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Coal Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {

        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> SilverRock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Silver Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {

        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> GoldRock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Gold Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {

        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> Gem() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Gem;" + Woo);


        return list;
    }

    public static ArrayList<String> Crystal() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Crystal;" + Woo);


        return list;
    }

    public static ArrayList<String> Titanium() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Titanium Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {

        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> Colbolt() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Colbolt Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {

        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> Mithril() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Mithril Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {

        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> Adamantium() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Adamantium Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {

        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> CopperRock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Copper Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((50000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {

        }

        return list;
    }

    public static ArrayList<String> LeadRock() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Lead Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {
            list.add("Platnium Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {

        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> Platinum() {
        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // nextInt as provided by Random is exclusive of the top value so you need to add 1

        int Wood = rand.nextInt((75 + 50 + 25) + 1);
        int Woo = 1;
        if (Wood < 125) {
            Woo = 1;
        }
        if (125 < Wood && Wood < 140) {
            Woo = 2;
        }
        if (140 < Wood && Wood < 150) {
            Woo = 3;
        }
        list.add("Platinum Ore;" + Woo);
        Random rander = new Random();
        int type = rander.nextInt((10000 - 0) + 1);
        //.01% for Adamantium

        if (type < 2) {
            list.add("Adamantium Ore;1");
        }
        if (type < 3 && type > 2) {
            list.add("Titanium Ore;1");
        }
        if (type < 7 && type > 3) {

        }
        if (type < 15 && type > 7) {
            list.add("Mithril Ore;1");
        }
        if (type < 15 && type > 7) {
            list.add("Gold Ore;1");
        }
        if (type < 31 && type > 15) {
            list.add("Silver Ore;1");
        }
        if (type < 62 && type > 31) {
            list.add("Cobolt Ore;1");
        }
        if (type < 90 && type > 62) {
            list.add("Lead Ore;1");
        }
        if (type < 120 && type > 90) {
            list.add("Iron Ore;1");
        }
        if (type < 200 && type > 120) {
            list.add("Coal Ore;1");
        }
        if (type < 350 && type > 200) {
            list.add("Copper Ore;1");
        }

        return list;
    }

    public static ArrayList<String> checker(String item) {
        if (item.equalsIgnoreCase("Tree")) {
            return Tree();
        }
        if (item.equalsIgnoreCase("Stone Rock")) {
            return Rock();
        }
        if (item.equalsIgnoreCase("Iron Rock")) {
            return IronRock();
        }
        if (item.equalsIgnoreCase("Coal Rock")) {
            return CoalRock();
        }
        if (item.equalsIgnoreCase("Silver Rock")) {
            return SilverRock();
        }
        if (item.equalsIgnoreCase("Gold Rock")) {
            return GoldRock();
        }
        if (item.equalsIgnoreCase("Gem Rock")) {
            return Gem();
        }
        if (item.equalsIgnoreCase("Crystal")) {
            return Crystal();
        }
        if (item.equalsIgnoreCase("Titanium Rock")) {
            return Titanium();
        }
        if (item.equalsIgnoreCase("Colbolt Rock")) {
            return Colbolt();
        }
        if (item.equalsIgnoreCase("Mithril Rock")) {
            return Mithril();
        }
        if (item.equalsIgnoreCase("Adamantium Rock")) {
            return Adamantium();
        }
        if (item.equalsIgnoreCase("Copper Rock")) {
            return CopperRock();
        }
        if (item.equalsIgnoreCase("Lead Rock")) {
            return LeadRock();
        }
        if (item.equalsIgnoreCase("Platinum Rock")) {
            return Platinum();
        }
        return null;
    }
    public static String GemPro(){
            String item = "";
            Random rand = new Random();

            // nextInt as provided by Random is exclusive of the top value so you need to add 1


            Random rander = new Random();
            int type = rander.nextInt((2500 - 0) + 1);
            //.01% for Adamantium
//Diamond;0;0.5;50;Gem;0;False
//Emerald;0;0.5;40;Gem;0;False
//Sapphire;0;0.5;30;Gem;0;False
//Ruby;0;0.5;20;Gem;0;False
//Topaz;0;0.5;10;Gem;0;False
//Amethyst;0;0.5;1;Gem;0;False

            if (type < 10) {
                item = "Uncut Diamond";
            }
            if (type < 50 && type >= 10) {
                item = "Uncut Emerald";
            }
            if (type < 100 && type >= 50) {
                item = "Uncut Sapphire";
            }
            if (type < 300 && type >= 100) {
                item = "Uncut Ruby";
            }
            if (type < 900 && type >=  300) {
                item = "Uncut Topaz";
            }
            if (type < 2500 && type >= 900) {
                item = "Uncut Amethyst";
            }

            return item;
        }
    }

