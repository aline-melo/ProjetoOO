package view;

import modelo.Dados;
import modelo.Cosmetico;
import modelo.Loja;
import modelo.Medicamento;
import modelo.Produto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
/*
@author Caio Pacheco
@since 06/2023

 */

/**
 * Interface gráfica para a classe {@link Loja}.
 *
 * @author Caio Pacheco
 * @version 1.0
 * @see TelaLoja#TelaLoja(Loja, TelaMenu)  new TelaLoja
 * @see TelaLoja#actionPerformed(ActionEvent)
 * @see TelaLoja#valueChanged(ListSelectionEvent)
 * @see Dados
 * @since 06/2023
 */
public class TelaLoja implements ActionListener, ListSelectionListener, KeyListener {
	private final Dados dados;

    private final JFrame janelaLoja = new JFrame("Loja");

    private final JButton buttonBusca = new JButton("Buscar");

    private final JButton buttonCriarCosmestico = new JButton("Criar Cosmético");
    private final JButton buttonCriarMedicamento = new JButton("Criar Medicamento");
    private final JButton buttonSalvar = new JButton("Salvar Loja");
    private final JButton buttonApagar = new JButton("Apagar loja");
    private final JTextField textfieldBusca = new JTextField("");
    private final JTextField textfieldEndereco = new JTextField("Endereço");
    private final JTextField textfieldCidade = new JTextField("Cidade");
    private final JLabel labelBusca = new JLabel("Buscar Produto");
    private final JLabel labelEndereco = new JLabel("Endereço");

    private final JLabel labelCidade = new JLabel("Cidade");
    private final JLabel labelList = new JLabel("Produtos nessa loja:");

    private JList<String> jlistLoja;
    private ArrayList<Produto> listaObjetos;

    private static Loja lojaPai;
    private TelaMenu telaPai;
    private long lastClick = 0;

    /**
     * Construtor de uma {@link TelaLoja}.
     *
     * @param loja Loja a ser exibida
     * @param pai  TelaMenu que chamou o construtor da TelaLoja
     * @see Loja
     * @see TelaMenu
     * @see TelaLoja#buscar()
     * @see TelaLoja#valueChanged(ListSelectionEvent)
     * @see TelaLoja#actionPerformed(ActionEvent)
     */
    public TelaLoja(Loja loja, TelaMenu pai) {

		this.dados = Dados.getDados();
		String[] listaAExibir = {};

        jlistLoja = new JList<>(listaAExibir);

        telaPai = pai;
        lojaPai = loja;
        listaObjetos = loja.getEstoque();


        textfieldBusca.setBounds(50, 50, 300, 30);
        labelBusca.setBounds(50, 30, 200, 25);
        buttonBusca.setBounds(380, 50, 150, 30);
        buttonCriarCosmestico.setBounds(380, 100, 150, 30);
        buttonCriarMedicamento.setBounds(380, 150, 150, 30);
        buttonSalvar.setBounds(380, 200, 150, 30);
        textfieldEndereco.setBounds(380, 250, 150, 30);
        textfieldCidade.setBounds(380, 300, 150, 30);
        labelEndereco.setBounds(380, 230, 150, 25);
        labelCidade.setBounds(380, 280, 150, 25);
        labelList.setBounds(50, 75, 330, 25);
        jlistLoja.setBounds(50, 100, 300, 300);
        buttonApagar.setBounds(380, 370, 150, 30);

        janelaLoja.setLayout(null);

        janelaLoja.add(textfieldBusca);
        janelaLoja.add(jlistLoja);
        janelaLoja.add(buttonCriarCosmestico);
        janelaLoja.add(buttonCriarMedicamento);
        janelaLoja.add(buttonBusca);
        janelaLoja.add(buttonSalvar);
        janelaLoja.add(buttonApagar);
        janelaLoja.add(textfieldEndereco);
        janelaLoja.add(textfieldCidade);
        janelaLoja.add(labelBusca);
        janelaLoja.add(labelEndereco);
        janelaLoja.add(labelCidade);
        janelaLoja.add(labelList);
        janelaLoja.setSize(585, 485);
        janelaLoja.addWindowListener(new LojaWindowAdapter());
        janelaLoja.setVisible(true);


        janelaLoja.setTitle("Loja:  " + loja.getLocalizacao());
        if ( lojaPai.getLocalizacao() == null ) {
            janelaLoja.setTitle("Criar Loja");
        } else {
            labelList.setText("Todos os produtos da loja " + lojaPai.getLocalizacao());
            labelList.updateUI();
        }


        jlistLoja.addListSelectionListener(this);
        buttonBusca.addActionListener(this);
        buttonSalvar.addActionListener(this);
        buttonApagar.addActionListener(this);
        buttonCriarMedicamento.addActionListener(this);
        buttonCriarCosmestico.addActionListener(this);
        textfieldBusca.addKeyListener(this);
        janelaLoja.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        textfieldCidade.setText(loja.getCidade());
        textfieldEndereco.setText(loja.getLocalizacao());


        this.atualizarJlistProdutos();
        buttonApagar.setEnabled(lojaPai.getLocalizacao() != null);

    }

