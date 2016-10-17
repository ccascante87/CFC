package com.cfc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfc.dao.IParametrosDao;
import com.cfc.dao.ISaldoDao;
import com.cfc.model.Parametros;
import com.cfc.model.Saldo;
import com.cfc.service.IParametersService;
/**
 * Implements the Parameters methods, defined by the interface;
 * @author Admind
 *
 */
@Service("iParametrosService")
@Transactional
public class ParametersServiceImpl implements IParametersService{

	@Autowired
	private IParametrosDao iParamsDao;
	
	
	@Autowired
	IParametrosDao parametrosDAO;


	@Override
	public List<Parametros> findAll() {
		return parametrosDAO.findAllParametros();
	}


	@Override
	public void save(Parametros param) {
		parametrosDAO.save(param);
	}


	@Override
	public void deleteById(int id) {
		parametrosDAO.deleteById(id);
	}


	@Override
	public List<Parametros> findAllParametros() {
		return parametrosDAO.findAllParametros();
	}


	@Override
	public Parametros findById(int id) {
		return parametrosDAO.findById(id);
	}


	@Override
	public Parametros findParametroByName(String name) {
		return parametrosDAO.findParametroByName(name);
	}
	

}
