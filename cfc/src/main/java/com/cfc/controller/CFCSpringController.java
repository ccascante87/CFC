package com.cfc.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.domain.GraphData;
import com.cfc.domain.Item;
import com.cfc.domain.MainData;
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
	private GraphData data = GraphData.getInstance();
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
	@RequestMapping(value = "/getSaldosByCurrency/{currency}", method = RequestMethod.GET, produces = "application/json")
	public List<Saldo> getSaldosByCurrency(@PathVariable("currency") String currency) {
		List<Saldo> saldos =  iSaldoService.findAllSaldosByCurrency(currency);
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
	@RequestMapping(value = "/getHistoricosByCurrency/{currency}", method = RequestMethod.GET, produces = "application/json")
	public List<Historico> getHistoricosByCurrency(@PathVariable("currency") String currency) {
		List<Historico> historicos =  iHistoricoService.findAllHistoricosByCurrency(currency);
		logger.debug("getHistoricosByCurrency.");
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
	@RequestMapping(value = "/getMovimientosByCurrency/{currency}", method = RequestMethod.GET, produces = "application/json")
	public List<Movimiento> getMovimientosByCurrency(@PathVariable("currency") String currency) {
		List<Movimiento> movimientos =  iMovimientoService.findAllMovimientosByCurrency(currency);
		logger.debug("getMovimientosByCurrency.");
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
	@RequestMapping(value = "/getSucursalByName/{name}", method = RequestMethod.GET, produces = "application/json")
	public Sucursal getSucursal(@PathVariable("name") String name) {
		Sucursal sucursal =  iSucursalService.findSucursalByName(name);
		logger.debug("getSucursal.");
		return sucursal;
	}
	
	@ResponseBody
	@RequestMapping(value = "/manejo/data/colones", method = RequestMethod.GET, produces = "application/json")
	public Sucursal getManejoDataColones(@PathVariable("name") String name) {
		Sucursal sucursal =  iSucursalService.findSucursalByName(name);
		logger.debug("getSucursal.");
		return sucursal;
	}
	
	@ResponseBody
	@RequestMapping(value = "/manejo/grafico/colones", method = RequestMethod.GET, produces = "application/json")
	public Sucursal getManejoGraficoColones(@PathVariable("name") String name) {
		Sucursal sucursal =  iSucursalService.findSucursalByName(name);
		logger.debug("getSucursal.");
		return sucursal;
	}
	
	@ResponseBody
	@RequestMapping(value = "/manejo/data/dolares", method = RequestMethod.GET, produces = "application/json")
	public Sucursal getManejoDataDolares(@PathVariable("name") String name) {
		Sucursal sucursal =  iSucursalService.findSucursalByName(name);
		logger.debug("getSucursal.");
		return sucursal;
	}
	
	@ResponseBody
	@RequestMapping(value = "/manejo/grafico/dolares", method = RequestMethod.GET, produces = "application/json")
	public Sucursal getManejoGraficoDolares(@PathVariable("name") String name) {
		Sucursal sucursal =  iSucursalService.findSucursalByName(name);
		logger.debug("getSucursal.");
		return sucursal;
	}
	
	@ResponseBody
	@RequestMapping(value = "/manejo/grafico/static", method = RequestMethod.GET, produces = "application/json")
	public List<Object[]> getManejoGraficoDolares() {
		List<Object[]>  sucursal =  iSaldoService.getStaticData();
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
	@ResponseBody
	@RequestMapping(value="/getGraphData", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public MainData getGraphData(String currency, String branch){
		
		data.addItem();
		
		MainData mda = new MainData();
		mda.setAutorizedBalance(BigDecimal.TEN.multiply(new BigDecimal(Math.random() * 10000)));
		mda.setCurrentBalance((BigDecimal.TEN.multiply(new BigDecimal(Math.random() * 10000))));
		mda.setInsuredAmount((BigDecimal.TEN.multiply(new BigDecimal(Math.random() * 10000))));
		mda.setLazyAmount((BigDecimal.TEN.multiply(new BigDecimal(Math.random() * 10000))));
		mda.setReorderPoint((BigDecimal.TEN.multiply(new BigDecimal(Math.random() * 10000))));
		mda.setUtilizationRate(10);
		
		for (String label : mda.getGraphData().getLabels()) {
			mda.getCashBehaviorDetail().add(new Item(label, new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 1000)));
		}
		
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 1000)));
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 1000)));
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 1000)));
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 1000)));	
		
		return mda;
	}

}