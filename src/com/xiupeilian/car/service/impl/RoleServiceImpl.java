package com.xiupeilian.car.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.model.Role;
import com.xiupeilian.car.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> findByPageQuery(Page<Role> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Role> page) {
		// TODO Auto-generated method stub
		return 0;
	}

}
