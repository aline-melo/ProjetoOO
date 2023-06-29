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

	
}
