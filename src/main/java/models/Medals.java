package models;

public class Medals {

    private Integer id;
    private Integer countryId;
    private Integer gold;
    private Integer silver;
    private Integer bronze;
    private Integer olympicsId;

    @Override
    public String toString() {
        return "Medals{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                ", olympicsId=" + olympicsId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public Integer getOlympicsId() {
        return olympicsId;
    }

    public void setOlympicsId(Integer olympicsId) {
        this.olympicsId = olympicsId;
    }
}

