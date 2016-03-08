/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */
@Repository("saldoDao")
public class SaldoDaoImpl extends AbstractDao<Integer, Saldo> implements ISaldoDao {
	@Override
	public Saldo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Saldo saldo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Saldo> findAllSaldos() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		List<Saldo> saldos = (List<Saldo>) criteria.list();
		
		return saldos;
	}
/*	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		
		return users;
	}*/
}
