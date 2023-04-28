package modelo;

public class Teste {
	static PrincipioAtivo PrincipioAtivoSerenataTeste;
	static Quantidade quantTesteSerenata;
	static Quantidade quantTestePresilha;
	static Utilidade utilidade1Teste;
	static Medicamento medicamento1Teste;
	static PrincipioAtivo principioAtivoSerenata;

	public static void main (String[] args) {
		
		quantTesteSerenata = new Quantidade(0, "teste");
		principioAtivoSerenata = new PrincipioAtivo("Cloridrato de sertralina ", "50", "mg");
		medicamento1Teste = new Medicamento("serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO. LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO." 
				, "torrent pharma",148.57, 200, quantTesteSerenata, null, null, false, principioAtivoSerenata);
		medicamento1Teste.quantidade.setNumQuant(100);
		medicamento1Teste.quantidade.setUnidMedidaQuant("comprimidos");
		
		quantTestePresilha = new Quantidade(12, " unidades");
		utilidade1Teste = new Utilidade("presilha", "belíssimas presilhas cobertas de glitter", 
				"shopee",1.99, 50, quantTestePresilha, false, false, false);
		
		
		System.out.println(medicamento1Teste.toString());
		System.out.println(utilidade1Teste.toString());
		
		
		
		
		
	}
}
/*50mg
 * cloridrato de sertralina
 * antidepressivo
 * 100 pilulas
 * fabricante: torrent pharma
 * tarja vermelha
 * gen = false
 * 
 * 
 */
