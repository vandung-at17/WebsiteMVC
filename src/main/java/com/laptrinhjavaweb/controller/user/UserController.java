package com.laptrinhjavaweb.controller.user;

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
	public ModelAndView Login() {
		mvShare.setViewName("user/account/login");
		mvShare.addObject("user", new UserLoginRequest());
		return mvShare;
	}

	/*
	 * @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST) public
	 * ModelAndView LoginAcc(@ModelAttribute("user") UserLoginRequest user) {
	 * mvShare.setViewName("user/account/login"); return mvShare; }
	 */

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView LogOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
}
