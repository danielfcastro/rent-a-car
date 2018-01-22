package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Employee;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class EmployeeDAO extends AbstractBaseRepository<Employee> implements IRepository<Employee> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Employee> query(String id) {
		TypedQuery<Employee> query = entityManager.createNamedQuery(id, Employee.class);
		return query.getResultList();
	}

}
