/**
 * 
 */
package com.cfc.service;

import java.util.List;

import com.cfc.model.Movimiento;

/**
 * @author JIO
 *
 */
public interface IMovimientoService {
    Movimiento findById(int id);
	
	void saveMovimiento(Movimiento movimiento);
	
	void updateMovimiento(Movimiento movimiento);

	List<Movimiento> findAllMovimientos(); 
}
