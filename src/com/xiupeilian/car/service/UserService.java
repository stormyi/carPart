package com.xiupeilian.car.service;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.User;
import com.xiupeilian.car.vo.LoginVo;
import com.xiupeilian.car.vo.RegisterVo;

public interface UserService extends BaseService<User> {

	User findUserByLoginNameAndPassword(LoginVo vo);

	User findUserByLoginName(String loginName);

	User findUserByPhone(String phone);

	User findUserByEmail(String email);

	void addRegister(RegisterVo vo);

	User findUserByLoginNameAndEmail(User user);

}
