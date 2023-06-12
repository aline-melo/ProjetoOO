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

/*
 * exibição do jlist
 * depois eu faço a actionlistener da jlist
 *  
 */

public class TelaMenu implements ActionListener, ListSelectionListener, KeyListener {

	private static ControleDados controleDados = new ControleDados();
	private static Dados dados = controleDados.getDados();
	private static JFrame janela = new JFrame("Drogarias OO");
	private static JButton buscar = new JButton("Buscar Produto");
	private static JButton botaoCidades = new JButton("Cidades");
	private static JButton botaoLojas = new JButton("Lojas");
	private static JTextField caixaDeBusca = new JTextField("");
	private static JList<String> jlist_produtos = new JList<String>();
	private static ArrayList<Produto> listaObjetos = new ArrayList<Produto>();
	private static int listMode = 0;


	public TelaMenu() {

		String[] listaAExibir = {};

		jlist_produtos = new JList<String>(listaAExibir);


		//titulo.setFont(new Font("Arial", Font.BOLD, 20));
		caixaDeBusca.setBounds(120, 50, 300, 30);
		buscar.setBounds(450, 50, 150, 30);
		botaoCidades.setBounds(500, 100, 100, 30);
		botaoLojas.setBounds(500, 150, 100, 30);
		jlist_produtos.setBounds(120, 100, 300, 300);
		//lista.setVisibleRowCount(10);

		janela.setLayout(null);

		janela.add(caixaDeBusca);
		janela.add(jlist_produtos);
		janela.add(botaoCidades);
		janela.add(botaoLojas);
		janela.add(buscar);
		janela.setSize(700, 500);
		janela.setVisible(true);
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//super.mouseClicked(e);
				//System.out.println(getClicked());
				if (getProdutoClicked().getClass() == Cosmetico.class) {
					TelaComestico tela = new TelaComestico((Cosmetico) getProdutoClicked());
				} else if (getProdutoClicked().getClass() == Medicamento.class) {
					TelaMedicamento tela = new TelaMedicamento();
				}
			}
		};
		jlist_produtos.addMouseListener(mouseListener);
	}

	public static void main(String[] args) {
		TelaMenu tela = new TelaMenu();

		buscar.addActionListener(tela);
		botaoCidades.addActionListener(tela);
		botaoLojas.addActionListener(tela);
		jlist_produtos.addListSelectionListener(tela);
	}


	public void atualizarJlistProdutos(ArrayList<Produto> obj_list) {
		listMode = 0;
		listaObjetos = obj_list;
		jlist_produtos.setListData(ControleDados.listarEmString(obj_list));
		jlist_produtos.updateUI();
	}

	public static Produto getProdutoClicked() {
		if (listMode == 0) {
			int index = jlist_produtos.getSelectedIndex();
			return listaObjetos.get(index);
		}
		return null;
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == botaoLojas) {
			listMode = 2;
			String[] listaAExibir = dados.listarLojas();
			jlist_produtos.setListData(listaAExibir);
			jlist_produtos.updateUI();
		}
		if (src == botaoCidades) {
			listMode = 1;
			String[] listaAExibir = dados.listarCidades();
			jlist_produtos.setListData(listaAExibir);
			jlist_produtos.updateUI();
		}
		if (src == buscar) {
			this.atualizarJlistProdutos(dados.buscar_tudo(caixaDeBusca.getText()));
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

	}
}
