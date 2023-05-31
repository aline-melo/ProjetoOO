package modelo;

import java.util.ArrayList;
import controle.*;

public class Teste {
	static Loja lojinhaDeEsquina;
	static ArrayList<Produto> estoqueLojinha;
	static Medicamento medicamento1Teste;
	static Medicamento medicamento2Teste;
	static Cosmetico cosmetico1Teste;

	public static void main (String[] args) {
		
		ArrayList<Produto> estoqueLojinha = new ArrayList<Produto>();
		lojinhaDeEsquina = new Loja("Esquina da 708N", "Brasília",estoqueLojinha);
		
		medicamento1Teste = new Medicamento("serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO.\n LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO." 
				, "torrent pharma",148.57, 20, "30 comprimidos", "Anti-depressivo", "Vermelha", false, "principioAtivoSerenataTeste");
		
		
		cosmetico1Teste = new Cosmetico("Batom líquido super stay matte ink", 
				"Batom Líquido matte de alta fixação", "MAC", 119.90, 10, 
				"1 unidade", "Vinho", null, false);

		
		medicamento2Teste = new Medicamento ("Decongex", "Xarope expectorante", "Aché", 20.89, 10, 
				"120 ml", "expectorante", "Sem tarja", false, 
			"principioAtivoXaropeTeste");
		
		
		estoqueLojinha.add(cosmetico1Teste);
		estoqueLojinha.add(medicamento1Teste);
		estoqueLojinha.add(medicamento2Teste);
		
		System.out.println(lojinhaDeEsquina.toString());
		lojinhaDeEsquina.listarEstoque(estoqueLojinha);
	}
}
	