package br.com.fiap.transplante.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_RECEPTOR")
public class Receptor {
	
	@Id
	@Column(name="cd_receptor")
	private int codigo;
	
	@Column(name="nm_receptor")
	private String nome;
	
	@Column(name="ds_sangue_receptor")
	private String tipoSanguineo;

	public Receptor() {
		super();
	}

	public Receptor(int codigo, String nome, String tipoSanguineo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipoSanguineo = tipoSanguineo;
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

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	
	
}
