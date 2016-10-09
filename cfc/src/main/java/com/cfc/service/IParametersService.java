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
	List<Parametros> findAll();

	void save(Parametros param);

	void deleteById(int id);

	List<Parametros> findAllParametros();

	Parametros findById(int id);

	Parametros findParametroByName(String name);
}
