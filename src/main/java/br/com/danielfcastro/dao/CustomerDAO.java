package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Customer;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class CustomerDAO extends AbstractBaseRepository<Customer> implements IRepository<Customer> {

	@Override
	public List<Customer> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
