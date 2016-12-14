/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Sucursal;

/**
 * @author JIO
 *
 */
public interface ISucursalDao {
	
	Sucursal findById(int id);

	void save(Sucursal sucursal);
	
	void update(Sucursal sucursal);

	void deleteById(long id);

	List<Sucursal> findAllSucursales();
	
	Sucursal findSucursalByName(String name);
}
