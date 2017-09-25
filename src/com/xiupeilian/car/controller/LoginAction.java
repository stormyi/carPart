package com.xiupeilian.car.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiupeilian.car.model.User;
import com.xiupeilian.car.service.UserService;
import com.xiupeilian.car.util.MailEngine;
import com.xiupeilian.car.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@Resource
	private MailEngine mailEngine;
	@Resource
	private UserService userService;

	@RequestMapping("/tologin.shtml")
	public String toLogin() {
		return "commons/login";
	}

	@RequestMapping("/login.shtml")
	public void login(HttpServletResponse response, HttpSession session, LoginVo vo) throws Exception {
		/*
		 * ��¼���߼� 1:�ж���֤�� 2:�ж��û��������� 3:��ѯ�����û���Ӧ�Ľ�ɫ��Ȩ��
		 */
		String code = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (vo.getValidateCode().toUpperCase().equals(code.toUpperCase())) {
			// ��ѯ���ݿ⣬�����Ƿ��и��û�
			User user = userService.findUserByLoginNameAndPassword(vo);
			if (user == null) {
				response.getWriter().write("2");
			} else {
				session.setAttribute("user", user);
				response.getWriter().write("3");
			}

		} else {
			response.getWriter().write("1");
		}

	}

	@RequestMapping("/logout.shtml")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:tologin.shtml";
	}

	@RequestMapping("/toGetPassword.shtml")
	public String toGetPassword() {

		return "commons/getPassword";
	}

	@RequestMapping("/getPassword.shtml")
	public void getPassword(HttpServletResponse response, User user) throws Exception {
		int code = 3 ;
		try {
			code = userService.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			code = 3 ;
		}
		response.getWriter().write(code + "");
	}
	
	@RequestMapping("/unauthorized.shtml")
	   public String unauthorized(){
		   return "commons/unauthorized";
	   }
}
