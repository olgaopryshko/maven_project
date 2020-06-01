package models;

import java.math.BigInteger;

public class Country {

    private String name;
    private BigInteger populaton;
    private Integer id;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", populaton=" + populaton +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPopulaton() {
        return populaton;
    }

    public void setPopulaton(BigInteger populaton) {
        this.populaton = populaton;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

