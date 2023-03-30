package com.laptrinhjavaweb.controller.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.request.UserLoginRequest;
import com.laptrinhjavaweb.model.request.UserRegisterRequest;
import com.laptrinhjavaweb.service.IUserService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		mvShare.setViewName("user/account/register");
		mvShare.addObject("user", new UserRegisterRequest());
		return mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc(@ModelAttribute("user") UserRegisterRequest user) {
		userService.insert(user);
		mvShare.setViewName("user/account/register");
		return mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView Login(HttpServletRequest request,HttpServletResponse response) {
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for(Cookie cookie : arr) {
				if (cookie.getName().equals("email")) {
					request.setAttribute("email", cookie.getValue());
				}
				if (cookie.getName().equals("password")) {
					request.setAttribute("password", cookie.getValue());
				}
			}
		}
		mvShare.setViewName("user/account/login");
		//mvShare.addObject("user", new UserLoginRequest());
		return mvShare;
	}


	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView LogOut(HttpServletRequest request, HttpServletResponse response) {
		String email="";
		String password="";
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for (Cookie cookie : arr) {
				if (cookie.getName().equals("email")) {
					email= cookie.getValue();
				}
				if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		if (email != null && email.isEmpty()== false) {
			Cookie gmail = new Cookie("email",email);
			gmail.setMaxAge(100);
			response.addCookie(gmail);
		}
		if (password != null && password.isEmpty() == false) {
		Cookie pass = new Cookie("password", password);
		pass.setMaxAge(100);
		response.addCookie(pass);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
}
