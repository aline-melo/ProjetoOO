package modelo;
/**
 * Classe que representa um produto. <br><br>
 * Todo produto possui um nome, descrição, fabricante, preço, quantidade em estoque e quantidade por embalagem. <br><br>
 * É uma classe abstrata, portanto não pode ser instanciada diretamente. <br>
 * Para instanciar um produto, use os contrutores de suas subclasses: {@link Cosmetico#Cosmetico(String, String, String,
 * double, int, String, String, String, boolean)  Cosmetico} e {@link Medicamento#Medicamento(String, String, String,
 * double, int, String, String, String, boolean, String)  Medicamento}. <br><br>
 * Todo produto existe somente no estoque de uma {@link Loja loja}.
 *
 * @author Aline Melo
 * @version 1.0
 * @since 05/2023
 */
public abstract class Produto {
	protected String nome;
	protected String descricao;
	protected String fabricante;
	protected double preco;
	protected int emEstoque;
	protected String quantidade;

	/**
	 * Construtor da classe abstrata {@link Produto}.
	 *
	 * @param nom   {@link String} do nome.
	 * @param desc  {@link String} da descrição.
	 * @param fabri {@link String} com o nome do fabricante.
	 * @param prc   {@link Double} do preço.
	 * @param emEst {@link Integer Int} da quantidade em estoque.
	 * @param quant {@link String} com a quantidade por embalagem.
	 * @see Cosmetico
	 * @see Medicamento
	 * @see Cosmetico#Cosmetico(String, String, String, double, int, String, String, String, boolean)  new Cosmetico
	 * @see Medicamento#Medicamento(String, String, String, double, int, String, String, String, boolean, String)  new Medicamento
	 */
	public Produto(String nom, String desc, String fabri
			, double prc, int emEst, String quant) {
		nome = nom;
		descricao = desc;
		fabricante = fabri;
		preco = prc;
		emEstoque = emEst;
		quantidade = quant;
	}

	/**
	 * Retorna o preço do produto.
	 *
	 * @return {@link Double} do preço.
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Altera o preço do produto.
	 *
	 * @param preco {@link Double} do preço.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Retorna o nome do produto.
	 *
	 * @return {@link String} do nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do produto.
	 *
	 * @param nome {@link String} do nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a descrição do produto.
	 *
	 * @return {@link String} da descrição.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Altera a descrição do produto.
	 *
	 * @param descricao {@link String} da descrição.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Retorna o nome do fabricante do produto.
	 *
	 * @return {@link String} do nome do fabricante.
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * Altera o nome do fabricante do produto.
	 *
	 * @param fabricante {@link String} do nome do fabricante.
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * Retorna a quantidade em estoque do produto.
	 *
	 * @return {@link Integer Int} da quantidade em estoque.
	 */
	public int getEmEstoque() {
		return emEstoque;
	}

	/**
	 * Altera a quantidade em estoque do produto.
	 *
	 * @param emEstoque {@link Integer Int} da quantidade em estoque.
	 */
	public void setEmEstoque(int emEstoque) {
		this.emEstoque = emEstoque;
	}

	/**
	 * Retorna a quantidade por embalagem do produto.
	 *
	 * @return {@link String} da quantidade por embalagem.
	 */
	public String getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera a quantidade por embalagem do produto.
	 *
	 * @param quantidade {@link String} da quantidade por embalagem.
	 */
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

}