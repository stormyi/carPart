package com.xiupeilian.car.intercetor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ModeAndViewInterceptor implements HandlerInterceptor {

	/**
	 * ���������֮��
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ������ͼ֮ǰ
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("ctx", request.getContextPath());
		
	}

	/**
	 * ���봦����֮ǰ
	 */
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
