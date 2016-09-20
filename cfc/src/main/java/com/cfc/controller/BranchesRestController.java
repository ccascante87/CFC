package com.cfc.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.model.Sucursal;
import com.cfc.service.ISucursalService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
//			Sucursal all = new Sucursal();
//			all.setCodigoAgencia(-1);
//			all.setIdSucursal(-1);
//			all.setNomAgencia("TODAS");
//			sucursales.add(0, all);
			return sucursales;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public List<Sucursal> saveOrUpdate(@RequestBody String branch) {
		ObjectMapper mapper = new ObjectMapper();
		List<Sucursal> branchesList = null;
		try {
			Sucursal s = mapper.readValue(branch.toString(), Sucursal.class);
			branchesList = iBranchesService.findAllSucursales();
			if(s.getIdSucursal()>0)
				branchesList.add(s);
			else{
				//Update the values
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branchesList;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteBranch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Sucursal> deleteBranch(@RequestBody String branchId) {
		List<Sucursal> branchesList = null;
		try{
			//TODO Call the real service method
			branchesList = iBranchesService.findAllSucursales();
			long idSucursal = Long.parseLong(branchId);
			Iterator<Sucursal> itSuc = branchesList.iterator();
			while (itSuc.hasNext()) {
				Sucursal temp = itSuc.next();
				if(temp.getIdSucursal()== idSucursal){
					itSuc.remove();
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return branchesList;
	}

}
