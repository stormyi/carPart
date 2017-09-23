package com.xiupeilian.car.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiupeilian.car.model.Brand;
import com.xiupeilian.car.model.City;
import com.xiupeilian.car.model.Company;
import com.xiupeilian.car.model.Parts;
import com.xiupeilian.car.model.Prime;
import com.xiupeilian.car.model.User;
import com.xiupeilian.car.service.BrandService;
import com.xiupeilian.car.service.CityService;
import com.xiupeilian.car.service.CompanyService;
import com.xiupeilian.car.service.PartsService;
import com.xiupeilian.car.service.PrimeService;
import com.xiupeilian.car.service.UserService;
import com.xiupeilian.car.util.JsonUtils;
import com.xiupeilian.car.vo.RegisterVo;

@Controller
@RequestMapping("/register")
public class RegisterAction {
	@Resource
	private UserService userService;
	@Resource
	private CompanyService companyService;
	@Resource
	private CityService cityService;
	@Resource
	private BrandService brandService;
	@Resource
	private PartsService partsService;
	@Resource
	private PrimeService primeService;
	
	/**
	 * 
	 * 进入注册页面
	 */
   @RequestMapping("/toRegister.shtml")
   public String toRegister(HttpServletRequest request){
	   //由于注册页面需要展示品牌的下拉选、配件种类的下拉选、精品种类的下拉选，所以先去查一查
	   List<Brand> brandList=brandService.findAllBrand();
	   List<Parts> partsList=partsService.findAllParts();
	   List<Prime> primeList=primeService.findAllPrime();
	   request.setAttribute("brandList", brandList);
	   request.setAttribute("partsList", partsList);
	   request.setAttribute("primeList", primeList);
	   return "commons/register";
   }
     /**
      * 校验用户名是否可以注册
      */
    @RequestMapping("/checkLoginName.shtml")
    public void checkLoginName(String loginName,HttpServletResponse response) throws Exception{
    	//校验用户名是否存在
    	User user=userService.findUserByLoginName(loginName);
    	if(user==null){
    		response.getWriter().write("1");
    	}else{
    		response.getWriter().write("0");
    	}
    }
    
    /**
     * 校验手机号是否可以注册
     */
   @RequestMapping("/checkPhone.shtml")
   public void checkPhone(String telnum,HttpServletResponse response) throws Exception{
   	//校验手机号是否存在
   	User user=userService.findUserByPhone(telnum);
   	if(user==null){
   		response.getWriter().write("1");
   	}else{
   		response.getWriter().write("0");
   	}
   }
   
   
   /**
    * 校验邮箱是否可以注册
    */
  @RequestMapping("/checkEmail.shtml")
  public void checkEmail(String email,HttpServletResponse response) throws Exception{
  	//校验手机号是否存在
  	User user=userService.findUserByEmail(email);
  	if(user==null){
  		response.getWriter().write("1");
  	}else{
  		response.getWriter().write("0");
  	}
  }
  
  /**
   * 校验企业名称是否可以注册
   * 
   * /checkCompanyname.shtml
   */
  
  @RequestMapping("/checkCompanyname.shtml")
  public void checkCompanyname(String companyname,HttpServletResponse response) throws Exception{
  	//根据企业名称查询企业表
  	Company company=companyService.findCompanyByName(companyname);
  	if(company==null){
  		response.getWriter().write("1");
  	}else{
  		response.getWriter().write("0");
  	}
  	
  }
  
  /**
   * 查询所有的省
 * @throws Exception 
   */
  @RequestMapping("/getProvince.shtml")
  public void getProvince(HttpServletResponse response) throws Exception{
	  //查询到所有的省，并以json格式响应给客户端
	  response.setCharacterEncoding("utf-8");
	  List<City> list=cityService.findAllProvinces();
	  String json=JsonUtils.List2Json(list);
	  response.getWriter().write(json);
	  
  }
  
  /**
   * 获取市或者区域
   */
  
  @RequestMapping("/getCity.shtml")
  public void getCity(int id,HttpServletResponse response) throws Exception{
	  //查询到所有的省，并以json格式响应给客户端
	  response.setCharacterEncoding("utf-8");
	  List<City> list=cityService.findCityByParentId(id);
	  String json=JsonUtils.List2Json(list);
	  response.getWriter().write(json);
	  
  }
  /**
   * 注册功能
 * @throws Exception 
   */
  @RequestMapping("/register.shtml")
  public void register(RegisterVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
	  userService.addRegister(vo);
	  response.sendRedirect(request.getContextPath()+"/login/tologin.shtml");
  }
  
}
