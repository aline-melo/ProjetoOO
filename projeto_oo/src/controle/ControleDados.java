package controle;
import java.util.ArrayList;
import java.util.Objects;

import modelo.*;

public class ControleDados {
	private static Dados dados = new Dados();
	
	public ControleDados() {
		dados.criarDados();
	}


	public static String[] listarEmString(ArrayList<Produto> array) {
		String[] lista_retorno = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			lista_retorno[i] = array.get(i).getNome();
		}
		return lista_retorno;
	}

	public void deletarCosmetico(Cosmetico item) {
		for (Loja loja : dados.getLojas()) {
			if ( loja.getEstoque().contains(item) ) {
				ArrayList<Produto> novoEstoque = loja.getEstoque();
				novoEstoque.remove(item);
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
				item.setPreco((double) listaInfo.get(3));
				item.setEmEstoque((int) listaInfo.get(4));
				item.setFabricante((String) listaInfo.get(5));
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

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados d) {
		dados = d;
	}

	public String[] taylorSwift() {

		return new String[]{"kNeW He wAs a kIlLeR FiRsT TiMe tHaT I SaW HiM\n",
				"WoNdEr hOw mAnY GiRlS He hAd lOvEd aNd lEfT HaUnTeD\n",
				"BuT If hE'S A GhOsT, tHeN I CaN Be a pHaNtOm\n",
				"hOlDiN' hIm fOr rAnSoM\n",
				"SoMe, SoMe bOyS ArE TrYiN' tOo hArD\n",
				"He dOn't tRy aT AlL, tHoUgH\n",
				"YoUnGeR ThAn mY ExEs bUt hE AcT LiKe sUcH A MaN, sO\n",
				"I SeE NoThInG BeTtEr, I KeEp hIm fOrEvEr\n",
				"lIkE A VeNdEtTa-tA\n",
				"I-I-I SeE HoW ThIs iS GoN' gO\n",
				"ToUcH Me aNd yOu'lL NeVeR Be aLoNe\n",
				"i-iSlAnD BrEeZe aNd lIgHtS DoWn lOw\n",
				"nO OnE HaS To kNoW\n",
				"In tHe mIdDlE Of tHe nIgHt, In mY DrEaMs\n",
				"yOu sHoUlD SeE ThE ThInGs wE Do, BaBy (MmM)\n",
				"iN ThE MiDdLe oF ThE NiGhT, iN My dReAmS\n",
				"I KnOw i'm gOnNa bE WiTh yOu\n",
				"sO I'Ll tAkE My tImE\n",
				"ArE YoU ReAdY FoR It?\n",
				"KnEw i wAs a rObBeR FiRsT TiMe tHaT He sAw mE\n",
				"StEaLiNg hEaRtS AnD RuNnInG OfF AnD NeVeR SaYiNg sOrRy\n",
				"bUt iF I'M A ThIeF, tHeN He cAn jOiN ThE HeIsT\n",
				"AnD We'lL MoVe tO An iSlAnD, aNd\n",
				"aNd hE CaN Be mY JaIlEr, BuRtOn tO ThIs tAyLoR\n",
				"EvErY LoVeR KnOwN In cOmPaRiSoN Is a fAiLuRe\n",
				"i fOrGeT ThEiR NaMeS NoW, i'm sO VeRy tAmE NoW\n",
				"NeVeR Be tHe sAmE NoW, nOw\n",
				"i-i-i sEe hOw tHiS Is gOn' Go (Go)\n",
				"ToUcH Me aNd yOu'lL NeVeR Be aLoNe\n",
				"i-iSlAnD BrEeZe aNd lIgHtS DoWn lOw (LoW)\n",
				"nO OnE HaS To kNoW\n",
				"(nO OnE HaS To kNoW)\n",
				"iN ThE MiDdLe oF ThE NiGhT, iN My dReAmS (eH)\n",
				"yOu sHoUlD SeE ThE ThInGs wE Do (We dO), BaBy\n",
				"iN ThE MiDdLe oF ThE NiGhT, iN My dReAmS (mY DrEaMs)\n",
				"I KnOw i'm gOnNa bE WiTh yOu\n",
				"sO I'Ll tAkE My tImE\n",
				"ArE YoU ReAdY FoR It?\n",
				"Oh, ArE YoU ReAdY FoR It?\n",
				"BaBy, LeT ThE GaMeS BeGiN\n",
				"LeT ThE GaMeS BeGiN\n",
				"LeT ThE GaMeS BeGiN (nOw)\n",
				"BaBy, LeT ThE GaMeS BeGiN\n",
				"LeT ThE GaMeS BeGiN\n",
				"LeT ThE GaMeS BeGiN\n",
				"I-I-I SeE HoW ThIs iS GoN' gO\n",
				"ToUcH Me aNd yOu'lL NeVeR Be aLoNe\n",
				"i-iSlAnD BrEeZe aNd lIgHtS DoWn lOw\n",
				"nO OnE HaS To kNoW\n",
				"In tHe mIdDlE Of tHe nIgHt, In mY DrEaMs (My dReAmS)\n",
				"yOu sHoUlD SeE ThE ThInGs wE Do (We dO), BaBy (BaBy, MmM, eH)\n",
				"iN ThE MiDdLe oF ThE NiGhT, iN My dReAmS (mY DrEaMs)\n",
				"I KnOw i'm gOnNa bE WiTh yOu\n",
				"sO I TaKe mY TiMe (Eh)\n",
				"In tHe mIdDlE Of tHe nIgHt\n",
				"bAbY, lEt tHe gAmEs bEgIn\n",
				"lEt tHe gAmEs bEgIn\n",
				"lEt tHe gAmEs bEgIn\n",
				"aRe yOu rEaDy fOr iT?\n",
				"bAbY, lEt tHe gAmEs bEgIn\n",
				"lEt tHe gAmEs bEgIn\n",
				"lEt tHe gAmEs bEgIn\n",
				"aRe yOu rEaDy fOr iT?"};
	}
}
