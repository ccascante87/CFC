/**
 * 
 */
package com.cfc.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cfc.dao.AbstractDao;
import com.cfc.dao.IPivotDao;
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
	public List<Pivot> getByMaxId(int maxId, int brachId, int currencyId) {
		Query query = null;
		if (brachId > 0 && currencyId > 0)
			query = getSession().getNamedQuery("Pivot.findByMaxId").setInteger("maxId", maxId)
					.setBigDecimal("codAgencia", BigDecimal.valueOf(brachId))
					.setBigDecimal("codMoneda", BigDecimal.valueOf(currencyId));
		else if (brachId > 0 && currencyId <= 0)
			query = getSession().getNamedQuery("Pivot.findByMaxId").setInteger("maxId", maxId)
					.setBigDecimal("codAgencia", BigDecimal.valueOf(brachId))
					.setBigDecimal("codMoneda", BigDecimal.valueOf(currencyId));
		else if (brachId <= 0 && currencyId > 0)
			query = getSession().getNamedQuery("Pivot.findByMaxId").setInteger("maxId", maxId)
					.setBigDecimal("codAgencia", BigDecimal.valueOf(brachId))
					.setBigDecimal("codMoneda", BigDecimal.valueOf(currencyId));
		else
			query = getSession().getNamedQuery("Pivot.findByMaxId").setInteger("maxId", maxId)
					.setBigDecimal("codAgencia", BigDecimal.valueOf(brachId))
					.setBigDecimal("codMoneda", BigDecimal.valueOf(currencyId));
		return (List<Pivot>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pivot> getDetailsByBranchAndCurrency(int branchId, int currencyId) {
		List<Pivot> detalles;
		Query query = getSession().getNamedQuery("Pivot.findByMaxDateBranchAndCurrency")
				.setTimestamp("maxDate", Timestamp.valueOf(LocalDateTime.now() ))
				.setInteger("branchId", branchId)
				.setInteger("currId", currencyId);
		detalles = query.list();
		return detalles;
	}
}