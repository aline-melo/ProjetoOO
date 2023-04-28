package modelo;

public class Medicamento extends Produto{
	private String tratamento;
	private String tarja;
	private boolean generico;
	private PrincipioAtivo principioAtivo;
	
	
	
	public Medicamento(String nom, String desc, String fabri
			, double prc,int emEst, Quantidade quant, String trat, String tarj, 
			boolean gen, PrincipioAtivo prinAtv) {

		super(nom, desc, fabri, prc, emEst, quant);
		tratamento = trat;
		tarja = tarj;
		generico = gen;
		principioAtivo = prinAtv;
	}

	public String toString() {
		return "\nNome: "+ nome +"\nDescrição: "+ descricao + "\nPreço: " + preco 
				+"\nFabricante: " 
				+fabricante + "\nQuantidade: "+ quantidade.toString() ;
		
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}



	public String getTarja() {
		return tarja;
	}



	public void setTarja(String tarja) {
		this.tarja = tarja;
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

}
