package br.com.danielfcastro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.danielfcastro.model.Reservation;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class ReservationDAO extends AbstractBaseRepository<Reservation> implements IRepository<Reservation> {
	@Inject
	EntityManager entityManager;

	@PostConstruct
	private void init() {
		super.entityManager = entityManager;
	}

	@Override
	public List<Reservation> query(String id) {
		TypedQuery<Reservation> query = entityManager.createNamedQuery(id, Reservation.class);
		return query.getResultList();
	}


}
