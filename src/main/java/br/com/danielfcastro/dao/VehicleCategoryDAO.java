package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.VehicleCategory;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class VehicleCategoryDAO extends AbstractBaseRepository<VehicleCategory> implements IRepository<VehicleCategory> {

	@Override
	public List<VehicleCategory> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
