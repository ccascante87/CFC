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
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cfc.dao.AbstractDao;
import com.cfc.dao.ISucursalDao;
import com.cfc.model.Sucursal;

/**
 * @author JIO
 *
 */
@Repository("sucursalDao")
public class SucursalDaoImpl extends AbstractDao<Integer, Sucursal> implements ISucursalDao {

	private Session currentSession;
	private Transaction currentTransaction;
	private static final Logger logger = LoggerFactory.getLogger(SucursalDaoImpl.class);

	public SucursalDaoImpl() {

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
	/* (non-Javadoc)
	 * @see com.cfc.dao.ISucursalDao#findById(int)
	 */
	@Override
	public Sucursal findById(int id) {
		Session session = getCurrentSession();
		Sucursal sucursal = (Sucursal) session.load(Sucursal.class, new Integer(id));
		logger.info("Sucursal loaded successfully, Sucursal details="+sucursal);
		return sucursal;
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ISucursalDao#save(com.cfc.model.Sucursal)
	 */
	@Override
	public void save(Sucursal sucursal) {
		Session session = getCurrentSession();
		session.persist(sucursal);
		logger.info("Sucursal saved successfully, Sucursal Details="+ sucursal);
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ISucursalDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		Session session = getCurrentSession();
		Sucursal sucursal = (Sucursal) session.load(Sucursal.class, new Integer(id));
		if(null != sucursal){
			session.delete(sucursal);
		}
		logger.info("Sucursal deleted successfully, Sucursal details="+sucursal);

	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ISucursalDao#findAllSucursales()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sucursal> findAllSucursales() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		List<Sucursal> sucursales = (List<Sucursal>) criteria.list();
		
		return sucursales;
	}
	
	@Override
	public Sucursal findSucursalByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nomAgencia",name).ignoreCase());
		Sucursal sucursal = (Sucursal) criteria.uniqueResult();

		return sucursal;
	}
	
	public void update(Sucursal sucursal){
		Session session = getCurrentSession();
		session.update(sucursal);
		logger.info("Sucursal updated successfully, Sucursal Details="+ sucursal);
	}

}
