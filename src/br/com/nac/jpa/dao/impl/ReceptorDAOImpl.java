package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.ReceptorDAO;
import br.com.nac.jpa.entity.Receptor;

public class ReceptorDAOImpl extends GenericDAOImpl<Receptor, Integer> implements ReceptorDAO {

	public ReceptorDAOImpl(EntityManager em) {
		super(em);
	}

}
