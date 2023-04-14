package com.laptrinhjavaweb.controller.user;

import java.util.Random;

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

import com.laptrinhjavaweb.helper.GmailHelper;
import com.laptrinhjavaweb.model.request.UserRegisterRequest;
import com.laptrinhjavaweb.service.IUserService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	private int ranNumber;
	
	private String gmailAcc;

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
	
	@RequestMapping(value = "/forgetpassword" , method = RequestMethod.GET)
	public ModelAndView  ForgetPassword () {
		mvShare.setViewName("user/account/forgetpassword");
		return mvShare;
	}
	
	@RequestMapping(value = "/forgetpassword" , method = RequestMethod.POST)
	public ModelAndView  ForgetPasswordAcc (HttpServletRequest request, HttpServletResponse response) {
		String gmail= request.getParameter("email");
		String code = request.getParameter("code");
		if (code == null|| code.isEmpty()) {
			if (gmail == null|| gmail.isEmpty()) {
				ranNumber = -1;
			}else {
				Random random = new Random();
				ranNumber = random.nextInt(100000);
				GmailHelper gmailHelper = new GmailHelper();
				gmailHelper.guiXacThucGmail(gmail, String.valueOf(ranNumber));
				gmailAcc = gmail;
			}
			mvShare.addObject("random",ranNumber);
		}else if (Integer.valueOf(code)==ranNumber) {
			mvShare.setViewName("user/account/forget_password");
		}else {
			mvShare.setViewName("user/account/forgetpassword");
		}
		return mvShare;
	}
	
	@RequestMapping(value = "/updatepasswordnew" , method = RequestMethod.POST)
	public ModelAndView AuthenticationCode (HttpServletRequest request, HttpServletResponse response){
		String passwordNew = request.getParameter("passwordNew");
		String passwordNews = request.getParameter("passwordNews");
		if (passwordNew.equals(passwordNews)) {
			userService.updatePassWordNew(passwordNew, gmailAcc);
			return new ModelAndView("redirect:/dang-nhap");
		}else {
			return mvShare;
		}
	}
}
