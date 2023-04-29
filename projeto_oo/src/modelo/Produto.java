package modelo;

public abstract class Produto {
	protected String nome;
	protected String descricao;
	protected String fabricante;
	protected double preco;
	protected int emEstoque;
	protected Quantidade quantidade;
	
		public Produto(String nom, String desc, String fabri
			, double prc,int emEst, Quantidade quant) {
			nome = nom;
			descricao = desc;
			fabricante = fabri;
			preco = prc;
			emEstoque = emEst;
			quantidade = quant;
		}
		
		
		
	public double getPreco() {
			return preco;
		}



		public void setPreco(double preco) {
			this.preco = preco;
		}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getEmEstoque() {
		return emEstoque;
	}

	public void setEmEstoque(int emEstoque) {
		this.emEstoque = emEstoque;
	}



	public Quantidade getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Quantidade quantidade) {
		this.quantidade = quantidade;
	}

	
	
}