    /**
     * Retorna a {@link Loja} que está sendo exibida.
     *
     * @return {@link Loja}
     */
    public Loja getLojaPai() {
        return lojaPai;
    }

    /**
     * Retorna a {@link TelaMenu} que chamou a {@link TelaLoja}.
     *
     * @return {@link TelaMenu}
     */
    public TelaMenu getTelaPai() {
        return telaPai;
    }

    /**
     * Atualiza a HUD e o parêmetro listaObjetos com todos os {@link Produto Produtos} cadastrados em uma {@link  Loja}.
     * <br>
     *
     * @see TelaLoja#atualizarJlistProdutos(ArrayList)
     * @see Loja#getEstoque()
     * @see Loja#buscar_loja(String)
     * @since 06/2023
     */
    public void atualizarJlistProdutos() {

        listaObjetos = lojaPai.buscar_loja("");
        jlistLoja.setListData(dados.listarProdutoEmString(listaObjetos));


        jlistLoja.updateUI();
    }

    /**
     * Atualiza a HUD e o parâmetro listaProdutos com uma nova {@link ArrayList lista} de {@link Produto Produtos}. <br>
     *
     * @param lista {@link ArrayList} com os Produtos a serem mostradas na {@link JList}
     * @since 06/2023
     */
    public void atualizarJlistProdutos(ArrayList<Produto> lista) {
        listaObjetos = lista;
        jlistLoja.setListData(dados.listarProdutoEmString(lista));
        jlistLoja.updateUI();
    }

    /**
     * Método que trata os eventos de clique na lista. <br>
     * Abre uma {@link TelaMedicamento}  ou uma
     * {@link TelaComestico}  dependendo do produto selecionado, somente se
     * {@link TelaLoja#clickable(long)} retornar true.
     * <br>
     *
     * @param e evento de clique
     * @see TelaLoja#clickable(long)
     * @see TelaMedicamento
     * @see TelaComestico
     * @since 06/2023
     */
    public void valueChanged(ListSelectionEvent e) {
 
        if ( clickable(System.currentTimeMillis()) ) {
            if ( e.getValueIsAdjusting() ) {
                int index = jlistLoja.getSelectedIndex();
                Produto produto = listaObjetos.get(index);
                if ( produto instanceof Medicamento ) {
                    new TelaMedicamento((Medicamento) produto, this);
                } else if ( produto instanceof Cosmetico ) {
                    new TelaComestico((Cosmetico) produto, this);
                }
            }
        }
    }

