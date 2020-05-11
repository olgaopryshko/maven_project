package sportgames.team;

import sportgames.participants.Team;

public class Hockey extends TeamGame {

    public Hockey() {
        super();
        gameName = "Hockey";
    }


    public Hockey(Team team1, Team team2) {
        super(team1, team2);
        gameName = "Hockey";
    }
}
