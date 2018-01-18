package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.State;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class StateDAO extends AbstractBaseRepository<State> implements IRepository<State> {

	@Override
	public List<State> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
