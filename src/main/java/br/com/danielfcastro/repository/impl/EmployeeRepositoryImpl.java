package br.com.danielfcastro.repository.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.danielfcastro.model.Employee;
import br.com.danielfcastro.repository.IRepository;


@Named("EmployeeRepository")
@RequestScoped
public class EmployeeRepositoryImpl implements IRepository<Employee> {

	@PersistenceContext(unitName = "EmployeeRepository")
	private EntityManager entityManager;

	public EmployeeRepositoryImpl() {
		super();
	}
	
	public EmployeeRepositoryImpl(EntityManager manager) {
		this.entityManager = manager;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void add(Employee item) {
		entityManager.persist(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void update(Employee item) {
		entityManager.merge(item);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(Employee item) {
		entityManager.remove(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id) {
		Employee toBeDelete = entityManager.find(Employee.class, id);
		entityManager.remove(toBeDelete);
	}

	public List<Employee> query(String id) {
		TypedQuery<Employee> query = null;
		if (null != id) {
			query = entityManager.createNamedQuery("Employee.findById", Employee.class);
			query.setParameter("id", id);
		} else {
			query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
		}
		List<Employee> results = query.getResultList();
		return results;
	}

}
