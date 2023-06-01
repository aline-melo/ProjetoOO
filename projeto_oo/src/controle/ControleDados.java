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
		String[] listaBusca = {"OuR SoNg iS ThE SlAmMiNg sCrEeN DoOr\n",
				"sNeAkIn' OuT LaTe, TaPpInG On yOuR WiNdOw\n",
				"wHeN We'rE On tHe pHoNe, AnD YoU TaLk rEaL SlOw\n",
				"'CaUsE It's lAtE, aNd yOuR MaMa dOn't kNoW\n",
				"OuR SoNg iS ThE WaY YoU LaUgH\n",
				"ThE FiRsT DaTe, \"mAn, I DiDn't kIsS HeR, aNd i sHoUlD HaVe\"\n",
				"AnD WhEn i gOt hOmE, 'FoRe i sAiD, \"AmEn\"\n",
				"AsKiNg gOd iF He cOuLd pLaY It aGaIn"};
		return listaBusca;
	}
	
	
	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

	

	

}
