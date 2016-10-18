/**
 * 
 */
package com.cfc.service;

import java.util.List;

import com.cfc.model.Moneda;

/**
 * @author JIO
 *
 */
public interface IMonedaService {
   
	Moneda findById(int id);
	
	void saveMoneda(Moneda moneda);
	
	void updateMoneda(Moneda moneda);

	List<Moneda> findAll();
	
	void delete(int idMoneda);

}
