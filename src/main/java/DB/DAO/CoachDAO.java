package DB.DAO;

import DB.mappers.CityMapper;
import DB.mappers.CoachMapper;
import DB.utils.MybatisConfigUtil;
import models.Coach;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

public class CoachDAO {
    public static final Logger LOGGER = Logger.getLogger(CoachDAO.class);

    public void printCoach() {
        LOGGER.debug("Printing coaches");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CoachMapper mapper = session.getMapper(CoachMapper.class);
            List<Coach> coaches = mapper.getAllCoaches();
            for (Coach coach :
                    coaches) {
                System.out.println(coach);
            }
        }
    }

    public void addCoach(String name, String lastname, Date dateOfBirth, Integer teamId) {
        LOGGER.debug("Adding coach "+ name+ " "+lastname);
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CoachMapper mapper = session.getMapper(CoachMapper.class);
            Coach coach = new Coach();
            coach.setName(name);
            coach.setLastname(lastname);
            coach.setDateOfBirth(dateOfBirth);
            coach.setTeamId(teamId);
            mapper.addCoach(coach);
            session.commit();

        }
    }
}
