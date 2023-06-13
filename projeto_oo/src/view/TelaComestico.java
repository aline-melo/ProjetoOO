package view;

import controle.ControleDados;
import modelo.Cosmetico;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TelaComestico implements ActionListener, ListSelectionListener {
    private static final JFrame janelaComestico = new JFrame("");
    private static JButton button_salvar = new JButton("Salvar");
    private static final JTextField field_nome = new JTextField("Nome do comestico");
    private static final JTextArea field_descricao = new JTextArea("field_descricao");
    private static final JTextField field_preco = new JTextField("field_preco");
    private static final JTextField field_estoque = new JTextField("field_estoque");
    private static final JTextField field_fabricante = new JTextField("field_fabricante");
    private static final JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private static final JTextField field_cor = new JTextField("field_cor");
    private static final JTextField field_fragancia = new JTextField("field_fragancia");
    private static final JCheckBox checkbox_hipoalergenico = new JCheckBox("Sim");
    private static final JLabel label_nome = new JLabel("Nome do Cosmético:");
    private static final JLabel label_descricao = new JLabel("Descrição:");
    private static final JLabel label_preco = new JLabel("Preço:");
    private static final JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private static final JLabel label_fabricante = new JLabel("Fabricante:");
    private static final JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private static final JLabel label_cor = new JLabel("Cor:");
    private static final JLabel label_fragancia = new JLabel("Fragância:");
    private static final JLabel label_hipoalergenico = new JLabel("É hipoalergênico?");
    private static String nomeAnterior;


    private static TelaMenu telaPai;

    public TelaComestico(Cosmetico item, TelaMenu pai) {

        nomeAnterior = item.getNome();
        telaPai = pai;

        button_salvar.addActionListener(this);

        field_nome.setBounds(40, 50, 300, 30);
        button_salvar.setBounds(350, 50, 145, 30);
        field_descricao.setBounds(40, 120, 300, 90);
        field_preco.setBounds(350, 120, 145, 30);
        field_estoque.setBounds(350, 180, 145, 30);
        field_fabricante.setBounds(350, 240, 145, 30);
        field_tamanho_embalagem.setBounds(40, 240, 145, 30);
        field_cor.setBounds(195, 240, 145, 30);
        field_fragancia.setBounds(40, 300, 145, 30);
        checkbox_hipoalergenico.setBounds(195, 300, 145, 30);

        label_nome.setBounds(40, 30, 160, 20);
        label_descricao.setBounds(40, 100, 160, 20);
        label_preco.setBounds(350, 100, 160, 20);
        label_estoque.setBounds(350, 160, 160, 20);
        label_fabricante.setBounds(350, 220, 160, 20);
        label_tamanho_embalagem.setBounds(40, 220, 160, 20);
        label_cor.setBounds(195, 220, 160, 20);
        label_fragancia.setBounds(40, 280, 160, 20);
        label_hipoalergenico.setBounds(195, 280, 160, 20);

        janelaComestico.setLayout(null);
        janelaComestico.add(field_nome);
        janelaComestico.add(field_descricao);
        janelaComestico.add(field_preco);
        janelaComestico.add(field_estoque);
        janelaComestico.add(field_fabricante);
        janelaComestico.add(field_tamanho_embalagem);
        janelaComestico.add(field_cor);
        janelaComestico.add(field_fragancia);
        janelaComestico.add(checkbox_hipoalergenico);
        janelaComestico.add(button_salvar);

        janelaComestico.add(label_nome);
        janelaComestico.add(label_descricao);
        janelaComestico.add(label_preco);
        janelaComestico.add(label_estoque);
        janelaComestico.add(label_fabricante);
        janelaComestico.add(label_tamanho_embalagem);
        janelaComestico.add(label_cor);
        janelaComestico.add(label_fragancia);
        janelaComestico.add(label_hipoalergenico);

        janelaComestico.setSize(555, 420);
        janelaComestico.setVisible(true);
        janelaComestico.setTitle("Cosmetico:  " + item.getNome());

        field_nome.setText(item.getNome());
        field_descricao.setText(item.getDescricao());
        field_preco.setText(Double.toString(item.getPreco()));
        field_estoque.setText(Integer.toString(item.getEmEstoque()));
        field_fabricante.setText(item.getFabricante());
        field_tamanho_embalagem.setText(item.getQuantidade());
        field_cor.setText(item.getCor());
        field_fragancia.setText(item.getFragrancia());
        checkbox_hipoalergenico.setSelected(item.isHipoalergenico());
    }

    public ArrayList<Object> getInfo() {
        ArrayList<Object> info = new ArrayList<>();
        info.add(nomeAnterior); //0
        info.add(field_nome.getText());//1
        info.add(field_descricao.getText()); //2
        info.add(parseDouble(field_preco.getText())); //3
        info.add(parseInt(field_estoque.getText())); //4
        info.add(field_fabricante.getText()); //5
        info.add(field_tamanho_embalagem.getText()); //6
        info.add(field_cor.getText()); //7
        info.add(field_fragancia.getText()); //8
        info.add(checkbox_hipoalergenico.isSelected()); //9
        return info;
    }

    public String getNomeAnterior() {
        return nomeAnterior;
    }

    public static TelaMenu getTelaPai() {
        return telaPai;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == button_salvar) {
            if ( field_nome.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "O produto precisa de um nome!");
            } else {
                ControleDados.salvarProduto(getInfo());
                janelaComestico.dispose();
                telaPai.atualizarJlistProdutos();
            }
        }
    }
}