package modelo;
/**
 * Classe que representa um medicamento. <br> Herda características básicas de {@link Produto}.<br><br>
 * Possui atributos específicos como tipo de tratamento, tarja, princípios ativos e se é genérico. <br><br>
 * Toda {@link view.TelaMedicamento TelaMedicamento} possui um Medicamento associado a ela.
 *
 * @author Aline Melo
 * @version 1.0
 * @since 05/2023
 */
public class Medicamento extends Produto {
	private String tratamento;
	private String tarja;
	private boolean generico;
	private String principioAtivo;

	/**
	 * Construtor da classe {@link Medicamento}.<br>
	 * Chama o construtor da classe pai {@link Produto#Produto(String, String, String, double, int, String) Produto}
	 * e inicializa os atributos específicos.
	 * @param nom     {@link String} do nome.
	 * @param desc    {@link String} da descrição.
	 * @param fabri   {@link String} com o nome do fabricante.
	 * @param prc     {@link Double} do preço.
	 * @param emEst   {@link Integer Int} da quantidade em estoque.
	 * @param quant   {@link String} com a quantidade por embalagem.
	 * @param trat    {@link String} do tipo de tratamento.
	 * @param tarj    {@link String} da tarja.
	 * @param gen     {@link Boolean} se o medicamento é genérico.
	 * @param prinAtv {@link String} do princípio ativo.
	 * @see Produto#Produto(String, String, String, double, int, String)  new Produto
	 * @see view.TelaMedicamento
	 */
	public Medicamento(String nom, String desc, String fabri
			, double prc, int emEst, String quant, String trat, String tarj,
					   boolean gen, String prinAtv) {

		super(nom, desc, fabri, prc, emEst, quant);
		tratamento = trat;
		tarja = tarj;
		generico = gen;
		principioAtivo = prinAtv;
	}

	/**
	 * Retorna a tarja do medicamento.
	 *
	 * @return {@link String} da tarja.
	 */
	public String getTarja() {
		return tarja;
	}

	/**
	 * Altera a tarja do medicamento.
	 *
	 * @param tarja {@link String} da tarja.
	 */
	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	/**
	 * Retorna o tipo de tratamento do medicamento.
	 *
	 * @return {@link String} do tipo de tratamento.
	 */
	public String getTratamento() {
		return tratamento;
	}

	/**
	 * Altera o tipo de tratamento do medicamento.
	 *
	 * @param tratamento {@link String} do tipo de tratamento.
	 */
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	/**
	 * Retorna se o medicamento é genérico.
	 *
	 * @return {@link Boolean} se o medicamento é genérico.
	 */
	public boolean isGenerico() {
		return generico;
	}

	/**
	 * Altera se o medicamento é genérico.
	 *
	 * @param generico {@link Boolean} se o medicamento é genérico.
	 */
	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	/**
	 * Retorna o princípio ativo do medicamento.
	 *
	 * @return {@link String} do princípio ativo.
	 */
	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	/**
	 * Altera o princípio ativo do medicamento.
	 *
	 * @param principioAtivo {@link String} do princípio ativo.
	 */
	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}


}
