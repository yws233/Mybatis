package cn.ms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.ms.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    /*private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSession = sqlSessionTemplate;
    }
*/


    @Override
    public List<User> getUserList(User user) {
        List<User> userList = new ArrayList<User>();
        //利用继承自SqlSessionDaoSupport,获取getSqlSession()
        //userList = this.getSqlSession().selectList("cn.ms.dao.UserMapper.getUserList",user);
        userList = this.getSqlSession().getMapper(UserMapper.class).getUserList(user);
        return userList;
    }


    @Override
    public int add(User user) {
        return 0;
    }
}
