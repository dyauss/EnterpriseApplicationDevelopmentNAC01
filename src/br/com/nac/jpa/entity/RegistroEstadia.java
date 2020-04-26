package br.com.nac.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_REGISTRO_ESTADIA")
@SequenceGenerator( name = "registro_estadia", sequenceName = "SQ_TB_REGISTRO_ESTADIA", allocationSize = 1)
public class RegistroEstadia {
	
	@Id
	@Column(name="cd_registro_estadia")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registro_estadia")
	private int codigo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_receptor" , nullable = false)
	private Receptor receptor;
	
	@Column(name="dt_abertura")
	@Temporal(TemporalType.DATE)
	private Calendar abertura;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="registroEstadia", fetch = FetchType.LAZY)
	private List<Estadia> estadias = new ArrayList<Estadia>();
	
	
	public RegistroEstadia() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RegistroEstadia(Receptor receptor, Calendar abertura) {
		super();
		this.receptor = receptor;
		this.abertura = abertura;
	}




	public List<Estadia> getEstadias() {
		return estadias;
	}


	public void setEstadias(List<Estadia> estadias) {
		this.estadias = estadias;
	}

	
	public void addEstadias(Estadia estadia) {
		estadia.setRegistroEstadia(this);
		estadias.add(estadia);
	}

	public RegistroEstadia(Calendar abertura) {
		super();
		this.abertura = abertura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getAbertura() {
		return abertura;
	}

	public void setAbertura(Calendar abertura) {
		this.abertura = abertura;
	}
	
}
