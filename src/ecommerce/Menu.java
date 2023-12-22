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
		int opcao;
		String nomeDaConta;
		Conta conta;

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
				System.out.println("Insira o nome da conta: ");
				nomeDaConta = leia.nextLine();
				leia.nextLine();
				conta = controller.criarConta(nomeDaConta);
				System.out.println(conta.getNome());
				keyPress();
				break;
			case 2:
				List<Produto> listaProdutos = controller.inicializarProdutos();
				controller.exibirProdutos(listaProdutos);
				keyPress();
				break;
			case 3:
				List<Produto> produtosCarrinho0 = controller.inicializarProdutos();
				Carrinho carrinho0 = new Carrinho(produtosCarrinho0);
				carrinho0.setListaProduto(produtosCarrinho0);
				keyPress();
				break;
			
			case 4:
				List<Produto> produtosCarrinho = controller.inicializarProdutos();
				Carrinho carrinho = new Carrinho(produtosCarrinho);
				carrinho.exibirProdutos();
				keyPress();
				break;
			case 5:
				List<Produto> produtosCarrinho2 = controller.inicializarProdutos();
				Carrinho carrinho2 = new Carrinho(produtosCarrinho2);
				carrinho2.finalizarCompra();
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
