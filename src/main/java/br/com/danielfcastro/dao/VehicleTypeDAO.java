package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.VehicleType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleTypeDAO extends AbstractBaseRepository<VehicleType> implements IRepository<VehicleType> {
	@Inject
	EntityManager entityManager;
	
	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}
	
	@Override
	public List<VehicleType> query(String id) {
		TypedQuery<VehicleType> query = entityManager.createNamedQuery(id, VehicleType.class);
		return query.getResultList();
	}


}
