package uk.co.ivaylokhr.hackfighter;

/**
 * Created by Ivaylo on 24/10/2015.
 */
public class Fight {

    Character player1, player2;
    Character winner;

    public Fight(){

    }

    public static Character between(Character char1, Character char2){
        int health1  = char1.getHealth();
        int health2 = char2.getHealth();
        System.out.println(char1 + "  " + char2);
        while(health1>0 && health2>0){
            System.out.print(char2.getName()+" health: "+ health2+ " -> ");
            health2 -= char1.attack(char2);
            System.out.println(health2);
            if(health2<=0){
                System.out.println(char1.getName()+" wins");
                return char1;
            }
            System.out.print(char1.getName()+" health: "+ health1+ " -> ");
            health1 -= char2.attack(char1);
            System.out.println(health1);
            if(health1<=0){
                System.out.println(char2.getName()+" wins");
                return char2;
            }
        }
        return null;
    }

    public Character getWinner(){
        return winner;
    }
}
