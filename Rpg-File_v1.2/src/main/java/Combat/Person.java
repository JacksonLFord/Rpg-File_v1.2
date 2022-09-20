package Combat;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static DataBase.FileLogger.pad;

public class Person {
    static String Class;
    static int level;

    static int Constitution;
    static int Strength;
    static int Speed;

    static int Mana;
    static int Stealth;
    static int Health;
    static int currentHealth;
    static int Defense;
    static int currentMana;
    static int Stamina;
    static int currentStamina;
    static int skillPoints;
    static int Magic;
    static int magicDefense;
    static String attacks;
    static String effects;
    public static void newPlayer(MessageReceivedEvent event, FileLogger fl ){
        Class = "False";
        level = 1;
        Magic = 1;
        Strength =1;
        Speed = 1;
        skillPoints = 10;
        Mana = 1;
        Stealth = 1;
        Constitution = 1;
        Health = Health(Constitution);
        currentHealth = Health;
        Defense = 1;
        currentMana = manaStam(Mana);
        Stamina = 1;
        magicDefense = 1;
        currentStamina = manaStam(Stamina);
    }public static void push(MessageReceivedEvent event, FileLogger fl){
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
        fl.toFile("profile.txt");
        fl.replace(6, Class);
        fl.replace(7, level+"");
        fl.replace(8, Magic+"");
        fl.replace(9, Strength+"");
        fl.replace(10, Constitution+"");
        fl.replace(11, Speed+"");
        fl.replace(12, Mana+"");
        fl.replace(13, currentMana+"");
        fl.replace(14, Stealth+"");
        fl.replace(15,skillPoints + "");
        fl.replace(16,Health+"");
        fl.replace(17, currentHealth+"");
        fl.replace( 18, Defense+"");
        fl.replace(19, Stamina+"");
        fl.replace(20, currentStamina+"");
        fl.replace(21,attacks);
        fl.replace(22,effects);
        fl.replace(23,magicDefense+"");



    }public static void pull(MessageReceivedEvent event, FileLogger fl){
        fl.toDir("C:\\Discord\\Player\\"+event.getAuthor().getId()+event.getGuild().getId());
        fl.toFile("profile.txt");
        ArrayList<String> stats = new ArrayList<String>();
        stats = fl.readAll();
        Class = stats.get(6);
        level = Integer.parseInt(stats.get(7));
        Magic = Integer.parseInt(stats.get(8));
        Strength = Integer.parseInt(stats.get(9));
        Constitution =  Integer.parseInt(stats.get(10));
        Speed =  Integer.parseInt(stats.get(11));
        Mana =  Integer.parseInt(stats.get(12));
        currentMana =  Integer.parseInt(stats.get(13));
        Stealth =  Integer.parseInt(stats.get(14));
        skillPoints =  Integer.parseInt(stats.get(15));
        Health =  Integer.parseInt(stats.get(16));
        currentHealth =  Integer.parseInt(stats.get(17));
        Defense =  Integer.parseInt(stats.get(18));
        Stamina =  Integer.parseInt(stats.get(19));
        currentStamina =  Integer.parseInt(stats.get(20));
        attacks =  stats.get(21);
        effects = stats.get(22);
        magicDefense = Integer.parseInt(stats.get(23));





    }public static void build(MessageReceivedEvent event, FileLogger fl, String prefix){

       EmbedBuilder eb = new EmbedBuilder();
        int pad = 18;
        int pad2 = 18;
        eb.setColor(new Color(0, 78, 255, 1));
        eb.setTitle(""+event.getAuthor().getName()+"'s stats");
        eb.setDescription("Avaliable stat points : " + skillPoints);
        eb.addField("``Info:``", "``"+pad("Level : "+level,pad2) +"``"+ " | "+
                "``"+pad("Mana : "+currentMana + "/"+manaStam(Mana),pad2)+"`` |\n" + "``"+
                pad("Stamina : "+currentStamina + "/"+manaStam(Stamina),pad2)+"`` | "+
                "``"+pad("Health : "+currentHealth + "/"+Health,pad2) +"``"+ " | ", false);
        eb.addField("``Stats``","``"+pad("Constitution : "+Constitution,pad)+"``" + " | "+
                        "``"+pad("Magic : "+Magic,pad) +"``"+ " | \n"+

                        "``"+pad("Strength : "+Strength,pad) +"``"+ " | "+
                        "``"+pad("Speed : "+Speed,pad) +"``"+ " | \n"+
                        "``"+pad("Stealth : "+Stealth,pad) +"``"+ " | "+
                        "``"+pad("Defense : "+Defense,pad) +"``"+ " | \n"+
                        "``"+pad("Magic Defense : "+magicDefense,pad) +"``"+ " | "+
                        "``"+pad("Stamina: "+Stamina,pad) +"``"+ " | \n"+
                        "``"+pad("Mana : "+Mana,pad) +"``"+ " | "

                ,false);
        //eb.setTitle(name + "'s Character | "+"``Health : "+health+"`` | ``Armor : "+armor+"``");
        eb.setFooter("Hint : Try doing "+prefix+"sp [stat] to put points into stats");
        event.getChannel().sendMessage(eb.build()).queue();
    } public static void stats(MessageReceivedEvent event, FileLogger fl, String prefix){
        if(event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"stat")||
            event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"stats")){
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
                Person per = new Person();
                per.pull(event,fl);
                per.build(event,fl,prefix);

            }
            if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not already started! ~ Stats");
                event.getChannel().sendMessage(edore.build()).queue();

            }
        }

    }//int math = (int)Math.round( (index * index) * 0.35 + 10);
    public static int Health(int consti){
        return (int)Math.round(( consti* consti) * 0.25 + 50);
    }public static int manaStam(int manaStam){
        return (int)Math.round(( manaStam* manaStam) * 0.35 + 10);
    }
    public static void sp(MessageReceivedEvent event, FileLogger fl, String prefix){
        String[] msgs = event.getMessage().getContentRaw().split(" ");
        if(msgs[0].equalsIgnoreCase(prefix+"sp")){
            User user = event.getAuthor();
            if(inCombat(event,fl)){
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You are in combat!");
                event.getChannel().sendMessage(edore.build()).queue();
                return;
            }
            fl.toDir("C:\\Discord\\Player\\"+user.getId()+event.getGuild().getId());
            fl.toFile("profile.txt");
            if (fl.read(3).equalsIgnoreCase("true")) {
                Person person = new Person();
                person.pull(event,fl);
                try{
                    String skill = event.getMessage().getContentRaw().replace(prefix+"sp ","");
                    if(skill.equalsIgnoreCase("Mana")){
                    person.Mana =person.Mana + 1;
                    person.currentMana = manaStam(person.Mana);
                    person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Stamina")){
                        person.Stamina = person.Stamina + 1;
                        person.currentStamina = manaStam(person.Stamina);
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Constitution")){
                        person.Constitution = person.Constitution + 1;
                        person.Health = Health(person.Constitution);
                        person.currentHealth = person.Health;
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Magic")){
                        person.Magic = person.Magic + 1;
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Strength")){
                        person.Strength = person.Strength + 1;
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Speed")){
                        person.Speed = person.Speed+1;
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Stealth")){
                        person.Stealth = person.Stealth + 1;
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Defense")){
                        person.Defense = person.Defense+1;
                        person.skillPoints =person.skillPoints - 1;
                    }else if(skill.equalsIgnoreCase("Magic Defense")){
                        person.magicDefense = person.magicDefense+1;
                        person.skillPoints =person.skillPoints - 1;
                    }else{
                        EmbedBuilder edore = new EmbedBuilder();
                        edore.setFooter("Lisa your helpful bot!");
                        edore.setColor(new Color(0, 78, 255, 1));
                        edore.setDescription("Please provide a valid skill to put in points ~ sp");

                        event.getChannel().sendMessage(edore.build()).append("Hello").queue();
                    }
                    person.push(event,fl);
                }catch(Exception e){
                    EmbedBuilder edore = new EmbedBuilder();
                    edore.setFooter("Lisa your helpful bot!");
                    edore.setColor(new Color(0, 78, 255, 1));
                    edore.setDescription("Unknown Error. It shouldnt have gotten to this point \n if you" +
                            " are reading this, this means I have failed, terribly ~ sp");


                    event.getChannel().sendMessage(edore.build()).append("Hello").queue();
                }
            }if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not started ~ sp");

                event.getChannel().sendMessage(edore.build()).queue();
            }


        }

    }
}
