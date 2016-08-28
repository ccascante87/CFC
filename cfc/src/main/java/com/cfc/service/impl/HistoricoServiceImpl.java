/**
 * 
 */
package com.cfc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfc.dao.IHistoricoDao;
import com.cfc.model.Historico;
import com.cfc.service.IHistoricoService;

/**
 * @author JIO
 *
 */
@Service("iHistoricoService")
@Transactional
public class HistoricoServiceImpl implements IHistoricoService{
	@Autowired
	IHistoricoDao historicoDAO;
	
	@Override
	public Historico findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveHistorico(Historico historico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Historico historico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Historico> findAllHistoricos() {
		return historicoDAO.findAllHistorico();
	}

	@Override
	public List<Historico> findAllHistoricosByCurrency(String currency) {
		return historicoDAO.findAllHistoricosByCurrency(currency);
	}

}
