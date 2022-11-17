package Entites;
//Importação de pacotes:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class PersonDate {
	private String matricula;
	private String name;
	private Integer idade;
	private LocalDate dataNascimento;
	private Endereco[] endereco;
	
	public PersonDate() {	
	}
	public PersonDate(String matricula, String name , LocalDate dataNascimento) {
		this.matricula = matricula;
		this.name = name;
		this.dataNascimento = dataNascimento;
	}
	public String getMatricula() {
		return matricula;
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
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setEndereco(Endereco [] endereco) {
		this.endereco = endereco;
	}
	public Endereco[] getEndereco() {
		return endereco; 
	}
	public void calculoIdade() {
		LocalDate data_atual = LocalDate.now();
		Duration tempo = Duration.between(dataNascimento.atStartOfDay(), data_atual.atStartOfDay());
		int idade = (int) tempo.toDays() / 365;
		this.idade = idade;
	}
	public String toString() {
		return String.format("Matricula: %s | Nome: %s | Data de nascimento: %s | Idade: %d%n",matricula,name,dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),getIdade());
	}
}
