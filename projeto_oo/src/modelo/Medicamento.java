package modelo;

public class Medicamento extends Produto{
	private String tratamento;
	private String tarja;
	private boolean generico;
	private PrincipioAtivo principioAtivo;
	
	
	
	public Medicamento(String nom, String desc, String fabri
			, double prc,int emEst, String quant, String trat, String tarj, 
			boolean gen, PrincipioAtivo prinAtv) {

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
				+"\nPrincipio Ativo: "+ principioAtivo.retornoPrincipioAtivo()
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
	public PrincipioAtivo getPrincipioAtivo() {
		return principioAtivo;
	}
	public void setPrincipioAtivo(PrincipioAtivo principioAtivo) {
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
		if(generico == true) {
			return "Este produto é genérico";
		}
		else
			return "Este produto não é genérico";
	}
	
	
	
	
	
	
	
}
