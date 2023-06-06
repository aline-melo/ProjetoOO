package view;

import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;
import modelo.Dados;

/*
 * exibição do jlist
 * depois eu faço a actionlistener da jlist
 *  
 */

public class TelaMenu implements ActionListener, ListSelectionListener {

	private static ControleDados controleDados = new ControleDados();
	private static Dados dados = controleDados.getDados();
	private static JFrame janela = new JFrame("Drogarias OO");
	private static JButton buscar = new JButton("Buscar Produto");
	private static JButton botaoCidades = new JButton("Cidades");
	private static JButton botaoLojas = new JButton("Lojas");
	private static JTextField caixaDeBusca = new JTextField ("...");
	private JList<String> lista = new JList<String>();

	public TelaMenu() {

		String[] listaAExibir = {};

		lista = new JList<String>(listaAExibir);
		
		
		//titulo.setFont(new Font("Arial", Font.BOLD, 20));
		caixaDeBusca.setBounds(120, 50, 300, 30);
		buscar.setBounds(450, 50, 150, 30);
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == botaoLojas) {
			String[] listaAExibir = dados.listarLojas();
			lista.setListData(listaAExibir);
			lista.updateUI();	
		}
		if (src == botaoCidades) {
			String[] listaAExibir = dados.listarCidades();
			lista.setListData(listaAExibir);
			lista.updateUI();	
		}
		if (src == buscar) {
			String text = caixaDeBusca.getText().toLowerCase();
			if (text.contains("taylor") || text.contains("swift")) {
				String[] listaAExibir = controleDados.taylorSwift();
				lista.setListData(listaAExibir);
				lista.updateUI();

			} else {
				String[] listaAExibir = controleDados.listarEmString(dados.buscar_tudo(text));
				lista.setListData(listaAExibir);
				lista.updateUI();
			}

		}
	}

}
