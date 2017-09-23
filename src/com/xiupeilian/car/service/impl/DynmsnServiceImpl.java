package com.xiupeilian.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.dao.DynmsnMapper;
import com.xiupeilian.car.model.Dynmsn;
import com.xiupeilian.car.service.DynmsnService;
@Service
public class DynmsnServiceImpl implements DynmsnService {
	@Resource
	private DynmsnMapper dynmsnMapper;
	

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Dynmsn t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Dynmsn t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dynmsn selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Dynmsn t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Dynmsn t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Dynmsn> findDymsnsPageQueryByTime() {
		// TODO Auto-generated method stub
		return dynmsnMapper.findDymsnsPageQueryByTime();
	}

	@Override
	public List<Dynmsn> findByPageQuery(Page<Dynmsn> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Dynmsn> page) {
		// TODO Auto-generated method stub
		return 0;
	}

}
