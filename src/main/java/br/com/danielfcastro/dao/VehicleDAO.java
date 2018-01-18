package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Vehicle;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleDAO extends AbstractBaseRepository<Vehicle> implements IRepository<Vehicle> {

	@Override
	public List<Vehicle> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
