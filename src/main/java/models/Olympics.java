package models;

public class Olympics {

    private Integer id;
    private Integer year;
    private String season;
    private Integer cityId;

    @Override
    public String toString() {
        return "Olympics{" +
                "id=" + id +
                ", year=" + year +
                ", season='" + season + '\'' +
                ", cityId=" + cityId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
