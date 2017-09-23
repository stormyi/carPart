package com.xiupeilian.car.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.model.Items;
import com.xiupeilian.car.service.ItemsService;
@Service
public class ItemsServiceImpl implements ItemsService {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Items t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Items t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Items selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Items t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Items t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Items> findByPageQuery(Page<Items> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Items> page) {
		// TODO Auto-generated method stub
		return 0;
	}

}
