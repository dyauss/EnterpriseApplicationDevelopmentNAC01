package br.com.nac.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CIRURGIAO")
@SequenceGenerator(name = "cirurgiao", sequenceName = "SQ_TB_CIRURGIAO",  allocationSize = 1)
public class Cirurgiao {

	@Id
	@Column(name = "cd_cirurgiao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cirurgiao")
	private int codigo;

	@Column(name = "nm_cirurgiao", nullable = false, length = 100)
	private String nome;

	@Column(name = "nr_idade", nullable = false)
	private int idade;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;

	@ManyToMany()
	@JoinTable(name = "TB_OPERACAO", joinColumns = @JoinColumn(name = "cd_cirurgiao"), inverseJoinColumns = @JoinColumn(name = "cd_transplante"))
	private List<Transplante> transplante;

	public Cirurgiao(String nome, int idade, Calendar nascimento) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.nascimento = nascimento;
	}

	public Cirurgiao() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public List<Transplante> getTransplante() {
		return transplante;
	}

	public void setTransplante(List<Transplante> transplante) {
		this.transplante = transplante;
	}

}