    /**
     * Verifica se {@link  TelaLoja} possui os dados suficientes para ser salva como uma {@link Loja}.
     * <br>
     * Exibe uma caixa de diálogo caso algum dos campos estejam incompletos.
     * <br>
     * Chama {@link Dados#salvarLoja(Loja, String, String, ArrayList)} e fecha a janela se os campos estiverem
     * preenchidos.
     *
     * @see TelaLoja#atualizarJlistProdutos()
     * @see Dados#salvarLoja(Loja, String, String, ArrayList)
     * @since 06/2023
     */
    public void salvarLoja() {
        atualizarJlistProdutos(lojaPai.getEstoque());
        if ( textfieldEndereco.getText().equals("") || textfieldCidade.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "A loja precisa de um endereço e " +
                    "uma cidade!");
        } else {
            dados.salvarLoja(lojaPai, textfieldEndereco.getText(), textfieldCidade.getText(), listaObjetos);
            JOptionPane.showMessageDialog(null, "Loja salva com sucesso!");
            janelaLoja.dispose();
        }
    }

    /**
     * {@link WindowListener} de {@link TelaLoja}.
     *
     * @version 1.0
     * @see LojaWindowAdapter#windowClosing(WindowEvent)
     * @see LojaWindowAdapter#windowActivated(WindowEvent)
     * @since 06/2023
     */
    class LojaWindowAdapter extends WindowAdapter {
        /**
         * Fecha a janela.
         *
         * @param e the event to be processed
         */
        @Override
        public void windowClosing(WindowEvent e) {
            janelaLoja.dispose();
        }

        /**
         * Atualiza a HUD usando {@link #buscar()} quando a janela recebe foco.
         *
         * @param e {@link WindowEvent evento de ativação da janela}
         */
        @Override
        public void windowActivated(WindowEvent e) {
            buscar();
        }

    }

    /**
     * Verifica se um evento de clique em um {@link TelaLoja#actionPerformed(ActionEvent) botão} ou em uma
     * {@link TelaLoja#valueChanged(ListSelectionEvent) lista}
     * pode ser executado.
     * <br>
     * Checa se tempo suficiente passou desde o último clique para validar se o novo pode ser executado.
     * <br>
     * Usado para evitar acionar múltiplos cliques acidentais.
     *
     * @param currentClick tempo atual no instante do clique.
     * @return true se o clique for válido para execução, false se não for.
     * @see TelaLoja#actionPerformed(ActionEvent)
     * @see TelaLoja#valueChanged(ListSelectionEvent)
     * @since 06/2023
     */
    public boolean clickable(long currentClick) {
        boolean x = false;

        if ( currentClick - lastClick > 750 ) {
            lastClick = currentClick;
            x = true;
        }
        return x;
    }

    /**
     * Método que trata os eventos de clique nos botões. <br>Chama os métodos correspondentes para cada caso, somente se
     * {@link TelaLoja#clickable(long)} retornar true.
     * <br><br>
     * {@link TelaLoja#cosmeticoVazio()} para o botão criar cosmético.<br>
     * {@link TelaLoja#medicamentoVazio()} para o botão criar medicamento.<br>
     * {@link TelaLoja#buscar()} para o botão buscar.<br>
     * {@link TelaLoja#salvarLoja()} para o botão salvar.<br>
     * {@link Dados#deletarLoja(Loja)} para o botão apagar loja.<br>
     * <br>
     *
     * @param e {@link ActionEvent evento de clique}
     * @see TelaLoja#clickable(long)
     * @see TelaLoja#medicamentoVazio()
     * @see TelaLoja#cosmeticoVazio()
     * @see TelaLoja#buscar()
     * @see TelaLoja#salvarLoja()
     * @see Dados#deletarLoja(Loja)
     * @since 06/2023
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if ( clickable(e.getWhen()) ) {
            if ( src == buttonCriarCosmestico ) {
                cosmeticoVazio();
            } else if ( src == buttonCriarMedicamento ) {
                medicamentoVazio();
            } else if ( src == buttonBusca ) {
                buscar();
            } else if ( src == buttonSalvar ) {
                salvarLoja();
            } else if ( src == buttonApagar ) {
                if ( 0 == JOptionPane.showConfirmDialog(null, "Deseja Apagar a loja?",
                        "Apagar", JOptionPane.YES_NO_OPTION) ) {
                    dados.deletarLoja(lojaPai);
                    janelaLoja.dispose();
                }
            }
        }
    }

    /**
     * Trata da busca de {@link Produto produtos} em Tela Loja.
     * <br>
     * Atualiza a {@link JList lista de produtos} da loja de acordo com o que foi digitado, chamando  {@link Loja#buscar_loja(String)}.
     * <br>
     * Também atualiza a {@link  JLabel} de acordo com o resultado da busca.
     *
     * @see TelaLoja#atualizarJlistProdutos(ArrayList)
     * @see Loja#buscar_loja(String)
     * @since 06/2023
     */
    public void buscar() {
        atualizarJlistProdutos(lojaPai.buscar_loja(textfieldBusca.getText()));
        if ( !listaObjetos.isEmpty() && !textfieldBusca.getText().isBlank() ) {
            labelList.setText("Resultados para '" + textfieldBusca.getText() + "'");
        } else if ( listaObjetos.isEmpty() && textfieldBusca.getText().isBlank() ) {
            labelList.setText("Nenhum Produto nessa loja");
        } else if ( textfieldBusca.getText().isEmpty() ) {
            if ( lojaPai.getLocalizacao() != null ) {
                labelList.setText("Todos os produtos da loja " + lojaPai.getLocalizacao());
            } else {
                labelList.setText("Todos os produtos da loja");
            }
        } else {
            labelList.setText("Nenhum resultado encontrado para '" + textfieldBusca.getText() + "'");
        }
        labelList.updateUI();
    }

    /**
     * Abre uma nova {@link TelaMedicamento} com um {@link Medicamento} vazio.
     */
    public void medicamentoVazio() {
        new TelaMedicamento(new Medicamento(null, null,
                null, 0, 0, null, null, null, false,
                null), this);
    }

    /**
     * Abre uma nova {@link TelaComestico} com um {@link Cosmetico} vazio.
     */
    public void cosmeticoVazio() {
        new TelaComestico(new Cosmetico(null,
                null, null, 0, 0,
                null, null, null, true), this);
    }

    /**
     * Método não implementado e não utilizado.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Método não implementado e não utilizado.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Atualiza a HUD chamando {@link #buscar()} quando uma tecla é solta.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        buscar();
    }


}