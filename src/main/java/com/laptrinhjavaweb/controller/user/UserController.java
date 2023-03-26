package com.laptrinhjavaweb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.dto.UserDto;

@Controller
public class UserController extends BaseController{
	@RequestMapping(value= "dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy () {
		mvShare.setViewName("user/account/register");
		mvShare.addObject("user", new UserDto());
		return mvShare;
	}
	
	@RequestMapping(value= "dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc () {
		mvShare.setViewName("user/account/register");
		mvShare.addObject("user", new UserDto());
		return mvShare;
	}
}
