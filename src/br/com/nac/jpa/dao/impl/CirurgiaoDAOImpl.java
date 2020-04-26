package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.CirurgiaoDAO;
import br.com.nac.jpa.entity.Cirurgiao;

public class CirurgiaoDAOImpl extends GenericDAOImpl<Cirurgiao, Integer> implements CirurgiaoDAO{

	public CirurgiaoDAOImpl(EntityManager em) {
		super(em);
	}

}
