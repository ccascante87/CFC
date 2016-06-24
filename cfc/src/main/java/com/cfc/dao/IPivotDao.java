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
	
}
