/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Transaccion;

/**
 * @author JIO
 *
 */
public interface ITransaccionDao {
	Transaccion findById(int id);

	void save(Transaccion transaccion);

	void deleteById(int id);

	List<Transaccion> findAllTransacciones();
}
