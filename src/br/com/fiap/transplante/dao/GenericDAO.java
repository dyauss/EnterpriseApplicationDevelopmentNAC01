package br.com.fiap.transplante.dao;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);
	
	void ler (K key);
	
	void atualizar(T entity);
	
	void apagar (K key) throws Exception;
	
	void commit() throws Exception;
	
}
