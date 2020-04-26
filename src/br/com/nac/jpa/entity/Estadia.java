package br.com.nac.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTADIA")
public class Estadia {

	@Id
	@Column(name = "cd_estadia")
	private int codigo;

	@Column(name = "nr_quarto")
	private int numeroQuarto;

	@Column(name = "ds_medicamentos")
	private String medicamentos;

	public Estadia() {
		super();
	}

	public Estadia(int codigo, int numeroQuarto, String medicamentos) {
		super();
		this.codigo = codigo;
		this.numeroQuarto = numeroQuarto;
		this.medicamentos = medicamentos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

}
