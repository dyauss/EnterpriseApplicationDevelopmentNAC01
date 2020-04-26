package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.EstadiaDAO;
import br.com.nac.jpa.entity.Estadia;

public class EstadiaDAOImpl extends GenericDAOImpl<Estadia, Integer> implements EstadiaDAO {

	public EstadiaDAOImpl(EntityManager em) {
		super(em);
	}

}
