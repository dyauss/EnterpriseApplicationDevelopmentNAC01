package br.com.fiap.transplante.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ORGAO")
public class Orgao {

	@Id
	@Column(name = "cd_orgao")
	private int codigo;

	@Column(name = "nm_orgao")
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_retirada")
	private Calendar retirada;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_validade")
	private Calendar validade;

	public Orgao() {
		super();
	}

	public Orgao(int codigo, String nome, Calendar retirada, Calendar validade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.retirada = retirada;
		this.validade = validade;
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
	

}
