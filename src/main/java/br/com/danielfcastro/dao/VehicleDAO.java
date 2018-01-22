package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Vehicle;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleDAO extends AbstractBaseRepository<Vehicle> implements IRepository<Vehicle> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Vehicle> query(String id) {
		TypedQuery<Vehicle> query = entityManager.createNamedQuery(id, Vehicle.class);
		return query.getResultList();
	}

}
