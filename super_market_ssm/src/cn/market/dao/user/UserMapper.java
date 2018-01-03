package cn.market.dao.user;

import cn.market.pojo.User;

import java.util.List;

public interface UserMapper {
    public int count();
    public List<User> getUserList(); //此处方法名唏嘘与SQL映射文件里边的(UserMapper.xml)id一致
}
