package sportgames.team;

import org.apache.log4j.Logger;
import sportgames.participants.Team;
import sportgames.utils.FileRW;

import java.util.*;

public class TeamList {

    private static final Logger LOGGER = Logger.getLogger(TeamList.class);
    List<Team> listBasketballTeams;
    List<Team> listFootballTeams;
    List<Team> listHockeyTeams;
    Map<String, List<Team>> mapCollections;

    public TeamList() {
        listBasketballTeams = new ArrayList<>();
        listFootballTeams = new LinkedList<>();
        listHockeyTeams = new LinkedList<>();
        mapCollections = new HashMap<>();

        mapCollections.put("football", listFootballTeams);
        mapCollections.put("basketball", listBasketballTeams);
        mapCollections.put("hockey", listHockeyTeams);
    }

    /**
     * Print all teams playing all sports
     */
    public void printAllTeams() {
        for (String sport :
                mapCollections.keySet()) {
            System.out.println("Teams playing " + sport + ":");
            List<?> list = mapCollections.get(sport);
            if (list.size() == 0) {
                System.out.println("[none]");
            } else {
                for (Object team : list) {
                    System.out.println(team.toString());
                }
            }
        }
    }

    public void loadTeamsFromFile(String sportName, String filePath) {
        List<String> lines = FileRW.readFile(filePath);
        List<Team> teams = new ArrayList<>();
        for (String line : lines) {
            Team team = new Team(line);
            teams.add(team);
        }
        mapCollections.get(sportName).addAll(teams);
    }


    public void saveTeamsToFile(String sportName, String filePath) {
        List<Team> teams = mapCollections.get(sportName);
        List<String> lines = new ArrayList<>();
        for (Team team : teams) {
            lines.add(team.getName());
        }
        FileRW.writeFile(filePath, lines);
    }

    public void addTeam(String sportName, Team team) {
        LOGGER.debug("Adding " + team + " to " + sportName + " teams");
        mapCollections.get(sportName).add(team);
    }

    public void removeTeam(String sportName, int index) {
        LOGGER.debug("Removing team from list of" + sportName + " teams at index" + index);
        mapCollections.get(sportName).remove(index);
    }

    public List<Team> getTeamList(String sportName) {
        return mapCollections.get(sportName);
    }


}