package com.cfc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cfc.model.Parametros;

/**
 * Implements the basic operations for the Parameters table, defined by the interface
 * @author Admind
 *
 */
@Repository(value="parametrosDao")
public class ParametrosDaoImpl extends AbstractDao<Integer, Parametros> implements IParametrosDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Parametros> findAll() {		
		return createEntityCriteria().list();
	}

	@Override
	public void save(Parametros param) {
		persist(param);
		
	}
}
