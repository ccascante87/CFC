/**
 * 
 */
package com.cfc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.IMonedaDao;
import com.cfc.model.Moneda;
import com.cfc.service.IMonedaService;

/**
 * @author JIO
 *
 */
@Service("iMonedaService")
@Transactional
public class MonedaServiceImpl implements IMonedaService {

	/* (non-Javadoc)
	 * @see com.cfc.service.IMonedaService#findById(int)
	 */
	
	@Autowired
	IMonedaDao monedaDao;
	
	@Override
	public Moneda findById(int id) {
		return monedaDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.IMonedaService#saveMoneda(com.cfc.model.Moneda)
	 */
	@Override
	public void saveMoneda(Moneda moneda) {
		monedaDao.save(moneda);
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.IMonedaService#updateMoneda(com.cfc.model.Moneda)
	 */
	@Override
	public void updateMoneda(Moneda moneda) {
		monedaDao.update(moneda);
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.IMonedaService#findAll()
	 */
	@Override
	public List<Moneda> findAll() {
		return monedaDao.findAll();
	}

}
