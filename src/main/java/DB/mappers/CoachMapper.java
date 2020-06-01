package DB.mappers;

import models.Coach;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CoachMapper {

    @Select("select * from coach")
    List<Coach> getAllCoaches();

    @Insert("insert into coach(name, lastname, date_of_birth, team_id) values(#{name}, #{lastname}, #{dateOfBirth}, #{teamId})")
            void addCoach(Coach coach);
}
