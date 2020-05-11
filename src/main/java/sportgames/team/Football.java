package sportgames.team;

import sportgames.participants.Team;

public class Football extends TeamGame {

    public Football() {
        super();
        gameName = "Football";
    }


    public Football(Team team1, Team team2) {
        super(team1, team2);
        gameName = "Football";
    }
}
