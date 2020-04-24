package br.com.fiap.transplante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.TransplanteDAO;
import br.com.fiap.transplante.entity.Transplante;

public class TransplanteDAOImpl extends GenericDAOImpl<Transplante, Integer> implements TransplanteDAO {

	public TransplanteDAOImpl(EntityManager em) {
		super(em);
	}

}
