package modelo;

/**
 * Classe que representa um cosmético. Herda características básicas de {@link Produto}.<br><br>
 * Possui atributos específicos como cor, fragrância e se é hipoalergênico. <br><br>
 * Toda {@link view.TelaComestico TelaCosmetico} possui um Cosmético associado a ela.
 *
 * @author Aline Melo
 * @version 1.0
 * @since 05/2023
 */
public class Cosmetico extends Produto {
	private String cor;
	private String fragrancia;
	private boolean hipoalergenico;


	/**
	 * Construtor da classe {@link Cosmetico}.
	 *
	 * @param nom      {@link String} do nome.
	 * @param desc     {@link String} da descrição.
	 * @param fabri    {@link String} com o nome do fabricante.
	 * @param prc      {@link Double} do preço.
	 * @param emEstoq  {@link Integer Int} da quantidade em estoque.
	 * @param quant    {@link String} com a quantidade por embalagem.
	 * @param c        {@link String} da cor do cosmético.
	 * @param frag     {@link String} com a fragância.
	 * @param hipoaler {@link Boolean} se o cosmético é hipoalergênico.
	 * @see view.TelaComestico
	 */
	public Cosmetico(String nom, String desc, String fabri, double prc, int emEstoq,
					 String quant, String c, String frag, boolean hipoaler) {
		super(nom, desc, fabri, prc, emEstoq, quant);
		cor = c;
		fragrancia = frag;
		hipoalergenico = hipoaler;
	}

	/**
	 * Retorna a cor do cosmético.
	 *
	 * @return {@link String} da cor.
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Altera a cor do cosmético.
	 *
	 * @param cor {@link String} da cor.
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Retorna a fragrância do cosmético.
	 *
	 * @return {@link String} da fragrância.
	 */
	public String getFragrancia() {
		return fragrancia;
	}

	/**
	 * Altera a fragrância do cosmético.
	 *
	 * @param fragrancia {@link String} da fragrância.
	 */
	public void setFragrancia(String fragrancia) {
		this.fragrancia = fragrancia;
	}

	/**
	 * Retorna se o cosmético é hipoalergênico.
	 *
	 * @return {@link Boolean} se é hipoalergênico.
	 */
	public boolean isHipoalergenico() {
		return hipoalergenico;
	}

	/**
	 * Altera se o cosmético é hipoalergênico.
	 *
	 * @param hipoalergenico {@link Boolean} se é hipoalergênico.
	 */
	public void setHipoalergenico(boolean hipoalergenico) {
		this.hipoalergenico = hipoalergenico;
	}

}
