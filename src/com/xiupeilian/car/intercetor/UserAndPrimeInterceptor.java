package com.xiupeilian.car.intercetor;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiupeilian.car.model.Menu;
import com.xiupeilian.car.model.User;

public class UserAndPrimeInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("ctx", request.getContextPath());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		String path = request.getRequestURI();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user") ;
		if(path.contains("login")||path.contains("register")) {
			return true ;
		}else {
			if(user==null) {
				response.sendRedirect(request.getContextPath()+"/login/tologin.shtml");
				return false ;
			}else {
				List<Menu> menuList = user.getMenus();
				boolean checkPermission=false;
				for(Menu menu:menuList){
					if(path.contains(menu.getPermissionCode())){
						checkPermission=true;
						break;
					}
				}
				if(checkPermission){
					return true;
				}else{
					response.sendRedirect(request.getContextPath()+"/login/unauthorized.shtml");
					return false;
				}
			}
		}
	}

}
