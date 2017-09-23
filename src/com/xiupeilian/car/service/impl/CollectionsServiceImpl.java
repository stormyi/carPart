package com.xiupeilian.car.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.model.Collections;
import com.xiupeilian.car.service.CollectionsService;
@Service
public class CollectionsServiceImpl implements CollectionsService {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collections selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Collections> findByPageQuery(Page<Collections> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Collections> page) {
		// TODO Auto-generated method stub
		return 0;
	}

}
