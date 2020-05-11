package sportgames.individual;

import sportgames.participants.Person;
import sportgames.base.SportsGame;


public class IndividualSport extends SportsGame {

    public IndividualSport() {
    }

    public IndividualSport(Person player1, Person player2) {
        super();
        this.player1 = player1;
        this.player2 = player2;
    }

}
