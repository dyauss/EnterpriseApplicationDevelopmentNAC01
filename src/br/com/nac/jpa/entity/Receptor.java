package br.com.nac.jpa.entity;

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

@Entity
@Table(name = "TB_RECEPTOR")
@SequenceGenerator(sequenceName = "SQ_TB_RECEPTOR", name = "receptor", allocationSize = 1)
public class Receptor {

	@Id
	@Column(name = "cd_receptor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receptor")
	private int codigo;
	
	@OneToOne
	@JoinColumn(name = "cd_estadia", nullable = false)
	private Estadia estadia;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "receptor")
    private List<Orgao> orgaos;
	
	@OneToMany(mappedBy= "receptor")
	private List<Transplante> transplantes;
	
	@Column(name = "nm_receptor", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "ds_sangue_receptor", nullable = false, length = 10)
	private String tipoSangue;

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

	public Receptor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receptor(String nome, String tipoSangue) {
		super();
		this.nome = nome;
		this.tipoSangue = tipoSangue;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

	public List<Transplante> getTransplantes() {
		return transplantes;
	}

	public void setTransplantes(List<Transplante> transplantes) {
		this.transplantes = transplantes;
	}
	
	
	
	
	
}
