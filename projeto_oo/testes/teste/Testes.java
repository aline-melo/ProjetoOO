
 package teste;
  
  import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

  import modelo.*;
  
  class Testes {

	  @Test
	  void testeListarCidades() {
		  
		  ArrayList<Produto> estoque1 = new ArrayList<Produto>();
		  Loja loja1 = new Loja("local1", "cidade1", estoque1);
		  String resultadoEsperado ="cidade1";
		  Dados dadosTeste = new Dados();
		  dadosTeste.getLojas().add(loja1);
		  
		  assertEquals(dadosTeste.listarCidades()[1],resultadoEsperado);
	  }
	  
  }
  
  