package DB.DAO;

import DB.mappers.OlympicsMapper;
import DB.utils.MybatisConfigUtil;
import models.Olympics;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class OlympicsDAO {

    public static final Logger LOGGER = Logger.getLogger(OlympicsDAO.class);

    public void printOlympics() {
        LOGGER.debug("Printing Olympics");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            OlympicsMapper mapper = session.getMapper(OlympicsMapper.class);
            List<Olympics> olympics = mapper.getAllOlympics();
            for (Olympics game :
                    olympics) {
                System.out.println(game);
            }
        }
    }

    public void addOlympics(Integer year, String season, Integer cityId) {
        LOGGER.debug("Adding Olympics "+year+" year");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            OlympicsMapper mapper = session.getMapper(OlympicsMapper.class);
            Olympics olympics = new Olympics();
            olympics.setYear(year);
            olympics.setSeason(season);
            olympics.setCityId(cityId);
            mapper.addOlympics(olympics);
            session.commit();
        }
    }
}

