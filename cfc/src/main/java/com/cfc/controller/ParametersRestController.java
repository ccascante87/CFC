package com.cfc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.model.Parametros;
import com.cfc.service.IParametersService;

@RestController
@RequestMapping(value = "/parameters")
public class ParametersRestController {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IParametersService iParamsSrvc;

	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Parametros> findAll() {
		logger.debug(".getAll");
		return iParamsSrvc.findAll();
	}
}
