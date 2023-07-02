
 package teste;
  
  import static org.junit.jupiter.api.Assertions.*;

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
		  Cosmetico cosmeticoTeste = new Cosmetico ("produto existente", null, null, 0, 0, null, null, null, false);
		  dadosTeste.getLojas().get(1).addToEstoque(cosmeticoTeste);
		  
		  assertTrue(dadosTeste.buscar_tudo("produto").contains(cosmeticoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto existente").contains(cosmeticoTeste));
		  assertFalse(dadosTeste.buscar_tudo("nome errado").contains(cosmeticoTeste));
		  assertTrue(dadosTeste.buscar_tudo("produto inexistente").isEmpty());
	  }

	  @Test
	  void testeListarCidades() {
		  Loja loja1 = new Loja("local1","cidade1", null);
		  Dados dadosTeste = new Dados();
		  dadosTeste.getLojas().add(loja1);
		  
		  String resultado = dadosTeste.listarCidades()[dadosTeste.listarCidades().length-1];
		  
		  assertEquals(resultado,"cidade1");
	  }
  }