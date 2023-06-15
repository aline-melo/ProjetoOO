package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;
import modelo.*;


public class TelaMenu implements ActionListener, ListSelectionListener, KeyListener, WindowListener, FocusListener {

	private static final ControleDados controleDados = new ControleDados();
	private static final Dados dados = controleDados.getDados();
	private static final JFrame janela = new JFrame("Drogarias OO");
	private static final JButton buttonBusca = new JButton("Buscar");
	private static final JButton buttonCidades = new JButton("Cidades");
	private static final JButton buttonProdutos = new JButton("Produtos");
	private static final JButton buttonLojas = new JButton("Lojas");
	private static final JButton buttonNovaLoja = new JButton("Nova Loja");
	private static final JTextField textfieldBusca = new JTextField("");
	private JLabel labelModo = new JLabel("Buscando produtos");
	private static JList<String> jlistMenu = new JList<String>();
	private static ArrayList<Produto> listaObjetos = new ArrayList<Produto>();
	private static int listMode = 0;
	private static TelaMenu self;
	private long lastClick = 0;


	public TelaMenu() {

		String[] listaAExibir = {};

		jlistMenu = new JList<String>(listaAExibir);
		self = this;

		//titulo.setFont(new Font("Arial", Font.BOLD, 20));
		textfieldBusca.setBounds(120, 50, 300, 30);
		labelModo.setBounds(120, 25, 300, 30);
		buttonBusca.setBounds(450, 50, 150, 30);
		buttonCidades.setBounds(450, 100, 150, 30);
		buttonProdutos.setBounds(450, 200, 150, 30);
		buttonLojas.setBounds(450, 150, 150, 30);
		buttonNovaLoja.setBounds(450, 250, 150, 30);
		jlistMenu.setBounds(120, 100, 300, 300);
		//lista.setVisibleRowCount(10);

		janela.setLayout(null);
		janela.addWindowListener(this);
		janela.addKeyListener(this);

		janela.add(textfieldBusca);
		janela.add(jlistMenu);
		janela.add(buttonCidades);
		janela.add(buttonLojas);
		janela.add(buttonNovaLoja);
		janela.add(buttonBusca);
		janela.add(buttonProdutos);
		janela.add(labelModo);
		janela.setSize(700, 500);
		janela.setVisible(true);
		MouseListener mouseListener = new MyMouseAdapter();
		jlistMenu.addMouseListener(mouseListener);

		buttonBusca.addActionListener(this);
		buttonCidades.addActionListener(this);
		buttonLojas.addActionListener(this);
		buttonProdutos.addActionListener(this);
		buttonNovaLoja.addActionListener(this);
		textfieldBusca.addKeyListener(this);
		jlistMenu.addListSelectionListener(this);
	}

	public static void main(String[] args) {
		TelaMenu telaMain = new TelaMenu();
		telaMain.atualizarJlistProdutos(dados.buscar_tudo(""));
	}


	public void atualizarJlistProdutos(ArrayList<Produto> obj_list) {
		changeModo(0);
		listaObjetos = obj_list;
		jlistMenu.setListData(ControleDados.listarEmString(obj_list));
		jlistMenu.updateUI();
	}

	public void atualizarJlistProdutos() {
		changeModo(0);
		jlistMenu.setListData(ControleDados.listarEmString(listaObjetos));
		jlistMenu.updateUI();
	}

	public static Object getObjectClicked() {
		int index = jlistMenu.getSelectedIndex();
		Object returnValue = null;
		if ( listMode == 0 ) {
			returnValue = listaObjetos.get(index);
		} else if ( listMode == 1 ) {
			returnValue = dados.getLojas().get(index);
		} else if ( listMode == 2 ) {
			returnValue = controleDados.listarCidades()[index];
		}
		return returnValue;
	}

	public void changeModo(int novoModo) {
		listMode = novoModo;
		switch (novoModo) {
			case 0 -> labelModo.setText("Buscando produtos");
			case 1 -> labelModo.setText("Buscando lojas");
			case 2 -> labelModo.setText("Buscando cidades");
		}
		labelModo.updateUI();
	}

	public Dados getDados() {
		return dados;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( clickable(e.getWhen()) ) {
			Object src = e.getSource();
			if ( src == buttonLojas ) {
				changeModo(1);
				jlistMenu.setListData(controleDados.listarLojas());
				jlistMenu.updateUI();
			}
			if ( src == buttonCidades ) {
				changeModo(2);
				jlistMenu.setListData(controleDados.listarCidades());
				jlistMenu.updateUI();
			}
			if ( src == buttonProdutos ) {
				changeModo(0);
				atualizarJlistProdutos(dados.buscar_tudo(""));
			}
			if ( src == buttonBusca ) {
				buscar();
			}
			if ( src == buttonNovaLoja ) {
				TelaLoja telaLojaNova = new TelaLoja(new Loja(null, null, null), self);
			}
		}
	}

	public static void buscar() {
		switch (listMode) {
			case 0 -> self.atualizarJlistProdutos(dados.buscar_tudo(textfieldBusca.getText()));
			case 1 -> {
				System.out.println("Buscando lojas");
				self.changeModo(1);
				jlistMenu.setListData(ControleDados.listarEmString(dados.buscar_lojas(textfieldBusca.getText())));
				jlistMenu.updateUI();
			}
		}
	}

	static class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if ( self.clickable(e.getWhen()) ) {
				var itemClicked = getObjectClicked();
				if ( itemClicked != null ) {
					if ( getObjectClicked().getClass() == Cosmetico.class ) {
						new TelaComestico((Cosmetico) getObjectClicked(), self);
					} else if ( getObjectClicked().getClass() == Medicamento.class ) {
						new TelaMedicamento((Medicamento) getObjectClicked());
					} else if ( getObjectClicked().getClass() == Loja.class ) {
						new TelaLoja((Loja) getObjectClicked(), self);
					}
				}
			}
		}
	}

	public boolean clickable(long currentClick) {
		if ( currentClick - lastClick > 175 ) {
			lastClick = currentClick;
			return true;
		} else {
			return false;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		buscar();
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {
		if ( listMode == 0 ) {
			self.atualizarJlistProdutos(dados.buscar_tudo(textfieldBusca.getText()));
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}
