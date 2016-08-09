package com.cfc.controller;

import java.math.BigDecimal;
import java.util.Calendar;
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
import com.cfc.domain.GraphicItem;
import com.cfc.domain.Item;
import com.cfc.domain.MainData;
import com.cfc.model.Moneda;
import com.cfc.model.Pivot;
import com.cfc.model.Sucursal;
import com.cfc.model.Transaccion;
import com.cfc.service.IMonedaService;
import com.cfc.service.IPivotService;
import com.cfc.service.ISucursalService;
import com.cfc.service.ITransaccionService;

@RestController
@RequestMapping("/efectivo")
public class CFCSpringController {
	final static Logger logger = Logger.getLogger(CFCSpringController.class);
	private GraphData comportamientoEfectivo = new GraphData();
	private GraphData variacionesEfectivo = new GraphData();
	private MainData mda = new MainData();
	private int maxId = 0;
	@Autowired
	ISucursalService iSucursalService;
	@Autowired
	IPivotService iPivotService;
	@Autowired
	IMonedaService iMonedaService;
	@Autowired
	ITransaccionService iTransaccionService;

	@ResponseBody
	@RequestMapping(value = "/getSucursales", method = RequestMethod.GET, produces = "application/json")
	public List<Sucursal> getSucursales() {
		List<Sucursal> sucursales = iSucursalService.findAllSucursales();
		logger.debug("getSucursales.");
		if (sucursales.isEmpty())
			return Collections.emptyList();
		else{
			Sucursal all = new Sucursal();
			all.setCodigoAgencia(new BigDecimal(-1));
			all.setIdSucursal(-1);
			all.setNomAgencia("TODAS");
			sucursales.add(0,all);
			return sucursales;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getGraphData/{branch}/{currency}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MainData getGraphData(@PathVariable String branch, @PathVariable String currency) {
		// variacionesEfectivo = new GraphData();
		// comportamientoEfectivo = new GraphDatCa();
		//
		System.err.println("currency: " + currency);
		System.err.println("Branch: " + branch);

		List<Pivot> data = iPivotService.findByMaxID(++maxId, 1150, 1);
		if (maxId > 125)
			return mda;
		variacionesEfectivo.getyAxisValues().clear();
		comportamientoEfectivo.getyAxisValues().clear();
		mda = new MainData();

		// Data for the first graph
		GraphicItem ocioso = new GraphicItem("Ocioso", "area");
		GraphicItem rm = new GraphicItem("rm", "area");
		GraphicItem menudo = new GraphicItem("Menudo", "area");
		GraphicItem reserva = new GraphicItem("Reserva", "area");
		GraphicItem seguro = new GraphicItem("Seguro max", "line");
		GraphicItem saldoAutorizado = new GraphicItem("Saldo Autorizado", "line");
		GraphicItem lcix = new GraphicItem("Lcix", "line");
		GraphicItem lcx = new GraphicItem("Lcx", "line");
		GraphicItem lcsx = new GraphicItem("Lcsx", "line");
		GraphicItem ptoReorden = new GraphicItem("Punto reorden", "line");

		// Data 2nd graph
		GraphicItem lcir = new GraphicItem("Lcir", "line");
		GraphicItem lcr = new GraphicItem("Lcr", "line");
		GraphicItem lcsr = new GraphicItem("Lcsr", "line");
		GraphicItem varianza = new GraphicItem("Varianza", "area");

		for (Pivot pivot : data) {
			// Graph. 1
			ocioso.getItemValues().add(pivot.getOcioso().toPlainString());
			rm.getItemValues().add(pivot.getLcix().toPlainString());
			menudo.getItemValues().add(pivot.getMenudo().toPlainString());
			reserva.getItemValues().add(pivot.getReserva().toPlainString());
			seguro.getItemValues().add(pivot.getSeguroMax().toPlainString());
			saldoAutorizado.getItemValues().add(pivot.getSaldoAutorizado().toPlainString());
			lcix.getItemValues().add(pivot.getLcix().toPlainString());
			lcx.getItemValues().add(pivot.getLcx().toPlainString());
			lcsx.getItemValues().add(pivot.getLcsx().toPlainString());
			ptoReorden.getItemValues().add(pivot.getPuntoReorden().toPlainString());

			// Graph. 2
			varianza.getItemValues().add(pivot.getReserva().toPlainString());
			lcsr.getItemValues().add(pivot.getLcsr().toPlainString());
			lcr.getItemValues().add(pivot.getLcr().toPlainString());
			lcir.getItemValues().add(pivot.getLcir().toPlainString());
		}

		comportamientoEfectivo.getyAxisValues().add(ocioso);
		comportamientoEfectivo.getyAxisValues().add(rm);
		comportamientoEfectivo.getyAxisValues().add(menudo);
		comportamientoEfectivo.getyAxisValues().add(reserva);
		comportamientoEfectivo.getyAxisValues().add(seguro);
		comportamientoEfectivo.getyAxisValues().add(saldoAutorizado);
		comportamientoEfectivo.getyAxisValues().add(lcix);
		comportamientoEfectivo.getyAxisValues().add(lcx);
		comportamientoEfectivo.getyAxisValues().add(lcsx);
		comportamientoEfectivo.getyAxisValues().add(ptoReorden);

		variacionesEfectivo.getyAxisValues().add(varianza);
		variacionesEfectivo.getyAxisValues().add(lcsr);
		variacionesEfectivo.getyAxisValues().add(lcr);
		variacionesEfectivo.getyAxisValues().add(lcir);

		mda.setAutorizedBalance(data.get(data.size() - 1).getSaldoAutorizado());
		mda.setCurrentBalance(data.get(data.size() - 1).getSaldo());
		mda.setInsuredAmount(data.get(data.size() - 1).getSeguroMax());
		mda.setLazyAmount(data.get(data.size() - 1).getOcioso());
		mda.setReorderPoint(data.get(data.size() - 1).getPuntoReorden());
		mda.setUtilizationRate(10);

		// variacionesEfectivo.

		mda.getCashBehaviorDetail().add(new Item("Menudo", data.get(data.size() - 1).getMenudo(), data.get(data.size() - 2).getMenudo()));
		mda.getCashBehaviorDetail().add(new Item("Reserva", data.get(data.size() - 1).getReserva(), data.get(data.size() - 2).getReserva()));
		mda.getCashBehaviorDetail().add(new Item("LCSX", data.get(data.size() - 1).getLcsx(), data.get(data.size() - 2).getLcsx()));
		mda.getCashBehaviorDetail().add(new Item("Lcx", data.get(data.size() - 1).getLcx(), data.get(data.size() - 2).getLcx()));
		mda.getCashBehaviorDetail().add(new Item("Lcix", data.get(data.size() - 1).getLcix(), data.get(data.size() - 2).getLcix()));

		mda.getCashVariations().add(new Item("Varianza", data.get(data.size() - 1).getReserva(), data.get(data.size() - 2).getReserva()));
		mda.getCashVariations().add(new Item("LCSr", data.get(data.size() - 1).getLcsr(), data.get(data.size() - 2).getLcsr()));
		mda.getCashVariations().add(new Item("LCr", data.get(data.size() - 1).getLcr(), data.get(data.size() - 2).getLcr()));
		mda.getCashVariations().add(new Item("LClr", data.get(data.size() - 1).getLcir(), data.get(data.size() - 2).getLcir()));

		Pivot item;
		if (data.size() == 1) {
			item = data.get(0);
			mda.getCurrentBalanceHistory().add(new Item(item.getFecha().toString(), item.getSaldo(), BigDecimal.ZERO));
		}
		mda.getCurrentBalanceHistory().add(new Item("7:00", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));
		mda.getCurrentBalanceHistory().add(new Item("7:15", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));
		mda.getCurrentBalanceHistory().add(new Item("7:30", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));
		mda.getCurrentBalanceHistory().add(new Item("7:45", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));

		mda.getCashValHistory().add(new Item("7:00", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));
		mda.getCashValHistory().add(new Item("7:15", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));
		mda.getCashValHistory().add(new Item("7:30", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));
		mda.getCashValHistory().add(new Item("7:45", new BigDecimal(Math.random() * 1000), new BigDecimal(Math.random() * 100000)));

		String stDate = String.valueOf(new java.util.Date().getTime());
		System.err.println(stDate);
		variacionesEfectivo.getxAxisValues().add(String.valueOf(Calendar.getInstance().getTime().getTime()));
		comportamientoEfectivo.getxAxisValues().add(String.valueOf(Calendar.getInstance().getTime().getTime()));

		mda.setVarEfectivoGraph(variacionesEfectivo);
		mda.setCompEfectivoGraph(comportamientoEfectivo);

		return mda;
	}

	@ResponseBody
	@RequestMapping(value = "/getMonedas", method = RequestMethod.GET, produces = "application/json")
	public List<Moneda> getMonedas() {
		List<Moneda> moneda = iMonedaService.findAll();
		logger.debug("getMonedas.");
		if (moneda.isEmpty())
			return Collections.emptyList();
		else
			return moneda;
	}

	@ResponseBody
	@RequestMapping(value = "/getTransacciones/{branchId}/{currencyId}", method = RequestMethod.GET, produces = "application/json")
	public List<Transaccion> getTransacciones(@PathVariable int branchId, @PathVariable int currencyId) {
		List<Transaccion> transaccion = iTransaccionService.findAllTransacciones();
		logger.debug("getTransacciones.");
		if (transaccion.isEmpty())
			return Collections.emptyList();
		else
			return transaccion;
	}

	@ResponseBody
	@RequestMapping(value = "/getDetalles/{branchId}/{currencyId}", method = RequestMethod.GET, produces = "application/json")
	public List<Pivot> getDetalles(@PathVariable int branchId, @PathVariable int currencyId) {
		List<Pivot> detalle = iPivotService.getDetailsByBranchAndCurrency(branchId, currencyId);
		logger.debug("getDetalles.");
		if (detalle.isEmpty())
			return Collections.emptyList();
		else
			return detalle;
	}
}