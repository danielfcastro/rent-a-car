package br.com.danielfcastro.repository;

import java.util.List;

import javax.transaction.Transactional;

public interface IRepository <T>{

	@Transactional(Transactional.TxType.REQUIRED)
	public void save(T element);
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void update(T element);
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(T element);

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(String id);

	@Transactional(Transactional.TxType.SUPPORTS)
	public List<T> query(String id);	
}