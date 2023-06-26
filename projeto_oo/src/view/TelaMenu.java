package view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;


@SuppressWarnings({"FieldMayBeFinal", "OverlyLongMethod", "OverlyComplexMethod"})
/** Classe que cria a tela principal do programa.
 * @version 1.0
 * @since 06/2023
 * @autor Caio Pacheco
 * @see TelaComestico
 * @see TelaMedicamento
 * @see TelaLoja
 */
//obj
public class TelaMenu implements ActionListener, ListSelectionListener, KeyListener, WindowListener, FocusListener {

//	private final Controle controleDados = new Controle();
	private final Dados dados;
	private final JButton buttonBusca = new JButton("Atualizar");
	private static final JButton buttonCidades = new JButton("Cidades");
	private static final JButton buttonProdutos = new JButton("Produtos");
	private static final JButton buttonLojas = new JButton("Lojas");
	private static final JButton buttonNovaLoja = new JButton("Nova Loja");
	private final JTextField textfieldBusca = new JTextField("");
	private JLabel labelModo = new JLabel("Buscando produtos");
	private JLabel labelList = new JLabel("Todos os produtos listados:");
	private JList<String> jlistMenu;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Loja> listaLojas;
	private ArrayList<String> listaCidades;
	private String cidadeClicada;
	private int listMode = 0;
	private long lastClick = 0;


	public TelaMenu() {

		this.dados = Dados.getDados();
		String[] listaAExibir = {};

		jlistMenu = new JList<>(listaAExibir);

		textfieldBusca.setBounds(75, 50, 300, 30);
		labelList.setBounds(75, 75, 330, 25);
		labelModo.setBounds(75, 25, 300, 30);
		buttonBusca.setBounds(400, 50, 150, 30);
		buttonCidades.setBounds(400, 100, 150, 30);
		buttonProdutos.setBounds(400, 200, 150, 30);
		buttonLojas.setBounds(400, 150, 150, 30);
		buttonNovaLoja.setBounds(400, 250, 150, 30);
		jlistMenu.setBounds(75, 100, 300, 300);

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
		janela.setSize(625, 500);
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
		//telaMain.atualizarJlistProdutos();
	}

	/**
	 * Atualiza a HUD e o parâmetro listaObjetos com uma nova {@link ArrayList lista} de {@link Produto Produtos} e chama
	 * {@link TelaMenu#changeModo(int)} para alterar o modo de execução. <br>
	 *
	 * @param obj_list {@link ArrayList} com os Produtos a serem mostradas na {@link JList}
	 * @author Caio Pacheco
	 * @see TelaMenu#changeModo(int)
	 * @see TelaMenu#atualizarJlistProdutos()
	 * @see TelaMenu#atualizarJListLojas(ArrayList)
	 * @see TelaMenu#atualizarJListCidades(String[])
	 * @since 06/2023
	 */
	public void atualizarJlistProdutos(ArrayList<Produto> obj_list) {
		changeModo(0);
		listaProdutos = obj_list;
		jlistMenu.setListData(dados.listarProdutoEmString(obj_list));
		jlistMenu.updateUI();
	}

	/**
	 * Atualiza a HUD usando o parâmetro listaObjetos de {@link Produto Produtos} e chama
	 * {@link TelaMenu#changeModo(int)} para alterar o modo de execução. <br>
	 *
	 * @author Caio Pacheco
	 * @see TelaMenu#changeModo(int)
	 * @see TelaMenu#atualizarJListLojas(ArrayList)
	 * @see TelaMenu#atualizarJListCidades(String[])
	 * @since 06/2023
	 */
	public void atualizarJlistProdutos() {
		changeModo(0);
		jlistMenu.setListData(dados.listarProdutoEmString(listaProdutos));
		jlistMenu.updateUI();
	}

	/**
	 * Atualiza a HUD e o parâmetro listaObjetos com uma nova {@link ArrayList lista} de {@link Loja Lojas} e chama
	 * {@link TelaMenu#changeModo(int)} para alterar o modo de execução. <br>
	 *
	 * @param obj_list {@link ArrayList} com as Lojas a serem mostradas na {@link JList}
	 * @author Caio Pacheco
	 * @see TelaMenu#changeModo(int)
	 * @see TelaMenu#atualizarJlistProdutos()
	 * @see TelaMenu#atualizarJListCidades(String[])
	 * @since 06/2023
	 */
	public void atualizarJListLojas(ArrayList<Loja> obj_list) {
		changeModo(1);
		listaLojas = obj_list;
		jlistMenu.setListData(dados.listarLojaEmString(obj_list));
		jlistMenu.updateUI();
	}


	/**
	 * Atualiza a HUD e o parâmetro listaObjetos com uma nova {@link ArrayList lista} de {@link String cidades} e chama
	 * {@link TelaMenu#changeModo(int)} para alterar o modo de execução. <br>
	 *
	 * @param obj_list {@link java.util.List String[]} com as cidades a serem mostradas na {@link JList}
	 * @author Caio Pacheco
	 * @see TelaMenu#changeModo(int)
	 * @see TelaMenu#atualizarJlistProdutos()
	 * @see TelaMenu#atualizarJListLojas(ArrayList)
	 * @since 06/2023
	 */
	public void atualizarJListCidades(String[] obj_list) {
		changeModo(2);
		ArrayList<String> lista = new ArrayList<>();
		Collections.addAll(lista, obj_list);
		listaCidades = lista;
		jlistMenu.setListData(obj_list);
		jlistMenu.updateUI();
	}


	
	public Produto getProdutoClicked() {
		int index = this.jlistMenu.getSelectedIndex();
		Produto returnValue = null;
			returnValue = this.listaProdutos.get(index);

		return returnValue;
		
	}

