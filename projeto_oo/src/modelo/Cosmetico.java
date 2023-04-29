package modelo;

public class Cosmetico extends Produto{
	private String cor;
	private String fragrancia;
	private boolean hipoalergenico;
	
	
	public Cosmetico(String nom, String desc,String fabri,double prc, int emEstoq, 
			Quantidade quant, String c, String frag, boolean hipoaler ) {

		super(nom, desc, fabri,prc, emEstoq, quant);
		cor = c;
		fragrancia = frag;
		hipoalergenico = hipoaler;
		
	}
	public String toString() {
		return "\nNome:" + nome 
				+ "\nDescrição:" + descricao 
				+"\nFabricante:"+ fabricante
				+"\nPreço:" + preco 
				+ "\nQuantidade:" + quantidade 
				+"\nCor:"+ cor 
				+"\nFragrância:"+ getFragrancia()
				+"\nHipoalergênico:" + isHipoalergenico()
				;
	}

	
	//gets e sets
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
	
	
	
	//médotos que eventualmente serão movidos para a camada controle
	
	public String toStringCor() {
		if (cor == null) {
			return "Este produto não tem cor registrada";
		}
		else
		return cor;
	}
	public String toStringFragrancia() {
		if (fragrancia == null){
			return "Este Produto não possui fragrância.";
		}
		else{
			return fragrancia;
		}
	}
	public String toStringHipoalergenico() {
		if (hipoalergenico = true) {
			return "Este produto é hipoalergênico";
			}
		else 
			return "Este produto não é hipoalergênico";
			 
		
	}
}
