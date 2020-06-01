package DB.DAO;

import DB.mappers.CityMapper;
import DB.mappers.SportMapper;
import DB.utils.MybatisConfigUtil;
import models.City;
import models.Sport;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class CityDAO {

    public static final Logger LOGGER = Logger.getLogger(DB.DAO.CityDAO.class);

    public void printCity() {
        LOGGER.debug("Printing cities");
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CityMapper mapper = session.getMapper(CityMapper.class);
            List<City> cities = mapper.getAllCities();
            for (City city :
                    cities) {
                System.out.println(city);
            }
        }
    }

    public void addCity(Integer countryId, String status, String name) {
        LOGGER.debug("Adding city: " + name);
        try (SqlSession session = MybatisConfigUtil.getSqlSessionFactory().openSession()) {
            CityMapper mapper = session.getMapper(CityMapper.class);
            City city = new City();
            city.setCountryId(countryId);
            city.setStatus(status);
            city.setName(name);
            mapper.addCity(city);
            session.commit();
        }
    }
}



