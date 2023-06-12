package modelo;

import java.util.ArrayList;
import java.util.List;

public class Dados {
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	//private int qtdLojas = lojas.size();
	
	
	public void criarDados() {
		ArrayList<Produto> estoqueLojinha = new ArrayList<Produto>();
		Loja lojinhaDeEsquina = new Loja("Esquina da 708N", "Brasília", estoqueLojinha);
		ArrayList<Produto> outroestoque = new ArrayList<Produto>();
		Loja outraLoja = new Loja("Shopping do gama", "Gama", outroestoque);
		ArrayList<Produto> estoqueNoroeste = new ArrayList<Produto>();
		Loja lojaNoroeste = new Loja("Noroeste", "Brasília", estoqueNoroeste);


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

		estoqueLojinha.add(cosmetico1Teste);
		estoqueLojinha.add(medicamento1Teste);
		estoqueLojinha.add(medicamento2Teste);
		estoqueNoroeste.add(cosmetico2Teste);
		lojas.add(lojinhaDeEsquina);
		lojas.add(outraLoja);
		lojas.add(lojaNoroeste);
		//int qtdLojas = lojas.size();


	}


	public ArrayList<Loja> getLojas() {
		return lojas;
	}

	public ArrayList<Produto> buscar_tudo(String termo) {
		ArrayList<Produto> return_list = new ArrayList<Produto>();
		for (int i = 0; i < lojas.size(); i++) {
			Loja y = lojas.get(i);
			ArrayList<Produto> achados = y.buscar_loja(termo);
			return_list.addAll(achados);
		}
		return return_list;
	}

	public ArrayList<Produto> listar_tudo() {
		ArrayList<Produto> return_list = new ArrayList<Produto>();
		for (int i = 0; i < lojas.size(); i++) {
			Loja y = lojas.get(i);
			ArrayList<Produto> achados = y.listarEstoque();
			return_list.addAll(achados);
		}
		return return_list;
	}

	public String[] listarCidades() {
		List<String> lista = new ArrayList<String>();
		for (int i = 0; i < lojas.size(); i++) {
			if (!lista.contains(lojas.get(i).getCidade())) {
				lista.add(lojas.get(i).getCidade());
			}
		}
		String[] listaCidades = new String[lista.size()];
		listaCidades = lista.toArray(listaCidades);
		return (String[]) listaCidades;
	}

	public String[] listarLojas() {
		String[] listaLojas = new String[lojas.size()];

		for (int i = 0; i < lojas.size(); i++) {
			listaLojas[i] = lojas.get(i).getLocalizacao() + ", " + lojas.get(i).getCidade();
		}
		return listaLojas;
	}

	public void setLojas(ArrayList<Loja> lojas) {
		this.lojas = lojas;
	}


}
