package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Carrinho;
import ecommerce.model.Conta;
import ecommerce.model.Produto;

public class EcommerceController {

	Conta conta;
	Carrinho carrinho = new Carrinho(this.listaProdutosCarrinho);
	List<Produto> listaProdutosCarrinho = new ArrayList<>();
	
	public List<Produto> inicializarProdutos() {
		List<Produto> produtos = new ArrayList<>();

		produtos.add(new Produto("Camiseta Casual", 29.99, 1));
		produtos.add(new Produto("Calça Jeans Slim Fit", 49.99, 2));
		produtos.add(new Produto("Tênis Esportivo", 79.99, 3));
		produtos.add(new Produto("Boné de Algodão", 14.99, 4));

		return produtos;
	}

	public void exibirProdutos() {
		List<Produto> produtos = this.inicializarProdutos();
		System.out.println("\n--- Produtos Disponíveis ---");

		for (int i = 0; i < produtos.size(); i++) {
			System.out.println(produtos.get(i).getId() + ". ");
			produtos.get(i).exibirInfo();
			System.out.println("------------");
		}

	}

	public void criarConta(Conta conta) {
		this.conta = conta;
		System.out.println("A conta de " + this.conta.getNome() + " foi criada com sucesso!");
	}
	
	public Conta buscarInfoConta() {
		return conta;
	}
	
	public void adicionarProdutosAoCarrinho(int opcao) {
		List<Produto> produtosDisponiveis = inicializarProdutos();
		for(Produto produto : produtosDisponiveis) {
			if(produto.getId() == opcao) {
				listaProdutosCarrinho.add(produto);
			}
 		}
		carrinho.setListaProduto(listaProdutosCarrinho);
	}
	
	public void exibirCarrinho() {
		carrinho.exibirProdutos();
	}
	
	public void finalizarCompra() {
		carrinho.finalizarCompra();
	}
}
