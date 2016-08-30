/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Moneda;

/**
 * @author JIO
 *
 */
public interface IMonedaDao {
	Moneda findById(int id);

	void save(Moneda moneda);
	
	void update(Moneda moneda);

	void deleteById(int id);

	List<Moneda> findAll();
}
