package com.xiupeilian.car.service;

import java.util.List;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.Prime;

public interface PrimeService extends BaseService<Prime> {

	List<Prime> findAllPrime();

}
