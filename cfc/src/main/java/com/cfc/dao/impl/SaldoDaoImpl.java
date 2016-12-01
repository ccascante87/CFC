/**
 * 
 */
package com.cfc.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cfc.dao.AbstractDao;
import com.cfc.dao.ISaldoDao;
import com.cfc.model.Saldo;

/**
 * @author JIO
 *
 */
@Repository("saldoDao")
public class SaldoDaoImpl extends AbstractDao<Integer, Saldo> implements ISaldoDao {
	private Session currentSession;
	private Transaction currentTransaction;
	private static final Logger logger = Logger.getLogger(SaldoDaoImpl.class.getName());
	
	public SaldoDaoImpl() {

	  }

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public Saldo findById(int id) {
		Session session = getCurrentSession();
		Saldo saldo = (Saldo) session.load(Saldo.class, new Integer(id));
		logger.info("Saldo loaded successfully, Saldo details="+saldo);
		return saldo;
	}

	@Override
	public void save(Saldo saldo) {
		Session session = getCurrentSession();
		session.persist(saldo);
		logger.info("Saldo saved successfully, Saldo Details="+ saldo);

	}

	@Override
	public void deleteById(int id) {
		Session session = getCurrentSession();
		Saldo saldo = (Saldo) session.load(Saldo.class, new Integer(id));
		if(null != saldo){
			session.delete(saldo);
		}
		logger.info("Saldo deleted successfully, Saldo details="+saldo);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Saldo> findAllSaldos() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<Saldo> saldos = (List<Saldo>) criteria.list();

		return saldos;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Saldo> findAllSaldosByCurrency(String currency) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("codigoMoneda", currency));
		List<Saldo> saldos = (List<Saldo>) criteria.list();

		return saldos;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	// @Transactional
	public List getManejoDataColones(String currency, String codigoUsuario, String codigo) {
		List saldos;
		Session session = getSession();
		try {
			// session = getSession();
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
			// session.getTransaction().rollback();
			throw e;
		}
		// session.close();
		return saldos;
	}
	/*
	 * @SuppressWarnings("unchecked") public List<User> findAllUsers() {
	 * Criteria criteria =
	 * createEntityCriteria().addOrder(Order.asc("firstName"));
	 * criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid
	 * duplicates. List<User> users = (List<User>) criteria.list();
	 * 
	 * return users; }
	 */
}
