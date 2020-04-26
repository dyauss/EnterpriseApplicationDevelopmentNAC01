package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.DoadorDAO;
import br.com.nac.jpa.entity.Doador;

public class DoadorDAOImpl extends GenericDAOImpl<Doador, Integer> implements DoadorDAO{

	public DoadorDAOImpl(EntityManager em) {
		super(em);
	}

}
