package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Conta;
import ecommerce.model.Produto;

public class EcommerceController {

	public List<Produto> inicializarProdutos() {
		List<Produto> produtos = new ArrayList<>();

		produtos.add(new Produto("Camiseta Casual", 29.99, 1));
		produtos.add(new Produto("Calça Jeans Slim Fit", 49.99,2));
		produtos.add(new Produto("Tênis Esportivo", 79.99,3));
		produtos.add(new Produto("Boné de Algodão", 14.99,4));

		return produtos;
	}

	public void exibirProdutos(List<Produto> produtos) {
		System.out.println("\n--- Produtos Disponíveis ---");

		for (int i = 0; i < produtos.size(); i++) {
			System.out.println((i + 1) + ". ");
			produtos.get(i).exibirInfo();
			System.out.println("------------");
		}

	}

	public Conta criarConta(String nome) {
		return new Conta(nome);
		

	}
	
	private static void adicionarProdutosAoCarrinho() {
		
	
	

	}
}
