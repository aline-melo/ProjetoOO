package view;

import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;

/*
 * fazer o jlist funcionar
 *  
 */

public class TelaMenu implements ActionListener, ListSelectionListener {

	private static ControleDados controleDados = new ControleDados();
	private static JFrame janela = new JFrame("Drogarias OO");
	private static JButton buscar = new JButton("Buscar");
	private static JButton botaoCidades = new JButton("Cidades");
	private static JButton botaoLojas = new JButton("Lojas");
	private static JTextField caixaDeBusca = new JTextField ("...");
	private String[] listaAExibir = new String[50];
	private JList<String> lista = new JList<String>();

	public TelaMenu() {
		

		String[] listaAExibir = controleDados.listarLojas();
		lista = new JList<String>(listaAExibir);
		
		
		//titulo.setFont(new Font("Arial", Font.BOLD, 20));
		caixaDeBusca.setBounds(120, 50, 300, 30);
		buscar.setBounds(500, 50, 100, 30);
		botaoCidades.setBounds(500, 100, 100, 30);
		botaoLojas.setBounds(500, 150, 100, 30);
		lista.setBounds(120, 100, 300, 300);
		//lista.setVisibleRowCount(10);
		
		janela.setLayout(null);
		
		janela.add(caixaDeBusca);
		janela.add(lista);
		janela.add(botaoCidades);
		janela.add(botaoLojas);
		janela.add(buscar);
		janela.setSize(700, 500);
		janela.setVisible(true);
	}
	public static void main(String[] args) {
		TelaMenu tela = new TelaMenu();
		
		buscar.addActionListener(tela);
		botaoCidades.addActionListener(tela);
		botaoLojas.addActionListener(tela);
		
	}

	//public String[] getListaAExibir() {
	//	return listaAExibir;
	//}
	//public void setListaAExibir(String[] listaAExibir) {
	//	this.listaAExibir = listaAExibir;
	//}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
