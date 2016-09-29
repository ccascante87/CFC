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
import com.cfc.dao.IParametrosDao;
import com.cfc.model.Parametros;

/**
 * Implements the basic operations for the Parameters table, defined by the
 * interface
 * 
 * @author Admind
 *
 */
@Repository(value = "parametrosDao")
public class ParametrosDaoImpl extends AbstractDao<Integer, Parametros> implements IParametrosDao {

	private Session currentSession;
	private Transaction currentTransaction;
	private static final Logger logger = LoggerFactory.getLogger(ParametrosDaoImpl.class);

	public ParametrosDaoImpl() {

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
	public Parametros findById(int id) {
		Session session = getCurrentSession();
		Parametros parametro = (Parametros) session.load(Parametros.class, new Integer(id));
		logger.info("Parametros loaded successfully, Parametros details="+parametro);
		return parametro;
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ISucursalDao#save(com.cfc.model.Sucursal)
	 */
	@Override
	public void save(Parametros parametro) {
		Session session = getCurrentSession();
		session.persist(parametro);
		logger.info("Parametros saved successfully, Parametros Details="+ parametro);
	}

	/* (non-Javadoc)
	 * @see com.cfc.dao.ISucursalDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		Session session = getCurrentSession();
		Parametros parametro = (Parametros) session.load(Parametros.class, new Integer(id));
		if(null != parametro){
			session.delete(parametro);
		}
		logger.info("Parametros deleted successfully, Parametros details="+parametro);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parametros> findAllParametros() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		
		List<Parametros> parametros = (List<Parametros>) criteria.list();
		
		return parametros;
	}
	
	@Override
	public Parametros findParametroByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("paramKey",name).ignoreCase());
		Parametros parametro = (Parametros) criteria.uniqueResult();

		return parametro;
	}
	
	public void update(Parametros parametro){
		Session session = getCurrentSession();
		session.update(parametro);
		logger.info("Parametros updated successfully, Parametros Details="+ parametro);
	}

	@Override
	public List<Parametros> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
