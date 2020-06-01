package DB.mappers;

import models.Sport;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SportMapper {
    @Select("select * from sport")
    List<Sport> getAllSports();

    @Insert("insert into sport(name, type) values(#{name}, #{type})")
    void addSport(Sport sport);
}
