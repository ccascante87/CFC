/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Movimiento;
import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */
public interface ISaldoDao {
	
	Saldo findById(int id);

	void save(Saldo saldo);

	void deleteById(int id);

	List<Saldo> findAllSaldos();
	
	List<Saldo> findAllSaldosByCurrency(long currency);
}
