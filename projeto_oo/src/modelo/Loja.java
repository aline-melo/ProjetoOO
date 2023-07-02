package modelo;

import java.util.ArrayList;

public class Loja {
	private String localizacao;
	private String cidade;
	private ArrayList<Produto> estoque;
	
	public Loja (String local, String cid, ArrayList<Produto> est) {
		localizacao = local;
		cidade = cid;
		estoque = est;
	}

	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public ArrayList<Produto> getEstoque() {
		if ( estoque == null || estoque.isEmpty() ) {
			estoque = new ArrayList<Produto>();
		}
		return estoque;
	}


	public void setEstoque(ArrayList<Produto> estoque) {
		this.estoque = estoque;
	}

	public void addToEstoque(Produto produto) {
		this.estoque.add(produto);
	}

	public void addToEstoque(ArrayList<Produto> lista) {
		this.estoque.addAll(lista);
	}

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
	 * @author Caio Pacheco
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