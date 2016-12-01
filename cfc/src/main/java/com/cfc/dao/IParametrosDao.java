package com.cfc.dao;

import java.util.List;

import com.cfc.model.Parametros;

/**
 * Defines the basic operations the system will perform on the Parameters table
 * 
 * @author Admind
 *
 */
public interface IParametrosDao {

	void save(Parametros param);

	void deleteById(int id);

	List<Parametros> findAllParametros();

	Parametros findById(int id);

	Parametros findParametroByName(String name);

}