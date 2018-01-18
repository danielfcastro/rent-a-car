package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Rent;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class RentDAO extends AbstractBaseRepository<Rent> implements IRepository<Rent> {

	@Override
	public List<Rent> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
