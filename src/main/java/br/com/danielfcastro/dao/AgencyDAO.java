package br.com.danielfcastro.dao;

import java.util.List;

import br.com.danielfcastro.model.Agency;
import br.com.danielfcastro.repository.AbstractBaseRepository;
import br.com.danielfcastro.repository.IRepository;

public class AgencyDAO extends AbstractBaseRepository<Agency> implements IRepository<Agency> {

	@Override
	public List<Agency> query(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
