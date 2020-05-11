package sportgames.individual;

import sportgames.participants.Person;

public class Tennis extends IndividualSport {

    public Tennis() {
        super();
        gameName = "Tennis";
    }

    public Tennis(Person player1, Person player2) {
        super(player1, player2);
        gameName = "Tennis";
    }
}
