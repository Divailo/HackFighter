package uk.co.ivaylokhr.hackfighter;

/**
 * Created by Ivaylo on 24/10/2015.
 */
public class Character {

    private int age;
    private String country;
    private String programmingLanguage;

    private int health, power, agility;
    private String name;
    //zname

    public Character(int age, String country, String programmingLanguage){
        this.age = age;
        this.country = country;
        this.programmingLanguage = programmingLanguage;
    }

    //Mechanics

    public void attack(Character opponent){}

    //ili 6te healwa w samiq metod s random
    //ili 6te prieme parameter, syotwetno 6te se wzeme randoma ot nqkyde drugade
    public void heal(){
        //int newHealth = this.getHealth + ammountOfHealing;
        //this.updateHealth(newHealth);
    }

    public void dodge(){}

    //Get or update stats

    public int getPower(){
        return power;
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

}
