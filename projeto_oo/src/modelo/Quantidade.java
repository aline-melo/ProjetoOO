package modelo;

public class Quantidade {
	private int numQuant;
	private String unidMedidaQuant;
	
	

	public Quantidade (int num, String unid) {
		numQuant = num;
		unidMedidaQuant = unid;		
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
	
public String toString() {
	return this.numQuant +this.unidMedidaQuant;
}
	
	
	
}