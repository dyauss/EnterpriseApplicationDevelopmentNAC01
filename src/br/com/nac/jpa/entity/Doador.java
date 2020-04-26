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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "TB_DOADOR")
@SequenceGenerator(name = "doador", sequenceName = "SQ_TB_DOADOR",  allocationSize = 1)
public class Doador {
	
	@Id
	@Column(name = "cd_doador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doador")
	private int codigo;
	
	@Column(name = "nm_doador", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "ds_sangue_doador", nullable = false, length = 10)
	private String tipoSangue;
	

	@OneToMany(mappedBy="doador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//
	private List<Orgao> orgaos =  new ArrayList<Orgao>(); 
	
	public List<Orgao> getOrgaos() {
		return orgaos;
	}


	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

	
	public void addOrgaos(Orgao orgao) {
		orgao.setDoador(this);//adiciona o doador no atributo que mapeia a FK
		orgaos.add(orgao);//adiciona o orgao na lista
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

	public Doador() {
		super();
	}

	public Doador(String nome, String tipoSangue) {
		super();
		this.nome = nome;
		this.tipoSangue = tipoSangue;
	}
			
	
}
