package modelo;

public class Loja {
	private String localizacao;
	private String cidade;
	private Produto[] estoque = new Produto[50];
	
	public Loja (String local, String cid, Produto[] est) {
		localizacao = local;
		cidade = cid;
		estoque = est;
	}
	 
	public String toString() {
		return "Loja OO Drogarias localização " + localizacao
				+ " na cidade de "+ cidade
				+", possui em seu estoque:\n"+ estoque;
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
	public Produto[] getEstoque() {
		return estoque;
	}
	public void setEstoque(Produto[] estoque) {
		this.estoque = estoque;
	}
	
	
	public void add(Produto produto) {
		int index = estoque.length;
		this.estoque[index++] = produto;
	}
	
	public void 
	
}
