package com.xiupeilian.car.service;

import java.util.List;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.City;

public interface CityService extends BaseService<City> {

	List<City> findAllProvinces();

	List<City> findCityByParentId(int id);

}
