package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.VehicleAccessory;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleAccessoryDAO extends AbstractBaseRepository<VehicleAccessory>
		implements IRepository<VehicleAccessory> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<VehicleAccessory> query(String id) {
		TypedQuery<VehicleAccessory> query = entityManager.createNamedQuery(id, VehicleAccessory.class);
		return query.getResultList();
	}

}
