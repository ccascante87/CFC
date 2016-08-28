/**
 * 
 */
package com.cfc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cfc.dao.AbstractDao;
import com.cfc.dao.IMonedaDao;
import com.cfc.model.Moneda;

/**
 * @author JIO
 *
 */
@Repository("monedaDao")
public class MonedaDaoImpl extends AbstractDao<Integer, Moneda> implements IMonedaDao {

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#findById(int)
	 */
	@Override
	public Moneda findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#save(com.cfc.model.Moneda)
	 */
	@Override
	public void save(Moneda moneda) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#findAll()
	 */
	@Override
	public List<Moneda> findAll() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		@SuppressWarnings("unchecked")
		List<Moneda> moneda = (List<Moneda>) criteria.list();
		
		return moneda;
	}

}
