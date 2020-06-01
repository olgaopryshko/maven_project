package DB.mappers;

import models.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper {
    @Select("select * from city")
    List<City> getAllCities();

    @Insert("insert into city(country_id, status, name) values(#{countryId}, #{status}, #{name})")
    void addCity(City city);
}
