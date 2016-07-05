package com.cfc.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.domain.GraphData;
import com.cfc.domain.GraphicItem;
import com.cfc.domain.Item;
import com.cfc.domain.MainData;
import com.cfc.domain.Message;
import com.cfc.model.Historico;
import com.cfc.model.Moneda;
import com.cfc.model.Movimiento;
import com.cfc.model.Pivot;
import com.cfc.model.Saldo;
import com.cfc.model.Sucursal;
import com.cfc.model.Transaccion;
import com.cfc.service.IHistoricoService;
import com.cfc.service.IMonedaService;
import com.cfc.service.IMovimientoService;
import com.cfc.service.IPivotService;
import com.cfc.service.ISaldoService;
import com.cfc.service.ISucursalService;
import com.cfc.service.ITransaccionService;

@RestController
@RequestMapping("/efectivo")
public class CFCSpringController {
	final static Logger logger = Logger.getLogger(CFCSpringController.class);
	private GraphData comportamientoEfectivo = new GraphData();
	private GraphData variacionesEfectivo = new GraphData();
	private int maxId = 0;
	@Autowired
	ISaldoService iSaldoService;
	@Autowired
	IHistoricoService iHistoricoService;
	@Autowired
	IMovimientoService iMovimientoService;
	@Autowired
	ISucursalService iSucursalService;
	@Autowired
	IPivotService iPivotService;
	@Autowired
	IMonedaService iMonedaService;
	@Autowired
	ITransaccionService iTransaccionService;
	
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
//		variacionesEfectivo = new GraphData();
//		comportamientoEfectivo = new  GraphDatCa();
		variacionesEfectivo.getyAxisValues().clear();
		comportamientoEfectivo.getyAxisValues().clear();
		List<Pivot> data = iPivotService.findByMaxID(++maxId);
		List<GraphicItem> yAxisComp = new ArrayList<GraphicItem>();
		List<GraphicItem> yAxisVar = new ArrayList<GraphicItem>();
		GraphicItem item = new GraphicItem();
		MainData mda = new MainData();
		GraphicItem lcir = new GraphicItem("Lcir", "line");
		GraphicItem lcix = new GraphicItem("Lcix", "line");
		GraphicItem lcr = new GraphicItem("Lcr", "line");
		GraphicItem lcsr = new GraphicItem("Lcsr", "line");
		GraphicItem lcsx = new GraphicItem("Lcsx", "line");
		GraphicItem lcx = new GraphicItem("Lcx", "line");
		GraphicItem menudo = new GraphicItem("Menudo", "area");
		GraphicItem reserva = new GraphicItem("Reserva", "area");
		GraphicItem varianza = new GraphicItem("Varianza", "area");
		
		for (Pivot pivot : data) {
			//Graph. 1
			System.out.println("Menudo: " + pivot.getMenudo() + ", Reserva=" + pivot.getReserva());
			menudo.getItemValues().add(pivot.getMenudo().intValue() +"");
			reserva.getItemValues().add(pivot.getReserva().intValue() +"");
			lcsx.getItemValues().add(pivot.getLcsx().intValue() +"");
			lcx.getItemValues().add(pivot.getLcx().intValue() +"");
			lcix.getItemValues().add(pivot.getLcix().intValue() +"");
			
			
			//Graph. 2
			varianza.getItemValues().add(pivot.getReserva().toPlainString());
			lcsr.getItemValues().add(pivot.getLcsr().toPlainString());
			lcr.getItemValues().add(pivot.getLcr().toPlainString());
			lcir.getItemValues().add(pivot.getLcir().toPlainString());
		}
		comportamientoEfectivo.getyAxisValues().add(menudo);
		comportamientoEfectivo.getyAxisValues().add(reserva);
		comportamientoEfectivo.getyAxisValues().add(lcsx);
		comportamientoEfectivo.getyAxisValues().add(lcx);
		comportamientoEfectivo.getyAxisValues().add(lcix);
		
		variacionesEfectivo.getyAxisValues().add(varianza);
		variacionesEfectivo.getyAxisValues().add(lcsr);
		variacionesEfectivo.getyAxisValues().add(lcr);
		variacionesEfectivo.getyAxisValues().add(lcir);
		
