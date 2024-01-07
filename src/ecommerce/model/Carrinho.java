package ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private List<Produto> listaProduto;
	private double valorTotal;
	
	public Carrinho(List<Produto> listaProduto) {
		super();
		this.listaProduto = listaProduto;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public double exibirValor() {
		double valorTotal = 0;
		for (Produto produto : this.listaProduto) {
			valorTotal += produto.getPreco();

		}
		return valorTotal;

	}

	public void exibirProdutos() {
		System.out.println("----- CARRINHO -----");
		for (Produto produto : this.listaProduto) {
			System.out.println(produto.getNome() + " - Valor: " + produto.getPreco());
		}
		System.out.println("Valor total do carrinho: " + this.exibirValor());
	}

	public void finalizarCompra() {
		System.out.println("\n--- Finalizando Compra ---");
		exibirProdutos();
		System.out.println("Total: R$" + exibirValor());
		System.out.println("Compra finalizada. Obrigado!");
		limpar();
	}
	
	private void limpar() {
		this.listaProduto = new ArrayList<Produto>();
	}
}
