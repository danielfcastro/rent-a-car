package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Branch;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class BranchDAO extends AbstractBaseRepository<Branch> implements IRepository<Branch> {

	@Override
	public List<Branch> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
