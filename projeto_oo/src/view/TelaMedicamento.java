package view;

import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;

public class TelaMedicamento implements ActionListener, ListSelectionListener {
    private static JFrame janelaMedicamento = new JFrame("Medicamento");
    private static JButton salvar = new JButton("Salvar");
    private static JTextField nomeMedicamento = new JTextField("Nome do medicamento");
    private static JTextField field_descricao = new JTextField("field_descricao");
    private static JTextField field_preco = new JTextField("field_preco");
    private static JTextField field_estoque = new JTextField("field_estoque");
    private static JTextField field_fabricante = new JTextField("field_fabricante");
    private static JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private static JTextField field_atributo6 = new JTextField("field_atributo6");
    private static JTextField field_atributo7 = new JTextField("field_atributo7");
    private static JTextField field_atributo8 = new JTextField("field_atributo8");
    private static JLabel label_descricao = new JLabel("label_descricao");
    private static JLabel label_preco = new JLabel("label_preco");
    private static JLabel label_estoque = new JLabel("label_estoque");
    private static JLabel label_fabricante = new JLabel("label_fabricante");
    private static JLabel label_tamanho_embalagem = new JLabel("label_tamanho_embalagem");
    private static JLabel label_atributo6 = new JLabel("label_atributo6");
    private static JLabel label_atributo7 = new JLabel("label_atributo7");
    private static JLabel label_atributo8 = new JLabel("label_atributo8");


    public TelaMedicamento() {
        nomeMedicamento.setBounds(120, 50, 300, 30);
        salvar.setBounds(500, 50, 100, 30);
        field_descricao.setBounds(120, 100, 100, 30);
        field_preco.setBounds(120, 150, 100, 30);
        field_estoque.setBounds(120, 200, 100, 30);
        field_fabricante.setBounds(120, 250, 100, 30);
        field_tamanho_embalagem.setBounds(220, 100, 100, 30);
        field_atributo6.setBounds(220, 150, 100, 30);
        field_atributo7.setBounds(220, 200, 100, 30);
        field_atributo8.setBounds(220, 250, 100, 30);

        label_descricao.setBounds(120, 75, 100, 25);
        label_preco.setBounds(120, 125, 100, 25);
        label_estoque.setBounds(120, 175, 100, 25);
        label_fabricante.setBounds(120, 225, 100, 25);
        label_tamanho_embalagem.setBounds(220, 75, 100, 25);
        label_atributo6.setBounds(220, 125, 100, 25);
        label_atributo7.setBounds(220, 175, 100, 25);
        label_atributo8.setBounds(220, 225, 100, 25);

        janelaMedicamento.setLayout(null);
        janelaMedicamento.add(nomeMedicamento);
        janelaMedicamento.add(field_descricao);
        janelaMedicamento.add(field_preco);
        janelaMedicamento.add(field_estoque);
        janelaMedicamento.add(field_fabricante);
        janelaMedicamento.add(field_tamanho_embalagem);
        janelaMedicamento.add(field_atributo6);
        janelaMedicamento.add(field_atributo7);
        janelaMedicamento.add(field_atributo8);

        janelaMedicamento.add(label_descricao);
        janelaMedicamento.add(label_preco);
        janelaMedicamento.add(label_estoque);
        janelaMedicamento.add(label_fabricante);
        janelaMedicamento.add(label_tamanho_embalagem);
        janelaMedicamento.add(label_atributo6);
        janelaMedicamento.add(label_atributo7);
        janelaMedicamento.add(label_atributo8);
        janelaMedicamento.add(salvar);

        janelaMedicamento.setSize(700, 500);
        janelaMedicamento.setVisible(true);
    }
    public static void main(String [] args) {
        TelaMedicamento tela = new TelaMedicamento();
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