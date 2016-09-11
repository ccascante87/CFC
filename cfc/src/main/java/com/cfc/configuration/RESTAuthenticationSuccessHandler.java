package com.cfc.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.cfc.domain.User;

public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	 @Override
	 public void onAuthenticationSuccess(HttpServletRequest request, 
	  HttpServletResponse response, Authentication authentication)
	 throws ServletException, IOException {
	  User user = new User();
	  user.setName(authentication.getName());
//	  SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, user);
	 }
}
