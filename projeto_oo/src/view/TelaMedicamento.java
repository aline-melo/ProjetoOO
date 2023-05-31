package view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaMedicamento implements ActionListener, ListSelectionListener {
    private static JFrame janelaMedicamento = new JFrame("Medicamento");
    private static JButton button_salvar = new JButton("Salvar");
    private static JTextField field_nome = new JTextField("Nome do medicamento");
    private static JTextField field_descricao = new JTextField("field_descricao");
    private static JTextField field_preco = new JTextField("field_preco");
    private static JTextField field_estoque = new JTextField("field_estoque");
    private static JTextField field_fabricante = new JTextField("field_fabricante");
    private static JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private static JTextField field_tratamento = new JTextField("field_tratamento");
    private static JTextField field_tarja = new JTextField("field_tarja");
    private static JTextField field_principio_ativo = new JTextField("field_principio_ativo");
    private static JCheckBox checkbox_generico = new JCheckBox("Sim");
    private static JLabel label_descricao = new JLabel("Descrição:");
    private static JLabel label_preco = new JLabel("Preço:");
    private static JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private static JLabel label_fabricante = new JLabel("Fabricante:");
    private static JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private static JLabel label_tratamento = new JLabel("Tipo de Tratamento:");
    private static JLabel label_tarja = new JLabel("Tarja:");
    private static JLabel label_principio_ativo = new JLabel("Princípios Ativos:");
    private static JLabel label_generico = new JLabel("É genérico?");


    public TelaMedicamento() {
        field_nome.setBounds(120, 50, 300, 30);
        button_salvar.setBounds(500, 50, 100, 30);
        field_descricao.setBounds(120, 100, 100, 30);
        field_preco.setBounds(120, 150, 100, 30);
        field_estoque.setBounds(120, 200, 100, 30);
        field_fabricante.setBounds(120, 250, 100, 30);
        field_tamanho_embalagem.setBounds(220, 100, 100, 30);
        field_tratamento.setBounds(220, 150, 100, 30);
        field_tarja.setBounds(220, 200, 100, 30);
        field_principio_ativo.setBounds(220, 250, 100, 30);
        checkbox_generico.setBounds(120, 300, 100, 30);

        label_descricao.setBounds(120, 75, 100, 25);
        label_preco.setBounds(120, 125, 100, 25);
        label_estoque.setBounds(120, 175, 100, 25);
        label_fabricante.setBounds(120, 225, 100, 25);
        label_tamanho_embalagem.setBounds(220, 75, 100, 25);
        label_tratamento.setBounds(220, 125, 100, 25);
        label_tarja.setBounds(220, 175, 100, 25);
        label_principio_ativo.setBounds(220, 225, 100, 25);
        label_generico.setBounds(120, 275, 100, 25);

        janelaMedicamento.setLayout(null);
        janelaMedicamento.add(field_nome);
        janelaMedicamento.add(field_descricao);
        janelaMedicamento.add(field_preco);
        janelaMedicamento.add(field_estoque);
        janelaMedicamento.add(field_fabricante);
        janelaMedicamento.add(field_tamanho_embalagem);
        janelaMedicamento.add(field_tratamento);
        janelaMedicamento.add(field_tarja);
        janelaMedicamento.add(field_principio_ativo);
        janelaMedicamento.add(checkbox_generico);

        janelaMedicamento.add(label_descricao);
        janelaMedicamento.add(label_preco);
        janelaMedicamento.add(label_estoque);
        janelaMedicamento.add(label_fabricante);
        janelaMedicamento.add(label_tamanho_embalagem);
        janelaMedicamento.add(label_tratamento);
        janelaMedicamento.add(label_tarja);
        janelaMedicamento.add(label_principio_ativo);
        janelaMedicamento.add(label_generico);
        janelaMedicamento.add(button_salvar);

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