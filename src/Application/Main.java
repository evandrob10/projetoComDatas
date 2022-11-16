package Application;
// importação de pacotes:

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.time.Duration;
import java.time.LocalDateTime;

//importação de Class
import Entites.PersonDate;
import Entites.Endereco;

public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		LocalDateTime dataNascimento = LocalDateTime.parse("1996-03-13T14:30");
		LocalDateTime data_atual = LocalDateTime.parse("2022-11-13T20:30");
		PersonDate pessoa = new PersonDate("Evandro",20,dataNascimento);
		
		end
		
	}
	public void cadastrarEndereco(PersonDate pessoa) {
		Scanner input = new Scanner(System.in);
		
		String rua, numeroCasa, bairro, cidade, estado, complemento;
		
		System.out.println("Numero de endereço que deseja cadastrar: ");
		int numeroEndereco = input.nextInt();
		input.nextLine();
		
		Endereco[] endereco =  new Endereco [numeroEndereco];
		
		do {
			System.out.println("Digite a rua: ");
			rua = input.nextLine();
			System.out.println("Digite o numero casa: ");
			numeroCasa = input.next();
			System.out.println("Digite o bairro: ");
			bairro = input.nextLine();
			System.out.println("Digite a cidade: ");
			cidade = input.nextLine();
			System.out.println("Digite o estado: ");
			estado = input.nextLine();
			System.out.println("(Opcional) Digite o complemento: ");
			complemento = input.nextLine();

			
			
			--numeroEndereco;
		}while(numeroEndereco != 0);
		
		input.close();
	}
}
