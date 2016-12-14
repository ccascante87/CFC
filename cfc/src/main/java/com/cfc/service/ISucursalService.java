/**
 * 
 */
package com.cfc.service;

import java.util.List;
import com.cfc.model.Sucursal;

/**
 * @author JIO
 *
 */
public interface ISucursalService {
    Sucursal findById(int id);
	
	void saveSucursal(Sucursal sucursal);
	
	void updateSucursal(Sucursal sucursal);

	List<Sucursal> findAllSucursales(); 
	
	Sucursal findSucursalByName(String nameSucursal);
	
	List<Sucursal> deleteSucucursal(long sucursalId);
}
