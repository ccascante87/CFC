/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import com.cfc.model.Historico;

/**
 * @author JIO
 *
 */
public interface IHistoricoDao {
	
	Historico findById(int id);

	void save(Historico historico);

	void deleteById(int id);

	List<Historico> findAllHistorico();

}
