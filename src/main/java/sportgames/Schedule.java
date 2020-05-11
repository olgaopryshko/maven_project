package sportgames;

import sportgames.base.SportsGame;
import sportgames.exceptions.NotEnoughParticipantsException;
import sportgames.individual.Badminton;
import sportgames.individual.PersonList;
import sportgames.individual.Tennis;
import sportgames.participants.Person;
import sportgames.participants.Team;
import sportgames.team.Basketball;
import sportgames.team.Football;
import sportgames.team.Hockey;
import sportgames.team.TeamList;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Schedule {

    private PersonList personList;
    private TeamList teamList;

    public Schedule(){}

    public Schedule(PersonList personList, TeamList teamList) {
        this.personList = personList;
        this.teamList = teamList;
    }

    private Team[] randomTeams(List<Team> teams) throws NotEnoughParticipantsException {
        if(teams.size() < 2) {
            throw new NotEnoughParticipantsException("Less than two teams available");
        }
        Random r = new Random();
        int index1 = r.nextInt(teams.size());
        int index2 = r.nextInt(teams.size());
        while (index2 == index1) {
            index2 = r.nextInt(teams.size());
        }
        return new Team[]{teams.get(index1), teams.get(index2)};

    }

    private Person[] randomPlayers(List<Person> players) throws NotEnoughParticipantsException {
        if (players.size() < 2){
            throw new NotEnoughParticipantsException("Less than two players available");
        }
        Random r = new Random();
        int index1 = r.nextInt(players.size());
        int index2 = r.nextInt(players.size());
        while (index2 == index1) {
            index2 = r.nextInt(players.size());
        }
        int i = 0;
        Person[] result = new Person[2];
        for (Person player :
                players) {
            if (index1 == i){
                result[0] = player;
            } else if (index2 == i) {
                result[1] = player;
            }
            i++;
        }
        return result;
    }

    public SportsGame scheduleGame (Weekday day) throws NotEnoughParticipantsException {
        Team[] teams;
        Person[] players;

        System.out.println("Scheduling a game on " + day);

        SportsGame game = null;
        switch (day) {
            case MONDAY:
                System.out.println("Tennis game is scheduled");
                players = randomPlayers(personList.getPlayersList("tennis"));
                game = new Tennis(players[0], players[1]);
                break;
            case TUESDAY:
                System.out.println("Football game is scheduled");
                teams = randomTeams(teamList.getTeamList("football"));
                game = new Football(teams[0], teams[1]);
                break;
            case WEDNESDAY:
                System.out.println("Day-off");
                break;
            case THURSDAY:
                System.out.println("Badminton game is scheduled");
                players = randomPlayers(personList.getPlayersList("badminton"));
                game = new Badminton(players[0],  players[1]);
                break;
            case FRIDAY:
                System.out.println("Basketball game is scheduled");
                teams = randomTeams(teamList.getTeamList("basketball"));
                game = new Basketball(teams[0],teams[1]);
                break;
            case SATURDAY:
                System.out.println("Hockey game is scheduled");
                teams = randomTeams((teamList.getTeamList("hockey")));
                game = new Hockey(teams[0],teams[1]);
                break;
            case SUNDAY:
                System.out.println("Day-off");
                break;
            default:
                System.out.println("Choose a weekday ");
        }

        return game;
    }

    public TeamList getTeamList() {
        return teamList;
    }

    public void setTeamList(TeamList teamList) {
        this.teamList = teamList;
    }

    public PersonList getPersonList() {
        return personList;
    }

    public void setPersonList(PersonList personList) {
        this.personList = personList;
    }
}


