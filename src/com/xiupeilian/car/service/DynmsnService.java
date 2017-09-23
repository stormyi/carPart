package com.xiupeilian.car.service;

import java.util.List;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.Dynmsn;

public interface DynmsnService extends BaseService<Dynmsn> {
	public List<Dynmsn> findDymsnsPageQueryByTime();

}
