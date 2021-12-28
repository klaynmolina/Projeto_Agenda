package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contatos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Endereço")
	private Endereco_emb endereco;

	@Column(name = "Telefone", unique = true)
	private String telefone;

	@Column(name = "Email", unique = true)
	private String email;

	public Contatos() {

	}

	public Contatos(String nome, Endereco_emb endereco, String telefone, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco_emb getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco_emb endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return 
				"ID: " + id + "\n" + 
				"Nome: " + nome + "\n" + 
				"Endereço: " + endereco + "\n" + 
				"Telefone: " + telefone + "\n" + 
				"E-mail: " + email + "\n" +
				"----------------------------------------------------\n";
	}

}
