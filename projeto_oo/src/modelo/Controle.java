package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("MethodWithMultipleLoops")
public class Controle {
	private static Dados dados = new Dados();

	public Controle() {
		dados.criarDados();
	}


	public static String[] listarEmString(ArrayList array) {
		String[] lista_retorno = new String[array.size()];
		if ( array.isEmpty() ) {
			lista_retorno = new String[0];
		} else {
			if ( array.get(0) instanceof Produto ) {
				for (int i = 0; i < array.size(); i++) {
					lista_retorno[i] = ((Produto) array.get(i)).getNome();
				}
			} else if ( array.get(0).getClass().equals(Loja.class) ) {
				for (int i = 0; i < array.size(); i++) {
					lista_retorno[i] = (((Loja) array.get(i)).getLocalizacao() + ", "
							+ ((Loja) array.get(i)).getCidade());
				}
			} else {
				for (int i = 0; i < array.size(); i++) {
					lista_retorno[i] = ((Produto) array.get(i)).getNome();
				}
			}
		}
		return lista_retorno;
	}

	public static void deletarProduto(Produto item) {
		for (Loja loja : dados.getLojas()) {
			if ( loja.getEstoque().contains(item) ) {
				ArrayList<Produto> novoEstoque = loja.getEstoque();
				while (novoEstoque.contains(item)) {
					novoEstoque.remove(item);
				}
				loja.setEstoque(novoEstoque);
			}
		}
	}

	
	public static void salvarCosmetico(String nomeAnterior, String nome,
			String descricao, String fabricante, double preco,
			int emEstoque, String quantidade, String cor, 
			String fragrancia,boolean hipoalergenico) {
		for (Produto item : dados.listar_tudo()) {
			if (item.getNome().matches(nomeAnterior) && item.getClass() == Cosmetico.class ) {
				item.setNome(nome);
				item.setDescricao(descricao);
				item.setFabricante(fabricante);
				item.setPreco(preco);
				item.setEmEstoque(emEstoque);
				item.setQuantidade(quantidade);
				((Cosmetico) item).setCor(cor);
				((Cosmetico) item).setFragrancia(fragrancia);
				((Cosmetico) item).setHipoalergenico(hipoalergenico);
			}
		}
	}
	public static void salvarMedicamento(String nomeAnterior, String nome,
			String descricao, String fabricante, double preco,
			int emEstoque, String quantidade, String tratamento, String tarja,
			Boolean generico, String principioAtivo) {
		for (Produto item : dados.listar_tudo()) {
			if (item.getNome().matches(nomeAnterior) &&  item.getClass() == Medicamento.class ) {
				item.setNome(nome);
				item.setDescricao(descricao);
				item.setFabricante(fabricante);
				item.setPreco(preco);
				item.setEmEstoque(emEstoque);
				item.setQuantidade(quantidade);
				((Medicamento) item).setTratamento(tratamento);
				((Medicamento) item).setTarja(tarja);
				((Medicamento) item).setGenerico(generico);
				((Medicamento) item).setPrincipioAtivo(principioAtivo);
			}
		}
	}
	public static void criarCosmetico(String nomeAnterior, String nome,
			String descricao, String fabricante, double preco,
			int emEstoque, String quantidade, String cor, 
			String fragrancia,boolean hipoalergenico, Loja lojaPertecente) {
		if ( dados.buscar_tudo(nome).isEmpty() ) {
			lojaPertecente.addToEstoque(new Cosmetico(nome,
							descricao,fabricante,preco,
							emEstoque,quantidade,cor, 
							fragrancia,hipoalergenico));
		} else {
			salvarCosmetico(nomeAnterior,nome,
					descricao,fabricante,preco,
					emEstoque,quantidade,cor, 
					fragrancia,hipoalergenico);
		}
	}

	public static void criarMedicamento(String nomeAnterior, String nome,
			String descricao, String fabricante, double preco,
			int emEstoque, String quantidade, String tratamento, String tarja,
			Boolean generico, String principioAtivo, Loja lojaPertecente) {
		if ( dados.buscar_tudo(nome).isEmpty() ) {
			lojaPertecente.addToEstoque(
					new Medicamento(nome,
							descricao,fabricante,preco,
							emEstoque, quantidade, tratamento,tarja,
							generico,principioAtivo)
			);
		} else {
			salvarMedicamento(nomeAnterior,nome,
					descricao,fabricante,preco,
					emEstoque, quantidade, tratamento,tarja,
					generico,principioAtivo);
		}
	}

	public static void salvarLoja(Loja loja,String localizacao,String cidade, ArrayList<Produto> estoque) {
		loja.setLocalizacao(localizacao);
		loja.setCidade(cidade);
		loja.setEstoque(estoque);
		if ( !dados.getLojas().contains(loja) ) {
			ArrayList<Loja> lista = dados.getLojas();
			lista.add(loja);
			dados.setLojas(lista);
		} else {
			dados.getLojas().set(dados.getLojas().indexOf(loja), loja);
		}

	}

	public static void deletarLoja(Loja loja) {
		for (Produto produto : loja.getEstoque()) {
			loja.getEstoque().remove(produto);
		}
		dados.getLojas().remove(loja);
	}

	public String[] listarLojas() {
		ArrayList<Loja> lojas = dados.getLojas();
		String[] listaLojas = new String[lojas.size()];

		for (int i = 0; i < lojas.size(); i++) {
			listaLojas[i] = lojas.get(i).getLocalizacao() + ", " + lojas.get(i).getCidade();
		}
		return listaLojas;
	}

	public String[] listarCidades() {
		ArrayList<Loja> lojas = dados.getLojas();
		List<String> lista = new ArrayList<>();
		for (Loja loja : lojas) {
			if ( !lista.contains(loja.getCidade()) ) {
				lista.add(loja.getCidade());
			}
		}
		String[] listaCidades = new String[lista.size()];
		listaCidades = lista.toArray(listaCidades);
		return listaCidades;
	}

	public static String[] buscarCidades(String termoDeBusca) {
		ArrayList<Loja> lojas = dados.getLojas();
		List<String> lista = new ArrayList<>();
		for (Loja loja : lojas) {
			if ( loja.getCidade().toLowerCase().contains(termoDeBusca) ) {
				if ( !lista.contains(loja.getCidade()) ) {
					lista.add(loja.getCidade());
				}
			}
		}
		String[] listaCidades = new String[lista.size()];
		listaCidades = lista.toArray(listaCidades);
		return listaCidades;
	}

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados d) {
		dados = d;
	}
}
