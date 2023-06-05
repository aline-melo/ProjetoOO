package controle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.criarDados();
	}


	public String[] buscaProduto() {
		//List<String> lista = new ArrayList<String>();

		//String[] listaBusca =  new String[lista.size()];
		String[] listaBusca = {"kNeW He wAs a kIlLeR FiRsT TiMe tHaT I SaW HiM\n",
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
		return listaBusca;
	}
	
	
	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

	

	

}
