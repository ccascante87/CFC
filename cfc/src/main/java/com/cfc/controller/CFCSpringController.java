package com.cfc.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.domain.Message;
import com.cfc.model.Historico;
import com.cfc.model.Saldo;
import com.cfc.service.IHistoricoService;
import com.cfc.service.ISaldoService;

@RestController
@RequestMapping("/efectivo")
public class CFCSpringController {
	
	@Autowired
	ISaldoService iSaldoService;
	@Autowired
	IHistoricoService iHistoricoService;
	
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
		if (historicos.isEmpty())
			return Collections.emptyList();
		else
			return historicos;
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