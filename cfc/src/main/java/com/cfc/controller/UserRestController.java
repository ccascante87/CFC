package com.cfc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.model.Usuario;
import com.cfc.service.IMonedaService;
import com.cfc.service.ISucursalService;

@RestController
@RequestMapping(value="/user")
public class UserRestController {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ISucursalService iSucursalService;
	@Autowired
	private IMonedaService iMonedaservice;

	@ResponseBody
	@RequestMapping(value="/getUser/{loginName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Usuario getUser(@PathVariable String loginName){
		Usuario user = new Usuario();
		user.setDefaultBranch(iSucursalService.findAllSucursales().get(0));
		user.setDefaultCurrency(iMonedaservice.findAll().get(0));
		if(loginName.equals("admin")){
			user.setAdmin(true);
			user.setLoginName("Carlos Admin");
			user.setName("Carlos Admin");
		}
		else if(loginName.equals("user")){
			user.setAdmin(false);
			user.setLoginName("Carlos User");
			user.setName("Carlos User");
		}
		return user;
	}

	
}
