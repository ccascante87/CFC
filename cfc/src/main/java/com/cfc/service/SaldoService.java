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

public interface SaldoService {
	Saldo findById(int id);
	
	void saveSaldo(Saldo user);
	
	void updateSaldo(Saldo user);

	List<Saldo> findAllSaldos(); 
}
