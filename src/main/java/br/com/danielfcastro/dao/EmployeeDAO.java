package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Employee;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class EmployeeDAO extends AbstractBaseRepository<Employee> implements IRepository<Employee> {

	@Override
	public List<Employee> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
