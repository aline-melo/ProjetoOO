package modelo;

public class Quantidade {
	private int numQuant;
	private String unidMedidaQuant;
	
	public Quantidade (int num, String unid) {
		numQuant = num;
		unidMedidaQuant = unid;		
	}
	
	
	public String retornoQuantidade() {
		if (numQuant <= 1) {
			return "Valor unitário";
		}
		else {
			return this.numQuant +this.unidMedidaQuant;
		}
	}
		
	
	public int getNumQuant() {
		return numQuant;
	}
	public void setNumQuant(int numQuant) {
		this.numQuant = numQuant;
	}
	public String getUnidMedidaQuant() {
		return unidMedidaQuant;
	}
	public void setUnidMedidaQuant(String unidMedidaQuant) {
		this.unidMedidaQuant = unidMedidaQuant;
	}
}