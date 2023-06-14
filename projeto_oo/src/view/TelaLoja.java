package view;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ListUI;

import controle.ControleDados;
import modelo.Cosmetico;
import modelo.Loja;
import modelo.Medicamento;
import modelo.Produto;


public class TelaLoja implements ActionListener, ListSelectionListener, KeyListener, WindowListener {
    private static final JFrame janelaLoja = new JFrame("Loja");
    private static final JButton buttonBusca = new JButton("Buscar Produto");
    private static final JButton buttonCriarProduto = new JButton("Criar Produto");
    private static final JTextField textfieldBusca = new JTextField("");
    private static final JTextField textfieldEndereco = new JTextField("Endereço");
    private static final JTextField textfieldCidade = new JTextField("Cidade");

    private static JList<String> jlistLoja;
    private static ArrayList<Produto> listaObjetos = new ArrayList<Produto>();
    private static TelaLoja self;

    private static Loja lojaPai;
    private TelaMenu telaPai;


    public TelaLoja(Loja loja, TelaMenu pai) {

        String[] listaAExibir = {};

        jlistLoja = new JList<String>(listaAExibir);
        self = this;
        telaPai = pai;
        lojaPai = loja;
        listaObjetos = loja.getEstoque();


        //titulo.setFont(new Font("Arial", Font.BOLD, 20));
        textfieldBusca.setBounds(120, 50, 300, 30);
        buttonBusca.setBounds(450, 50, 150, 30);
        buttonCriarProduto.setBounds(450, 100, 150, 30);
        textfieldEndereco.setBounds(450, 170, 150, 30);
        textfieldCidade.setBounds(450, 220, 150, 30);
        jlistLoja.setBounds(120, 100, 300, 300);
        //lista.setVisibleRowCount(10);

        janelaLoja.setLayout(null);

        janelaLoja.add(textfieldBusca);
        janelaLoja.add(jlistLoja);
        janelaLoja.add(buttonCriarProduto);
        janelaLoja.add(buttonBusca);
        janelaLoja.add(textfieldEndereco);
        janelaLoja.add(textfieldCidade);
        janelaLoja.setSize(700, 500);
        janelaLoja.setVisible(true);
        janelaLoja.addWindowListener(this);
        MouseListener mouseListener = new LojaMouseAdapter();
        jlistLoja.addMouseListener(mouseListener);

        textfieldCidade.setText(loja.getCidade());
        textfieldEndereco.setText(loja.getLocalizacao());
        if ( loja.getLocalizacao() == null || listaObjetos.isEmpty() ) {
            listaObjetos = new ArrayList<Produto>();
        } else {
            listaObjetos = loja.getEstoque();
        }
        jlistLoja.updateUI();
        buttonBusca.addActionListener(this);
        buttonCriarProduto.addActionListener(this);

        this.atualizarJlistProdutos();

    }

    public Loja getLojaPai() {
        return lojaPai;
    }

    public TelaMenu getTelaPai() {
        return telaPai;
    }

    public void atualizarJlistProdutos() {
        listaObjetos = lojaPai.getEstoque();
        jlistLoja.setListData(ControleDados.listarEmString(listaObjetos));
        jlistLoja.updateUI();
        jlistLoja.update(jlistLoja.getGraphics());
        jlistLoja.clearSelection();
        jlistLoja.revalidate();
    }

    public void atualizarJlistProdutos(ArrayList<Produto> lista) {
        jlistLoja.removeListSelectionListener(this);
        listaObjetos = lista;
        jlistLoja.setListData(ControleDados.listarEmString(lista));
        jlistLoja.updateUI();
        jlistLoja.update(jlistLoja.getGraphics());
        jlistLoja.clearSelection();
        jlistLoja.addListSelectionListener(this);
    }

    static class LojaMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                int index = jlistLoja.locationToIndex(e.getPoint());
                jlistLoja.clearSelection();
                Produto produto = listaObjetos.get(index);
                if ( produto instanceof Medicamento ) {
                    new TelaMedicamento((Medicamento) produto);
                } else if ( produto instanceof Cosmetico ) {
                    new TelaComestico((Cosmetico) produto, self);
                }
            } catch (IndexOutOfBoundsException exception) {
                return;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if ( src == buttonCriarProduto ) {
            TelaComestico tela = new TelaComestico(
                    new Cosmetico(
                            null, null, null, 0, 0,
                            null, null, null, false
                    ),
                    self
            );
        } else if ( src == buttonBusca ) {
            atualizarJlistProdutos(lojaPai.buscar_loja(textfieldBusca.getText()));
        }
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

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

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

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }


}