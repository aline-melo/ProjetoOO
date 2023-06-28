package view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;

/**
 * Classe que cria a tela principal do programa.
 *
 * @version 1.0
 * @see TelaComestico
 * @see TelaMedicamento
 * @see TelaLoja
 * @since 06/2023
 */
@SuppressWarnings({"FieldMayBeFinal", "OverlyLongMethod", "OverlyComplexMethod"})
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

	/**
	 * Construtor de uma {@link TelaMenu}.
	 *
	 * @see TelaLoja#TelaLoja(Loja, TelaMenu)  TelaLoja
	 * @see TelaComestico#TelaComestico(Cosmetico, Object)  TelaComestico
	 * @see TelaMedicamento#TelaMedicamento(Medicamento, Object)  TelaMedicamento
	 * @see Dados#criarDados()
	 */
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
		new TelaMenu();
	}

	/**
	 * Atualiza a HUD e o parâmetro listaProdutos com uma nova {@link ArrayList lista} de {@link Produto Produtos} e chama
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
	 * Atualiza a HUD usando o parâmetro listaProdutos de {@link Produto Produtos} e chama
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
	 * Atualiza a HUD e o parâmetro listaLojas com uma nova {@link ArrayList lista} de {@link Loja Lojas} e chama
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

	/**
	 * Atualiza o parâmetro listMode e altera o texto da {@link JLabel label} para o caso correspondente: <br>
	 * 0  ->  Buscando em produtos <br>
	 * 1  ->  Buscando em lojas <br>
	 * 2  ->  Buscando em cidades <br>
	 * <br>
	 * ListMode é usado para especificar que tipo de objeto está sendo buscado e mostrado na {@link JList lista}. <br>
	 *
	 * @param novoModo {@link Integer int} com o valor do modo para ser alterado.
	 * @author Caio Pacheco
	 * @see TelaMenu#actionPerformed(ActionEvent)
	 * @see TelaMenu#buscar()
	 * @since 06/2023
	 */
	public void changeModo(int novoModo) {
		listMode = novoModo;
		switch (novoModo) {
			case 0:
				labelModo.setText("Buscando em produtos");
			case 1:
				labelModo.setText("Buscando em lojas");
			case 2:
				labelModo.setText("Buscando em cidades");
		}
		labelModo.updateUI();
	}

	/**
	 * Método que trata os eventos de clique nos botões em TelaMenu. <br>Chama os métodos correspondentes para cada caso, somente se
	 * {@link TelaMenu#clickable(long)} retornar true.
	 * <br><br>
	 * Chama {@link TelaMenu#buscar()} se o botão clicado for o de buscar. <br><br>
	 * Chama {@link TelaMenu#changeModo(int)} e {@link TelaMenu#buscar()} se o botão clicado for o de
	 * produtos, lojas ou cidades. <br>
	 * <br>
	 *
	 * @param e {@link ActionEvent evento de clique}
	 * @see TelaMenu#clickable(long)
	 * @see TelaMenu#changeModo(int)
	 * @see TelaMenu#buscar()
	 * @since 06/2023
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if ( src == buttonLojas ) {
			changeModo(1);
			textfieldBusca.setText("");
			textfieldBusca.updateUI();
			buscar();
		} else if ( src == buttonCidades ) {
			changeModo(2);
			textfieldBusca.setText("");
			textfieldBusca.updateUI();
			buscar();
		} else if ( src == buttonProdutos ) {
			changeModo(0);
			textfieldBusca.setText("");
			textfieldBusca.updateUI();
			buscar();
		} else if ( src == buttonNovaLoja ) {
			new TelaLoja(new Loja(null, null, null), this);
		}
	}

	/**
	 * Trata da busca e atualização da HUD em {@link TelaMenu}.
	 * <br>
	 * Atualiza a {@link JList lista} com objetos de acordo com o listMode atual e o texto digitado.
	 * <br><br>
	 * Chama diferentes métodos para cada caso: <br>
	 * ListMode = 0 >  {@link Dados#buscar_tudo(String)}<br>
	 * ListMode = 1 >  {@link Loja#buscar_loja(String)}<br>
	 * ListMode = 2 >  {@link Dados#buscarCidades(String)}<br>
	 * <br>
	 * Também atualiza o texto da {@link  JLabel} de acordo com o resultado da busca e do modo atual.
	 *
	 * @author Caio Pacheco
	 * @see TelaMenu#atualizarJlistProdutos(ArrayList)
	 * @see TelaMenu#atualizarJListLojas(ArrayList)
	 * @see TelaMenu#atualizarJListCidades(String[])
	 * @since 06/2023
	 */
	public void buscar() {
		if ( textfieldBusca.getText().isBlank() ) {
			buttonBusca.setText("Atualizar");
		} else {
			buttonBusca.setText("Buscar");
		}
		if ( listMode == 0 ) {
			atualizarJlistProdutos(dados.buscar_tudo(textfieldBusca.getText()));
			if ( !listaProdutos.isEmpty() && !textfieldBusca.getText().isBlank() ) {
				labelList.setText("Resultados para produtos '" + textfieldBusca.getText() + "'");
			} else if ( textfieldBusca.getText().isEmpty() || !listaProdutos.isEmpty() ) {
				labelList.setText("Todos os produtos listados:");

			} else {
				labelList.setText("Nenhum produto encontrado para '" + textfieldBusca.getText() + "'");
			}
		} else if ( listMode == 1 ) {
			atualizarJListLojas(dados.buscar_lojas(textfieldBusca.getText()));
			if ( !listaLojas.isEmpty() && !textfieldBusca.getText().isBlank() ) {
				labelList.setText("Resultados para lojas '" + textfieldBusca.getText() + "'");
			} else if ( textfieldBusca.getText().isEmpty() || !listaLojas.isEmpty() ) {
				labelList.setText("Todas as lojas listadas:");

			} else {
				labelList.setText("Nenhuma loja encontrada para '" + textfieldBusca.getText() + "'");
			}
		} else if ( this.listMode == 2 ) {
			this.atualizarJListCidades(dados.buscarCidades(this.textfieldBusca.getText()));
			if ( !this.listaCidades.isEmpty() && !this.textfieldBusca.getText().isBlank() ) {
				this.labelList.setText("Resultados para cidades '" + this.textfieldBusca.getText() + "'");
			} else if ( this.textfieldBusca.getText().isEmpty() || !this.listaCidades.isEmpty() ) {
				this.labelList.setText("Todas as cidades listadas:");
			} else {
				labelList.setText("Nenhuma cidade encontrada para '" + textfieldBusca.getText() + "'");
			}
			labelList.updateUI();
		}
		jlistMenu.clearSelection();
	}

	/**
	 * Método que trata os eventos de clique na lista. <br>
	 * Se {@link TelaMenu#clickable(long)} retornar true:<br><br>
	 * Para listMode = 0, chama {@link TelaComestico#TelaComestico(Cosmetico, Object) new TelaCosmetico}  ou
	 * {@link TelaMedicamento#TelaMedicamento(Medicamento, Object) new TelaMedicamento} de acordo com o tipo do produto
	 * clicado.<br><br>
	 * Para listMode = 1, chama {@link TelaLoja#TelaLoja(Loja, TelaMenu) new TelaLoja} com a loja clicada.<br><br>
	 * Para listMode = 2, chama {@link TelaMenu#atualizarJListLojas(ArrayList)} e {@link Dados#buscar_lojas(String)}
	 * com a {@link String} da cidade clicada.<br><br>
	 *
	 * @param e evento de clique
	 * @see TelaLoja#clickable(long)
	 * @see TelaMedicamento
	 * @see TelaComestico
	 * @since 06/2023
	 */
	public void valueChanged(ListSelectionEvent e) {

		int index = jlistMenu.getSelectedIndex();

		if ( e.getValueIsAdjusting() && clickable(System.currentTimeMillis()) ) {
			if ( listMode == 0 ) {
				if ( this.listaProdutos.get(index).getClass() == Cosmetico.class ) {
					new TelaComestico((Cosmetico) this.listaProdutos.get(index), this);
				} else if ( this.listaProdutos.get(index).getClass() == Medicamento.class ) {
					new TelaMedicamento((Medicamento) this.listaProdutos.get(index), this);
				}

			} else if ( listMode == 1 ) {
				new TelaLoja(listaLojas.get(index), this);
			} else if ( listMode == 2 ) {
				cidadeClicada = listaCidades.get(index);
				atualizarJListLojas(dados.buscar_lojas(cidadeClicada));
				labelList.setText("Resultados para lojas na cidade '" + (cidadeClicada) + "'");
				labelList.updateUI();
			}
		}
	}

	/**
	 * Verifica se um evento de clique em um {@link TelaMenu#actionPerformed(ActionEvent) botão} ou em uma
	 * {@link TelaMenu#valueChanged(ListSelectionEvent) lista}
	 * pode ser executado.
	 * <br>
	 * Checa se tempo suficiente passou desde o último clique para validar se o novo pode ser executado.
	 * <br>
	 * Usado para evitar acionar múltiplos cliques acidentais.
	 *
	 * @param currentClick tempo atual no instante do clique.
	 * @return true se o clique for válido para execução, false se não for.
	 * @see TelaMenu#actionPerformed(ActionEvent)
	 * @see TelaMenu#valueChanged(ListSelectionEvent)
	 * @since 06/2023
	 */
	public boolean clickable(long currentClick) {
		boolean x = false;
		if ( currentClick - lastClick > 175 ) {
			lastClick = currentClick;
			x = true;
		} else {
			jlistMenu.clearSelection();
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

	/**
	 * Atualiza a HUD usando {@link TelaMenu#buscar()} quando a janela recebe foco.
	 * @param e {@link WindowEvent evento de ativação da janela}
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		buscar();
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


