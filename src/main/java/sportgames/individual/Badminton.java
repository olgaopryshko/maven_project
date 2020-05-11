package sportgames.individual;

import sportgames.participants.Person;

public class Badminton extends IndividualSport {

    public Badminton() {
        super();
        gameName = "Badminton";
    }


    public Badminton(Person player1, Person player2) {
        super(player1, player2);
        gameName = "Badminton";
    }
}
