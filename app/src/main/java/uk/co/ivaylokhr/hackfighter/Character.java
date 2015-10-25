package uk.co.ivaylokhr.hackfighter;

import android.graphics.Bitmap;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ivaylo on 24/10/2015.
 */
public class Character {

    private int age;
    private String country;
    //    private String programmingLanguage;
    private Bitmap avatar;
    private int health, strength, agility, luck; // battle stats
    private String name;
    private Random r;
    private SecureRandom number;
    //zname

    public Character(Bitmap avatar, String name, int age, String country) throws NoSuchAlgorithmException {
        number = SecureRandom.getInstance("SHA1PRNG");
        this.age = age;
        this.name = name;
        this.avatar = avatar;
        this.country = country;
        health = 0;
        strength = 0;
        agility = 0;
        luck = 0;
        calculateStats();
        ageBonuses();
        countryBonuses();
        bitmapBonuses();

        becomeJoe(this);
    }

    private void bitmapBonuses() {
        if (avatar == null) {

        } else {
            strength += avatar.toString().hashCode() % 12;
            agility += avatar.getClass().hashCode() % 12;
            luck += avatar.getConfig().hashCode() % 12;
            health += avatar.getNinePatchChunk().hashCode() % 18;
        }
    }

    private void countryBonuses() {
        strength += country.hashCode() % 7;
        agility += country.hashCode() % 7;
        luck += country.hashCode() % 7;
        health += country.hashCode() % 11;
    }

    private void ageBonuses() {
        strength += age / 5;
        health += age / 5;
        agility -= age / 8;
    }

    private void calculateStats() {
        health = 200;
        calculateHealth();
        strength = 26;
        agility = 26;
        luck = 26;
        calculateSAL();
    }

    private void calculateSAL(){
        int limit = 10;
        strength += number.nextInt(limit * 2) - limit;
        agility += number.nextInt(limit * 2) - limit;
        luck += number.nextInt(limit * 2) - limit;
    }

    private void calculateHealth() {
        int limit = 40;
        health += number.nextInt(limit * 2) - limit;
    }


    //Mechanics

    public int attack(Character opponent) {
        int dodgeRate = opponent.getAgility() + opponent.getLuck() - this.getLuck();
        if(number.nextInt(100) > dodgeRate ){
            if(number.nextInt(100) < this.luck / 5) {
                System.out.print("Critical hit");
                return strength + strength/2;
            }
            else{
                return strength;
            }
        }
        else{
            System.out.print("Missed");
            return 0;
        }
    }

    //ili 6te healwa w samiq metod s random
    //ili 6te prieme parameter, syotwetno 6te se wzeme randoma ot nqkyde drugade
    public void heal() {
        //int newHealth = this.getHealth + ammountOfHealing;
        //this.updateHealth(newHealth);
    }

    //Get or update stats

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public String getName() { return name;}

    public int getHealth() {
        return health;
    }

    public int getLuck() {
        return luck;
    }

    private void becomeJoe(Character c) {
        if (c.name.equals("Joe Nash")) {
            c.agility = 99;
            c.strength = 99;
            c.health = 1000;
            c.luck = 99;
        }
    }

    public String toString() {
        return name + " h:" + health + " s:" + strength + " a:" + agility + " l:" + luck;
    }

}
