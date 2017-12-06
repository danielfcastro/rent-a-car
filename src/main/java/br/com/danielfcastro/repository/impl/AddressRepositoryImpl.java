package br.com.danielfcastro.repository.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.danielfcastro.model.Address;
import br.com.danielfcastro.model.BaseModel;
import br.com.danielfcastro.repository.IRepository;


@Named("AddressRepository")
@RequestScoped
public class AddressRepositoryImpl implements IRepository<Address> {

	@PersistenceContext(unitName = "AddressRepository")
	private EntityManager entityManager;

	public AddressRepositoryImpl() {
		super();
	}
	
	public AddressRepositoryImpl(EntityManager manager) {
		this.entityManager = manager;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void add(BaseModel item) {
		entityManager.persist(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void update(Address item) {
		entityManager.merge(item);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(BaseModel item) {
		entityManager.remove(item);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id) {
		BaseModel toBeDelete = entityManager.find(Address.class, id);
		entityManager.remove(toBeDelete);
	}

	public List<Address> query(String id) {
		TypedQuery<Address> query = null;
		if (null != id) {
			query = entityManager.createNamedQuery("Address.findById", Address.class);
			query.setParameter("id", id);
		} else {
			query = entityManager.createNamedQuery("Address.findAll", Address.class);
		}
		List<Address> results = query.getResultList();
		return results;
	}

}
