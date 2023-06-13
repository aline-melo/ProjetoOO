package view;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;
import modelo.Cosmetico;
import modelo.Dados;
import modelo.Medicamento;
import modelo.Produto;


public class TelaMenu implements ActionListener, ListSelectionListener, KeyListener {

	private static final ControleDados controleDados = new ControleDados();
	private static final Dados dados = controleDados.getDados();
	private static final JFrame janela = new JFrame("Drogarias OO");
	private static final JButton buttonBusca = new JButton("Buscar Produto");
	private static final JButton buttonCidades = new JButton("Cidades");
	private static final JButton buttonLojas = new JButton("Lojas");
	private static final JTextField textfieldBusca = new JTextField("");
	private static JList<String> jlistMenu = new JList<String>();
	private static ArrayList<Produto> listaObjetos = new ArrayList<Produto>();
	private static int listMode = 0;
	private static TelaMenu self;


	public TelaMenu() {

		String[] listaAExibir = {};

		jlistMenu = new JList<String>(listaAExibir);
		self = this;


		//titulo.setFont(new Font("Arial", Font.BOLD, 20));
		textfieldBusca.setBounds(120, 50, 300, 30);
		buttonBusca.setBounds(450, 50, 150, 30);
		buttonCidades.setBounds(500, 100, 100, 30);
		buttonLojas.setBounds(500, 150, 100, 30);
		jlistMenu.setBounds(120, 100, 300, 300);
		//lista.setVisibleRowCount(10);

		janela.setLayout(null);

		janela.add(textfieldBusca);
		janela.add(jlistMenu);
		janela.add(buttonCidades);
		janela.add(buttonLojas);
		janela.add(buttonBusca);
		janela.setSize(700, 500);
		janela.setVisible(true);
		MouseListener mouseListener = new MyMouseAdapter();
		jlistMenu.addMouseListener(mouseListener);
	}

	public static void main(String[] args) {
		TelaMenu telaMain = new TelaMenu();

		buttonBusca.addActionListener(telaMain);
		buttonCidades.addActionListener(telaMain);
		buttonLojas.addActionListener(telaMain);
		jlistMenu.addListSelectionListener(telaMain);
	}


	public void atualizarJlistProdutos(ArrayList<Produto> obj_list) {
		listMode = 0;
		listaObjetos = obj_list;
		jlistMenu.setListData(ControleDados.listarEmString(obj_list));
		jlistMenu.updateUI();
	}

	public static Object getObjectClicked() {
		if (listMode == 0) {
			int index = jlistMenu.getSelectedIndex();
			return listaObjetos.get(index);
		}
		return null;
	}

	public static void medicamentoVazio() {
		TelaMedicamento tela = new TelaMedicamento(new Medicamento(null, null,
				null, 0, 0, null, null, null, false,
				null));
	}

	public void cosmeticoVazio() {
		TelaComestico tela = new TelaComestico(new Cosmetico(null,
				null, null, 0, 0,
				null, null, null, true), this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == buttonLojas) {
			listMode = 2;
			String[] listaAExibir = dados.listarLojas();
			jlistMenu.setListData(listaAExibir);
			jlistMenu.updateUI();
		}
		if (src == buttonCidades) {
			listMode = 1;
			String[] listaAExibir = dados.listarCidades();
			jlistMenu.setListData(listaAExibir);
			jlistMenu.updateUI();
		}
		if (src == buttonBusca) {
			this.atualizarJlistProdutos(dados.buscar_tudo(textfieldBusca.getText()));
		}
	}

	private static class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			var itemClicked = getObjectClicked();
			if (itemClicked != null) {
				if (getObjectClicked().getClass() == Cosmetico.class) {
					TelaComestico tela = new TelaComestico((Cosmetico) getObjectClicked(), self);
				} else if (getObjectClicked().getClass() == Medicamento.class) {
					TelaMedicamento tela = new TelaMedicamento((Medicamento) getObjectClicked());
				}
			}
		}
	}

	public Dados getDados() {
		return dados;
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}


}
