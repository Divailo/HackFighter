package uk.co.ivaylokhr.hackfighter;

/**
 * Created by Ivaylo on 24/10/2015.
 */
public class Fight {

    Character player1, player2;
    Character winner;

    public Fight(Character player1, Character player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public Character getWinner(){
        return winner;
    }
}
