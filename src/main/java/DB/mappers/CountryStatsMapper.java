package DB.mappers;

import models.CountryStats;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountryStatsMapper {
    @Select("select country.name as country_name, count(player.id) as player_count " +
            "from country " +
            "join player on player.country_id = country.id " +
            "group by country.name " +
            "order by player_count desc")
    List<CountryStats> getStats();
}
