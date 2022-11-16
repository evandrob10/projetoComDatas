package Application;

import java.time.Duration;
// importação de pacotes:
import java.time.LocalDate;
import java.time.LocalDateTime;

//importação de Class
import Entites.PersonDate;

public class Main {
	public static void main(String[] args) {
		LocalDateTime dataNascimento = LocalDateTime.parse("1996-03-13T14:30");
		LocalDateTime data_atual = LocalDateTime.parse("2022-11-13T20:30");
		PersonDate pessoa = new PersonDate("Evandro",20,dataNascimento);
		
		Duration tempo = Duration.between(dataNascimento, data_atual);
		System.out.println(tempo.toDays());
		
	}
}
