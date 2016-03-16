/**
 * 
 */
package com.cfc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cfc.model.Historico;
import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */
@Repository("historicoDao")
public class HistoricoDaoImpl extends AbstractDao<Integer, Historico> implements IHistoricoDao {

	@Override
	public Historico findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Historico historico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Historico> findAllHistorico() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		List<Historico> historicos = (List<Historico>) criteria.list();
		
		return historicos;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Historico> findAllHistoricosByCurrency(long currency) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("codigoMoneda",BigDecimal.valueOf(currency)));
		List<Historico> historicos = (List<Historico>) criteria.list();

		return historicos;
	}
}
