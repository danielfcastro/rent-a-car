package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.AddressType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class AddressTypeDAO extends AbstractBaseRepository<AddressType> implements IRepository<AddressType> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
		super.persistentClass = AddressType.class;
	}
	
	@Override
	public List<AddressType> query(String id) {
		TypedQuery<AddressType> query = entityManager.createNamedQuery(id, AddressType.class);
		return query.getResultList();
	}


}
