package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.City;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class CityDAO extends AbstractBaseRepository<City> implements IRepository<City> {

	@Override
	public List<City> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
