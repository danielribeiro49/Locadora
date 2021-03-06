package br.edu.tglima.locadora.models.pessoa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name="tb_funcionario", 
uniqueConstraints=@UniqueConstraint(columnNames="cpf", name ="cpf_uk"))

@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private Long id;
	private String cpf;
	private String nome;
	private String sobrenome;
	private Date dataNasc;
	private OpGeneros genero;
	private String telefone;
	private Date dataCadastro;
	private TiposCargo cargo;
	private String password;
	
	@Id
	@SequenceGenerator(name = "seq_func", sequenceName = "seq_func", initialValue = 2017000, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_func")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
		
	@Column(unique=true, nullable=false, length=14)
	@NotEmpty
	@Size(min=14, message="O CPF deve conter 11 digitos!")
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(nullable=false, length=20)
	@Size(min=2, max=20, message="O nome do funcionário, deve conter entre 2 e 20 caracteres.")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(nullable=false, length=50)
	@Size(min=2, max=50, message="O sobrenome do funcionário, deve conter entre 2 e 50 caracteres.")
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento", nullable=false)
	@Past(message="Data de nascimento inválida!")
	public Date getDataNasc() {
		return dataNasc;
	}
	
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	public OpGeneros getGenero() {
		return genero;
	}
	
	public void setGenero(OpGeneros genero) {
		this.genero = genero;
	}
	
	@Column(nullable=false, length=15)
	@Size(min=14, max=15, message="O número de telefone deve conter entre 10 e 11 digitos.")
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro", nullable=false)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	public TiposCargo getCargo() {
		return cargo;
	}
	
	public void setCargo(TiposCargo cargo) {
		this.cargo = cargo;
	}
	
	@Column(nullable=false, length=8)
	@Size(min=6, max=8, message="A senha deve conter entre 6 e 8 caracteres")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
