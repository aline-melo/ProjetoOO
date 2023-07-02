package modelo;
/**
 * Classe que representa um medicamento. <br> Herda características básicas de {@link Produto}.<br><br>
 * Possui atributos específicos como tipo de tratamento, tarja, princípios ativos e se é genérico. <br><br>
 * Toda {@link view.TelaMedicamento TelaMedicamento} possui um Medicamento associado a ela.
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
	 *
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

	
	public String getTarja() {
		return tarja;
	}
	public void setTarja(String tarja) {
		this.tarja = tarja;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public boolean isGenerico() {
		return generico;
	}
	public void setGenerico(boolean generico) {
		this.generico = generico;
	}
	public String getPrincipioAtivo() {
		return principioAtivo;
	}
	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	
}
