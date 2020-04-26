package br.com.nac.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.jpa.dao.OrgaoDAO;
import br.com.nac.jpa.entity.Orgao;

public class OrgaoDAOImpl extends GenericDAOImpl<Orgao, Integer> implements OrgaoDAO{

	public OrgaoDAOImpl(EntityManager em) {
		super(em);
	}

}
