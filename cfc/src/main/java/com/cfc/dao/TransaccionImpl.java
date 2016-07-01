/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cfc.model.Transaccion;

/**
 * @author JIO
 *
 */
@Repository("transaccionDao")
public class TransaccionImpl extends AbstractDao<Integer, Transaccion> implements ITransaccionDao {
	

	/* (non-Javadoc)
	 * @see com.cfc.dao.ITransaccionDao#findById(int)
	 */
	@Override
	public Transaccion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ITransaccionDao#save(com.cfc.model.Transaccion)
	 */
	@Override
	public void save(Transaccion transaccion) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ITransaccionDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ITransaccionDao#findAllTransacciones()
	 */
	@Override
	public List<Transaccion> findAllTransacciones() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		@SuppressWarnings("unchecked")
		List<Transaccion> transaccion = (List<Transaccion>) criteria.list();
		
		return transaccion;
	}

}
