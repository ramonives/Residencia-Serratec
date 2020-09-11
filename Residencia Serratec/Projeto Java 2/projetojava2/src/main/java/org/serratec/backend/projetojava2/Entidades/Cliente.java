package org.serratec.backend.projetojava2.Entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 200)
	@Column(name="endereco", nullable = false, length = 200)
	private String endereco;
	
	@NotNull
	@Size(min = 5, max = 20)
	@Column(name="telefone", nullable = false, length = 20)
	private String telefone;
	
	@NotNull
	@Size(min = 5, max = 15)
	@Column(name="usuario", nullable = false, length = 15)
	private String usuario;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column(name="email", nullable = false, length = 30)
	private String email;
	
	@NotNull
	@Size(min = 14, max = 14)
	@Column(name="cpf", nullable = false, length = 14)
	private String cpf;
	
	@Column(name="nascimento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")//MM MAISCULO MES - minusculo minutos
	private Date nascimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	

}
