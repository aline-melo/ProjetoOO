package modelo;

public class Utilidade extends Produto{
	protected boolean digital;
	protected boolean descartavel;
	protected boolean curativo;
	
	public Utilidade (String nom, String desc,String fabri,double prc, int emEst, 
			Quantidade quant, boolean dig, boolean descart, boolean curat) {
		
		super(nom, desc, fabri,prc, emEst, quant);
		digital = dig;
		descartavel = descart;
		curativo = curat;
	}
	
	public String toString() {
		return "\nNome: " + nome + "\nPreço:"+ preco+"\nDescrição: " + descricao +"\nFabricante:"+ fabricante +"\nQuantidade:" + quantidade.toString();	
	}
	
	
	public boolean isDigital() {
		return digital;
	}
	public void setDigital(boolean digital) {
		this.digital = digital;
	}
	public boolean isDescartavel() {
		return descartavel;
	}
	public void setDescartavel(boolean descartavel) {
		this.descartavel = descartavel;
	}

	public boolean isCurativo() {
		return curativo;
	}

	public void setCurativo(boolean curativo) {
		this.curativo = curativo;
	}
	
	
	
	public String toStringCurativo() {
		if(curativo = true) {
			return "Este produto é um tipo de curativo";
		}
		else
			return "Este produto não é um tipo de curativo";
	}
	public String toStringDigital() {
		if(digital = true) {
			return "Este produto é um tipo de equipamento digital";
		}
		else
			return "Este produto não é um tipo de equipamento digital";
	}
	public String toStringDescartavel() {
		if(descartavel = true) {
			return "Este é um produto descartável";
		}
		else
			return "Este não é um produto descartável";
	}
}
