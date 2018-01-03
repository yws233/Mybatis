package cn.market.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class UserMapperTest {
    Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testCount() {

        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try {
            //1.获取mybatis-config.xml
            InputStream is = Resources.getResourceAsStream(resource);
            //2.创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3.创建sqlSession
            sqlSession = factory.openSession();
            //4.调用mapper文件，操作数据库
            count = sqlSession.selectOne("cn.market.dao.user.UserMapper.count");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        logger.debug("UserDaoTest count++---> " + count);
    }
}
