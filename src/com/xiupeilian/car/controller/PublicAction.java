package com.xiupeilian.car.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.base.Pager;
import com.xiupeilian.car.model.Brand;
import com.xiupeilian.car.model.Items;
import com.xiupeilian.car.model.Parts;
import com.xiupeilian.car.service.BrandService;
import com.xiupeilian.car.service.ItemsService;
import com.xiupeilian.car.service.PartsService;
import com.xiupeilian.car.service.impl.ItemsServiceImpl;

@Controller
@RequestMapping("/public")
public class PublicAction {
	@Resource
	private ItemsService itemsService ;
	@Resource
	private BrandService brandService ;
	@Resource
	private PartsService partsService ;

	@RequestMapping("/publicList.shtml")
	public String publicList(Page page,Items items,String brandName,HttpServletRequest request) {
		//给页面返回品牌列表  配件列表  所有商品列表  查询结果总条数
		//品牌
		List<Brand> brandList = brandService.findAllBrand() ;
		request.setAttribute("brandList", brandList);
		//配件
		List<Parts> partsList = partsService.findAllParts() ;
		request.setAttribute("partsList", partsList);
		//商品
		//第一次访问不带分页信息，需要判空
		if(page.getPager()==null) {
			page.setPager(new Pager());
		}
		//每页数据条数
		page.getPager().setPageSize(8);
		//分页查询  将搜索信息封到page
		page.setT(items);
		List<Items> itemsList = itemsService.findByPageQuery(page) ;
		//用page回显数据
		page.setList(itemsList);
		//查询结果总条数
		int totalRows=itemsService.findTotalRowsByPageQuery(page);
		page.setTotalRows(totalRows);
		//数据回显
		request.setAttribute("page", page);
		request.setAttribute("brandName", brandName);
		return "publicItems/publicList" ;
	}
}
