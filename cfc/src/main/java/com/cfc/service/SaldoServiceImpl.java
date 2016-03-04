/**
 * 
 */
package com.cfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.SaldoDao;
import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */

@Service("saldoService")
@Transactional
public class SaldoServiceImpl implements SaldoService {
	
	@Autowired
	SaldoDao dao;

	@Override
	public Saldo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSaldo(Saldo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSaldo(Saldo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Saldo> findAllSaldos() {
		return dao.findAllSaldos();
	}

}
