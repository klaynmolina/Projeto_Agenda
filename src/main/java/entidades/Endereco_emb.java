package entidades;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco_emb {
	
	private String rua;
	private String bairro;
	private int numero;
	
	public Endereco_emb() {
		
	}
	
	public Endereco_emb(String rua, int numero, String bairro) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return 	rua +" / Número "+ numero +" / Bairro "+ bairro ;
	}	
	
	
	
}
