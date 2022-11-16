package Entites;
//Importação de pacotes:
import java.time.LocalDateTime;
import java.time.Duration;

public class PersonDate {
	private String name;
	private Integer idade;
	private LocalDateTime dataNascimento;
	private Endereco[] endereco;
	
	public PersonDate() {	
	}
	public PersonDate(String name, Integer idade, LocalDateTime dataNascimento) {
		this.name = name;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public Integer getIdade() {
		calculoIdade();
		return idade;
	}
	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	public void setEndereco(Endereco [] endereco) {
		this.endereco = endereco;
	}
	public void calculoIdade() {
		LocalDateTime data_atual = LocalDateTime.now();
		Duration tempo = Duration.between(dataNascimento, data_atual);
		int idade = (int) tempo.toDays() / 365;
		this.idade = idade;
	}
}
