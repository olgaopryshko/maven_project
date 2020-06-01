package sportgames.menu;

import DB.DAO.CountryStatsDAO;
import DB.DAO.PlayerDAO;
import DB.DAO.SportDAO;
import DB.DAO.TeamDAO;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class);
    private Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    private SportDAO sportDAO = new SportDAO();
    private PlayerDAO playerDAO = new PlayerDAO();
    private CountryStatsDAO countryStatsDAO = new CountryStatsDAO();
    private TeamDAO teamDAO = new TeamDAO();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void run() {
        LOGGER.debug("Displaying menu...");
        try {
            while (true) {
                System.out.println("Choose an action: ");
                System.out.println("1 - List players; 2 - Add player; 3 - Delete player");
                System.out.println("4 - List sports; 5 - Add sport;");
                System.out.println("6 - List teams; 7 - Add team;");
                System.out.println("8 - Print country stats");
                System.out.println("Any other number - exit program");
                int action = scanner.nextInt();
                switch (action) {
                    case 1:
                        playerDAO.printPlayer();
                        break;
                    case 2:
                        System.out.println("Player's name:");
                        String name = scanner.next();
                        System.out.println("Player's lastname:");
                        String lastname = scanner.next();
                        System.out.println("Player's date of birth (yyyy-mm-dd):");
                        String dateOfBirthString = scanner.next();
                        Date dateOfBirth;
                        try {
                            dateOfBirth = sdf.parse(dateOfBirthString);
                        } catch (ParseException e) {
                            LOGGER.error(e);
                            System.out.println("Invalid date: " + dateOfBirthString);
                            break;
                        }
                        System.out.println("Sport id:");
                        Integer sportId = scanner.nextInt();
                        Integer countryId = scanner.nextInt();
                        playerDAO.addPlayer(name, lastname, dateOfBirth, sportId, countryId);
                        break;
                    case 3:
                        System.out.println("Enter player's id: ");
                        Integer id = scanner.nextInt();
                        playerDAO.deletePlayer(id);
                        break;
                    case 4:
                        sportDAO.printSports();
                        break;
                    case 5:
                        System.out.println("Sport name:");
                        String sportName = scanner.next();
                        System.out.println("Sport type:");
                        String type = scanner.next();
                        sportDAO.addSport(sportName, type);
                        break;
                    case 6:
                        teamDAO.printTeams();
                        break;
                    case 7:
                    System.out.println("Team name:");
                        String teamName = scanner.next();
                        System.out.println("Sport ID:");
                        Integer teamSportId = scanner.nextInt();
                        System.out.println("Country ID:");
                        Integer teamCountryId = scanner.nextInt();
                        teamDAO.addTeam(teamName, teamSportId, teamCountryId);
                        break;
                    case 8:
                        countryStatsDAO.getStats();
                        break;
                    default:
                        System.out.println("Goodbye!");
                        return;
                }
            }
        } catch (InputMismatchException e) {
            LOGGER.error(e);
            System.out.println("Please, select a number!");
        } finally {
            scanner.close();
        }
    }
}

