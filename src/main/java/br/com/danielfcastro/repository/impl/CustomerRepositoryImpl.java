package br.com.danielfcastro.repository.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.danielfcastro.model.Customer;
import br.com.danielfcastro.repository.IRepository;


@Named("CustomerRepository")
@RequestScoped
public class CustomerRepositoryImpl implements IRepository<Customer> {

	@PersistenceContext(unitName = "CustomerRepository")
	private EntityManager entityManager;

	public CustomerRepositoryImpl() {
		super();
	}
	
	public CustomerRepositoryImpl(EntityManager manager) {
		this.entityManager = manager;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void add(Customer item) {
		entityManager.persist(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void update(Customer item) {
		entityManager.merge(item);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(Customer item) {
		entityManager.remove(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id) {
		Customer toBeDelete = entityManager.find(Customer.class, id);
		entityManager.remove(toBeDelete);
	}

	public List<Customer> query(String id) {
		TypedQuery<Customer> query = null;
		if (null != id) {
			query = entityManager.createNamedQuery("Customer.findById", Customer.class);
			query.setParameter("id", id);
		} else {
			query = entityManager.createNamedQuery("Customer.findAll", Customer.class);
		}
		List<Customer> results = query.getResultList();
		return results;
	}

}
