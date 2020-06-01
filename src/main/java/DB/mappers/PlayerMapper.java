package DB.mappers;

import models.Player;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlayerMapper {
    @Select("select * from player")
    List<Player> getAllPlayers();

    @Insert("insert into player(name, lastname, date_of_birth, sport_id, country_id) values(#{name}, #{lastname}, #{dateOfBirth}, #{sportId}, #{countryId})")
    void addPlayer(Player player);

    @Delete("delete from player where id = #{id}")
    void deletePlayer(int id);
}
