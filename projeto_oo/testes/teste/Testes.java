
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
		  String esperado ="cidade1";
		  Dados dadosTeste = new Dados();
		  dadosTeste.getLojas().add(loja1);
		  String resultado = dadosTeste.listarCidades()[dadosTeste.listarCidades().length-1];
		  System.out.println(resultado);
		  
		  
		  
		  assertEquals(resultado,esperado);
	  }
  }