package com.cfc.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.model.Sucursal;
import com.cfc.service.ISucursalService;

@RestController
@RequestMapping("/branches")
public class BranchesRestController {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private ISucursalService iBranchesService;

	@ResponseBody
	@RequestMapping(value = "/getSucursales", method = RequestMethod.GET, produces = "application/json")
	public List<Sucursal> getSucursales() {
		List<Sucursal> sucursales = iBranchesService.findAllSucursales();
		logger.debug("getSucursales.");
		if (sucursales.isEmpty())
			return Collections.emptyList();
		else {
			return sucursales;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public List<Sucursal> saveOrUpdate() {
		// TODO Validata param
		return iBranchesService.findAllSucursales();
	}

}
