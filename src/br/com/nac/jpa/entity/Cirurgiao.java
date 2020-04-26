package br.com.nac.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CIRURGIAO")
public class Cirurgiao {
	
	@Id
	@Column(name="cd_cirurgiao")
	private int codigo;
	
	@Column(name="nm_cirurgiao")
	private String nome;

	public Cirurgiao() {
		super();
	}

	public Cirurgiao(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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
	
}
