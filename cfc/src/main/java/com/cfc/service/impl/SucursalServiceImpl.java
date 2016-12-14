/**
 * 
 */
package com.cfc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.ISucursalDao;
import com.cfc.model.Sucursal;
import com.cfc.service.ISucursalService;

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
		return sucursalDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#saveSucursal(com.cfc.model.Sucursal)
	 */
	@Override
	public void saveSucursal(Sucursal sucursal) {
		sucursalDAO.save(sucursal);
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#updateSucursal(com.cfc.model.Sucursal)
	 */
	@Override
	public void updateSucursal(Sucursal sucursal) {
		sucursalDAO.update(sucursal);
	}

	/* (non-Javadoc)
	 * @see com.cfc.service.ISucursalService#findAllSucursales()
	 */
	@Override
	public List<Sucursal> findAllSucursales() {
		return sucursalDAO.findAllSucursales();
	}

	public Sucursal findSucursalByName(String nameSucursal) {
		return sucursalDAO.findSucursalByName(nameSucursal);
	}

	@Override
	public List<Sucursal> deleteSucucursal(long sucursalId) {
		sucursalDAO.deleteById(sucursalId);
		return sucursalDAO.findAllSucursales();
	}

}
