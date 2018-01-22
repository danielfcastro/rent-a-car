package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.TelephoneType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class TelephoneTypeDAO extends AbstractBaseRepository<TelephoneType> implements IRepository<TelephoneType> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<TelephoneType> query(String id) {
		TypedQuery<TelephoneType> query = entityManager.createNamedQuery(id, TelephoneType.class);
		return query.getResultList();
	}

}
