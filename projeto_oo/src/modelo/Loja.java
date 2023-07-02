package modelo;

import java.util.ArrayList;

/**
 * Classe que representa uma loja. <br><br>
 * Uma loja possui uma localização, uma cidade e um estoque de {@link Produto produtos}. <br><br>
 * Toda {@link view.TelaLoja TelaLoja} possui uma Loja associada a ela.
 *
 * @author Aline Melo
 * @version 1.0
 * @see Loja#buscar_loja(String)
 * @since 05/2023
 */
public class Loja {
	private String localizacao;
	private String cidade;
	private ArrayList<Produto> estoque;

	/**
	 * Construtor da classe {@link Loja}.
	 * @param local {@link String} do endereço da loja.
	 * @param cid {@link String} da cidade da loja.
	 * @param est {@link ArrayList} de {@link Produto produtos} que compõem o estoque da loja.
	 */
	public Loja(String local, String cid, ArrayList<Produto> est) {
		localizacao = local;
		cidade = cid;
		estoque = est;
	}

	/**
	 * Retorna a localização da loja.
	 * @return {@link String} da localização.
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * Altera a localização da loja.
	 * @param localizacao {@link String} da localização.
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Retorna a cidade da loja.
	 * @return {@link String} da cidade.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Altera a cidade da loja.
	 * @param cidade {@link String} da cidade.
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna o estoque da loja.
	 * @return {@link ArrayList} de {@link Produto produtos} que compõem o estoque da loja.
	 */
	public ArrayList<Produto> getEstoque() {
		if ( estoque == null || estoque.isEmpty() ) {
			estoque = new ArrayList<Produto>();
		}
		return estoque;
	}

	/**
	 * Altera o estoque da loja.
	 * @param estoque {@link ArrayList} de {@link Produto produtos} que compõem o estoque da loja.
	 */
	public void setEstoque(ArrayList<Produto> estoque) {
		this.estoque = estoque;
	}

	/**
	 * Adiciona um {@link Produto produto} ao estoque da loja.
	 * @param produto {@link Produto} a ser adicionado.
	 */
	public void addToEstoque(Produto produto) {
		this.estoque.add(produto);
	}

	/**
	 * Retorna uma {@link ArrayList} com todos os {@link Produto produtos} do estoque da loja. <br>
	 * Diferente de {@link Loja#getEstoque()}, este método retorna uma nova {@link ArrayList} com os mesmos produtos.
	 * Usado quando se deseja listar os produtos da loja sem alterar o estoque.
	 * @return {@link ArrayList} com todos os {@link Produto produtos} do estoque da loja.
	 */
	public ArrayList<Produto> listarEstoque() {
		return new ArrayList<Produto>(this.estoque);
	}

	/**
	 * Busca geral de {@link Produto Produtos} em uma {@link Loja}. <br>
	 * Percorre a lista com todos as {@link Produto produtos} cadastrados e adiciona em uma {@link ArrayList} os
	 * produtos que possuem o termo de busca em seu nome.
	 * <br>
	 * Funciona de forma indêntica a {@link Loja#getEstoque()} quando o termo de busca é uma
	 * {@link String} vazia ou {@code null}.
	 *
	 * @param termo_busca O termo a ser utilizado para a busca.
	 * @return {@link ArrayList} com os {@link Produto produtos} encontradas. Retorna uma {@link ArrayList} vazia se
	 * nenhum Produto foi encontrado.
	 * @see Loja#listarEstoque()
	 * @see Loja#getEstoque()
	 * @see view.TelaLoja
	 * @since 06/2023
	 */
	public ArrayList<Produto> buscar_loja(String termo_busca) {
		ArrayList<Produto> lista_retorno = new ArrayList<Produto>();
		ArrayList<Produto> estoque = this.getEstoque();

		for (Produto produto : estoque) {
			String nome = produto.getNome();
			if ( nome.toLowerCase().contains(termo_busca.toLowerCase()) ) {
				lista_retorno.add(produto);
			}
		}
		return lista_retorno;
	}

}