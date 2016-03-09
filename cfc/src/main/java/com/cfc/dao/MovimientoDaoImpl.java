/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cfc.model.Movimiento;

/**
 * @author JIO
 *
 */
@Repository("movimientoDao")
public class MovimientoDaoImpl extends AbstractDao<Integer, Movimiento> implements IMovimientoDao {

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMovimientoDao#findById(int)
	 */
	@Override
	public Movimiento findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMovimientoDao#save(com.cfc.model.Movimiento)
	 */
	@Override
	public void save(Movimiento movimiento) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMovimientoDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMovimientoDao#findAllMovimientos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Movimiento> findAllMovimientos() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		List<Movimiento> movimientos = (List<Movimiento>) criteria.list();
		
		return movimientos;
	}

}
