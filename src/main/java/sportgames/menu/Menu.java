package sportgames.menu;

import sportgames.Schedule;
import sportgames.Weekday;
import sportgames.base.SportsGame;
import sportgames.exceptions.NotEnoughParticipantsException;
import sportgames.individual.PersonList;
import sportgames.participants.Person;
import sportgames.participants.Team;
import sportgames.team.TeamList;
import sportgames.utils.PropertiesRW;
import org.apache.log4j.Logger;

import java.util.*;


public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class);
    private TeamList teamList = new TeamList();
    private PersonList personList = new PersonList();
    private Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    private Schedule schedule = new Schedule(personList, teamList);

    private String chooseGame() {
        System.out.println("Choose a game: 1 - Football; 2 - Basketball; 3 - Hockey; 4 - Tennis; 5 - Badminton;");
        int gameChoice = scanner.nextInt();
        switch (gameChoice) {
            case 1:
                return "football";
            case 2:
                return "basketball";
            case 3:
                return "hockey";
            case 4:
                return "tennis";
            case 5:
                return "badminton";
            default:
                return null;
        }
    }

    /**
     * Read the first and last name from the user and return a new Person object.
     *
     * @return null if no first name entered, a Person instance otherwise.
     */
    private Person inputPerson() {
        System.out.println("Enter player first name (Empty = stop):");
        String firstName = scanner.next();
        if (firstName.equals("")) {
            return null;
        }
        String lastName;
        while (true) {
            System.out.println("Enter player last name:");
            lastName = scanner.next();
            if (!lastName.equals("")) {
                break;
            }
            System.out.println("Please enter the last name!");
        }
        return new Person(firstName, lastName);
    }

    public void run() {
        LOGGER.debug("Displaying menu...");
        try {
            while (true) {
                System.out.println("Choose an action: 1 - Enter data; 2 - Print data; 3 - Delete data; 4 - Play a random game;");
                System.out.println("5 - Read data from file; 6 - Save data to file;");
                System.out.println("7 - Load property value; 8 - Save property value;");
                System.out.println("Any other number - exit program");
                int action = scanner.nextInt();
                switch (action) {
                    case 1:
                        enterData();
                        break;
                    case 2:
                        printData();
                        break;
                    case 3:
                        deleteData();
                        break;
                    case 4:
                        playRandomGame();
                        System.out.println("Total games played: " + SportsGame.getTotalGamesPlayed());
                        break;
                    case 5:
                        loadData();
                        break;
                    case 6:
                        saveData();
                        break;
                    case 7:
                        loadProperty();
                        break;
                    case 8:
                        saveProperty();
                        break;
                    default:
                        System.out.println("Goodbye!");
                        return;
                }
            }
        } catch (InputMismatchException e) {
            LOGGER.error("Please, select a number!");
        } finally {
            scanner.close();
        }
    }

    private void saveProperty() {
        System.out.println("Property name:");
        String propertyName = scanner.next();
        System.out.println("Property value:");
        String propertyValue = scanner.next();
        System.out.println("Properties file path:");
        String path = scanner.next();
        PropertiesRW.saveProperty(path, propertyName, propertyValue);
    }

    private void loadProperty() {
        System.out.println("Enter property name");
        String propertyName = scanner.next();
        System.out.println("Enter property file path");
        String path = scanner.next();
        String property = PropertiesRW.loadProperty(path, propertyName);
        System.out.println(property);
    }


    private void loadData() {
        String game = chooseGame();
        System.out.println("Enter file path:");
        String filePath = scanner.next();
        switch (game) {
            case "football":
            case "basketball":
            case "hockey":
                teamList.loadTeamsFromFile(game, filePath);
                break;
            case "tennis":
            case "badminton":
                personList.loadPlayersFromFile(game, filePath);
                break;
            default:
                LOGGER.warn("Invalid input!");
        }
    }


    private void saveData() {
        String game = chooseGame();
        System.out.println("Enter file path:");
        String filePath = scanner.next();
        switch (game) {
            case "football":
            case "basketball":
            case "hockey":
                teamList.saveTeamsToFile(game, filePath);
                break;
            case "tennis":
            case "badminton":
                personList.savePlayersToFile(game, filePath);
                break;
            default:
                LOGGER.warn("Invalid input!");
        }
    }

    private void playRandomGame() {
        Weekday[] weekdays = Weekday.values();
        Weekday randomDay = weekdays[new Random().nextInt(weekdays.length)];
        try {
            SportsGame game = schedule.scheduleGame(randomDay);
            game.setRandomScore();
            game.play();
        } catch (NotEnoughParticipantsException e) {
            LOGGER.error(e);
            LOGGER.info("Game was not played: " + e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.error(e);
            LOGGER.info("No games played on " + randomDay);
        }
    }


    public void enterData() {
        String game = chooseGame();
        switch (game) {
            case "football":
            case "basketball":
            case "hockey":
                while (true) {
                    System.out.println("Enter team name (Empty = stop):");
                    String name = scanner.next();
                    if (name.equals("")) {
                        LOGGER.debug("Empty input, exiting enterData");
                        break;
                    }
                    teamList.addTeam(game, new Team(name));
                }
                break;
            case "tennis":
            case "badminton":
                while (true) {
                    Person person = inputPerson();
                    if (person == null) {
                        LOGGER.debug("Empty input, exiting enterData");
                        break;
                    }
                    personList.addPlayer(game, person);
                }
                break;
            default:
                LOGGER.warn("Invalid input!");
        }
    }

    public void printData() {
        teamList.printAllTeams();
        personList.printAllPlayers();
    }


    public void deleteData() {
        String game = chooseGame();
        int index;
        try {
            switch (game) {
                case "football":
                case "basketball":
                case "hockey":
                    System.out.println("Enter index (0-" + (teamList.getTeamList(game).size() - 1) + ")");
                    index = scanner.nextInt();
                    teamList.removeTeam(game, index);
                    break;
                case "tennis":
                case "badminton":
                    System.out.println("Enter index (0-" + (personList.getPlayersList(game).size() - 1) + ")");
                    index = scanner.nextInt();
                    personList.removePlayer(game, index);
                    break;
                default:
                    LOGGER.warn("Invalid input!");
            }
        } catch (InputMismatchException e) {
            LOGGER.error(e);
            LOGGER.info("Please enter a number!");
            scanner.next();
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            LOGGER.error(e);
            LOGGER.info("There's no such index");
        }
    }
}

