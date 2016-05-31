/**
 * 
 */
package com.cfc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Saldo> findAllSaldosByCurrency(String currency) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("codigoMoneda",currency));
		List<Saldo> saldos = (List<Saldo>) criteria.list();

		return saldos;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	//@Transactional
	public List getManejoDataColones(String currency, String codigoUsuario, String codigo) {
		List saldos;
		Session session = getSession();
		try {
			//session = getSession();
			@SuppressWarnings("unused")
			Criteria criteria = createEntityCriteria();
			session.getTransaction().begin();
			Query query = (Query) session
					.createQuery("Select S " + " FROM  Saldo S, Historico h , Movimiento m ,Sucursal ss " + " WHERE "
							+ "	h.codigoAgencia = S.codigoAgencia" + "	AND m.codigoAgencia = h.codigoAgencia"
							+ "	AND ss.codigoAgencia = m.codigoAgencia" + " AND S.codigoUsuario= 1 "
							+ " AND S.codigoMoneda = 'COLONES' " + " AND S.codigoAgencia =4");
			saldos = query.list();
			// saldos.add(criteria);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			//session.getTransaction().rollback();
			throw e;
		}
		// session.close();
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
