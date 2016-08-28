package com.cfc.service;

import java.util.List;

import com.cfc.model.Parametros;

/**
 * Defines the basic services that will be available for the parameters
 * 
 * @author Admind
 *
 */
public interface IParametersService {
	public List<Parametros> findAll();

	public void save(Parametros param);
}
