package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Telephone;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class TelephoneDAO extends AbstractBaseRepository<Telephone> implements IRepository<Telephone> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Telephone> query(String id) {
		TypedQuery<Telephone> query = entityManager.createNamedQuery(id, Telephone.class);
		return query.getResultList();
	}

}
