package com.xiupeilian.car.dao;

import com.xiupeilian.car.base.BaseMapper;
import com.xiupeilian.car.model.Company;

public interface CompanyMapper extends BaseMapper<Company> {

	Company findCompanyByName(String companyname);
  
}