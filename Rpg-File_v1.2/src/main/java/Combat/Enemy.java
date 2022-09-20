package Combat;

import DataBase.FileLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Combat.Attack.inCombat;
import static Entities.Goblin.*;
import static DataBase.FileLogger.pad;


public class Enemy {
    //Name;Level;Intelligence;Strength;Constitution;Speed;Dexterity;Mana;Stealth;Health;CurrentHealth;Defense;attacks,attacks;effects,effects
    static String name;
    static int level;
    static int Intelligence;
    static int Strength;
    static int Constitution;
    static int Speed;

    static int Mana;
    static int Stealth;
    static int Health;
    static int currentHealth;
    static int Defense;
    static int currentMana;
    static int Stamina;
    static int currentStamina;
    static int exp;
    static int Magic;
    static String attacks;
    static String effects;
    public static void pull(MessageReceivedEvent event, FileLogger fl, String location, int enemy){
        FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
        FileLogger.toFile("\\" + location + " - Enemy.txt");
        String[] array = fl.read(enemy).split(";", 17);
        name = array[0];
        level = Integer.parseInt(array[1]);
        Magic = Integer.parseInt(array[2]);
        Strength = Integer.parseInt(array[3]);
        Constitution = Integer.parseInt(array[4]);
        Speed = Integer.parseInt(array[5]);
        exp = Integer.parseInt(array[6]);
        Mana = Integer.parseInt(array[7]);
        Stealth = Integer.parseInt(array[8]);
        Health = Integer.parseInt(array[9]);
        currentHealth = Integer.parseInt(array[10]);
        Defense = Integer.parseInt(array[11]);
        currentMana = Integer.parseInt(array[12]);
        Stamina = Integer.parseInt(array[13]);
        currentStamina = Integer.parseInt(array[14]);

        attacks =  array[15];
        effects =  array[16];

    }public static void set(MessageReceivedEvent event, String enemy){

        String[] array = enemy.split(";", 17);
        name = array[0];
        level = Integer.parseInt(array[1]);
        Magic = Integer.parseInt(array[2]);
        Strength = Integer.parseInt(array[3]);
        Constitution = Integer.parseInt(array[4]);
        Speed = Integer.parseInt(array[5]);
        exp = Integer.parseInt(array[6]);
        Mana = Integer.parseInt(array[7]);
        Stealth = Integer.parseInt(array[8]);
        Health = Integer.parseInt(array[9]);
        currentHealth = Integer.parseInt(array[10]);
        Defense = Integer.parseInt(array[11]);
        currentMana = Integer.parseInt(array[12]);
        Stamina = Integer.parseInt(array[13]);
        currentStamina = Integer.parseInt(array[14]);

        attacks =  array[15];
        effects =  array[16];

    }public static void enemies(MessageReceivedEvent event, FileLogger fl,String prefix){
        if(event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"enemy")||
            event.getMessage().getContentRaw().equalsIgnoreCase(prefix+"enemies")){
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
            String file = FileLogger.read(4);
            if (fl.read(3).equalsIgnoreCase("true")) {
                try{
                    ArrayList<String> list = new ArrayList<String>();
                    ArrayList<String> Enemies = pullAll(event,fl,file);
                    System.out.println(Enemies);
                    int index0 = 0;
                    while(index0<Enemies.size()){
                        String Enemy = Enemies.get(index0);
                        String[] str = Enemy.split(";", 17);
                        String Name = str[0];
                        int Level = Integer.parseInt(str[1]);
                        String finel = Name + " : Level "+Level;
                        list.add(finel);

                        index0++;
                    }int index10 = 0;
                    String field = "";
                    Boolean one = true;
                    String field2 = "";
                    Boolean two = false;
                    String field3 = "";
                    Boolean three = false;
                    int index100 = 0;
                    int index200 = 0;
                    int index300 = 0;
                    while(index10<list.size()){


                        if(field.length()<1800){
                            index100++;
                            field = field + "``"+(pad(index10+". "+list.get(index10), 35))+"`` | ";
                            if (index100 % 2 == 0) {
                                index100 = 0;
                                field = field + "\n";
                            }
                        }if(field.length()>1800){
                            two = true;
                            if(field2.length()<1800){
                                index200++;
                                field2 = field2 + "``"+(pad(index10+". "+list.get(index10), 35))+"`` | ";
                                if (index200 % 2 == 0) {
                                    index200 = 0;
                                    field2 = field2 + "\n";

                                }

                            }if(field2.length()>1800){
                                three = true;
                                index300++;
                                field3 = field3 + "``"+(pad(index10+". "+list.get(index10), 35))+"`` | ";
                                if (index300 % 2 == 0) {
                                    index300 = 0;
                                    field2 = field2 + "\n";

                                }
                            }
                        }


                        index10++;
                    }
                    if(one){
                        EmbedBuilder eb = new EmbedBuilder();

                        eb.setColor(new Color(0, 78, 255, 1));

                        if(!two){
                            eb.setFooter("Lisa, your helpful bot!");
                        }
                        eb.setTitle("Enemys around you!");

                        eb.setDescription(field);
                        event.getChannel().sendMessage(eb.build()).queue();
                    }if(two){
                        EmbedBuilder eb = new EmbedBuilder();

                        eb.setColor(new Color(0, 78, 255, 1));

                        eb.setDescription(field2);
                        if(!three){
                            eb.setFooter("Lisa, your helpful bot!");
                        }
                        event.getChannel().sendMessage(eb.build()).queue();
                    }if(three){

                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setDescription(field3);

                        eb.setColor(new Color(0, 78, 255, 1));
                        eb.setFooter("Lisa, your helpful bot!");
                        event.getChannel().sendMessage(eb.build()).queue();

                    }


                }catch(Exception e){

                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setColor(new Color(0, 78, 255, 1));
                    eb.setFooter("Lisa, your helpful bot!");
                    eb.addField("Enemies around you!", "``"+pad("There are none", 32)+"`` | "+
                            "``"+pad(" ", 32)+"`` | ",false);
                    event.getChannel().sendMessage(eb.build()).queue();
                }



            }if (fl.read(3).equalsIgnoreCase("false")) {
                EmbedBuilder edore = new EmbedBuilder();
                edore.setFooter("Lisa your helpful bot!");
                edore.setColor(new Color(0, 78, 255, 1));
                edore.setDescription("You have not already started! ~ Enemy");
                event.getChannel().sendMessage(edore.build()).queue();
            }

        }
    }
    public static void push(MessageReceivedEvent event, FileLogger fl,String location){
        FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
        FileLogger.toFile("\\" + location + " - Enemy.txt");
        String item = "";
        item = item + name + ";";
        item = item + level + ";";
        item = item + Magic + ";";
        item = item + Strength + ";";
        item = item + Constitution + ";";
        item = item + Speed + ";";
        item = item + exp + ";";
        item = item + Mana + ";";
        item = item + Stealth + ";";
        item = item + Health + ";";
        item = item + currentHealth + ";";
        item = item + Defense + ";";
        item = item + currentMana + ";";
        item = item + Stamina + ";";
        item = item + currentStamina + ";";

        item = item + attacks + ";";
        item = item + effects + "";
        fl.write(item);


    }public static ArrayList<String> pullAll(MessageReceivedEvent event, FileLogger fl, String Location){
        FileLogger.toDir("C:\\Discord\\Guild\\" + event.getGuild().getId() + "\\Info");
        FileLogger.toFile("\\" + Location + " - Enemy.txt");
        return fl.readAll();
    }
    public static String Slash(){
        //number one will be dmage
        //number two will be effects with ; duration
        //Name/Effect/Str/ManaCost/StaminaCost
        String Slash = "Slash$";
        double damage = Strength * 2.5;
        Double max = damage / 9;
        Double min = damage / 9* -1;
        double type = Math.random()*(max-min)+min;
        damage = damage + type;
        damage = damage+1;
        damage = Math.round(damage);
        int dmg = (int)Math.round(damage);
        Slash = Slash + dmg + "$bleed$1$0$5";
       return Slash;
    }public static String Stab(){
        //number one will be damage
        //number two will be effects with ; duration
        String stab = "Stab$";
        //Name/dmg/Effect/Str/ManaCost/StaminaCost
        double damage = Strength * 3;
        Double max = damage / 9;
        Double min = damage / 9* -1;
        double type = Math.random()*(max-min)+min;
        damage = damage+type;
        damage = damage+1;
        damage = Math.round(damage);
        int dmg = (int)Math.round(damage);
        stab = stab + dmg + "$False$False$0$10";


        return stab;
    } public static void genGoblin(int goblevel){

        name = "Goblin Foot Soilder";
        attacks = Stab() +"&"+ Slash();


        int stbby = Integer.parseInt(Stab().split("\\$",6)[1]);

        int slshy = Integer.parseInt(Slash().split("\\$",6)[1]);


        int greatestDmg = Math.max(stbby, slshy);
        level = goblevel;
        Magic = 0;
        Constitution = level;

        Defense = InstStrengthSpeed(goblevel);

        Health = InstHealth(Constitution);
        currentHealth = Health;

        Strength = InstStrengthSpeed(goblevel);
        Speed = InstStrengthSpeed(goblevel) * 2;

        Mana = 0;

        exp = InstExp(goblevel,Health, greatestDmg);
        currentMana = Mana;
        Stealth = 1;

        System.out.println("Stamina");
        Stamina = InstStamina(goblevel);
        currentStamina = Stamina;
        System.out.println("Finished Generation");
    }public static void build(MessageReceivedEvent event){
        EmbedBuilder eb = new EmbedBuilder();
        int pad = 18;
        int pad2 = 18;
        eb.setColor(new Color(0, 78, 255, 1));
        eb.setTitle(""+name+"  \n");
        eb.addField("``Info:``", "``"+pad("Level : "+level,pad2) +"``"+ " | "+
                "``"+pad("Mana : "+currentMana+"/"+Mana,pad2)+"`` |\n" + "``"+
               pad("Stamina : "+currentStamina+"/"+Stamina,pad2)+"`` |"+
                "``"+pad("Health : "+currentHealth+"/"+Health,pad2) +"``"+ " | ", false);
        eb.addField("``Stats``","``"+pad("Constitution : "+Constitution,pad)+"``" + " | "+
                "``"+pad("Defense : "+Defense,pad)  +"``"+ " | \n"+

                        "``"+pad("Strength : "+Strength,pad) +"``"+ " | "+
                        "``"+pad("Speed : "+Speed,pad) +"``"+ " | \n"+
                        "``"+pad("Stealth : "+Stealth,pad) +"``"+ " | "

                ,false);
                //eb.setTitle(name + "'s Character | "+"``Health : "+health+"`` | ``Armor : "+armor+"``");
        event.getChannel().sendMessage(eb.build()).queue();
    }
}
