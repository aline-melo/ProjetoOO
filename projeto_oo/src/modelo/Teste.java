package modelo;

import java.util.ArrayList;
//import controle.*;

public class Teste {
	static Loja lojinhaDeEsquina;
	static Loja lojinhaBarata;
	static ArrayList<Produto> estoqueLojinha;
	static ArrayList<Produto> estoqueBarato;
	static Medicamento medicamento1Teste;
	static Medicamento medicamento2Teste;
	static Cosmetico cosmetico1Teste;
	static Cosmetico cosmetico2Teste;


	public static void main(String[] args) {

		ArrayList<Produto> estoqueLojinha = new ArrayList<Produto>();
		ArrayList<Produto> estoqueBarato = new ArrayList<Produto>();
		Dados dados_teste = new Dados();
		dados_teste.criarDados();

		lojinhaDeEsquina = new Loja("Esquina da 708N", "Brasília", estoqueLojinha);
		lojinhaBarata = new Loja("Esquina da 502N", "Brasília", estoqueBarato);

		medicamento1Teste = new Medicamento("serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO.\n LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO."
				, "torrent pharma", 148.57, 20, "30 comprimidos", "Anti-depressivo", "Vermelha", false, "principioAtivoSerenataTeste");


		cosmetico1Teste = new Cosmetico("Batom líquido super stay matte ink",
				"Batom Líquido matte de alta fixação", "MAC", 119.90, 10,
				"1 unidade", "Vinho", null, false);


		medicamento2Teste = new Medicamento("Decongex", "Xarope expectorante", "Aché", 20.89, 10,
				"120 ml", "expectorante", "Sem tarja", false,
				"principioAtivoXaropeTeste");

		cosmetico2Teste = new Cosmetico("Poziny",
				"po", "avon", 119.90, 10,
				"1 unidade", "creme", null, false);


		estoqueLojinha.add(cosmetico1Teste);
		estoqueLojinha.add(medicamento1Teste);
		estoqueLojinha.add(medicamento2Teste);
		estoqueBarato.add(medicamento1Teste);
		estoqueBarato.add(cosmetico2Teste);


		ArrayList<Produto> lista_busca;
		//lista_busca = dados_teste.getLojas().get(0).buscar_loja("o");
		lista_busca = dados_teste.buscar_tudo("e");
		System.out.println("\nResultado da busca:\n");
		System.out.println(lista_busca);
		System.out.println("\nTodos os Produtos:\n");
		System.out.println(dados_teste.listar_tudo());

	}
}
	