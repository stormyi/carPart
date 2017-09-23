package com.xiupeilian.car.service;

import com.xiupeilian.car.base.BaseService;
import com.xiupeilian.car.model.City;
import com.xiupeilian.car.model.Company;

public interface CompanyService extends BaseService<Company> {

	Company findCompanyByName(String companyname);

}
