package cn.market.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
*  sqlsession公共操作类
* */

public class MybatisUtil {
    private static SqlSessionFactory factory;
    //SqlSessionFactory只需创建一次
    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession createSqlsession(){
        return factory.openSession(false); //开启事物控制
    }

    public static void closeSqlsession(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
