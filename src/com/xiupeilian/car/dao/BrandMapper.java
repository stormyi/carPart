package com.xiupeilian.car.dao;

import java.util.List;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.Brand;

public interface BrandMapper extends BaseMapper<Brand>{

	List<Brand> findAllBrand();
   
}