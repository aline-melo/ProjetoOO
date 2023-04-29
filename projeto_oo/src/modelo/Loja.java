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
		return "Loja OO Drogarias localização " + localizacao
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
	
	
	//public void add(Produto produto) {
		//this.estoque[estoque.size++] = produto;
        //return true;
	//}
	
	public void listarEstoque(ArrayList<Produto> estoque) {
		for (int i = 0; i < estoque.size(); i++) {
		      System.out.println(estoque.get(i).toString());
		    }
		
	}
}
	
	
	

