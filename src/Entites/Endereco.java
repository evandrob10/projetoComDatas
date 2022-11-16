package Entites;

public class Endereco {
	private String rua, numeroCasa , bairro, cidade, estado, complemento = null;
	
	public Endereco() {
	}
	public Endereco(String rua, String numeroCasa, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numeroCasa = numeroCasa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Endereco(String rua, String numeroCasa, String bairro, String cidade, String estado, String complemento) {
		this.rua = rua;
		this.numeroCasa = numeroCasa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String toString() {
		return String.format("Rua: %s%nNumero: %s%nBairro: %s%nCidade: %s%nEstado: %s%nComplemento: %s%n", rua,numeroCasa,bairro,cidade,estado,complemento);
	}
}
