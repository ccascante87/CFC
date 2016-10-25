/**
 * 
 */
package com.cfc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	private Session currentSession;
	private Transaction currentTransaction;
	private static final Logger logger = LoggerFactory.getLogger(MonedaDaoImpl.class);

	public MonedaDaoImpl() {

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

	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
	    return sessionFactory.getCurrentSession();
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

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#findById(int)
	 */
	@Override
	public Moneda findById(int id) {
		Session session = getSession();
		Moneda moneda = (Moneda) session.load(Moneda.class, new Integer(id));
		logger.info("Moneda loaded successfully, Moneda details="+moneda);
		return moneda;
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#save(com.cfc.model.Moneda)
	 */
	@Override
	public void save(Moneda moneda) {
		Session session = getSession();
		session.persist(moneda);
		logger.info("Moneda saved successfully, Moneda Details="+ moneda);
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.IMonedaDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		Session session = getSession();
		Moneda moneda = (Moneda) session.load(Moneda.class, new Integer(id));
		if(null != moneda){
			session.delete(moneda);
		}
		logger.info("Moneda deleted successfully, Moneda details="+moneda);

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

	@Override
	public void update(Moneda moneda) {
		Session session = getSession();
		session.update(moneda);
		logger.info("Moneda updated successfully, Moneda Details="+ moneda);
		
	}
}
