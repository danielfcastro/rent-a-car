package br.com.danielfcastro.repository.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.danielfcastro.model.Country;
import br.com.danielfcastro.repository.IRepository;


@Named("CountrRepository")
@RequestScoped
public class CountryRepositoryImpl implements IRepository<Country> {

	@PersistenceContext(unitName = "CountrRepository")
	private EntityManager entityManager;

	public CountryRepositoryImpl() {
		super();
	}
	
	public CountryRepositoryImpl(EntityManager manager) {
		this.entityManager = manager;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void add(Country item) {
		entityManager.persist(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void update(Country item) {
		entityManager.merge(item);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(Country item) {
		entityManager.remove(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id) {
		Country toBeDelete = entityManager.find(Country.class, id);
		entityManager.remove(toBeDelete);
	}

	public List<Country> query(String id) {
		TypedQuery<Country> query = null;
		if (null != id) {
			query = entityManager.createNamedQuery("Country.findById", Country.class);
			query.setParameter("id", id);
		} else {
			query = entityManager.createNamedQuery("Country.findAll", Country.class);
		}
		List<Country> results = query.getResultList();
		return results;
	}

}
