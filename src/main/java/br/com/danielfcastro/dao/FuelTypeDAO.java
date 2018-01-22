package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.FuelType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class FuelTypeDAO extends AbstractBaseRepository<FuelType> implements IRepository<FuelType> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<FuelType> query(String id) {
		TypedQuery<FuelType> query = entityManager.createNamedQuery(id, FuelType.class);
		return query.getResultList();
	}

}
