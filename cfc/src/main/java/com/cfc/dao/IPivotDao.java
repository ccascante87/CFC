/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Pivot;

/**
 * @author JIO
 *
 */
public interface IPivotDao {
	
	Pivot findById(int id);

	void save(Pivot pivot);

	void deleteById(int id);

	List<Pivot> findAll();
	/**
	 * Get the details list (Pivot data) for the given branch and currency
	 * @param branchId Id of the selected branch, -1 to get all branches
	 * @param currencyId Id of the selected currency, -1 to get all currencies
	 * @return
	 */
	List<Pivot> getDetailsByBranchAndCurrency(int branchId, int currencyId);
	
	/**
	 * 
	 * @param maxId	
	 * @param brachId
	 * @param currencyId
	 * @return
 */
	List<Pivot> getByMaxId(int maxId, int brachId, int currencyId);
}
