package com.xiupeilian.car.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.model.Menu;
import com.xiupeilian.car.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Menu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Menu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Menu selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Menu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Menu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> findByPageQuery(Page<Menu> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Menu> page) {
		// TODO Auto-generated method stub
		return 0;
	}

}
