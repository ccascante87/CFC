/**
 * 
 */
package com.cfc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.IPivotDao;
import com.cfc.model.Pivot;
import com.cfc.service.IPivotService;

/**
 * @author JIO
 *
 */
@Service("iPivotService")
@Transactional
public class PivotServiceImpl implements IPivotService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.service.IPivotService#findById(int)
	 */
	@Autowired
	IPivotDao pivotDao;

	@Override
	public Pivot findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.service.IPivotService#savePivot(com.cfc.model.Pivot)
	 */
	@Override
	public void savePivot(Pivot pivot) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.service.IPivotService#updatePivot(com.cfc.model.Pivot)
	 */
	@Override
	public void updatePivot(Pivot pivot) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.service.IPivotService#findAll()
	 */
	@Override
	public List<Pivot> findAll() {
		return pivotDao.findAll();
	}

	@Override
	public List<Pivot> findByMaxID(int maxId, int brachId, int currencyId) {
		return pivotDao.getByMaxId(maxId, brachId, currencyId);
	}
	
	@Override
	public List<Pivot> getDetailsByBranchAndCurrency(int branchId, int currencyId){
		return pivotDao.getDetailsByBranchAndCurrency(branchId, currencyId);
	}
}
