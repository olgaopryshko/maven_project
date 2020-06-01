package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {

    private String name;
    private String lastname;
    private Date dateOfBirth;
    private Integer sportId;
    private Integer countryId;
    private Integer id;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getSportId() {
        return sportId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "Player{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + format.format(dateOfBirth) +
                ", sportId=" + sportId +
                ", countryId=" + countryId +
                ", id=" + id +
                '}';
    }
}
