package modelo;

public class Medicamento extends Produto{
	private String tratamento;
	private String tarja;
	private boolean generico;
	private String principioAtivo;
	
	
	
	public Medicamento(String nom, String desc, String fabri
			, double prc,int emEst, String quant, String trat, String tarj, 
			boolean gen, String prinAtv) {

		super(nom, desc, fabri, prc, emEst, quant);
		tratamento = trat;
		tarja = tarj;
		generico = gen;
		principioAtivo = prinAtv;
	}

	public String toString() {
		return "\nNome: "+ nome 
				+"\nDescrição: "+ descricao 
				+ "\nPreço: " + preco 
				+"\nFabricante: " +fabricante 
				+ "\nQuantidade: "+ quantidade 
				+ "\nTarja :"+ retornoTarja() 
				+"\nPrincipio Ativo: "+ principioAtivo
				+ "\nTratamento: "+ tratamento 
				+"\nGenerico: "+ retornoGenerico()
				+"\nEm estoque: " + emEstoque;
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

	
	
	
	public String retornoTarja() {
		if (tarja == null) {
			return "Este produto não possui tarja registrada";
		}
		else {
			return tarja;
		}
	}
	public String retornoGenerico() {
		if (generico) {
			return "Este produto é genérico";
		} else
			return "Este produto não é genérico";
	}
	
	
	
	
	
	
	
}
