package view;

import java.awt.*;
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


public class TelaLoja implements ActionListener, ListSelectionListener, KeyListener {
    private static final JFrame janelaLoja = new JFrame("Loja");
    private static final JButton buttonBusca = new JButton("Buscar Produto");
    private static final JButton buttonCriarProduto = new JButton("Criar Produto");
    private static final JButton buttonSalvar = new JButton("Salvar Loja");
    private static final JButton buttonApagar = new JButton("Apagar loja");
    private static final JTextField textfieldBusca = new JTextField("");
    private static final JTextField textfieldEndereco = new JTextField("Endereço");
    private static final JTextField textfieldCidade = new JTextField("Cidade");

    private JList<String> jlistLoja;
    private ArrayList<Produto> listaObjetos = new ArrayList<Produto>();
    private static TelaLoja self;

    private static Loja lojaPai;
    private TelaMenu telaPai;
    private long lastClick = 0;


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
        buttonSalvar.setBounds(450, 150, 150, 30);
        textfieldEndereco.setBounds(450, 200, 150, 30);
        textfieldCidade.setBounds(450, 250, 150, 30);
        jlistLoja.setBounds(120, 100, 300, 300);
        buttonApagar.setBounds(450, 400, 150, 30);
        //lista.setVisibleRowCount(10);

        janelaLoja.setLayout(null);

        janelaLoja.add(textfieldBusca);
        janelaLoja.add(jlistLoja);
        janelaLoja.add(buttonCriarProduto);
        janelaLoja.add(buttonBusca);
        janelaLoja.add(buttonSalvar);
        janelaLoja.add(buttonApagar);
        janelaLoja.add(textfieldEndereco);
        janelaLoja.add(textfieldCidade);
        janelaLoja.setSize(700, 500);
        janelaLoja.addWindowListener(new LojaWindowAdapter());
        janelaLoja.setVisible(true);
        MouseListener mouseListener = new LojaMouseAdapter();
        jlistLoja.addMouseListener(mouseListener);
        buttonBusca.addActionListener(this);
        buttonSalvar.addActionListener(this);
        buttonApagar.addActionListener(this);
        buttonCriarProduto.addActionListener(this);
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

    public void itemClicked(MouseEvent e) {
        if ( clickable(e.getWhen()) ) {
            try {
                if ( e.getClickCount() == 1 ) {
                    int index = jlistLoja.locationToIndex(e.getPoint());
                    jlistLoja.clearSelection();
                    Produto produto = listaObjetos.get(index);
                    if ( produto instanceof Medicamento ) {
                        new TelaMedicamento((Medicamento) produto);
                    } else if ( produto instanceof Cosmetico ) {
                        new TelaComestico((Cosmetico) produto, self);
                    }
                }
            } catch (IndexOutOfBoundsException exception) {
                return;
            }
        }
    }

    public void windowClose(int mode) {
        atualizarJlistProdutos(lojaPai.getEstoque());
        int option = 0;
        if ( mode == 1 ) {
            option = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?");
        } else if ( mode == 2 ) {
            option = 1;
        }

        if ( option == 0 ) {
            if ( textfieldEndereco.getText().equals("") || textfieldCidade.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "A loja precisa de um endereço e " +
                        "uma cidade!");
            } else {
                ControleDados.salvarLoja(getInfo());
                JOptionPane.showMessageDialog(null, "Loja salva com sucesso!");
                janelaLoja.dispose();
            }
        } else if ( option == 1 ) {
            janelaLoja.dispose();

        } else if ( option == 2 || option == -1 ) {
            janelaLoja.setState(Frame.NORMAL);
            janelaLoja.setVisible(true);
        }
    }

    public boolean clickable(long currentClick) {
        if ( currentClick - lastClick > 500 ) {
            lastClick = currentClick;
            return true;
        } else {
            return false;
        }
    }

    public boolean clickable(long currentClick, double cooldown) {
        if ( currentClick - lastClick > cooldown * 1000 ) {
            lastClick = currentClick;
            return true;
        } else {
            return false;
        }
    }

    static class LojaMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            self.itemClicked(e);
        }
    }


    static class LojaWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            if ( (textfieldEndereco.getText().equals("") || textfieldCidade.getText().equals(""))
                    && !textfieldEndereco.getText().equals(textfieldCidade.getText()) ) {
                self.windowClose(1);
            } else if ( (textfieldEndereco.getText().equals("") || textfieldCidade.getText().equals(""))
                    && textfieldEndereco.getText().equals(textfieldCidade.getText()) ) {
                self.windowClose(2);
            } else {
                self.windowClose(0);
            }
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println(self.listaObjetos);
            self.atualizarJlistProdutos();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( clickable(e.getWhen(), 0.7) ) {
            Object src = e.getSource();
            if ( src == buttonCriarProduto ) {
                cosmeticoVazio();
            } else if ( src == buttonBusca ) {
                atualizarJlistProdutos(lojaPai.buscar_loja(textfieldBusca.getText()));
            } else if ( src == buttonSalvar ) {
                windowClose(0);
            } else if ( src == buttonApagar ) {
                if ( 0 == JOptionPane.showConfirmDialog(null, "Deseja Apagar a loja?",
                        "Apagar", JOptionPane.YES_NO_OPTION) ) {
                    ControleDados.deletarLoja(lojaPai);
                    janelaLoja.dispose();
                }
            }
        }
    }

    public ArrayList getInfo() {
        ArrayList info = new ArrayList<>();
        info.add(lojaPai);
        info.add(textfieldEndereco.getText());
        info.add(textfieldCidade.getText());
        info.add(listaObjetos);
        return info;
    }

    public TelaMedicamento medicamentoVazio() {
        TelaMedicamento tela = new TelaMedicamento(new Medicamento(null, null,
                null, 0, 0, null, null, null, false,
                null));
        return tela;
    }

    public TelaComestico cosmeticoVazio() {
        TelaComestico tela = new TelaComestico(new Cosmetico(null,
                null, null, 0, 0,
                null, null, null, true), this);
        return tela;
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