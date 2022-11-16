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
		do {
			redirect(showMenu());
		}while(showMenu() != 0);
	}
	public static int showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Oque deseja fazer? %n1 - Cadastrar usuario%n2 - Cadastrar endereço%n0 - Sair%n");
		int opcao = input.nextInt();
		return opcao;
	}
	public static void redirect(int opcaoEscolhida) {
		switch(opcaoEscolhida) {
			case 1:
				System.out.println("Você escolheu cadastrar usuario: ");
				break;
			case 2:
				System.out.println("Você escolheu cadastrar endereço:  ");
				break;
			case 0:
				System.out.println("Sistema finalizado com sucesso!");
				break;
			default:
				System.out.println("Opção invalida!");
				break;
		}
	}
	public static void cadastrarEndereco(PersonDate pessoa) {
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
			numeroCasa = input.nextLine();
			System.out.println("Digite o bairro: ");
			bairro = input.nextLine();
			System.out.println("Digite a cidade: ");
			cidade = input.nextLine();
			System.out.println("Digite o estado: ");
			estado = input.nextLine();
			System.out.println("(Opcional) Digite o complemento: ");
			complemento = input.nextLine();
			
			for(int i = 0; i < endereco.length; i++) {
				if(endereco[i] == null) {
					endereco[i] = new Endereco(rua,numeroCasa,bairro,cidade,estado,complemento);
				}
			}
			
			--numeroEndereco;
		}while(numeroEndereco != 0);
		
		pessoa.setEndereco(endereco);
		
		input.close();
	}
}
