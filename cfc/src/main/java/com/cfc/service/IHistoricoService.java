/**
 * 
 */
package com.cfc.service;

import java.util.List;

import com.cfc.model.Historico;

/**
 * @author JIO
 *
 */
public interface IHistoricoService {

	Historico findById(int id);
	
	void saveHistorico(Historico historico);
	
	void updateHistorico(Historico historico);

	List<Historico> findAllHistoricos(); 
	
	List<Historico> findAllHistoricosByCurrency(long currency);

}
