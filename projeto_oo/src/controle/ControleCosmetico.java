package controle;

import modelo.Cosmetico;
import modelo.Produto;
import view.TelaComestico;
import view.TelaMenu;

import java.util.Objects;


public class ControleCosmetico {
	public static void salvarCosmetico(TelaComestico tela) {
		for (Produto item : TelaComestico.getTelaPai().getDados().listar_tudo()) {
			if (Objects.equals(item.getNome(), tela.getNomeAnterior())) ;
		}

	}


}
