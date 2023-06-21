package view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;

import static modelo.Controle.*;


@SuppressWarnings({"FieldMayBeFinal", "OverlyLongMethod", "OverlyComplexMethod"})
public class TelaMenu implements ActionListener, ListSelectionListener, KeyListener, WindowListener, FocusListener {

	private static final Controle controleDados = new Controle();
	private static final Dados dados = controleDados.getDados();
	private static final JButton buttonBusca = new JButton("Buscar");
	private static final JButton buttonCidades = new JButton("Cidades");
	private static final JButton buttonProdutos = new JButton("Produtos");
	private static final JButton buttonLojas = new JButton("Lojas");
	private static final JButton buttonNovaLoja = new JButton("Nova Loja");
	private final JTextField textfieldBusca = new JTextField("");
	private JLabel labelModo = new JLabel("Buscando produtos");
	private JLabel labelList = new JLabel("Todos os produtos listados:");
	private JList<String> jlistMenu;
	private ArrayList listaObjetos = new ArrayList<>();
	private int listMode = 0;
	private static TelaMenu self;
	private long lastClick = 0;


	public TelaMenu() {

		String[] listaAExibir = {};

		jlistMenu = new JList<>(listaAExibir);
		self = this;

		textfieldBusca.setBounds(120, 50, 300, 30);
		labelList.setBounds(120, 75, 330, 25);
		labelModo.setBounds(120, 25, 300, 30);
		buttonBusca.setBounds(450, 50, 150, 30);
		buttonCidades.setBounds(450, 100, 150, 30);
		buttonProdutos.setBounds(450, 200, 150, 30);
		buttonLojas.setBounds(450, 150, 150, 30);
		buttonNovaLoja.setBounds(450, 250, 150, 30);
		jlistMenu.setBounds(120, 100, 300, 300);

		JFrame janela = new JFrame("Drogarias OO");
		janela.setLayout(null);
		janela.addWindowListener(this);
		janela.addKeyListener(this);

		janela.add(textfieldBusca);
		janela.add(labelList);
		janela.add(jlistMenu);
		janela.add(buttonCidades);
		janela.add(buttonLojas);
		janela.add(buttonNovaLoja);
		janela.add(buttonBusca);
		janela.add(buttonProdutos);
		janela.add(labelModo);
		janela.setSize(700, 500);
		janela.setVisible(true);

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
		jlistMenu.setListData(listarEmString(obj_list));
		jlistMenu.updateUI();
	}

	public void atualizarJlistProdutos() {
		changeModo(0);
		jlistMenu.setListData(listarEmString(listaObjetos));
		jlistMenu.updateUI();
	}

	public void atualizarJListLojas(ArrayList<Loja> obj_list) {
		changeModo(1);
		listaObjetos = obj_list;
		jlistMenu.setListData(listarEmString(obj_list));
		jlistMenu.updateUI();
	}

	public void atualizarJListLojas() {
		changeModo(1);
		jlistMenu.setListData(controleDados.listarLojas());
		jlistMenu.updateUI();
	}


	public void atualizarJListCidades(String[] obj_list) {
		changeModo(2);
		ArrayList<String> lista = new ArrayList<>();
		Collections.addAll(lista, obj_list);
		listaObjetos = lista;
		jlistMenu.setListData(obj_list);
		jlistMenu.updateUI();
	}

	public void atualizarJListCidades() {
		changeModo(2);
		jlistMenu.setListData(controleDados.listarCidades());
		jlistMenu.updateUI();
	}

