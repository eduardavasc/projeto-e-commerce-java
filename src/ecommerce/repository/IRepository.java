package ecommerce.repository;

import java.util.List;

import ecommerce.model.Produto;

public interface IRepository {

	public List<Produto> inicializarProdutos();
	public void exibirProdutos(List<Produto>produtos);
	public void criarConta();
	public void adicionarProdutosAoCarrinho();
	
}
