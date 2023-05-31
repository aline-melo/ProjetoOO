package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaComestico implements ActionListener, ListSelectionListener {
    private static JFrame janelaComestico = new JFrame("Cosmetico");
    private static JButton button_salvar = new JButton("Salvar");
    private static JTextField field_nome = new JTextField("Nome do comestico");
    private static JTextField field_descricao = new JTextField("field_descricao");
    private static JTextField field_preco = new JTextField("field_preco");
    private static JTextField field_estoque = new JTextField("field_estoque");
    private static JTextField field_fabricante = new JTextField("field_fabricante");
    private static JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private static JTextField field_cor = new JTextField("field_cor");
    private static JTextField field_fragancia = new JTextField("field_fragancia");
    private static JCheckBox checkbox_hipoalergenico = new JCheckBox("Sim");
    private static JLabel label_descricao = new JLabel("Descrição:");
    private static JLabel label_preco = new JLabel("Preço:");
    private static JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private static JLabel label_fabricante = new JLabel("Fabricante:");
    private static JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private static JLabel label_cor = new JLabel("Cor:");
    private static JLabel label_fragancia = new JLabel("Fragância:");
    private static JLabel label_hipoalergenico = new JLabel("É hipoalergênico?");


    public TelaComestico() {
        field_nome.setBounds(120, 50, 300, 30);
        button_salvar.setBounds(500, 50, 100, 30);
        field_descricao.setBounds(120, 99, 180, 30);
        field_preco.setBounds(120, 150, 180, 30);
        field_estoque.setBounds(120, 200, 180, 30);
        field_fabricante.setBounds(120, 250, 180, 30);
        field_tamanho_embalagem.setBounds(320, 99, 180, 30);
        field_cor.setBounds(320, 150, 180, 30);
        field_fragancia.setBounds(320, 200, 180, 30);
        checkbox_hipoalergenico.setBounds(320, 250, 180, 30);

        label_descricao.setBounds(120, 75, 180, 25);
        label_preco.setBounds(120, 125, 180, 25);
        label_estoque.setBounds(120, 175, 180, 25);
        label_fabricante.setBounds(120, 225, 180, 25);
        label_tamanho_embalagem.setBounds(320, 75, 180, 25);
        label_cor.setBounds(320, 125, 180, 25);
        label_fragancia.setBounds(320, 175, 180, 25);
        label_hipoalergenico.setBounds(320, 225, 180, 25);

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

        janelaComestico.add(label_descricao);
        janelaComestico.add(label_preco);
        janelaComestico.add(label_estoque);
        janelaComestico.add(label_fabricante);
        janelaComestico.add(label_tamanho_embalagem);
        janelaComestico.add(label_cor);
        janelaComestico.add(label_fragancia);
        janelaComestico.add(label_hipoalergenico);
        janelaComestico.add(button_salvar);

        janelaComestico.setSize(700, 500);
        janelaComestico.setVisible(true);
    }

    public static void main(String[] args) {
        TelaComestico tela = new TelaComestico();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}