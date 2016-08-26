/**
 * 
 */
package com.cfc.service;

import java.util.List;

import com.cfc.model.Transaccion;

/**
 * @author JIO
 *
 */
public interface ITransaccionService {
	Transaccion findById(int id);

	void saveTransaccion(Transaccion transaccion);

	void updateTransaccion(Transaccion transaccion);

	List<Transaccion> findAllTransacciones();

	List<Transaccion> findByCurrencyAndBranch(int currencyId, int branchId);
}
