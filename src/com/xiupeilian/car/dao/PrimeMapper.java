package com.xiupeilian.car.dao;

import java.util.List;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.Prime;

public interface PrimeMapper extends BaseMapper<Prime> {

	List<Prime> findAllPrime();
   
}