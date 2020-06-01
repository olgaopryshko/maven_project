package DB.mappers;

import models.Olympics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OlympicsMapper {

    @Select("select * from olympics")
    List<Olympics> getAllOlympics();

    @Insert("insert into olympics(year, season, city_id) values(#{year}, #{season}, #{cityId})")
    void addOlympics(Olympics olympics);
}
