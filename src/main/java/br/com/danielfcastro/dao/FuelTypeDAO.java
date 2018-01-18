package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.FuelType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class FuelTypeDAO extends AbstractBaseRepository<FuelType> implements IRepository<FuelType> {

	@Override
	public List<FuelType> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
