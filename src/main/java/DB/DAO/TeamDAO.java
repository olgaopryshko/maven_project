package DB.DAO;

import DB.mappers.OlympicsMapper;
import DB.mappers.TeamMapper;
import DB.utils.MybatisConfigUtil;
import models.Team;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class TeamDAO {
    public static final Logger LOGGER = Logger.getLogger(TeamDAO.class);

    public void printTeams() {
        LOGGER.debug("Printing teams");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            TeamMapper mapper = session.getMapper(TeamMapper.class);
            List<Team> teams = mapper.getAllTeams();
            for (Team team :
                    teams) {
                System.out.println(team);
            }
        }
    }

    public void addTeam(String name, Integer sportId, Integer countryId) {
        LOGGER.debug("Adding team "+ name);
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            TeamMapper mapper = session.getMapper(TeamMapper.class);
            Team team = new Team();
            team.setName(name);
            team.setSportId(sportId);
            team.setCountryId(countryId);
            mapper.addTeam(team);
            session.commit();
        }
    }
}
