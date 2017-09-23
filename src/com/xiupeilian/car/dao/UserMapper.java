package com.xiupeilian.car.dao;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.User;
import com.xiupeilian.car.vo.LoginVo;

public interface UserMapper extends BaseMapper<User> {

	User findUserByLoginNameAndPassword(LoginVo vo);

	User findUserByLoginName(String loginName);

	User findUserByPhone(String phone);

	User findUserByEmail(String email);

	User findUserByLoginNameAndEmail(User user);
   
}