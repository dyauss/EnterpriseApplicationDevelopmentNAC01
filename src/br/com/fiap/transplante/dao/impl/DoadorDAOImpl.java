package br.com.fiap.transplante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.DoadorDAO;
import br.com.fiap.transplante.entity.Doador;

public class DoadorDAOImpl extends GenericDAOImpl<Doador, Integer> implements DoadorDAO{

	public DoadorDAOImpl(EntityManager em) {
		super(em);
	}

}
