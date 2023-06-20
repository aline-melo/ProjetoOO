package view;

import controle.ControleDados;
import modelo.Cosmetico;
import modelo.Loja;
import modelo.Medicamento;
import modelo.Produto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;


@SuppressWarnings({"FieldMayBeFinal", "OverlyLongMethod"})
public class TelaLoja implements ActionListener, ListSelectionListener, KeyListener {
    private final JFrame janelaLoja = new JFrame("Loja");
    private final JButton buttonBusca = new JButton("Buscar");
    private static final JButton buttonCriarCosmestico = new JButton("Criar Cosmético");
    private static final JButton buttonCriarMedicamento = new JButton("Criar Medicamento");
    private static final JButton buttonSalvar = new JButton("Salvar Loja");
    private static final JButton buttonApagar = new JButton("Apagar loja");
    private final JTextField textfieldBusca = new JTextField("");
    private final JTextField textfieldEndereco = new JTextField("Endereço");
    private final JTextField textfieldCidade = new JTextField("Cidade");
    private static final JLabel labelBusca = new JLabel("Buscar Produto");
    private static final JLabel labelEndereco = new JLabel("Endereço");

    private static final JLabel labelCidade = new JLabel("Cidade");
    private final JLabel labelList = new JLabel("Produtos nessa loja:");

    private JList<String> jlistLoja;
    private ArrayList<Produto> listaObjetos;
    private static TelaLoja self;

    private static Loja lojaPai;
    private TelaMenu telaPai;
    private long lastClick = 0;


    public TelaLoja(Loja loja, TelaMenu pai) {

        String[] listaAExibir = {};

        jlistLoja = new JList<>(listaAExibir);
        self = this;
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
        labelList.setText("Todos os produtos da loja " + lojaPai.getLocalizacao());
        labelList.updateUI();

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

    }

    public Loja getLojaPai() {
        return lojaPai;
    }

    public TelaMenu getTelaPai() {
        return telaPai;
    }

    public void atualizarJlistProdutos() {
        listaObjetos = lojaPai.buscar_loja("");
        jlistLoja.setListData(ControleDados.listarEmString(listaObjetos));
        jlistLoja.updateUI();
    }

    public void atualizarJlistProdutos(ArrayList<Produto> lista) {
        listaObjetos = lista;
        jlistLoja.setListData(ControleDados.listarEmString(lista));
        jlistLoja.updateUI();
    }

	public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if ( clickable(System.currentTimeMillis()) ) {
            if ( e.getValueIsAdjusting() ) {
                int index = jlistLoja.getSelectedIndex();
                Produto produto = listaObjetos.get(index);
                if ( produto instanceof Medicamento ) {
                    new TelaMedicamento((Medicamento) produto, self);
                } else if ( produto instanceof Cosmetico ) {
                    new TelaComestico((Cosmetico) produto, self);
                }
            }
        }
    }

    public void salvarLoja() {
        atualizarJlistProdutos(lojaPai.getEstoque());
        if ( textfieldEndereco.getText().equals("") || textfieldCidade.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "A loja precisa de um endereço e " +
                    "uma cidade!");
        } else {
            ControleDados.salvarLoja(getInfo());
            JOptionPane.showMessageDialog(null, "Loja salva com sucesso!");
            janelaLoja.dispose();
        }
    }


    static class LojaWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            self.janelaLoja.dispose();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            self.atualizarJlistProdutos();
        }

    }

    public boolean clickable(long currentClick) {
        boolean x = false;

        if ( currentClick - lastClick > 750 ) {
            lastClick = currentClick;
            x = true;
        }
        return x;
    }

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
                    ControleDados.deletarLoja(lojaPai);
                    janelaLoja.dispose();
                }
            }
        }
    }

    public void buscar() {
        atualizarJlistProdutos(lojaPai.buscar_loja(textfieldBusca.getText()));
        if ( !listaObjetos.isEmpty() && !textfieldBusca.getText().isBlank() ) {
            labelList.setText("Resultados para '" + textfieldBusca.getText() + "'");
        } else if ( textfieldBusca.getText().isEmpty() || !listaObjetos.isEmpty() ) {
            labelList.setText("Todos os produtos da loja " + lojaPai.getLocalizacao());
        } else {
            labelList.setText("Nenhum resultado encontrado para '" + textfieldBusca.getText() + "'");
        }
        labelList.updateUI();
    }

    public ArrayList<Object> getInfo() {
        ArrayList<Object> info = new ArrayList<>();
        info.add((Loja) lojaPai);
        info.add((String) textfieldEndereco.getText());
        info.add((String) textfieldCidade.getText());
        info.add((ArrayList<Produto>) listaObjetos);
        return info;
    }

    public TelaMedicamento medicamentoVazio() {
        return new TelaMedicamento(new Medicamento(null, null,
                null, 0, 0, null, null, null, false,
                null), this);
    }

    public void cosmeticoVazio() {
        new TelaComestico(new Cosmetico(null,
                null, null, 0, 0,
                null, null, null, true), this);
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


}