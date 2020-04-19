package br.com.fiap.transplante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.transplante.dao.OrgaoDAO;
import br.com.fiap.transplante.entity.Orgao;

public class OrgaoDAOImpl extends GenericDAOImpl<Orgao, Integer> implements OrgaoDAO{

	public OrgaoDAOImpl(EntityManager em) {
		super(em);
	}

}
