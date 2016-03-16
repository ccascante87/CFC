package com.cfc.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.domain.Message;
import com.cfc.model.Historico;
import com.cfc.model.Movimiento;
import com.cfc.model.Saldo;
import com.cfc.model.Sucursal;
import com.cfc.service.IHistoricoService;
import com.cfc.service.IMovimientoService;
import com.cfc.service.ISaldoService;
import com.cfc.service.ISucursalService;

@RestController
@RequestMapping("/efectivo")
public class CFCSpringController {
	final static Logger logger = Logger.getLogger(CFCSpringController.class);
	@Autowired
	ISaldoService iSaldoService;
	@Autowired
	IHistoricoService iHistoricoService;
	@Autowired
	IMovimientoService iMovimientoService;
	@Autowired
	ISucursalService iSucursalService;
	
	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/getSaldos", method = RequestMethod.GET, produces = "application/json")
	public List<Saldo> getSaldos() {
		List<Saldo> saldos =  iSaldoService.findAllSaldos();
		if (saldos.isEmpty())
			return Collections.emptyList();
		else
			return saldos;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getHistoricos", method = RequestMethod.GET, produces = "application/json")
	public List<Historico> getHistoricos() {
		List<Historico> historicos =  iHistoricoService.findAllHistoricos();
		logger.debug("getHistoricos.");
		if (historicos.isEmpty())
			return Collections.emptyList();
		else
			return historicos;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMovimientos", method = RequestMethod.GET, produces = "application/json")
	public List<Movimiento> getMovimientos() {
		List<Movimiento> movimientos =  iMovimientoService.findAllMovimientos();
		logger.debug("getMovimientos.");
		if (movimientos.isEmpty())
			return Collections.emptyList();
		else
			return movimientos;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSucursales", method = RequestMethod.GET, produces = "application/json")
	public List<Sucursal> getSucursales() {
		List<Sucursal> sucursales =  iSucursalService.findAllSucursales();
		logger.debug("getSucursales.");
		if (sucursales.isEmpty())
			return Collections.emptyList();
		else
			return sucursales;
	}
	@ResponseBody
	@RequestMapping(value = "/getSucursal", method = RequestMethod.GET, produces = "application/json")
	public Sucursal getSucursal() {
		Sucursal sucursal =  iSucursalService.findSucursalByName();
		logger.debug("getSucursal.");
		return sucursal;
	}
	/*@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}*/

}