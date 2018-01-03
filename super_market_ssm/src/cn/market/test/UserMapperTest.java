package cn.market.test;

import cn.market.dao.user.UserMapper;
import cn.market.pojo.User;
import cn.market.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.List;


/**
 * 测试类
 * @author ws
 */
public class UserMapperTest {
    Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testCount() {
        int count = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtil.createSqlsession();
            count = sqlSession.getMapper(UserMapper.class).count();
            logger.debug("UserDaoTest count++---> " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlsession(sqlSession);
        }

    }

    @Test
    public void getUserList() {
        List<User> userList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtil.createSqlsession();
            userList = sqlSession.getMapper(UserMapper.class).getUserList();
            for (User user : userList){
                logger.debug("UserDaoTest count++---> " + user.getUserName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlsession(sqlSession);
        }

    }
}
