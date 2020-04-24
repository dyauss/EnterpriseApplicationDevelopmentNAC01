package br.com.fiap.transplante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.EstadiaDAO;
import br.com.fiap.transplante.entity.Estadia;

public class EstadiaDAOImpl extends GenericDAOImpl<Estadia, Integer> implements EstadiaDAO {

	public EstadiaDAOImpl(EntityManager em) {
		super(em);
	}

}
