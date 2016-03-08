/**
 * 
 */
package com.cfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.ISaldoDao;
import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */

@Service("iSaldoService")
@Transactional
public class SaldoServiceImpl implements ISaldoService {
	
	@Autowired
	ISaldoDao dao;

	@Override
	public Saldo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSaldo(Saldo saldo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSaldo(Saldo saldo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Saldo> findAllSaldos() {
		return dao.findAllSaldos();
	}

}
