
 package teste;
  
  import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

  import modelo.*;
  
  class Testes {

	  @Test
	  void testeListarCidades() {
		  String esperado ="cidade1";
		  Loja loja1 = new Loja("local1",esperado, null);
		  Dados dadosTeste = new Dados();
		  dadosTeste.getLojas().add(loja1);
		  
		  String resultado = dadosTeste.listarCidades()[dadosTeste.listarCidades().length-1];
		  
		  assertEquals(resultado,esperado);
	  }
  }