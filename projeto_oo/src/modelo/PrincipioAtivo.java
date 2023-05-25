package modelo;

public class PrincipioAtivo {
	private String nomePrincipioAtivo;
	private String numeroDosagem;
	private String unidadeMedidaDosagem;
	
	public PrincipioAtivo (String nomPrinAtv, String numDos, String unidMedDos) {
		nomePrincipioAtivo = nomPrinAtv;
		numeroDosagem = numDos;
		unidadeMedidaDosagem = unidMedDos;
	}
	
	
	public String getNomePrincipioAtivo() {
		return nomePrincipioAtivo;
	}
	public void setNomePrincipioAtivo(String nomePrincipioAtivo) {
		this.nomePrincipioAtivo = nomePrincipioAtivo;
	}
	public String getNumeroDosagem() {
		return numeroDosagem;
	}
	public void setNumeroDosagem(String numeroDosagem) {
		this.numeroDosagem = numeroDosagem;
	}
	public String getUnidadeMedidaDosagem() {
		return unidadeMedidaDosagem;
	}
	public void setUnidadeMedidaDosagem(String unidadeMedidaDosagem) {
		this.unidadeMedidaDosagem = unidadeMedidaDosagem;
	}
	
	
	
	
	
	public String retornoPrincipioAtivo() {
		String retorno = "";
		int i = 0;
		String[] arrOfNome = getNomePrincipioAtivo().split(",");
		String[] arrOfNum = getNumeroDosagem().split(",");
		String[] arrOfUnid = getUnidadeMedidaDosagem().split(",");
		while (i != arrOfNome.length) {
			retorno = retorno.concat(arrOfNome[i] + arrOfNum[i] + arrOfUnid[i] + " ");
			i++;
		}
		return retorno;
	}
}