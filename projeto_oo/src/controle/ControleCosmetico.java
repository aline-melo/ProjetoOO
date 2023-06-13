package controle;

import modelo.Cosmetico;
import modelo.Produto;
import view.TelaComestico;
import view.TelaMenu;

import java.util.ArrayList;
import java.util.Objects;


public class ControleCosmetico {
	public static void salvarCosmetico(ArrayList listaInfo) {
		for (Produto item : TelaComestico.getTelaPai().getDados().listar_tudo()) {
			String nomeAnterior = (String) listaInfo.get(9);
			if (item.getClass() == Cosmetico.class) {
				if (Objects.equals(item.getNome(), nomeAnterior)) {
					item.setNome((String) listaInfo.get(0));
					item.setDescricao((String) listaInfo.get(1));
					item.setPreco((double) listaInfo.get(2));
					item.setEmEstoque((int) listaInfo.get(3));
					item.setFabricante((String) listaInfo.get(4));
					item.setQuantidade((String) listaInfo.get(5));
					((Cosmetico) item).setCor((String) listaInfo.get(6));
					((Cosmetico) item).setFragrancia((String) listaInfo.get(7));
					((Cosmetico) item).setHipoalergenico((boolean) listaInfo.get(8));
				}
			}
		}

	}


}
