package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Address;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class AddressDAO extends AbstractBaseRepository<Address> implements IRepository<Address> {

	@Override
	public List<Address> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
