package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Telephone;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class TelephoneDAO extends AbstractBaseRepository<Telephone> implements IRepository<Telephone> {

	@Override
	public List<Telephone> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
