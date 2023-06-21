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

	public static void salvarProduto(ArrayList listaInfo) {
		String nomeAnterior = (String) listaInfo.get(0);
		for (Produto item : dados.listar_tudo()) {
			if ( Objects.equals(item.getNome(), nomeAnterior) ) {
				item.setNome((String) listaInfo.get(1));
				item.setDescricao((String) listaInfo.get(2));
				item.setPreco((double) listaInfo.get(4));
				item.setEmEstoque((int) listaInfo.get(5));
				item.setFabricante((String) listaInfo.get(3));
				item.setQuantidade((String) listaInfo.get(6));
				if ( item.getClass() == Cosmetico.class ) {
					((Cosmetico) item).setCor((String) listaInfo.get(7));
					((Cosmetico) item).setFragrancia((String) listaInfo.get(8));
					((Cosmetico) item).setHipoalergenico((boolean) listaInfo.get(9));
				} else if ( item.getClass() == Medicamento.class ) {
					((Medicamento) item).setTratamento((String) listaInfo.get(7));
					((Medicamento) item).setTarja((String) listaInfo.get(8));
					((Medicamento) item).setGenerico((boolean) listaInfo.get(9));
					((Medicamento) item).setPrincipioAtivo((String) listaInfo.get(10));
				}
			}
		}
	}

	public static void criarCosmetico(ArrayList listaInfo, Loja lojaPertecente) {
		if ( dados.buscar_tudo((String) listaInfo.get(1)).isEmpty() ) {
			lojaPertecente.addToEstoque(
					new Cosmetico(
							(String) listaInfo.get(1),
							(String) listaInfo.get(2),
							(String) listaInfo.get(5),
							(Double) listaInfo.get(3),
							(Integer) listaInfo.get(4),
							(String) listaInfo.get(6),
							(String) listaInfo.get(7),
							(String) listaInfo.get(8),
							(Boolean) listaInfo.get(9)
					)
			);
		} else {
			salvarProduto(listaInfo);
		}
	}

	public static void criarMedicamento(ArrayList listaInfo, Loja lojaPertecente) {
		if ( dados.buscar_tudo((String) listaInfo.get(1)).isEmpty() ) {
			lojaPertecente.addToEstoque(
					new Medicamento(
							(String) listaInfo.get(1),
							(String) listaInfo.get(2),
							(String) listaInfo.get(5),
							(Double) listaInfo.get(3),
							(Integer) listaInfo.get(4),
							(String) listaInfo.get(6),
							(String) listaInfo.get(7),
							(String) listaInfo.get(8),
							(Boolean) listaInfo.get(10),
							(String) listaInfo.get(9)

					)
			);
		} else {
			salvarProduto(listaInfo);
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
