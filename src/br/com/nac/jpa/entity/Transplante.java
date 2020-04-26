package br.com.nac.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_TRANSPLANTE")
@SequenceGenerator( name = "transplante",sequenceName = "SQ_TB_TRANSPLANTE", allocationSize = 1)
public class Transplante {

	@Id
	@Column(name = "cd_transplante")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transplante")
	private int codigo;
	
    @ManyToOne
    @JoinColumn(name = "cd_receptor", nullable = false)
	private Receptor receptor;
	
	@Column(name = "dt_cirurgia", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataCirurgia;
	
	@ManyToMany(mappedBy = "transplante", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cirurgiao> cirurgiao;

	public Transplante() {
		super();
	}

	public Transplante(Calendar dataCirurgia) {
		super();
		this.dataCirurgia = dataCirurgia;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataCirurgia() {
		return dataCirurgia;
	}

	public void setDataCirurgia(Calendar dataCirurgia) {
		this.dataCirurgia = dataCirurgia;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public List<Cirurgiao> getCirurgiao() {
		return cirurgiao;
	}

	public void setCirurgiao(List<Cirurgiao> cirurgiao) {
		this.cirurgiao = cirurgiao;
	}
	
	
}
