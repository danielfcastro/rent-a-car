package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Branch;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class BranchDAO extends AbstractBaseRepository<Branch> implements IRepository<Branch> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Branch> query(String id) {
		TypedQuery<Branch> query = entityManager.createNamedQuery(id, Branch.class);
		return query.getResultList();
	}

}
