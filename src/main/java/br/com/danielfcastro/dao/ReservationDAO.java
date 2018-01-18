package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Reservation;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class ReservationDAO extends AbstractBaseRepository<Reservation> implements IRepository<Reservation> {

	@Override
	public List<Reservation> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
