package sportgames.team;

import sportgames.participants.Team;
import sportgames.base.SportsGame;

public class TeamGame extends SportsGame {
    public TeamGame() {
    }

    public final int NUM_TEAMS = 2;

    public TeamGame(Team team1, Team team2) {
        super();
        this.player1 = team1;
        this.player2 = team2;
    }
}
