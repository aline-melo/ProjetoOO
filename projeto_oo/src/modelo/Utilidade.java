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
		return "Nome: " + nome + ", Preço:"+ preco+", Descrição: " + descricao +", Fabricante:"+ fabricante +", Quantidade:" + quantidade.toString();	
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
	
}
