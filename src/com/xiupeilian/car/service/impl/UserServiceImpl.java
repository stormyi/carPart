package com.xiupeilian.car.service.impl;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.constant.SysConstant;
import com.xiupeilian.car.dao.CompanyMapper;
import com.xiupeilian.car.dao.UserMapper;
import com.xiupeilian.car.model.Company;
import com.xiupeilian.car.model.User;
import com.xiupeilian.car.service.UserService;
import com.xiupeilian.car.util.DateUtil;
import com.xiupeilian.car.util.MailEngine;
import com.xiupeilian.car.vo.LoginVo;
import com.xiupeilian.car.vo.RegisterVo;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private MailEngine mailEngine;
	@Resource
	private CompanyMapper companyMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User t) {
		User checkUser = findUserByLoginNameAndEmail(t);
		if (checkUser == null) {
			return 1;
		}
		Random random = new Random();
		String password = "";
		for (int i = 0; i < 6; i++) {
			password = password + random.nextInt(10);
		}
		checkUser.setPassword(password);
		userMapper.updateByPrimaryKeySelective(checkUser);
		String address = checkUser.getEmail();
		String text = "asdf" + password;
		try {
			mailEngine.sendMessage(text, address);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return 2;
	}

	@Override
	public int updateByPrimaryKey(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserByLoginNameAndPassword(LoginVo vo) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginNameAndPassword(vo);
	}

	@Override
	public List<User> findByPageQuery(Page<User> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<User> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginName(loginName);
	}

	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userMapper.findUserByPhone(phone);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.findUserByEmail(email);
	}

	/**
	 * ��ҵע��
	 */
	public void addRegister(RegisterVo vo) {
		// ��ҵע���Ϊ������1�����ȵ�����ҵ������¼�������ظ���ҵ������
		// 2:���û�������¼�����Ҹ��û�������ҵid����ɫid
		Company company = new Company();
		company.setAddress(vo.getAddress());
		company.setBoss(vo.getUsername());
		company.setCompanyCode(UUID.randomUUID().toString());
		company.setCompanyName(vo.getCompanyname());
		company.setCreateTime(DateUtil.now());
		company.setManageStyle(Integer.parseInt(vo.getManageStyle()));
		company.setManageDetail(vo.getManageDetail());
		company.setPhone(vo.getTelnum());
		company.setQq(vo.getQq());
		company.setStatus(SysConstant.COMPANY_STATUS_NORMAL);
		company.setTel1(vo.getTel1());
		company.setTel2(vo.getTel2());
		company.setZone1(vo.getZone1());
		company.setZone2(vo.getZone2());
		companyMapper.insertSelective(company);
		// �����û�
		User user = new User();
		user.setCompanyId(company.getId());
		user.setCreateTime(DateUtil.now());
		user.setEmail(vo.getEmail());
		user.setLevel(SysConstant.USER_LEVEL_BOSS);
		user.setLoginName(vo.getLoginName());
		user.setPassword(vo.getPassword());
		user.setPhone(vo.getTelnum());
		user.setQq(vo.getQq());
		user.setRoleId(SysConstant.USER_ROLE_BOSS);
		user.setStatus(SysConstant.USER_STATUS_NORMAL);
		user.setUsername(vo.getUsername());
		userMapper.insertSelective(user);

	}

	@Override
	public User findUserByLoginNameAndEmail(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginNameAndEmail(user);
	}

}
