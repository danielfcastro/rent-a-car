package br.com.danielfcastro.repository;

import java.util.List;

public interface IRepository<T> {
	
    void add(T item);

    void update(T item);

    void remove(T item);

    void remove(String  id);

    List<T> query(String  id);
}
