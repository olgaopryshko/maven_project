package DB.mappers;

import models.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeamMapper {
    @Select("select * from team")
    List<Team> getAllTeams();

    @Insert("insert into team(name, sport_id, country_id) values(#{name}, #{sportId}, #{countryId})")
    void addTeam(Team team);
}
