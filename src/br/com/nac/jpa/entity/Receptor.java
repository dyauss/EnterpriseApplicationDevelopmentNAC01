package br.com.nac.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RECEPTOR")
@SequenceGenerator(name = "receptor", sequenceName = "SQ_TB_RECEPTOR",  allocationSize = 1)
public class Receptor {
	
	@Id
	@Column(name = "cd_receptor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receptor")
	private int codigo;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "receptor")
	private RegistroEstadia registroEstadia;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "receptor")
	//
	private List<Orgao> orgaos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="receptor", fetch = FetchType.LAZY)
	private List<Transplante> transplantes = new ArrayList<Transplante>();
	
	@Column(name = "nm_receptor", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "ds_sangue_receptor", nullable = false, length = 10)
	private String tipoSangue;

	public Receptor() {
		super();
	}

	public Receptor(String nome, String tipoSangue) {
		super();
		this.nome = nome;
		this.tipoSangue = tipoSangue;
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

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public List<Transplante> getTransplantes() {
		return transplantes;
	}

	public void setTransplantes(List<Transplante> transplantes) {
		this.transplantes = transplantes;
	}
	
	// Métodos add
	
	public void addTransplantes(Transplante transplante) {
		transplante.setReceptor(this);
		transplantes.add(transplante);
	}
	
}
