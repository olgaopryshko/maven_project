package models;

public class CountryStats {
    private String countryName;
    private int playerCount;


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    @Override
    public String toString() {
        String playerNoun = "players";
        if (playerCount == 1) {
            playerNoun = "player";
        }
        return countryName + ": " + playerCount + " " + playerNoun;
    }
}
