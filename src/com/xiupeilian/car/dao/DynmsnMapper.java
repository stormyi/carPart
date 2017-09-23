package com.xiupeilian.car.dao;

import java.util.List;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.Dynmsn;

public interface DynmsnMapper extends BaseMapper<Dynmsn> {

	List<Dynmsn> findDymsnsPageQueryByTime();
}