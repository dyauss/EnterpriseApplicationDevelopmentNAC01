package br.com.nac.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ORGAO")
@SequenceGenerator(name = "orgao", sequenceName = "SQ_TB_ORGAO",  allocationSize = 1)
public class Orgao {

	@Id
	@Column(name = "cd_orgao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgao")
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "cd_doador", nullable = false)
	//nullable = false
	private Doador doador;

	@ManyToOne
	@JoinColumn(name = "cd_receptor", nullable = false)
	//nullable = false
	private Receptor receptor;

	@Column(name = "nm_orgao", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_retirada", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar retirada;

	@Column(name = "dt_validade", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar validade;

	public Orgao() {
		super();
	}

	public Orgao(Receptor receptor, String nome, Calendar retirada, Calendar validade) {
		super();
		//this.doador = doador;
		this.receptor = receptor;
		this.nome = nome;
		this.retirada = retirada;
		this.validade = validade;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getRetirada() {
		return retirada;
	}

	public void setRetirada(Calendar retirada) {
		this.retirada = retirada;
	}

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

}
