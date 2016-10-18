package com.cfc.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.cfc.model.Moneda;
import com.cfc.service.IMonedaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyRestController {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private IMonedaService iMoneda;

	@ResponseBody
	@RequestMapping(value = "/getMonedas", method = RequestMethod.GET, produces = "application/json")
	public List<Moneda> getMonedas() {
		List<Moneda> moneda = iMoneda.findAll();
		logger.debug("getMonedas.");
		if (moneda.isEmpty())
			return Collections.emptyList();
		else
			return moneda;
	}

	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Moneda> saveOrUpdate(@RequestBody String currency) {
		logger.debug("saveOrUpdate");
		List<Moneda> currencies = iMoneda.findAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			Moneda temp = mapper.readValue(currency, Moneda.class);
			if(temp.getId() <= 0){
				iMoneda.saveMoneda(temp);
			}else{
				iMoneda.updateMoneda(temp);
			}
			currencies = iMoneda.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currencies.isEmpty())
			return Collections.emptyList();
		else
			return currencies;
	}

	@ResponseBody
	@RequestMapping(value ="/delete", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Moneda> deleteCurrency(@RequestBody String currencyId) {
		logger.debug("saveOrUpdate");
		List<Moneda> currencies = new ArrayList<>();

		iMoneda.delete(Integer.parseInt(currencyId));
		currencies = iMoneda.findAll();
		if (currencies.isEmpty())
			return Collections.emptyList();
		else
			return currencies;
	}

}
