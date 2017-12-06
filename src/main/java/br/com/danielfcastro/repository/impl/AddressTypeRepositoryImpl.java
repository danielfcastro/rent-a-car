package br.com.danielfcastro.repository.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.danielfcastro.model.AddressType;
import br.com.danielfcastro.repository.IRepository;


@Named("AddressTypeRepository")
@RequestScoped
public class AddressTypeRepositoryImpl implements IRepository<AddressType> {

	@PersistenceContext(unitName = "AddressTypeRepository")
	private EntityManager entityManager;

	public AddressTypeRepositoryImpl() {
		super();
	}
	
	public AddressTypeRepositoryImpl(EntityManager manager) {
		this.entityManager = manager;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void add(AddressType item) {
		entityManager.persist(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void update(AddressType item) {
		entityManager.merge(item);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(AddressType item) {
		entityManager.remove(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id) {
		AddressType toBeDelete = entityManager.find(AddressType.class, id);
		entityManager.remove(toBeDelete);
	}

	public List<AddressType> query(String id) {
		TypedQuery<AddressType> query = null;
		if (null != id) {
			query = entityManager.createNamedQuery("AddressType.findById", AddressType.class);
			query.setParameter("id", id);
		} else {
			query = entityManager.createNamedQuery("AddressType.findAll", AddressType.class);
		}
		List<AddressType> results = query.getResultList();
		return results;
	}

}
