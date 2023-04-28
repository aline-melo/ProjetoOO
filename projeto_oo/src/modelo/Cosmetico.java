package modelo;

public class Cosmetico extends Produto{
	private String cor;
	private String fragrancia;
	private boolean hipoalergenico;
	
	
	public Cosmetico(String nom, String desc,String fabri,double prc, int estoq, 
			Quantidade quant, String c, String frag, boolean hipoaler ) {

		super(nom, desc, fabri,prc, estoq, quant);
		cor = c;
		fragrancia = frag;
		hipoalergenico = hipoaler;
		
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getFragrancia() {
		return fragrancia;
	}


	public void setFragrancia(String fragrancia) {
		this.fragrancia = fragrancia;
	}


	public boolean isHipoalergenico() {
		return hipoalergenico;
	}


	public void setHipoalergenico(boolean hipoalergenico) {
		this.hipoalergenico = hipoalergenico;
	}
	
	
	
	
}
