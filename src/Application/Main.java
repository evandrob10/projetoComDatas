package Application;
// importação de pacotes:

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//importação de Class
import Entites.PersonDate;
import Entites.Endereco;

public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		ArrayList <PersonDate> usuarios = new ArrayList();
		do {
			redirect(showMenu(),usuarios);
		}while(showMenu() != 0);
	}
	public static int showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Oque deseja fazer? %n1 - Cadastrar usuario%n2 - Cadastrar endereço%n3 - Consultar usuario%n0 - Sair%n");
		int opcao = input.nextInt();
		return opcao;
	}
	public static void redirect(int opcaoEscolhida,ArrayList <PersonDate> pessoa) {
		switch(opcaoEscolhida) {
			case 1:
				if(confirmOpcaoEscolhida("cadastrar usuarios")) {
					cadastrarUsuario(pessoa);
				}
				break;
			case 2:
				if(confirmOpcaoEscolhida("cadastrar endereço")) {
					System.out.println(localizar_usuario("3020",pessoa));
				}
				break;
			case 3:
				if(confirmOpcaoEscolhida("cadastrar usuarios")) {
					
				}
			case 0:
				System.out.println("Sistema finalizado com sucesso!");
				break;
			default:
				System.out.println("Opção invalida!");
				break;
		}
	}
	public static String localizar_usuario(String matricula, ArrayList <PersonDate> pessoa) {
		String resultado_busca = "";
		for(PersonDate usuarios : pessoa) {
			if(usuarios.getMatricula().equals(matricula)) {
				resultado_busca = usuarios.toString();
			}else {
				resultado_busca = "Usuario não localizado!";
			}
		}
		return resultado_busca;
	}
	public static boolean confirmOpcaoEscolhida(String opcaoSelecionada) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Você escolheu %s?%n",opcaoSelecionada);
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		int opcao = input.nextInt();
		if(opcao == 1) {
			return true;
		}else {
			return false;
		}
	}
	public static void cadastrarUsuario(ArrayList <PersonDate> usuarios) {
		Scanner input = new Scanner(System.in);
		
		String matricula, nome, dataNascimento;
		LocalDate dataNascimentoTime;
	
		System.out.println("Digite os dados abaixo: ");
		System.out.println("Matricula: ");
		matricula = input.nextLine();
		System.out.println("Nome: ");
		nome = input.nextLine();
		System.out.println("Data de nascimento(00/00/0000): ");
		dataNascimento = input.nextLine();
		dataNascimentoTime = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		PersonDate pessoa = new PersonDate(matricula,nome,dataNascimentoTime);
		
		usuarios.add(pessoa);
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
