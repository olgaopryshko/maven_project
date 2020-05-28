package sportgames.individual;

import org.apache.log4j.Logger;
import sportgames.participants.Person;
import sportgames.utils.FileRW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonList {
    private static final Logger LOGGER = Logger.getLogger(PersonList.class);
    List<Person> listOfBadmintonPlayers;
    List<Person> listOfTennisPlayers;
    Map<String, List<Person>> mapPersonCollection;

    public PersonList() {
        listOfBadmintonPlayers = new ArrayList<>();
        listOfTennisPlayers = new ArrayList<>();
        mapPersonCollection = new HashMap<>();

        mapPersonCollection.put("badminton", listOfBadmintonPlayers);
        mapPersonCollection.put("tennis", listOfTennisPlayers);
    }


    public void addPlayer(String sportName, Person person) {
        LOGGER.debug("Adding " + person + " to " + sportName + " players");
        mapPersonCollection.get(sportName).add(person);
    }

    public void removePlayer(String sportName, int index) {
        LOGGER.debug("Removing player from list of" + sportName + " players at index" + index);
        mapPersonCollection.get(sportName).remove(index);
    }

    public List<Person> getPlayersList(String sportName) {
        return mapPersonCollection.get(sportName);
    }
    public void loadPlayersFromFile(String sportName, String filePath) {
        List<String> lines = FileRW.readFile(filePath);
        List<Person> players = new ArrayList<>();
        for (String line : lines) {
            String[] names = line.split(" ");
            Person player = new Person(names[0], names[1]);
            players.add(player);
        }
        mapPersonCollection.get(sportName).addAll(players);
    }


    public void savePlayersToFile(String sportName, String filePath) {
        List<Person> players = mapPersonCollection.get(sportName);
        List<String> lines = new ArrayList<>();
        for (Person player : players) {
            lines.add(player.getName());
        }
        FileRW.writeFile(filePath, lines);
    }


    /**
     * Print all athletes playing all sports
     */
    public void printAllPlayers() {
        for (String sport :
                mapPersonCollection.keySet()) {
            System.out.println("Athletes playing " + sport + ":");
            List<?> personList = mapPersonCollection.get(sport);
            if (personList.size() == 0) {
                System.out.println("[none]");
            } else {
                for (Object team : personList) {
                    System.out.println(team.toString());
                }
            }
        }
    }
}
