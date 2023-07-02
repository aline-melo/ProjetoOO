
 package teste;
  
  import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

  import modelo.*;
  
  class Testes {
	  @Test
	  void testeBuscarLojas () {
		  Dados dadosTeste = new Dados();
		  Loja loja1 = new Loja("local 1","cidade1", null);
		  Loja loja2 = new Loja("local 2","cidade2", null);
		  
		  dadosTeste.getLojas().add(loja1);
		  dadosTeste.getLojas().add(loja2);
		  
		  assertTrue(dadosTeste.buscar_lojas("local 1").contains(loja1));
		  assertTrue(dadosTeste.buscar_lojas("cidade1").contains(loja1));
		  assertTrue(dadosTeste.buscar_lojas("local").contains(loja1));
		  assertTrue(dadosTeste.buscar_lojas("local").contains(loja2));
		  assertTrue(dadosTeste.buscar_lojas("local onde não tem loja").isEmpty());
		  assertFalse(dadosTeste.buscar_lojas("nomeErrado").contains(loja1));
		  assertFalse(dadosTeste.buscar_lojas("nomeErrado").contains(loja2));
	  }
	  
	  
	  @Test
	  void testeBuscarTudo() {
		  Dados dadosTeste = new Dados();
		  Loja loja1 = new Loja("local1","cidade1", new ArrayList<Produto>());
		  
		  Cosmetico cosmeticoTeste = new Cosmetico ("produto existente", null, null, 0, 0, null, null, null, false);
		  Medicamento medicamentoTeste = new Medicamento("outro produto", null, null, 0, 0, null, null, null, false, null);
		  
		  
		  dadosTeste.getLojas().add(loja1);
		  loja1.addToEstoque(cosmeticoTeste);
		  loja1.addToEstoque(medicamentoTeste);
		  
		  assertTrue(dadosTeste.buscar_tudo("produto").contains(cosmeticoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto").contains(medicamentoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto existente").contains(cosmeticoTeste));
		  assertFalse(dadosTeste.buscar_tudo("produto existente").contains(medicamentoTeste));
		  assertFalse(dadosTeste.buscar_tudo("nome errado").contains(cosmeticoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto inexistente").isEmpty());
	  }

	  @Test
	  void testeDeletarProduto() {
		  Dados dadosTeste = new Dados();
		  Loja loja1 = new Loja("local1","cidade1", new ArrayList<Produto>());
		  
		  Medicamento medicamentoTeste = new Medicamento(null, null, null, 0, 0, null, null, null, false, null);
		  Cosmetico cosmeticoTeste = new Cosmetico (null, null, null, 0, 0, null, null, null, false);
		  
		  dadosTeste.getLojas().add(loja1);
		  loja1.addToEstoque(cosmeticoTeste);
		  
		  assertTrue(dadosTeste.deletarProduto(cosmeticoTeste));
		  assertFalse(dadosTeste.deletarProduto(cosmeticoTeste));
		  assertFalse(dadosTeste.deletarProduto(medicamentoTeste));
	  }
  }