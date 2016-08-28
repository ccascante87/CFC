package com.cfc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfc.dao.IParametrosDao;
import com.cfc.model.Parametros;
import com.cfc.service.IParametersService;
/**
 * Implements the Parameters methods, defined by the interface;
 * @author Admind
 *
 */
@Service
@Transactional
public class ParametersServiceImpl implements IParametersService{

	@Autowired
	private IParametrosDao iParamsDao;
	
	@Override
	public List<Parametros> findAll() {
		return iParamsDao.findAll();
	}

	@Override
	public void save(Parametros param) {
		iParamsDao.save(param);
	}

}
