package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.SiteType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class SiteTypeDAO extends AbstractBaseRepository<SiteType> implements IRepository<SiteType> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<SiteType> query(String id) {
		TypedQuery<SiteType> query = entityManager.createNamedQuery(id, SiteType.class);
		return query.getResultList();
	}

}
