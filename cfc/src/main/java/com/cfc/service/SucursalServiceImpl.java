/**
 * 
 */
package com.cfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.ISucursalDao;
import com.cfc.model.Sucursal;

/**
 * @author JIO
 *
 */
@Service("iSucursalService")
@Transactional
public class SucursalServiceImpl implements ISucursalService {
	
	@Autowired
	ISucursalDao sucursalDAO;

	
	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#findById(int)
	 */
	@Override
	public Sucursal findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#saveSucursal(com.cfc.model.Sucursal)
	 */
	@Override
	public void saveSucursal(Sucursal sucursal) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#updateSucursal(com.cfc.model.Sucursal)
	 */
	@Override
	public void updateSucursal(Sucursal sucursal) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#findAllSucursales()
	 */
	@Override
	public List<Sucursal> findAllSucursales() {
		return sucursalDAO.findAllSucursales();
	}

}
