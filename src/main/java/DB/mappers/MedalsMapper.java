package DB.mappers;

import models.Medals;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MedalsMapper {

    @Select("select * from medals")
    List<Medals> getAllMedals();

    @Insert("insert into medals(country_id, gold, silver, bronze, olympics_id) values(#{countryId}, #{gold}, #{silver}, #{bronze}, #{olympicsId})")
    void addMedals(Medals medals);
}
