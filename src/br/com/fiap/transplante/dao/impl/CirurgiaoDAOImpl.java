package br.com.fiap.transplante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.CirurgiaoDAO;
import br.com.fiap.transplante.entity.Cirurgiao;

public class CirurgiaoDAOImpl extends GenericDAOImpl<Cirurgiao, Integer> implements CirurgiaoDAO{

	public CirurgiaoDAOImpl(EntityManager em) {
		super(em);
	}

}
