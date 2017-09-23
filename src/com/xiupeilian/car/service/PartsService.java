package com.xiupeilian.car.service;

import java.util.List;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.Parts;

public interface PartsService extends BaseService<Parts> {

	List<Parts> findAllParts();

}
