package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.Carrinho;
import ecommerce.model.Conta;
import ecommerce.model.Produto;
import ecommerce.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		EcommerceController controller = new EcommerceController();

		Scanner scanner = new Scanner(System.in);
		int opcao, opcaoCarrinho;
		String nome, email, senha, endereco;

		while (true) {
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("                                                     ");
			System.out.println("                     GEM.COM                         ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Visualizar Produtos                  ");
			System.out.println("            3 - Adicionar ao Carrinho                ");
			System.out.println("            4 - Visualizar Carrinho                  ");
			System.out.println("            5 - Finalizar Compra                     ");
			System.out.println("            00 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores válidos!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 00) {

				System.out.println();
				System.out.println("*********************************************************");
				System.out.println("              GEN.COM AGRADECE SUA VISITA                ");
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1: 
				System.out.println("Insira o nome da conta: \n");
				// o nextLine é utilizado aqui para limpar o cache do nextInt da linha 45
				leia.nextLine();
				nome = leia.nextLine();
				System.out.println("Insira o email: \n");
				email = leia.nextLine();
				System.out.println("Insira a senha: \n");
				senha = leia.nextLine();
				System.out.println("Insira o endereço: \n");
				endereco = leia.nextLine();
				controller.criarConta(new Conta(nome, email, senha, endereco));
				keyPress();
				break;
			case 2:
				controller.exibirProdutos();
				keyPress();
				break;
			case 3:
				do {
					System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND);
					controller.exibirProdutos();
					System.out.println("Selecione qual produto deseja adicionar ao carrinho: ");
					opcaoCarrinho = leia.nextInt();
					System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND);
					System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_WHITE_BACKGROUND);
					System.out.println("Digite 0 para sair.");
					System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_WHITE_BACKGROUND);
					if(opcaoCarrinho > 4) {
						System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_WHITE_BACKGROUND);
						System.out.println("Produto número "+ opcaoCarrinho + " não é um produto válido!");
						System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_WHITE_BACKGROUND);
					}
					controller.adicionarProdutosAoCarrinho(opcaoCarrinho);
				} while (opcaoCarrinho != 0);
				keyPress();
				break;
			
			case 4:
				controller.exibirCarrinho();
				keyPress();
				break;
			case 5:
				controller.finalizarCompra();
				keyPress();
				break;
				
			}
		}

		}

	private static void keyPress() {
		try {
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}

	}
}
