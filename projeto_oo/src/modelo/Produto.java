package modelo;
/**
 * Classe que representa um produto. <br><br>
 * Todo produto possui um nome, descrição, fabricante, preço, quantidade em estoque e quantidade por embalagem. <br><br>
 * É uma classe abstrata, portanto não pode ser instanciada diretamente. <br>
 * Para instanciar um produto, use os contrutores de suas subclasses: {@link Cosmetico#Cosmetico(String, String, String,
 * double, int, String, String, String, boolean)  Cosmetico} e {@link Medicamento#Medicamento(String, String, String,
 * double, int, String, String, String, boolean, String)  Medicamento}. <br><br>
 * Todo produto existe somente no estoque de uma {@link Loja loja}.
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
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}	
}