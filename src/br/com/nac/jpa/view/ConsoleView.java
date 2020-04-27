package br.com.nac.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.nac.jpa.dao.DoadorDAO;
import br.com.nac.jpa.dao.RegistroEstadiaDAO;
import br.com.nac.jpa.dao.impl.DoadorDAOImpl;
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

		RegistroEstadiaDAO registroDao = new RegistroEstadiaDAOImpl(em);
		DoadorDAO doadorDao = new DoadorDAOImpl(em);

		Receptor receptor = new Receptor("Dahyun", "O");
		RegistroEstadia reg = new RegistroEstadia(receptor, new GregorianCalendar(2000, Calendar.APRIL, 20));

		reg.addEstadias(new Estadia(302, "cloroquina", new GregorianCalendar(2020, Calendar.MARCH, 11),
				new GregorianCalendar(2020, Calendar.MARCH, 14)));

		receptor.addTransplantes(new Transplante(new GregorianCalendar(2020, Calendar.DECEMBER, 4)));

		Doador doador1 = new Doador("Thandy", "A+");

		doador1.addOrgaos(new Orgao(receptor, "coração", new GregorianCalendar(2000, Calendar.APRIL, 20),
				new GregorianCalendar(2001, Calendar.AUGUST, 11)));

		Cirurgiao hans = new Cirurgiao("Hans Chucrute", 48, new GregorianCalendar(1972, Calendar.SEPTEMBER, 14),
				receptor.getTransplantes());

		List<Cirurgiao> cirurgioes = new ArrayList<Cirurgiao>();
		cirurgioes.add(hans);

		for (Transplante tr : receptor.getTransplantes()) {
			tr.setCirurgiao(cirurgioes);
		}

		try {
			registroDao.cadastrar(reg);
			registroDao.commit();
			doadorDao.cadastrar(doador1);
			doadorDao.commit();
			System.out.println("Entidades cadastradas!");
		} catch (CommitException e) {
			System.out.println("Erro: " + e);
		}
		em.close();
		fabrica.close();

	}
}
