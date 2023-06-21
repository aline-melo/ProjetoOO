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
	 * @see Dados#buscar_lojas_cidades(String)
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
	 * Busca de {@link Loja lojas} em uma cidade. <br>
	 * Percorre a lista com todas as {@link Loja lojas} e seleciona as que possuem o
	 * termo de busca no seu atributo cidade.
	 * <br>
	 * Diferente de {@link Dados#buscar_lojas(String)} pois usa somente o atributo
	 * cidade para procurar lojas válidas.
	 *
	 * @param termo O termo a ser utilizado para a busca.
	 * @return {@link ArrayList} com as Lojas encontradas. Retorna uma {@link ArrayList} vazia se nenhuma {@link Loja} foi encontrada.
	 * @author Caio Pacheco
	 * @see Dados#buscar_lojas(String)
	 * @see Dados#buscar_tudo(String)
	 * @since 06/2023
	 */
	public ArrayList<Loja> buscar_lojas_cidades(String termo) {
		ArrayList<Loja> return_list = new ArrayList<Loja>();
		for (Loja y : lojas) {
			if ( y.getCidade().toLowerCase().contains(termo.toLowerCase()) ) {
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
	 * @return {@link ArrayList} com os {@link Produto produtos} encontradas. Retorna uma {@link ArrayList} vazia se nenhum Produto
	 * foi encontrado.
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
	 * Busca geral de {@link Produto produtos}. <br>
	 * Percorre a lista com todas as {@link Loja lojas} e chama
	 * {@link Loja#buscar_loja(String)} usando o termo de busca como parâmetro para cada chamada.
	 * <br>
	 * Adiciona o retorno de todas as iterações para alcançar o resultado.
	 * <br>
	 * Funciona de forma indêntica a {@link Dados#listar_tudo()} quando o termo de busca é uma
	 * {@link String} vazia ou {@code null}.
	 *
	 * @return {@link ArrayList} com os {@link Produto produtos} encontradas. Retorna uma {@link ArrayList} vazia se nenhum Produto
	 * foi encontrado.
	 * @author Aline Melo
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
