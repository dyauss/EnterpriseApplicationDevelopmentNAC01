package br.com.nac.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTADIA")
@SequenceGenerator(sequenceName = "SQ_TB_ESTADIA", name = "estadia", allocationSize = 1)
public class Estadia {

	@Id
	@Column(name = "cd_estadia")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadia")
	private int codigo;
	
	@OneToOne(mappedBy="estadia")
	private Receptor receptor;
	
	@Column(name = "nr_quarto", nullable = false)
	private int quarto;
	
	@Column(name = "ds_medicamentos", length = 100)
	private String medicamentos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public Estadia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estadia(int quarto, String medicamentos) {
		super();
		this.quarto = quarto;
		this.medicamentos = medicamentos;
	}
	
	
	
	
}
