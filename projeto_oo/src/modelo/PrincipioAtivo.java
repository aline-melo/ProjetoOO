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
	
	
	/*public String toString() {
	 * return 	
	 *		}
	 */

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
	
	public String toString() {
		return this.getNomePrincipioAtivo()+ this.getNumeroDosagem() + this.getUnidadeMedidaDosagem();
	}
}
