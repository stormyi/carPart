package com.xiupeilian.car.service;

import java.util.List;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.Brand;

public interface BrandService extends BaseService<Brand> {

	List<Brand> findAllBrand();

}
