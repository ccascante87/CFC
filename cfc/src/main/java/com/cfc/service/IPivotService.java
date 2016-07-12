/**
 * 
 */
package com.cfc.service;

import java.util.List;

import com.cfc.model.Pivot;

/**
 * @author JIO
 *
 */
public interface IPivotService {
	
	Pivot findById(int id);
	
	void savePivot(Pivot pivot);
	
	void updatePivot(Pivot pivot);

	List<Pivot> findAll(); 

	List<Pivot> findByMaxID(int maxId,int brachId, int currencyId);
}