		mda.setAutorizedBalance(data.get(data.size() - 1 ).getSaldoAutorizado());
		mda.setCurrentBalance(data.get(data.size() - 1 ).getSaldo());
		mda.setInsuredAmount(data.get(data.size() - 1 ).getSeguroMax());		
		mda.setLazyAmount(data.get(data.size() - 1 ).getOcioso());
		mda.setReorderPoint(data.get(data.size() -1 ).getPuntoReorden());
		mda.setUtilizationRate(10);
		
//		variacionesEfectivo.
		
		mda.getCashBehaviorDetail().add(new Item("Menudo",data.get(data.size()-1).getMenudo(),data.get(data.size()-2).getMenudo()));
		mda.getCashBehaviorDetail().add(new Item("Reserva",data.get(data.size()-1).getReserva(),data.get(data.size()-2).getReserva()));
		mda.getCashBehaviorDetail().add(new Item("LCSX",data.get(data.size()-1).getLcsx(),data.get(data.size()-2).getLcsx()));
		mda.getCashBehaviorDetail().add(new Item("Lcx",data.get(data.size()-1).getLcx(),data.get(data.size()-2).getLcx()));
		mda.getCashBehaviorDetail().add(new Item("Lcix",data.get(data.size()-1).getLcix(),data.get(data.size()-2).getLcix()));
		
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 100000)));
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 100000)));
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 100000)));
		mda.getCurrentBalanceHistory().add(new Item("7:05", new BigDecimal(Math.random() * 1000),new BigDecimal(Math.random() * 100000)));
		
		String stDate = String.valueOf(new java.util.Date().getTime());
		System.err.println(stDate);
		variacionesEfectivo.getxAxisValues().add(String.valueOf(Calendar.getInstance().getTime().getTime()));
		comportamientoEfectivo.getxAxisValues().add(String.valueOf(Calendar.getInstance().getTime().getTime()));
		
		
		
		
mda.setVarEfectivoGraph(variacionesEfectivo);
mda.setCompEfectivoGraph( comportamientoEfectivo);
	
		return mda;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPivotTable", method = RequestMethod.GET, produces = "application/json")
	public List<Pivot> getPivotTable() {
		List<Pivot>  pivot =  iPivotService.findAll();
		logger.debug("getPivotTable.");
		return pivot;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMonedas", method = RequestMethod.GET, produces = "application/json")
	public List<Moneda> getMonedas() {
		List<Moneda>  moneda =  iMonedaService.findAll();
		logger.debug("getMonedas.");
		if (moneda.isEmpty())
			return Collections.emptyList();
		else
		return moneda;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getTransacciones", method = RequestMethod.GET, produces = "application/json")
	public List<Transaccion> getTransacciones() {
		List<Transaccion>  transaccion =  iTransaccionService.findAllTransacciones();
		logger.debug("getTransacciones.");
		if (transaccion.isEmpty())
			return Collections.emptyList();
		else
		return transaccion;
	}

	@PostConstruct
	public void init(){
//		List<GraphicItem> compEfectList = new ArrayList<GraphicItem>();		
//		compEfectList.add(new GraphicItem("Menudo", "area"));
//		compEfectList.add(new GraphicItem("Reserva", "area"));
//		compEfectList.add(new GraphicItem("Prestamos", "area"));
//		compEfectList.add(new GraphicItem("LCSx", "line"));
//		compEfectList.add(new GraphicItem("LCx", "line"));
//		comportamientoEfectivo.setyAxisValues(compEfectList);
		
		
//		List<GraphicItem> varEfectList = new ArrayList<GraphicItem>();		
//		varEfectList.add(new GraphicItem("Menudo2", "area"));
//		varEfectList.add(new GraphicItem("Reserva2", "area"));
//		varEfectList.add(new GraphicItem("Prestamos2", "area"));
//		varEfectList.add(new GraphicItem("LCSx2", "line"));
//		varEfectList.add(new GraphicItem("LCx2", "line"));
//		variacionesEfectivo.setyAxisValues(varEfectList);
		
	}
}