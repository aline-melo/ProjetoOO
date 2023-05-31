package controle;
import java.util.ArrayList;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	int aaaaa = d.getLojas().size();
	private ArrayList<Loja> a = d.getLojas();
	
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

	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

}
