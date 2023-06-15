package modelo;

import java.util.ArrayList;
import java.util.List;

public class Dados {
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	//private int qtdLojas = lojas.size();
	
	
	public void criarDados() {

		Loja lojinhaDeEsquina = new Loja("Esquina da 708N", "Brasília", new ArrayList<>());
		Loja outraLoja = new Loja("Shopping do gama", "Gama", new ArrayList<>());
		Loja lojaNoroeste = new Loja("Noroeste", "Brasília", new ArrayList<>());


		Medicamento medicamento1Teste = new Medicamento("serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO.\n LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO."
				, "torrent pharma", 148.57, 20, "30 comprimidos", "Anti-depressivo", "Vermelha", false, "principioAtivoSerenataTeste");


		Cosmetico cosmetico1Teste = new Cosmetico("Batom líquido super stay matte ink",
				"Batom Líquido matte de alta fixação", "MAC", 119.90, 10,
				"1 unidade", "Vinho", null, false);


		Medicamento medicamento2Teste = new Medicamento("Decongex", "Xarope expectorante", "Aché", 20.89, 10,
				"120 ml", "expectorante", "Sem tarja", false,
				"principioAtivoXaropeTeste");

		Cosmetico cosmetico2Teste = new Cosmetico("Poziny",
				"po", "avon", 119.90, 10,
				"1 unidade", "creme", null, true);


		lojinhaDeEsquina.addToEstoque(cosmetico1Teste);
		lojinhaDeEsquina.addToEstoque(medicamento1Teste);
		lojaNoroeste.addToEstoque(medicamento2Teste);
		lojaNoroeste.addToEstoque(cosmetico2Teste);

		lojas.add(lojinhaDeEsquina);
		lojas.add(outraLoja);
		lojas.add(lojaNoroeste);
		//int qtdLojas = lojas.size();


	}


	public ArrayList<Loja> getLojas() {
		return lojas;
	}

	public ArrayList<Loja> buscar_lojas(String termo) {
		ArrayList<Loja> return_list = new ArrayList<Loja>();
		for (Loja y : lojas) {
			if ( y.getLocalizacao().contains(termo) || y.getCidade().contains(termo) ) {
				return_list.add(y);
			}
		}
		return return_list;
	}

	public ArrayList<Produto> buscar_tudo(String termo) {
		ArrayList<Produto> return_list = new ArrayList<Produto>();
		for (Loja y : lojas) {
			ArrayList<Produto> achados = y.buscar_loja(termo);
			return_list.addAll(achados);
		}
		return return_list;
	}

	public ArrayList<Produto> listar_tudo() {
		ArrayList<Produto> return_list = new ArrayList<Produto>();
		for (Loja y : lojas) {
			ArrayList<Produto> achados = y.listarEstoque();
			return_list.addAll(achados);
		}
		return return_list;
	}


	public void setLojas(ArrayList<Loja> lojas) {
		this.lojas = lojas;
	}


}
