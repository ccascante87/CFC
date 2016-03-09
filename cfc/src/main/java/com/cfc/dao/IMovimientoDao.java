/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Movimiento;

/**
 * @author JIO
 *
 */
public interface IMovimientoDao {
	Movimiento findById(int id);

	void save(Movimiento movimiento);

	void deleteById(int id);

	List<Movimiento> findAllMovimientos();
}
