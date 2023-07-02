
 package teste;
  
  import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

  import modelo.*;
  
  class Testes {
	  @Test
	  void testeBuscarLojas () {
		  Loja loja1 = new Loja("local1","cidade1", null);
		  Dados dadosTeste = new Dados();
		  dadosTeste.getLojas().add(loja1);
		  
		  assertTrue(dadosTeste.buscar_lojas("local1").contains(loja1));
		  assertTrue(dadosTeste.buscar_lojas("cidade1").contains(loja1));
		  assertTrue(dadosTeste.buscar_lojas("local onde não tem loja").isEmpty());
		  assertFalse(dadosTeste.buscar_lojas("nomeErrado").contains(loja1));
	  }
	  
	  
	  @Test
	  void testeBuscarTudo() {
		  Dados dadosTeste = new Dados();
		  Loja loja1 = new Loja("local1","cidade1", new ArrayList<Produto>());
		  
		  Cosmetico cosmeticoTeste = new Cosmetico ("produto existente", null, null, 0, 0, null, null, null, false);
		  
		  dadosTeste.getLojas().add(loja1);
		  loja1.addToEstoque(cosmeticoTeste);
		  
		  
		  assertTrue(dadosTeste.buscar_tudo("produto").contains(cosmeticoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto existente").contains(cosmeticoTeste));
		  assertFalse(dadosTeste.buscar_tudo("nome errado").contains(cosmeticoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto inexistente").isEmpty());
	  }

	  @Test
	  void testeDeletarProduto() {
		  Dados dadosTeste = new Dados();
		  Loja loja1 = new Loja("local1","cidade1", new ArrayList<Produto>());
		  
		  Medicamento medicamentoTeste = new Medicamento(null, null, null, 0, 0, null, null, null, false, null);
		  Cosmetico cosmeticoTeste = new Cosmetico ("produto existente", null, null, 0, 0, null, null, null, false);
		  
		  dadosTeste.getLojas().add(loja1);
		  loja1.addToEstoque(cosmeticoTeste);
		  
		  assertTrue(dadosTeste.deletarProduto(cosmeticoTeste));
		  assertFalse(dadosTeste.deletarProduto(cosmeticoTeste));
		  assertFalse(dadosTeste.deletarProduto(medicamentoTeste));
	  }
  }