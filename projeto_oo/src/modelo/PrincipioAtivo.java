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
		String[] arrOfNome = this.getNomePrincipioAtivo().split(",");
		String[] arrOfNum = this.getNumeroDosagem().split(",");
		String[] arrOfUnid = this.getUnidadeMedidaDosagem().split(",");
		while (i != arrOfNome.length) {
			retorno = retorno.concat(arrOfNome[i]);
			retorno = retorno.concat(arrOfNum[i]);
			retorno = retorno.concat(arrOfUnid[i]);
			retorno = retorno.concat(", ");
			i++;
		}
		return retorno;
	}
}