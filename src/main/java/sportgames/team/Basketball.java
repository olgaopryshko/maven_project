package sportgames.team;


import sportgames.participants.Team;

public class Basketball extends TeamGame {

    public Basketball() {
        super();
        gameName = "Basketball";
    }

    public Basketball(Team team1, Team team2) {
        super(team1, team2);
        gameName = "Basketball";


    }
}
