package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaInicial implements ActionListener {
	
	
	private static JFrame janela = new JFrame("Drogarias OO");
	private static JLabel titulo = new JLabel("Consultar:");
	private static JButton produto = new JButton("Produtos");
	private static JButton filial = new JButton("Filiais");
	private static JButton cidade = new JButton("Cidades");
	public static ControleDados dados = new ControleDados();
	
	public TelaInicial() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(140, 10, 150, 30);
		produto.setBounds(140, 100, 100, 30);
		filial.setBounds(140, 150, 100, 30);
		cidade.setBounds(140, 50, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(produto);
		janela.add(filial);
		janela.add(cidade);
		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	public static void main(String[] args) {
		TelaInicial menu = new TelaInicial();
		
		produto.addActionListener(menu);
		filial.addActionListener(menu);
		cidade.addActionListener(menu);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cidade)
			new TelaCidade().mostrarDados(dados, 1);
		
		if(src == produto)
			new TelaProduto().mostrarDados(dados, 2);
		
		if(src == filial)
			new TelaFilial().mostrarDados(dados, 3);
	}
}