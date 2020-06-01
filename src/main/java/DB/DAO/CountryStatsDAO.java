package DB.DAO;

import DB.mappers.CountryStatsMapper;
import DB.mappers.OlympicsMapper;
import DB.utils.MybatisConfigUtil;
import models.CountryStats;
import models.Olympics;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class CountryStatsDAO {
    public static final Logger LOGGER = Logger.getLogger(CountryStatsDAO.class);

    public void getStats() {
        LOGGER.debug("Printing country statistics");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CountryStatsMapper mapper = session.getMapper(CountryStatsMapper.class);
            List<CountryStats> stats = mapper.getStats();
            for (CountryStats stat :
                    stats) {
                System.out.println(stat);
            }
        }
    }
}
