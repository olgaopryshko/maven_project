package models;

public class Team {
    private String name;
    private Integer sportId;
    private Integer countryId;
    private Integer id;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", sportId=" + sportId +
                ", countryId=" + countryId +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
