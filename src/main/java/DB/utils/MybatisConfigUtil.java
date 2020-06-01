package DB.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MybatisConfigUtil {
    private static final Logger LOGGER = Logger.getLogger(MybatisConfigUtil.class);
    private static final String CONFIG_FILE_NAME = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory != null) return sqlSessionFactory;
        try {
            Reader reader = Resources.getResourceAsReader(CONFIG_FILE_NAME);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
        return sqlSessionFactory;
    }
}
