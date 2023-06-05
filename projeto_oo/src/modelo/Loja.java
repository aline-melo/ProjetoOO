package modelo;

import java.util.ArrayList;

public class Loja {
	private String localizacao;
	private String cidade;
	private ArrayList<Produto> estoque  = new ArrayList<Produto>();
	
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
		return estoque;
	}

	public void setEstoque(ArrayList<Produto> estoque) {
		this.estoque = estoque;
	}


	public ArrayList listarEstoque() {
		ArrayList lista_retorno = new ArrayList();
		for (int i = 0; i < this.estoque.size(); i++) {
			lista_retorno.add(this.estoque.get(i));
		}
		return lista_retorno;
	}

	public ArrayList buscar_loja(String termo_busca) {
		ArrayList lista_retorno = new ArrayList();
		ArrayList estoque = this.getEstoque();

		for (int i = 0; i < estoque.size(); i++) {
			Produto x = (Produto) estoque.get(i);
			String nome = x.getNome();
			if (nome.toLowerCase().contains(termo_busca.toLowerCase())) {
				lista_retorno.add(x);
			}
		}
		return lista_retorno;
	}

}