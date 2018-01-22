package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Address;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

@RequestScoped
public class AddressDAO extends AbstractBaseRepository<Address> implements IRepository<Address> {

	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	public AddressDAO() {
	}

	@Override
	public List<Address> query(String id) {
		TypedQuery<Address> query = entityManager.createNamedQuery(id, Address.class);
		return query.getResultList();
	}
}
