package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.TransplanteDAO;
import br.com.nac.jpa.entity.Transplante;

public class TransplanteDAOImpl extends GenericDAOImpl<Transplante, Integer> implements TransplanteDAO {

	public TransplanteDAOImpl(EntityManager em) {
		super(em);
	}

}
