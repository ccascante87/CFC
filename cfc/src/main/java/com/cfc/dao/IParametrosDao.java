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

	List<Parametros> findAll();

	void save(Parametros param);

}
