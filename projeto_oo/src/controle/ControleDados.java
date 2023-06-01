package controle;
import java.util.ArrayList;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.criarDados();
	}
	
	public String[] listarLojas () {	
		String[] listaLojas = new String[d.getLojas().size()];
		
		for(int i = 0; i < d.getLojas().size(); i++) {
			listaLojas[i] = d.getLojas().get(i).getLocalizacao()+ ", "+ d.getLojas().get(i).getCidade();
		}
		return listaLojas;
	}
	
	public String[] listarCidades() {
		String[] listaCidades = new String[d.getLojas().size()];
		
		int j = 0;
		for(int i = 0; i < d.getLojas().size(); i++ ) {
			if (listaCidades[j] != d.getLojas().get(i).getCidade()) {
				j++;
				listaCidades[j] = d.getLojas().get(i).getCidade();
			}
		}
		return listaCidades;
	}
	public String[] buscaProduto() {
		String[] listaBusca = {"I WaS RiDiN' sHoTgUn wItH My hAiR UnDoNe",
				"iN ThE FrOnT SeAt oF HiS CaR",
				"He's gOt a oNe-hAnD FeEl oN ThE StEeRiNg wHeEl",
				"tHe oThEr oN My hEaRt",
				"i lOoK ArOuNd, TuRn tHe rAdIo dOwN",
				"He sAyS, \"BaBy, Is sOmEtHiNg wRoNg?\"",
				"i sAy, \"nOtHiNg, I WaS JuSt tHiNkIn' HoW We dOn't hAvE A SoNg\"",
				"AnD He sAyS",
				"OuR SoNg iS ThE SlAmMiNg sCrEeN DoOr",
				"sNeAkIn' OuT LaTe, TaPpInG On yOuR WiNdOw",
				"wHeN We'rE On tHe pHoNe, AnD YoU TaLk rEaL SlOw",
				"'CaUsE It's lAtE, aNd yOuR MaMa dOn't kNoW",
				"OuR SoNg iS ThE WaY YoU LaUgH",
				"ThE FiRsT DaTe, \"mAn, I DiDn't kIsS HeR, aNd i sHoUlD HaVe\"",
				"AnD WhEn i gOt hOmE, 'FoRe i sAiD, \"AmEn\"",
				"AsKiNg gOd iF He cOuLd pLaY It aGaIn",
				"i wAs wAlKiN' uP ThE FrOnT PoRcH StEpS AfTeR EvErYtHiNg tHaT DaY",
				"HaD GoNe aLl wRoNg aNd bEeN TrAmPlEd oN",
				"AnD LoSt aNd tHrOwN AwAy",
				"gOt tO ThE HaLlWaY, wElL On mY WaY To mY LoViN' bEd",
				"i aLmOsT DiDn't nOtIcE AlL ThE RoSeS",
				"AnD ThE NoTe tHaT SaId",
				"oUr sOnG Is tHe sLaMmInG ScReEn dOoR",
				"SnEaKiN' oUt lAtE, tApPiNg oN YoUr wInDoW",
				"WhEn wE'Re oN ThE PhOnE, aNd yOu tAlK ReAl sLoW",
				"'cAuSe iT'S LaTe, AnD YoUr mAmA DoN'T KnOw",
				"oUr sOnG Is tHe wAy yOu lAuGh",
				"tHe fIrSt dAtE, \"MaN, i dIdN'T KiSs hEr aNd i sHoUlD HaVe\"",
				"AnD WhEn i gOt hOmE, 'FoRe i sAiD, \"AmEn\"",
				"AsKiNg gOd iF He cOuLd pLaY It aGaIn",
				"i'vE HeArD EvErY AlBuM, lIsTeNeD To tHe rAdIo",
				"wAiTeD FoR SoMeThInG To cOmE AlOnG",
				"ThAt wAs aS GoOd aS OuR SoNg",
				"'CaUsE OuR SoNg iS ThE SlAmMiNg sCrEeN DoOr",
				"sNeAkIn' OuT LaTe, TaPpInG On hIs wInDoW",
				"WhEn wE'Re oN ThE PhOnE, aNd hE TaLkS ReAl sLoW",
				"'cAuSe iT'S LaTe, AnD HiS MaMa dOn't kNoW",
				"OuR SoNg iS ThE WaY He lAuGhS",
				"ThE FiRsT DaTe, \"mAn, I DiDn't kIsS HiM, aNd i sHoUlD HaVe\"",
				"AnD WhEn i gOt hOmE, 'FoRe i sAiD, \"AmEn\"",
				"AsKiN' gOd iF He cOuLd pLaY It aGaIn, PlAy iT AgAiN",
				"Oh, YeAh",
				"oH, oH YeAh",
				"i wAs rIdIn' ShOtGuN WiTh mY HaIr uNdOnE",
				"In tHe fRoNt sEaT Of hIs cAr",
				"i gRaBbEd a pEn aNd aN OlD NaPkIn",
				"aNd i wRoTe dOwN OuR SoNg"};
		return listaBusca;
	}
	
	
	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

	

	

}
