package controle;
import java.util.ArrayList;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.criarDados();
	}
	
	public String[] listarLojas () {	
		String[] listaLojas = new String[d.getLojas().size()];
		
		for(int i = 0; i < d.getLojas().size(); i++) {
			listaLojas[i] = d.getLojas().get(i).getLocalizacao()+ ", "+ d.getLojas().get(i).getCidade();
		}
		return listaLojas;
	}
	
	public String[] listarCidades() {
		String[] listaCidades = new String[d.getLojas().size()];
		
		int j = 0;
		for(int i = 0; i < d.getLojas().size(); i++ ) {
			if (listaCidades[j] != d.getLojas().get(i).getCidade()) {
				j++;
				listaCidades[j] = d.getLojas().get(i).getCidade();
			}

		}
		return listaCidades;
	}
	public String[] buscaProduto() {
		String[] listaBusca = {"xispa que ainda não tá pronto"};
		return listaBusca ;
	}
	
	
	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

	

	

}
