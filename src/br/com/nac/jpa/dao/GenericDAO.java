package br.com.nac.jpa.dao;

import br.com.nac.jpa.exception.CommitException;
import br.com.nac.jpa.exception.KeyNotFoundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);
	
	T ler (K key);
	
	void atualizar(T entity);
	
	void apagar (K key) throws KeyNotFoundException;
	
	void commit() throws CommitException;
	
}
