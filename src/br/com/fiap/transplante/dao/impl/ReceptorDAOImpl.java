package br.com.fiap.transplante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.ReceptorDAO;
import br.com.fiap.transplante.entity.Receptor;

public class ReceptorDAOImpl extends GenericDAOImpl<Receptor, Integer> implements ReceptorDAO {

	public ReceptorDAOImpl(EntityManager em) {
		super(em);
	}

}
