/**
 * 
 */
package com.cfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.IMovimientoDao;
import com.cfc.model.Movimiento;

/**
 * @author JIO
 *
 */
@Service("iMovimientoService")
@Transactional
public class MovimientoServiceImpl implements IMovimientoService {

	@Autowired
	IMovimientoDao movimientoDAO;
	
	/* (non-Javadoc)
	 * @see com.cfc.service.IMovimientoService#findById(int)
	 */
	@Override
	public Movimiento findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.IMovimientoService#saveMovimiento(com.cfc.model.Movimiento)
	 */
	@Override
	public void saveMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.service.IMovimientoService#updateMovimiento(com.cfc.model.Movimiento)
	 */
	@Override
	public void updateMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.service.IMovimientoService#findAllMovimientos()
	 */
	@Override
	public List<Movimiento> findAllMovimientos() {
		return movimientoDAO.findAllMovimientos();
	}

}
