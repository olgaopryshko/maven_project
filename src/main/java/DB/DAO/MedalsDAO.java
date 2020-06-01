package DB.DAO;

import DB.mappers.CountryMapper;
import DB.mappers.MedalsMapper;
import DB.utils.MybatisConfigUtil;
import models.Country;
import models.Medals;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class MedalsDAO {
    public static final Logger LOGGER = Logger.getLogger(DB.DAO.MedalsDAO.class);

    public void printMedals() {
        LOGGER.debug("Printing medals");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            MedalsMapper mapper = session.getMapper(MedalsMapper.class);
            List<Medals> medals = mapper.getAllMedals();
            for (Medals medals1 :
                    medals) {
                System.out.println(medals1);
            }
        }
    }

    public void addMedals(Integer countryId, Integer gold, Integer silver, Integer bronze, Integer olympicsId) {
        LOGGER.debug("Adding medals");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            MedalsMapper mapper = session.getMapper(MedalsMapper.class);
            Medals medals = new Medals();
            medals.setCountryId(countryId);
            medals.setGold(gold);
            medals.setSilver(silver);
            medals.setBronze(bronze);
            medals.setOlympicsId(olympicsId);
            mapper.addMedals(medals);
            session.commit();

        }
    }
}
