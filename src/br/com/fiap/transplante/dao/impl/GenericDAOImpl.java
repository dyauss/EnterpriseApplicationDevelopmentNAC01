package br.com.fiap.transplante.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.GenericDAO;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public T ler(K key) {
		return em.find(clazz, key);
	}

	@Override
	public void atualizar(T entity) {
		em.merge(entity);
	}

	@Override
	public void apagar(K key) throws Exception {
		T entity = ler(key);
		if (entity == null){
			//Precisa criar a exception certa (KeyNotFound) pra deixar um throw new dela aqui
			System.out.println("entity vazia");
		}
		em.remove(entity);
	}

	@Override
	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			//mesmo caso do apagar, só que aqui a certa é CommitException
		}
	}

}
