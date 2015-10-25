package uk.co.ivaylokhr.hackfighter;

import android.graphics.Bitmap;

import java.util.Random;

/**
 * Created by Ivaylo on 24/10/2015.
 */
public class Character {

    private int age;
    private String country;
    private String programmingLanguage;
    private Bitmap avatar;
    private int health, strength, agility, luck; // battle stats
    private String name;
    //zname

    public Character(Bitmap avatar, String name,int age, String country){
        this.age = age;
        this.name = name;
        this.avatar = avatar;
        this.country = country;
        health = 0; strength=0;agility = 0; luck = 0;
        calculateStats();
        becomeJoe(this);
    }
    private void calculateStats(){
        health = 100;
        calculateHealth();
        strength=10;
        agility=10;
        luck=10;
        calculateSAL();
    }
    private void calculateSAL(){
        Random r = new Random();
        int limit = 10;
        strength = r.nextInt(limit*2) - limit;
        agility = r.nextInt(limit*2) - limit;
        luck = r.nextInt(limit*2) - limit;
    }
    private void calculateHealth(){
        Random r = new Random();
        int limit = 25;
        health+= r.nextInt(limit*2) - limit;
    }



    //Mechanics

    public void attack(Character opponent){}

    //ili 6te healwa w samiq metod s random
    //ili 6te prieme parameter, syotwetno 6te se wzeme randoma ot nqkyde drugade
    public void heal(){
        //int newHealth = this.getHealth + ammountOfHealing;
        //this.updateHealth(newHealth);
    }

    //Get or update stats

    public int getStrength(){
        return strength;
    }

    public int getAgility(){
        return agility;
    }

    public int getHealth(){
        return health;
    }

    public void updateHealth(int newHealth){
        health = newHealth;
    }

    private void becomeJoe(Character c){
        if(c.name.equals("Joe Nash")){
            c.agility = 99;
            c.strength = 99;
            c.health = 1000;
            c.luck = 99;
        }
    }
    public String toString(){
        return name+ " "+age+" s:"+strength+" a:"+agility+" l:"+luck;
    }

}
