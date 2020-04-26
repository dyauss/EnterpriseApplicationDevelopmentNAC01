package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.RegistroEstadiaDAO;
import br.com.nac.jpa.entity.RegistroEstadia;

public class RegistroEstadiaDAOImpl extends GenericDAOImpl<RegistroEstadia, Integer> implements RegistroEstadiaDAO{

	public RegistroEstadiaDAOImpl(EntityManager em) {
		super(em);
	}

}
