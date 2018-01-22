package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.VehicleCategory;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleCategoryDAO extends AbstractBaseRepository<VehicleCategory>
		implements IRepository<VehicleCategory> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<VehicleCategory> query(String id) {
		TypedQuery<VehicleCategory> query = entityManager.createNamedQuery(id, VehicleCategory.class);
		return query.getResultList();
	}

}
