package modelo;

import java.util.ArrayList;

public class Dados {
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	//private int qtdLojas = lojas.size();
	
	
	public void criarDados() {
		ArrayList<Produto> estoqueLojinha = new ArrayList<Produto>();
		Loja lojinhaDeEsquina = new Loja("Esquina da 708N", "Brasília",estoqueLojinha);
		ArrayList<Produto> outroestoque= new ArrayList<Produto>();
		Loja outraLoja = new Loja("Shopping do gama", "Brasília", outroestoque);
		ArrayList<Produto> estoqueNoroeste= new ArrayList<Produto>();
		Loja lojaNoroeste = new Loja("Noroeste", "Brasília", estoqueNoroeste);
		
		
		Medicamento medicamento1Teste = new Medicamento("serenata", "SERENATA 50MG É UM MEDICAMENTO. SEU USO PODE TRAZER RISCOS. PROCURE UM MÉDICO OU UM FARMACÊUTICO.\n LEIA A BULA. MEDICAMENTOS PODEM CAUSAR EFEITOS INDESEJADOS. EVITE A AUTOMEDICAÇÃO: INFORME-SE COM O FARMACÊUTICO." 
				, "torrent pharma",148.57, 20, "30 comprimidos", "Anti-depressivo", "Vermelha", false, "principioAtivoSerenataTeste");
		
		
		Cosmetico cosmetico1Teste = new Cosmetico("Batom líquido super stay matte ink", 
				"Batom Líquido matte de alta fixação", "MAC", 119.90, 10, 
				"1 unidade", "Vinho", null, false);

		
		Medicamento medicamento2Teste = new Medicamento ("Decongex", "Xarope expectorante", "Aché", 20.89, 10, 
				"120 ml", "expectorante", "Sem tarja", false, 
			"principioAtivoXaropeTeste");
		
		
		estoqueLojinha.add(cosmetico1Teste);
		estoqueLojinha.add(medicamento1Teste);
		estoqueLojinha.add(medicamento2Teste);
		lojas.add(lojinhaDeEsquina);
		lojas.add(outraLoja);
		lojas.add(lojaNoroeste);
		//int qtdLojas = lojas.size();
		
		
	}


	public ArrayList<Loja> getLojas() {
		return lojas;
	}


	public void setLojas(ArrayList<Loja> lojas) {
		this.lojas = lojas;
	}

	


}
