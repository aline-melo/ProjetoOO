package controle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
		List<String> lista = new ArrayList<String>();
		for(int i = 0; i < d.getLojas().size(); i++ ) {
			if (lista.contains(d.getLojas().get(i).getCidade()) == false) {
				lista.add(d.getLojas().get(i).getCidade());
			}
		}
		String[] listaCidades = new String[lista.size()];
		listaCidades = lista.toArray(listaCidades);
		return (String[]) listaCidades;
		
	}
	public String[] buscaProduto() {
		String[] listaBusca = {"NÃO TÁ PRONTO"};
		return listaBusca;
	}
	
	
	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

	

	

}
