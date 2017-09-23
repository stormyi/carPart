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
	 * ����ע��ҳ��
	 */
   @RequestMapping("/toRegister.shtml")
   public String toRegister(HttpServletRequest request){
	   //����ע��ҳ����ҪչʾƷ�Ƶ�����ѡ��������������ѡ����Ʒ���������ѡ��������ȥ��һ��
	   List<Brand> brandList=brandService.findAllBrand();
	   List<Parts> partsList=partsService.findAllParts();
	   List<Prime> primeList=primeService.findAllPrime();
	   request.setAttribute("brandList", brandList);
	   request.setAttribute("partsList", partsList);
	   request.setAttribute("primeList", primeList);
	   return "commons/register";
   }
     /**
      * У���û����Ƿ����ע��
      */
    @RequestMapping("/checkLoginName.shtml")
    public void checkLoginName(String loginName,HttpServletResponse response) throws Exception{
    	//У���û����Ƿ����
    	User user=userService.findUserByLoginName(loginName);
    	if(user==null){
    		response.getWriter().write("1");
    	}else{
    		response.getWriter().write("0");
    	}
    }
    
    /**
     * У���ֻ����Ƿ����ע��
     */
   @RequestMapping("/checkPhone.shtml")
   public void checkPhone(String telnum,HttpServletResponse response) throws Exception{
   	//У���ֻ����Ƿ����
   	User user=userService.findUserByPhone(telnum);
   	if(user==null){
   		response.getWriter().write("1");
   	}else{
   		response.getWriter().write("0");
   	}
   }
   
   
   /**
    * У�������Ƿ����ע��
    */
  @RequestMapping("/checkEmail.shtml")
  public void checkEmail(String email,HttpServletResponse response) throws Exception{
  	//У���ֻ����Ƿ����
  	User user=userService.findUserByEmail(email);
  	if(user==null){
  		response.getWriter().write("1");
  	}else{
  		response.getWriter().write("0");
  	}
  }
  
  /**
   * У����ҵ�����Ƿ����ע��
   * 
   * /checkCompanyname.shtml
   */
  
  @RequestMapping("/checkCompanyname.shtml")
  public void checkCompanyname(String companyname,HttpServletResponse response) throws Exception{
  	//������ҵ���Ʋ�ѯ��ҵ��
  	Company company=companyService.findCompanyByName(companyname);
  	if(company==null){
  		response.getWriter().write("1");
  	}else{
  		response.getWriter().write("0");
  	}
  	
  }
  
  /**
   * ��ѯ���е�ʡ
 * @throws Exception 
   */
  @RequestMapping("/getProvince.shtml")
  public void getProvince(HttpServletResponse response) throws Exception{
	  //��ѯ�����е�ʡ������json��ʽ��Ӧ���ͻ���
	  response.setCharacterEncoding("utf-8");
	  List<City> list=cityService.findAllProvinces();
	  String json=JsonUtils.List2Json(list);
	  response.getWriter().write(json);
	  
  }
  
  /**
   * ��ȡ�л�������
   */
  
  @RequestMapping("/getCity.shtml")
  public void getCity(int id,HttpServletResponse response) throws Exception{
	  //��ѯ�����е�ʡ������json��ʽ��Ӧ���ͻ���
	  response.setCharacterEncoding("utf-8");
	  List<City> list=cityService.findCityByParentId(id);
	  String json=JsonUtils.List2Json(list);
	  response.getWriter().write(json);
	  
  }
  /**
   * ע�Ṧ��
 * @throws Exception 
   */
  @RequestMapping("/register.shtml")
  public void register(RegisterVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
	  userService.addRegister(vo);
	  response.sendRedirect(request.getContextPath()+"/login/tologin.shtml");
  }
  
}
