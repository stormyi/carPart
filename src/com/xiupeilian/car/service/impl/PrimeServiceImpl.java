package com.xiupeilian.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.dao.PrimeMapper;
import com.xiupeilian.car.model.Prime;
import com.xiupeilian.car.service.PrimeService;
@Service
public class PrimeServiceImpl implements PrimeService {
	@Resource
	private PrimeMapper primeMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Prime t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Prime t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prime selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Prime t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Prime t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Prime> findByPageQuery(Page<Prime> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Prime> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Prime> findAllPrime() {
		// TODO Auto-generated method stub
		return primeMapper.findAllPrime();
	}

}
