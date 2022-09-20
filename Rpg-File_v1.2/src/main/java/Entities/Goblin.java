package Entities;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;

public class Goblin {

    public static int InstHealth(int lvl) {
        int Constitution = lvl;
        Double Health =( (Constitution * Constitution)* 0.05 ) + 5;
        Double max = Health / 9;
        Double min = Health / 9* -1;
        double type = Math.random()*(max-min)+min;
        Health = Health+type;
        int health  = (int) Math.round(Health) ;
        if(health == 0){
            Goblin gob = new Goblin();
            health = gob.InstHealth(Constitution);
        }else if(!(health== 0)){

        }
        return health;
    }
    public static int InstStrengthSpeed(int level){
        Double Stren = ((level * level )* 0.01)+1;
        Double max = Stren / 9;
        Double min = Stren / 9* -1;
        double type = Math.random()*(max-min)+min;
        Stren = Stren+type;
        int stre  = (int) Math.round(Stren) ;
        if(stre == 0){
            Goblin gob = new Goblin();
            stre = gob.InstStrengthSpeed(level);
        }else if(!(stre== 0)){

        }
        return stre;
    }public static int InstInt(int level){
        Double lvl = ((level * level )* 0.002)+1;
        Double max = lvl / 9;
        Double min = lvl / 9* -1;
        double type = Math.random()*(max-min)+min;
        lvl = lvl+type;
        int lol = (int)Math.round(lvl);
        return lol;
    }public static int InstStamina(int level){
        Double lvl = ((level * level )* 0.01)+50;
        Double max = lvl / 9;
        Double min = lvl / 9* -1;
        double type = Math.random()*(max-min)+min;
        lvl = lvl+type;
        int lol = (int)Math.round(lvl);
        return lol;
    }public static int InstExp(int level, int Health, int Damage){
        //((10 + Health)/Health) * level
        double equat = (Damage + Health) * level / 5;

        int and = (int)Math.round(equat);
        return and;
    }

}
