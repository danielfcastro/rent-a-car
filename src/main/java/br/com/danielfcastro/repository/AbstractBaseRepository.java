package br.com.danielfcastro.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


public abstract class AbstractBaseRepository<T> implements IRepository<T> {

	protected EntityManager entityManager;
	protected Class persistentClass;
	public AbstractBaseRepository() {
		super();
	}
	
	public AbstractBaseRepository(EntityManager manager) {
		this.entityManager = manager;
		this.persistentClass = (Class<T>) ((ParameterizedType) 
			      getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void save(T element) {
		entityManager.persist(element);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void update(T element) {
		entityManager.merge(element);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(T element) {
		entityManager.remove(element);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id) {
		T toBeDelete = (T) entityManager.find((Class<T>) ((ParameterizedType) 
			      getClass().getGenericSuperclass()).getActualTypeArguments()[0], id);
		entityManager.remove(toBeDelete);
	}

	public abstract List<T> query(String id);
}
