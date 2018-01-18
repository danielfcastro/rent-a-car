package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.VehicleType;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleTypeDAO extends AbstractBaseRepository<VehicleType> implements IRepository<VehicleType> {

	@Override
	public List<VehicleType> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
