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
	 
	public String toString() {
		return "A loja OO Drogarias na localização " + localizacao
				+ " na cidade de "+ cidade
				+", possui em seu estoque:";
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

	public ArrayList<Produto> buscar_loja(String termo_busca) {
		ArrayList<Produto> lista_retorno = new ArrayList<Produto>();
		ArrayList<Produto> estoque = this.getEstoque();

		for (Produto produto : estoque) {
			String nome = produto.getNome();
			if (nome.toLowerCase().contains(termo_busca.toLowerCase())) {
				lista_retorno.add(produto);
			}
		}
		return lista_retorno;
	}

}