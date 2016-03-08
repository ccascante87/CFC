/**
 * 
 */
package com.cfc.service;

import java.util.List;

import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */

public interface ISaldoService {
	Saldo findById(int id);
	
	void saveSaldo(Saldo saldo);
	
	void updateSaldo(Saldo saldo);

	List<Saldo> findAllSaldos(); 
}
