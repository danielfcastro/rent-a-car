package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Country;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class CountryDAO extends AbstractBaseRepository<Country> implements IRepository<Country> {

	@Override
	public List<Country> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
