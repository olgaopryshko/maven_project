package DB.DAO;

import DB.mappers.PlayerMapper;
import DB.mappers.SportMapper;
import DB.utils.MybatisConfigUtil;
import models.Player;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

public class PlayerDAO {
    public static final Logger LOGGER = Logger.getLogger(PlayerDAO.class);

    public void printPlayer() {
        LOGGER.debug("Printing players");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            PlayerMapper mapper = session.getMapper(PlayerMapper.class);
            List<Player> players = mapper.getAllPlayers();
            for (Player player :
                    players) {
                System.out.println(player);
            }
        }
    }

    public void addPlayer(String name, String lastname, Date dateOfBirth, Integer sportId, Integer countryId) {
        LOGGER.debug("Adding player "+ name);
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            PlayerMapper mapper = session.getMapper(PlayerMapper.class);
        Player player = new Player();
            player.setName(name);
            player.setLastname(lastname);
            player.setDateOfBirth(dateOfBirth);
            player.setSportId(sportId);
            player.setCountryId(countryId);
            mapper.addPlayer(player);
            session.commit();
        }
    }

    public void deletePlayer(Integer id){
        LOGGER.debug("");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            PlayerMapper mapper = session.getMapper(PlayerMapper.class);
            mapper.deletePlayer(id);
            session.commit();
        }
    }
}
