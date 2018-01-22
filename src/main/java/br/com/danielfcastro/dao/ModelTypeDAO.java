package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.ModelType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class ModelTypeDAO extends AbstractBaseRepository<ModelType> implements IRepository<ModelType> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<ModelType> query(String id) {
		TypedQuery<ModelType> query = entityManager.createNamedQuery(id, ModelType.class);
		return query.getResultList();
	}

}