	public Loja getLojaClicked(int index, String cidadeClicada) {

		Loja returnValue = dados.getLojas().get(index);
		
		if (cidadeClicada != null) {
			returnValue = dados.buscar_lojas(cidadeClicada).get(index);
		}
		this.cidadeClicada = null;

		return returnValue;
	}
	
	public String getCidadeClicked(int index) {
		String returnValue = dados.listarCidades()[index];
		
		return returnValue;
	}
	
	
	
	public void changeModo(int novoModo) {
		listMode = novoModo;
		switch (novoModo) {
			case 0 :
				labelModo.setText("Buscando em produtos");
			case 1 : 
				labelModo.setText("Buscando em lojas");
			case 2 : 
				labelModo.setText("Buscando em cidades");
		}
		labelModo.updateUI();
	}


	public Dados getDados() {
		return dados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if ( src == buttonLojas) {
				atualizarJListLojas(dados.buscar_lojas(""));
				labelList.setText("Todas as lojas listadas:");
				labelList.updateUI();
				textfieldBusca.setText("");
				textfieldBusca.updateUI();
			} else if ( src == buttonCidades ) {
				atualizarJListCidades(dados.listarCidades());
				labelList.setText("Todas as cidades listadas:");
				labelList.updateUI();
				textfieldBusca.setText("");
				textfieldBusca.updateUI();
			} else if ( src == buttonProdutos ) {
				atualizarJlistProdutos(dados.listar_tudo());
				labelList.setText("Todos os produtos listados:");
				labelList.updateUI();
				textfieldBusca.setText("");
				textfieldBusca.updateUI();
			} else if ( src == buttonBusca && listMode != 2 ) {
				buscar();
			} else if ( src == buttonNovaLoja ) {
				new TelaLoja(new Loja(null, null, null), this);
			}
	}

	public  void buscar() {
		if ( this.textfieldBusca.getText().isBlank() ) {
			this.buttonBusca.setText("Atualizar");
		} else {
			this.buttonBusca.setText("Buscar");
		}
		if ( this.listMode == 0 ) {
			this.atualizarJlistProdutos(dados.buscar_tudo(this.textfieldBusca.getText()));
			if ( !this.listaProdutos.isEmpty() && !this.textfieldBusca.getText().isBlank() ) {
				this.labelList.setText("Resultados para produtos '" + this.textfieldBusca.getText() + "'");
			} else if ( this.textfieldBusca.getText().isEmpty() || !this.listaProdutos.isEmpty() ) {
				this.labelList.setText("Todos os produtos listados:");

			} else {
				this.labelList.setText("Nenhum produto encontrado para '" + this.textfieldBusca.getText() + "'");
			}
		} else if ( this.listMode == 1 ) {
			this.atualizarJListLojas(dados.buscar_lojas(this.textfieldBusca.getText()));
			if ( !this.listaLojas.isEmpty() && !this.textfieldBusca.getText().isBlank() ) {
				this.labelList.setText("Resultados para lojas '" + this.textfieldBusca.getText() + "'");
			} else if ( this.textfieldBusca.getText().isEmpty() || !this.listaLojas.isEmpty() ) {
				this.labelList.setText("Todas as lojas listadas:");

			} else {
				this.labelList.setText("Nenhuma loja encontrada para '" + this.textfieldBusca.getText() + "'");
			}
		} else if ( this.listMode == 2 ) {
			this.atualizarJListCidades(dados.buscarCidades(this.textfieldBusca.getText()));
			if ( !this.listaCidades.isEmpty() && !this.textfieldBusca.getText().isBlank() ) {
				this.labelList.setText("Resultados para cidades '" + this.textfieldBusca.getText() + "'");
			} else if ( this.textfieldBusca.getText().isEmpty() || !this.listaCidades.isEmpty() ) {
				this.labelList.setText("Todas as cidades listadas:");
			} else {
				this.labelList.setText("Nenhuma cidade encontrada para '" + this.textfieldBusca.getText() + "'");
			}
			this.labelList.updateUI();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
	

		int index = jlistMenu.getSelectedIndex();
		
		if ( e.getValueIsAdjusting() &&  clickable(System.currentTimeMillis())  ) {
				if ( listMode == 0) {
					if ( this.getProdutoClicked().getClass() == Cosmetico.class ) {
						new TelaComestico((Cosmetico) this.getProdutoClicked(), this);
					} 
					else if ( this.getProdutoClicked().getClass() == Medicamento.class ) {
						new TelaMedicamento((Medicamento) this.getProdutoClicked(), this);
					} 


 
				}
				else if (listMode == 1) {
						new TelaLoja((Loja) this.getLojaClicked(index, cidadeClicada), this);
				} 
				else if (listMode == 2) {
						cidadeClicada = getCidadeClicked(index);
						this.atualizarJListLojas(dados.buscar_lojas(cidadeClicada));
						this.labelList.setText("Resultados para lojas na cidade '" + (cidadeClicada) + "'");
						this.labelList.updateUI();
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
			this.atualizarJlistProdutos(dados.buscar_tudo(textfieldBusca.getText()));
		} else if ( listMode == 1 ) {
			this.atualizarJListLojas(dados.buscar_lojas(textfieldBusca.getText()));
		} else if ( listMode == 2 ) {
			this.atualizarJListCidades(dados.listarCidades());
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


