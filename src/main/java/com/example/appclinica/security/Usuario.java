package com.example.appclinica.security;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "email"),
				@UniqueConstraint(columnNames = "username")
		})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
	@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
	private Long id;

	@NotBlank(message = "O campo nome não pode ficar em branco.")
	private String nome;

	@Column(name = "data_nascimento")
	@NotBlank(message = "O campo data nascimento não pode ficar em branco.")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotBlank
	@CPF
	private String cpf;

	@NotBlank(message = "O campo email não pode ficar em branco.")
	@Email(message = "O campo email está com valor inválido.")
	private String email;

	@NotEmpty(message = "O campo telefone não pode ser vazio.")
	@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])\\d{5}-\\d{4}$", message = "O campo telefone está com valor inválido.")
	private String telefone;

	@NotBlank(message = "O campo usuário não pode ser vazio.")
	private String username;

	@NotBlank(message = "O campo senha não pode ser vazio.")
	@Size(min = 8, message = "O campo senha precisa ter pelo menos 8 caracteres.")
	private String password;

	public Usuario(String nome, LocalDate dataNascimento, String email, String telefone) {
		this(null, nome, dataNascimento, null, email, telefone, null, null);
	}

	public Usuario(Long id, String nome, String email, String telefone) {
		this(id, nome, null, null, email, telefone, null, null);
	}

	public Usuario(String email, String telefone) {
		this(null, null, null, null, email, telefone, null, null);
	}

	public Usuario(Long id, String nome, LocalDate dataNascimento, String email, String telefone) {
		this(id, nome, dataNascimento, null, email, telefone, null, null);
	}

	public Usuario(String nome, LocalDate dataNascimento, String cpf, String email, String telefone, String username, String password) {
		this(null, nome, dataNascimento, cpf, email, telefone, username, password);
	}

	public Usuario(Long id, String nome, LocalDate dataNascimento, String cpf, String email, String telefone, String username, String password) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.username = username;
		this.password = password;
	}

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuário{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", dataNascimento=" + dataNascimento +
				", email='" + email + '\'' +
				", telefone='" + telefone + '\'' +
				'}';
	}

}


