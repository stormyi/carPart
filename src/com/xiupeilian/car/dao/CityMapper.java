package com.xiupeilian.car.dao;

import java.util.List;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.City;

public interface CityMapper extends BaseMapper<City> {

	List<City> findAllProvinces();

	List<City> findCityByParentId(int id);
   
}