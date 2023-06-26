package modelo;

import java.util.ArrayList;

/**
 * Classe que simula um banco de dados. Todos os dados do progama são armazenados dentro dessa classe.
 *
 * @author Aline Melo
 * @version 1.0
 * @see Controle
 * @since 05/2023
 */
public class Dados {
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	//private int qtdLojas = lojas.size();


	/**
	 * Popula a classe Dados com os dados padrão.
	 * @author Aline Melo
	 * @since 05/2023
	 */
	public void criarDados() {

		Loja lojinhaDeEsquina = new Loja("Esquina da 708N", "Brasília", new ArrayList<>());
		Loja outraLoja = new Loja("Shopping do gama", "Gama", new ArrayList<>());
		Loja lojaNoroeste = new Loja("Noroeste", "Brasília", new ArrayList<>());
		Loja lojaTampa = new Loja("Amalie Arena", "Tampa Bay", new ArrayList<>());


		Medicamento medicamento1Teste = new Medicamento("Serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO.\n LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO."
				, "Torrent pharma", 148.57, 20, "30 comprimidos", "Anti-depressivo", "Vermelha", false, "Cloridato de Sertralina");


		Medicamento medicamento2Teste = new Medicamento("Decongex", "Xarope expectorante", "Aché", 20.89, 10,
				"120 ml", "expectorante", "Sem tarja", false,
				"principioAtivoXaropeTeste");
		Medicamento medicamento3Teste = new Medicamento("Glifage XR", "Glifage® XR é um medicamento antidiabético de uso oral, que associado a uma dieta apropriada, é utilizado para o tratamento do diabetes tipo 2 em adultos.", "Merck", 11.18, 46,
				"30 comprimidos", "antidiabético", "Vermelha", false,
				"CLORIDRATO DE METFORMINA 500mg");
		Medicamento medicamento4Teste = new Medicamento("Durateston", "Durateston é utilizado para a reposição de testosterona em homens para o tratamento de vários problemas de saúde relacionados à falta de testosterona (hipogonadismo masculino).", "Aspen Pharma", 15.88, 37,
				"1 Ampola", "Endocrinológico", "Vermelha", false,
				"PROPIONATO DE TESTOSTERONA 250mg/ml");
		Medicamento medicamento5Teste = new Medicamento("Hemitartarato de Zolpidem", "O hemitartarato de zolpidem é destinado ao tratamento de curta duração da insônia (dificuldade para dormir) que pode ser ocasional (eventual), transitória (passageira) ou crônica (que dura há muito tempo).", "Novartis", 35.72, 82,
				"30 Comprimidos", "Sonífero", "Preta", true,
				"Hemitartarato de Zolpidem 10mg");
		Medicamento medicamento6Teste = new Medicamento("Novalgina Xarope", "Novalgina é a marca mais recomendada por pediatras e especialistas em dor e febre. Com quase 100 anos de tradição, Novalgina é indicado como antitérmico para febre e analgésico para dor. Novalgina é um medicamento à base de dipirona, utilizado no tratamento dor e febre", "Sanofi Aventis", 45.66, 37,
				"100ml", "Analgésico", "Sem Tarja", false,
				"Dipirona Monohidratada 50mg/ml");
		Medicamento medicamento7Teste = new Medicamento("Enterogermina", "O Enterogermina é um probiótico que contribui para o equilíbrio da flora intestinal, indicado para pessoas com desconforto intestinal.", "Sanofi Aventis", 46.50, 26,
				"10 frascos de 5ml", "Probiótico", "Sem Tarja", false,
				"ESPOROS DE BACILLUS CLAUSII");

		Cosmetico cosmetico1Teste = new Cosmetico("Batom líquido super stay matte ink",
				"Batom Líquido matte de alta fixação", "MAC", 119.90, 10,
				"1 unidade", "Vinho", null, false);

		Cosmetico cosmetico2Teste = new Cosmetico("Poziny",
				"Pó compacto para finalização de maquiagem. \n" +
						"Textura Matte, esconde a oleosidade.", "Avon", 17.85, 13,
				"1 unidade", "Creme", "Não Possui", true);

		Cosmetico cosmetico3Teste = new Cosmetico("Base Superstay Full Coverage",
				"A base SuperStay Full Coverage de Maybelline NY oferece uma alta cobertura com 24 horas de duração para dar um acabamento impecável resistente à rotina. Com fórmula líquida e suave, a base SuperStay de Maybelline NY cria uma camada uniforme sobre a pele que disfarça imperfeições sem desaparecer ao longo do dia, sendo resistente até mesmo ao calor, humidade e suor.", "Maybelline", 97.90, 31,
				"30 ml", "128 Warm Nude", null, false);

		Cosmetico cosmetico4Teste = new Cosmetico("Máscara de Cílios Volume Up",
				"Vult Volume Up é um rímel para quem ama cílios super volumosos, é aquela máscara de cílios que dá um verdadeiro Up na maquiagem do dia a dia. ", "Vult", 29.90, 16,
				"10g", "Preta", null, false);

		Cosmetico cosmetico5Teste = new Cosmetico("Balm Protetor Labial Soleil FPS 15",
				"O Vult Soleil é um balm labial com proteção solar FPS 15, que mantém os lábios protegidos e hidratados por 8h após aplicação, graças a um complexo de vitaminas hidratantes com óleo de rícino. ", "Vult", 18.99, 76,
				"3.6g", "Rosa Claro", "Cranberry", true);
		Cosmetico cosmetico6Teste = new Cosmetico("",
				"", "", 119.90, 10,
				"", "", null, false);
		Cosmetico cosmetico7Teste = new Cosmetico("",
				"", "", 119.90, 10,
				"", "", null, false);


		lojinhaDeEsquina.addToEstoque(cosmetico1Teste);
		lojinhaDeEsquina.addToEstoque(medicamento1Teste);
		lojinhaDeEsquina.addToEstoque(medicamento5Teste);
		lojinhaDeEsquina.addToEstoque(cosmetico3Teste);
		lojaNoroeste.addToEstoque(medicamento2Teste);
		lojaNoroeste.addToEstoque(cosmetico2Teste);
		lojaNoroeste.addToEstoque(medicamento6Teste);
		lojaNoroeste.addToEstoque(cosmetico4Teste);
		outraLoja.addToEstoque(medicamento3Teste);
		outraLoja.addToEstoque(medicamento4Teste);
		outraLoja.addToEstoque(medicamento7Teste);
		outraLoja.addToEstoque(cosmetico5Teste);

		lojas.add(lojinhaDeEsquina);
		lojas.add(outraLoja);
		lojas.add(lojaNoroeste);
		lojas.add(lojaTampa);
		//int qtdLojas = lojas.size();


	}

