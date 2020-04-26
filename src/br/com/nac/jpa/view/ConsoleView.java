package br.com.nac.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.nac.jpa.dao.OrgaoDAO;
import br.com.nac.jpa.dao.RegistroEstadiaDAO;
import br.com.nac.jpa.dao.impl.OrgaoDAOImpl;
import br.com.nac.jpa.dao.impl.RegistroEstadiaDAOImpl;
import br.com.nac.jpa.entity.Cirurgiao;
import br.com.nac.jpa.entity.Doador;
import br.com.nac.jpa.entity.Estadia;
import br.com.nac.jpa.entity.Orgao;
import br.com.nac.jpa.entity.Receptor;
import br.com.nac.jpa.entity.RegistroEstadia;
import br.com.nac.jpa.entity.Transplante;
import br.com.nac.jpa.exception.CommitException;
import br.com.nac.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {
	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		// Até aqui EZPZ

		RegistroEstadiaDAO registroDao = new RegistroEstadiaDAOImpl(em);
		OrgaoDAO orgaoDao = new OrgaoDAOImpl(em);

		// Fazer um dao aqui em cima

//		Doador doador1 = new Doador(1, "Thandy", "A+");
//		Orgao figado = new Orgao(doador1, 3, "figado", new GregorianCalendar(2000, Calendar.APRIL, 20), new GregorianCalendar(2001, Calendar.AUGUST, 11));

		Receptor receptor = new Receptor("Thandy", "A+");
		RegistroEstadia reg = new RegistroEstadia(receptor, new GregorianCalendar(2000, Calendar.APRIL, 20));
		
		//
		
		reg.addEstadias(new Estadia(302, "cloroquina", new GregorianCalendar(2020, Calendar.MARCH, 11), new GregorianCalendar(2020, Calendar.MARCH, 14)));
		
		receptor.addTransplantes(new Transplante(new GregorianCalendar(2020, Calendar.DECEMBER, 4)));
		
		//Criar cirurgiões
		
		Cirurgiao hans = new Cirurgiao("Hans Chucrute", 48, new GregorianCalendar(1972, Calendar.SEPTEMBER, 14));
//		
//		//Criar list de cirurgioes
//		
		List<Cirurgiao> cirurgioes = new ArrayList<Cirurgiao>();
		cirurgioes.add(hans);
		
		//
				
		//Relacionar
		
//		for (Filme f : loc.getFilmes()) {
//		f.setClientes(clientes);
//	}
		for (Transplante tr : receptor.getTransplantes()) {
			tr.setCirurgiao(cirurgioes);
		}
		
		//
//		Orgao figado = new Orgao(doador1, 3, "figado", new GregorianCalendar(2000, Calendar.APRIL, 20), new GregorianCalendar(2001, Calendar.AUGUST, 11));
//		Doador doador1 = new Doador(1, "Thandy", "A+");

		Doador doador1 = new Doador("Dyaus", "B+");
		Orgao figado = new Orgao(doador1, receptor, "figado", new GregorianCalendar(2000, Calendar.APRIL, 20), new GregorianCalendar(2001, Calendar.AUGUST, 11));
		
		
		try {
			registroDao.cadastrar(reg);
			registroDao.commit();
			System.out.println("Deu bom o registroDao");
			orgaoDao.cadastrar(figado);
			orgaoDao.commit();
			System.out.println("Deu bom o orgaoDao");
			System.out.println("Deu tudo bom :D");
		} catch (CommitException e) {
			System.out.println("Deu ruim. Erro: " + e);
		}

		// fechar as paradas
		em.close();
		fabrica.close();

	}
}
