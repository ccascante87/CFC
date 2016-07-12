/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.domain.Detalle;
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
	
	List<Detalle> getDetalles();

	List<Pivot> getByMaxId(int maxId, int brachId, int currencyId);
}
