package DB.DAO;

import DB.mappers.CountryMapper;
import DB.utils.MybatisConfigUtil;
import models.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.List;

public class CountryDAO {
    public static final Logger LOGGER = Logger.getLogger(DB.DAO.CountryDAO.class);

    public void printCountry() {
        LOGGER.debug("Printing countries");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            List<Country> countries = mapper.getAllCountries();
            for (Country country :
                    countries) {
                System.out.println(country);
            }
        }
    }

    public void addCountry(String name, BigInteger population) {
        LOGGER.debug("Adding country "+ name);
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            Country country = new Country();
            country.setName(name);
            country.setPopulaton(population);
            mapper.addCountry(country);
            session.commit();
        }
    }
}
