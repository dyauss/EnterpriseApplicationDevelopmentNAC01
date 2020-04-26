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
@Table(name="TB_ESTADIA")
@SequenceGenerator(name = "estadia", sequenceName = "SQ_TB_ESTADIA",  allocationSize = 1)
public class Estadia {
	
	@Id
	@Column(name="cd_estadia")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadia")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_registro_estadia", nullable = false)
	private RegistroEstadia registroEstadia;
	
	@Column(name="nr_quarto")
	private int quarto;
	
	@Column(name="ds_medicamentos")
	private String medicamentos;
	
	@Column(name="dt_entrada")
	@Temporal(TemporalType.DATE)
	private Calendar entrada;
	
	@Column(name="dt_saida")
	@Temporal(TemporalType.DATE)
	private Calendar saida;

	public Estadia() {
		super();
	}

	public Estadia(int quarto, String medicamentos, Calendar entrada, Calendar saida) {
		super();
		this.quarto = quarto;
		this.medicamentos = medicamentos;
		this.entrada = entrada;
		this.saida = saida;
	}

	
	public RegistroEstadia getRegistroEstadia() {
		return registroEstadia;
	}

	public void setRegistroEstadia(RegistroEstadia registroEstadia) {
		this.registroEstadia = registroEstadia;
	}

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

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}
	

}
