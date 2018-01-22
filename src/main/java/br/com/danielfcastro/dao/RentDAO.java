package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Rent;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class RentDAO extends AbstractBaseRepository<Rent> implements IRepository<Rent> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Rent> query(String id) {
		TypedQuery<Rent> query = entityManager.createNamedQuery(id, Rent.class);
		return query.getResultList();
	}

}