	public ArrayList<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(ArrayList<Loja> lojas) {
		this.lojas = lojas;
	}

	/**
	 * Busca de {@link Loja lojas}. <br>
	 * Percorre a lista com todas as {@link Loja lojas} e seleciona as que possuem o termo de busca
	 * em seus atributos endereço ou cidade.
	 *
	 * @param termo O termo a ser utilizado para a busca.
	 * @return {@link ArrayList} com as lojas encontradas. Retorna uma {@link ArrayList} vazia se nenhuma {@link Loja} foi
	 * encontrada.
	 * @author Caio Pacheco
	 * @see Dados#buscar_tudo(String)
	 * @since 06/2023
	 */
	public ArrayList<Loja> buscar_lojas(String termo) {
		ArrayList<Loja> return_list = new ArrayList<Loja>();
		for (Loja y : lojas) {
			if ( y.getLocalizacao().toLowerCase().contains(termo.toLowerCase()) ||
					y.getCidade().toLowerCase().contains(termo.toLowerCase()) ) {
				return_list.add(y);
			}
		}
		return return_list;
	}


	/**
	 * Busca geral de {@link Produto produtos}. <br>
	 * Percorre a lista com todas as {@link Loja lojas} e chama
	 * {@link Loja#buscar_loja(String)} usando o termo de busca como parâmetro para cada chamada.
	 * <br>
	 * Adiciona o retorno de todas as iterações para alcançar o resultado.
	 * <br>
	 * Funciona de forma indêntica a {@link Dados#listar_tudo()} quando o termo de busca é uma
	 * {@link String} vazia ou {@code null}.
	 *
	 * @param termo O termo a ser utilizado para a busca.
	 * @return {@link ArrayList} com os {@link Produto produtos} encontradas. Retorna uma {@link ArrayList} vazia se
	 * nenhum Produto foi encontrado.
	 * @author Caio Pacheco
	 * @see Loja#buscar_loja(String)
	 * @see Dados#listar_tudo()
	 * @see view.TelaMenu
	 * @since 06/2023
	 */
	public ArrayList<Produto> buscar_tudo(String termo) {
		ArrayList<Produto> return_list = new ArrayList<Produto>();
		for (Loja y : lojas) {
			ArrayList<Produto> achados = y.buscar_loja(termo);
			return_list.addAll(achados);
		}
		return return_list;
	}

	/**
	 * Listagem completa de {@link Produto produtos}. <br>
	 * Percorre a lista com todas as {@link Loja lojas} e chama {@link Loja#listarEstoque()}, então
	 * adiciona o retorno de todas as iterações em uma {@link ArrayList} para alcançar o resultado.
	 * <br>
	 *
	 * @return {@link ArrayList} com todos os {@link Produto produtos} cadastrados.
	 * @author Caio Pacheco
	 * @see Loja#buscar_loja(String)
	 * @see Dados#buscar_tudo(String)
	 * @since 05/2023
	 */
	public ArrayList<Produto> listar_tudo() {
		ArrayList<Produto> return_list = new ArrayList<Produto>();
		for (Loja y : lojas) {
			ArrayList<Produto> achados = y.listarEstoque();
			return_list.addAll(achados);
		}
		return return_list;
	}
}