	public static Object getObjectClicked() {
		int index = self.jlistMenu.getSelectedIndex();
		Object returnValue = null;
		if ( self.listMode == 0 ) {
			returnValue = self.listaObjetos.get(index);
		} else if ( self.listMode == 1 ) {
			try {
				returnValue = dados.getLojas().get(index);
			} catch (Exception ignored) {

			}

		} else if ( self.listMode == 2 ) {
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
	public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if ( src == buttonLojas && listMode != 1 ) {
				atualizarJListLojas();
				labelList.setText("Todas as lojas listadas:");
				labelList.updateUI();
				textfieldBusca.setText("");
				textfieldBusca.updateUI();
			} else if ( src == buttonCidades && listMode != 2 ) {
				atualizarJListCidades();
				labelList.setText("Todas as cidades listadas:");
				labelList.updateUI();
				textfieldBusca.setText("");
				textfieldBusca.updateUI();
			} else if ( src == buttonProdutos && listMode != 0 ) {
				atualizarJlistProdutos(dados.buscar_tudo(""));
				labelList.setText("Todos os produtos listados:");
				labelList.updateUI();
				textfieldBusca.setText("");
				textfieldBusca.updateUI();
			} else if ( src == buttonBusca && listMode != 2 ) {
				buscar();
			} else if ( src == buttonNovaLoja ) {
				new TelaLoja(new Loja(null, null, null), self);
			}
	}

	public static void buscar() {
		if ( self.listMode == 0 ) {
			self.atualizarJlistProdutos(dados.buscar_tudo(self.textfieldBusca.getText()));
			if ( !self.listaObjetos.isEmpty() && !self.textfieldBusca.getText().isBlank() ) {
				self.labelList.setText("Resultados para produtos '" + self.textfieldBusca.getText() + "'");
			} else if ( self.textfieldBusca.getText().isEmpty() || !self.listaObjetos.isEmpty() ) {
				self.labelList.setText("Todos os produtos listados:");
			} else {
				self.labelList.setText("Nenhum produto encontrado para '" + self.textfieldBusca.getText() + "'");
			}
		} else if ( self.listMode == 1 ) {
			self.atualizarJListLojas(dados.buscar_lojas(self.textfieldBusca.getText()));
			if ( !self.listaObjetos.isEmpty() && !self.textfieldBusca.getText().isBlank() ) {
				self.labelList.setText("Resultados para lojas '" + self.textfieldBusca.getText() + "'");
			} else if ( self.textfieldBusca.getText().isEmpty() || !self.listaObjetos.isEmpty() ) {
				self.labelList.setText("Todas as lojas listadas:");
			} else {
				self.labelList.setText("Nenhuma loja encontrada para '" + self.textfieldBusca.getText() + "'");
			}
		} else if ( self.listMode == 2 ) {
			self.atualizarJListCidades(buscarCidades(self.textfieldBusca.getText()));
			if ( !self.listaObjetos.isEmpty() && !self.textfieldBusca.getText().isBlank() ) {
				self.labelList.setText("Resultados para cidades '" + self.textfieldBusca.getText() + "'");
			} else if ( self.textfieldBusca.getText().isEmpty() || !self.listaObjetos.isEmpty() ) {
				self.labelList.setText("Todas as cidades listadas:");
			} else {
				self.labelList.setText("Nenhuma cidade encontrada para '" + self.textfieldBusca.getText() + "'");
			}
			self.labelList.updateUI();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if ( e.getValueIsAdjusting() ) {
			if ( clickable(System.currentTimeMillis()) ) {
				var itemClicked = getObjectClicked();
				if ( itemClicked != null ) {
					if ( itemClicked.getClass() == Cosmetico.class ) {
						new TelaComestico((Cosmetico) itemClicked, self);
					} else if ( itemClicked.getClass() == Medicamento.class ) {
						new TelaMedicamento((Medicamento) itemClicked, self);
					} else if ( itemClicked.getClass() == Loja.class ) {
						new TelaLoja((Loja) itemClicked, self);
					} else if ( itemClicked.getClass() == String.class ) {
						self.atualizarJListLojas(dados.buscar_lojas_cidades((String) itemClicked));
						self.labelList.setText("Resultados para lojas '" + ((String) itemClicked) + "'");
						self.labelList.updateUI();
					}
				}
			} else {
				jlistMenu.clearSelection();
			}
		}
	}

	public boolean clickable(long currentClick) {
		boolean x = false;

		if ( currentClick - lastClick > 175 ) {
			lastClick = currentClick;
			x = true;
		}
		return x;
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
		} else if ( listMode == 1 ) {
			self.atualizarJListLojas(dados.buscar_lojas(textfieldBusca.getText()));
		} else if ( listMode == 2 ) {
			self.atualizarJListCidades();
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


