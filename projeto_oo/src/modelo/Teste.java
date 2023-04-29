package modelo;

import java.util.ArrayList;

public class Teste {
	static Loja lojinhaDeEsquina;
	static ArrayList<Produto> estoqueLojinha;
	static PrincipioAtivo principioAtivoSerenataTeste;
	static PrincipioAtivo principioAtivoXaropeTeste;
	static Quantidade quantTesteSerenata;
	static Quantidade quantTesteXarope;
	static Quantidade quantTestePresilha;
	static Quantidade quantTesteBatom;
	static Utilidade utilidade1Teste;
	static Medicamento medicamento1Teste;
	static Medicamento medicamento2Teste;
	static Cosmetico cosmetico1Teste;

	public static void main (String[] args) {
		
		ArrayList<Produto> estoqueLojinha = new ArrayList<Produto>();
		lojinhaDeEsquina = new Loja("Gama", "Brasília",estoqueLojinha);
		
		quantTesteSerenata = new Quantidade(0, "teste");
		principioAtivoSerenataTeste = new PrincipioAtivo("Cloridrato de sertralina ", "50", "mg");
		medicamento1Teste = new Medicamento("serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO.\n LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO." 
				, "torrent pharma",148.57, 200, quantTesteSerenata, null, null, false, principioAtivoSerenataTeste);
		medicamento1Teste.quantidade.setNumQuant(30);
		medicamento1Teste.quantidade.setUnidMedidaQuant(" comprimidos");
		
		
		quantTestePresilha = new Quantidade(12, " unidades");
		utilidade1Teste = new Utilidade("presilha", "belíssimas presilhas cobertas de glitter", 
				"shopee",1.99, 50, quantTestePresilha, false, false, false);
		
		quantTesteBatom = new Quantidade (1, " unidade");
		cosmetico1Teste = new Cosmetico("Batom líquido super stay matte ink", 
				"Batom Líquido matte de alta fixação", "MAC", 119.90, 10, 
				quantTesteBatom, null, null, false);

		
		quantTesteXarope = new Quantidade (120, "ml");
		principioAtivoXaropeTeste = new PrincipioAtivo ("maleato de bronfeniramina, cloridrato fenillefrina"
				, "2/5, 1", "mg/ml, mg/ml");
		medicamento2Teste = new Medicamento ("Decongex", "Xarope expectorante", "Aché", 20.89, 10, 
				quantTesteBatom, null, null, false, 
			null);
		
		
		estoqueLojinha.add(cosmetico1Teste);
		estoqueLojinha.add(medicamento1Teste);
		estoqueLojinha.add(medicamento2Teste);
		estoqueLojinha.add(utilidade1Teste);
		
		System.out.println(lojinhaDeEsquina.toString());
		lojinhaDeEsquina.listarEstoque(estoqueLojinha);
		
	}
}
		
	//	System.out.println(medicamento1Teste.toString());
		//System.out.println(medicamento2Teste.toString());
		//System.out.println(utilidade1Teste.toString());
		//System.out.println(cosmetico1Teste.toString());
//		System.out.println(principioAtivoXaropeTeste.listar());
		
		
		
		

/*50mg
 * cloridrato de sertralina
 * antidepressivo
 * 100 pilulas
 * fabricante: torrent pharma
 * tarja vermelha
 * gen = false
 *  //Maleato de Bronfeniramina 2mg/5ml + Cloridrato Fenillefrina 5mg/5ml
//maleato de bronfeniramina, cloridrato fenillefrina
//2/5, 1
//mg/ml, mg/ml
 * 
 */
