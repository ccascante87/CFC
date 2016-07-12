/**
 * 
 */
package com.cfc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cfc.domain.Detalle;
import com.cfc.model.Pivot;

/**
 * @author JIO
 *
 */
@Repository("pivotDao")
public class PivotDaoImpl extends AbstractDao<Integer, Pivot> implements IPivotDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.dao.IPivotDao#findById(int)
	 */
	@Override
	public Pivot findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.dao.IPivotDao#save(com.cfc.model.Pivot)
	 */
	@Override
	public void save(Pivot pivot) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.dao.IPivotDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cfc.dao.IPivotDao#findAll()
	 */
	@Override
	public List<Pivot> findAll() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		@SuppressWarnings("unchecked")
		List<Pivot> pivot = (List<Pivot>) criteria.list();

		return pivot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pivot> getByMaxId(int maxId,int brachId, int currencyId) {
		Query query = getSession().getNamedQuery("Pivot.findByMaxId").setInteger("maxId", maxId).
				setBigDecimal("codAgencia", BigDecimal.valueOf(brachId)).
				setBigDecimal("codMoneda", BigDecimal.valueOf(currencyId));
		return  (List<Pivot>) query.list();
		
		
		
		
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	//@Transactional
	public List<Detalle> getDetalles() {
		List<Detalle> detalles;
		Session session = getSession();
		try {
			//session = getSession();
			@SuppressWarnings("unused")
			Criteria criteria = createEntityCriteria();
			session.getTransaction().begin();
			Query query = (Query) session
					.createQuery("Select P " +
							" FROM  Pivot P ") ;
			detalles = query.list();
			// saldos.add(criteria);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			//session.getTransaction().rollback();
			throw e;
		}
		// session.close();
		return detalles;
	}
}
