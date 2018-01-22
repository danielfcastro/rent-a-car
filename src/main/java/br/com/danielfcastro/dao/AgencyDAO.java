package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Agency;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class AgencyDAO extends AbstractBaseRepository<Agency> implements IRepository<Agency> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Agency> query(String id) {
		TypedQuery<Agency> query = entityManager.createNamedQuery(id, Agency.class);
		return query.getResultList();
	}

}
