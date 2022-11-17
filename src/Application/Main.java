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
		int opcao = -1;
		do {
			opcao = showMenu();
			redirect(opcao,usuarios);
		}while(opcao != 0);
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
					PersonDate usuario = localizar_usuario(pessoa); 
					if(usuario.getName() != null) {
						cadastrarEndereco(usuario);
					}
				}
				break;
			case 3:
				if(confirmOpcaoEscolhida("consultar usuario")) {
					localizar_usuario(pessoa).toString();
				}
				break;
			case 0:
				System.out.println("Sistema finalizado com sucesso!");
				break;
			default:
				System.out.println("Opção invalida!");
				break;
		}
	}
	public static PersonDate localizar_usuario(ArrayList <PersonDate> pessoa) {
		Scanner input = new Scanner(System.in);
		PersonDate resultado_busca = new PersonDate();
		boolean confirmacao_usuario = true;
		
		do {
			System.out.println("Digite a matricula do usuario: ");
			String matricula = input.nextLine();
			int opcao = 0;
			for(PersonDate usuarios : pessoa) {
				if(usuarios.getMatricula().equalsIgnoreCase(matricula)) {
					resultado_busca = usuarios;
				}
			}
			if(resultado_busca.getName() != null) {
				System.out.println("Usuario desejado é: " + resultado_busca.getName() + "?");
				System.out.printf("1 - Sim%n2 - Não%n");
				opcao = input.nextInt();
				input.nextLine();
				if(opcao == 1) {
					confirmacao_usuario = false;
				}
			}else {
				System.out.println("Usuario não localizado!");
				System.out.printf("Deseja tentar novamente?%n1 - Sim%n2 - Não%n");
				opcao = input.nextInt();
				if(opcao != 1) {
					confirmacao_usuario = false;
				}
				input.nextLine();
			}
		}while(confirmacao_usuario);
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
