package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.service.impl.CustomUserDetailsService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Component
// Phần này xử lý phần phân quyền sau khi đăng nhập
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		String email= request.getParameter("j_username");
		String password = request.getParameter("j_password");
		String remember = request.getParameter("remember-me");
		Cookie user = new Cookie("email", email);
		user.setMaxAge(90);
		response.addCookie(user);
		if (remember != null) {
			Cookie pass = new Cookie("password", password);
			pass.setMaxAge(70);
			response.addCookie(pass);
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	private String determineTargetUrl(Authentication authentication) {
		// TODO Auto-generated method stub
		String url ="";
		List<String> roles = SecurityUtils.getAuthorities();
		if (isAdmin(roles)) {
			url= "/home";
		}
		if (isUser(roles)) {
			url= "/trang-chu";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> roles) {
		if(roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	private boolean isUser(List<String> roles) {
		if (roles.contains("USER")) {
			return true;
		}
		return false;
	}
}
