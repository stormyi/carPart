package com.xiupeilian.car.dao;

import java.util.List;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.Parts;

public interface PartsMapper extends BaseMapper<Parts> {

	List<Parts> findAllParts();
   
}