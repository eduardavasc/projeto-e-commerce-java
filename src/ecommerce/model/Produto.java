package ecommerce.model;

public class Produto {
	private String nome;
	private double preco;
	private int id;
	
	public Produto(String nome, double preco, int id) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void exibirInfo() {
		System.out.println(this.nome + "" + this.preco);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
