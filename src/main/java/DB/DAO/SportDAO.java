package DB.DAO;

import DB.mappers.SportMapper;
import DB.utils.MybatisConfigUtil;
import models.Sport;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.util.List;

public class SportDAO {
    public static final Logger LOGGER = Logger.getLogger(SportDAO.class);

    public void printSports() {
        LOGGER.debug("Printing sports");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            SportMapper mapper = session.getMapper(SportMapper.class);
            List<Sport> sports = mapper.getAllSports();
            for (Sport sport :
                    sports) {
                System.out.println(sport);
            }
        }
    }

    public void addSport(String name, String type) {
        LOGGER.debug("Adding sport "+ name);
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            SportMapper mapper = session.getMapper(SportMapper.class);
            Sport sport = new Sport();
            sport.setName(name);
            sport.setType(type);
            mapper.addSport(sport);
            session.commit();
        }
    }
}
