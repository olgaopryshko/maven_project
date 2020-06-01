package DB.mappers;

import models.Country;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountryMapper {

    @Select("select * from country")
    List<Country> getAllCountries();

    @Insert("insert into country(name, population) values(#{name}, #{population})")
    void addCountry(Country country);
}
