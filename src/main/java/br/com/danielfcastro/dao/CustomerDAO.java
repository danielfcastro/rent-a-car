package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Customer;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class CustomerDAO extends AbstractBaseRepository<Customer> implements IRepository<Customer> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Customer> query(String id) {
		TypedQuery<Customer> query = entityManager.createNamedQuery(id, Customer.class);
		return query.getResultList();
	}

}
