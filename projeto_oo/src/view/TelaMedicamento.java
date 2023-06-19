package view;

import modelo.Medicamento;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaMedicamento implements ActionListener{
    private static final JFrame janelaMedicamento = new JFrame("Medicamento");
    private static final JButton button_salvar = new JButton("Salvar");
    private static final JTextField field_nome = new JTextField("Nome do medicamento");
    private static final JTextArea field_descricao = new JTextArea("field_descricao");
    private static final JTextField field_preco = new JTextField("field_preco");
    private static final JTextField field_estoque = new JTextField("field_estoque");
    private static final JTextField field_fabricante = new JTextField("field_fabricante");
    private static final JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private static final JTextField field_tratamento = new JTextField("field_tratamento");
    private static final JTextField field_tarja = new JTextField("field_tarja");
    private static final JTextField field_principio = new JTextField("field_principio");
    private static final JCheckBox checkbox_generico = new JCheckBox("Sim");
    private static final JLabel label_nome = new JLabel("Nome do Medicamento:");
    private static final JLabel label_descricao = new JLabel("Descrição:");
    private static final JLabel label_preco = new JLabel("Preço:");
    private static final JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private static final JLabel label_fabricante = new JLabel("Fabricante:");
    private static final JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private static final JLabel label_tratamento = new JLabel("Tratamento:");
    private static final JLabel label_tarja = new JLabel("Tarja:");
    private static final JLabel label_principio = new JLabel("Princípios Ativos:");
    private static final JLabel label_generico = new JLabel("É genérico?");


    public TelaMedicamento(Medicamento item, Object pai) {
        field_nome.setBounds(40, 50, 300, 30);
        button_salvar.setBounds(350, 50, 145, 30);
        field_descricao.setBounds(40, 120, 300, 90);
        field_preco.setBounds(350, 120, 145, 30);
        field_estoque.setBounds(350, 180, 145, 30);
        field_fabricante.setBounds(350, 240, 145, 30);
        field_tamanho_embalagem.setBounds(40, 240, 145, 30);
        field_tratamento.setBounds(195, 240, 145, 30);
        field_tarja.setBounds(40, 300, 145, 30);
        field_principio.setBounds(195, 300, 145, 30);
        checkbox_generico.setBounds(350, 300, 145, 30);

        label_nome.setBounds(40, 30, 160, 20);
        label_descricao.setBounds(40, 100, 160, 20);
        label_preco.setBounds(350, 100, 160, 20);
        label_estoque.setBounds(350, 160, 160, 20);
        label_fabricante.setBounds(350, 220, 160, 20);
        label_tamanho_embalagem.setBounds(40, 220, 160, 20);
        label_tratamento.setBounds(195, 220, 160, 20);
        label_tarja.setBounds(40, 280, 160, 20);
        label_generico.setBounds(350, 280, 160, 20);
        label_principio.setBounds(195, 280, 160, 20);

        janelaMedicamento.setLayout(null);
        janelaMedicamento.add(field_nome);
        janelaMedicamento.add(field_descricao);
        janelaMedicamento.add(field_preco);
        janelaMedicamento.add(field_estoque);
        janelaMedicamento.add(field_fabricante);
        janelaMedicamento.add(field_tamanho_embalagem);
        janelaMedicamento.add(field_tratamento);
        janelaMedicamento.add(field_tarja);
        janelaMedicamento.add(field_principio);
        janelaMedicamento.add(checkbox_generico);
        janelaMedicamento.add(button_salvar);

        janelaMedicamento.add(label_nome);
        janelaMedicamento.add(label_descricao);
        janelaMedicamento.add(label_preco);
        janelaMedicamento.add(label_estoque);
        janelaMedicamento.add(label_fabricante);
        janelaMedicamento.add(label_tamanho_embalagem);
        janelaMedicamento.add(label_tratamento);
        janelaMedicamento.add(label_tarja);
        janelaMedicamento.add(label_principio);
        janelaMedicamento.add(label_generico);

        janelaMedicamento.setSize(555, 420);
        janelaMedicamento.setVisible(true);

        field_nome.setText(item.getNome());
        field_descricao.setText(item.getDescricao());
        field_preco.setText(Double.toString(item.getPreco()));
        field_estoque.setText(Integer.toString(item.getEmEstoque()));
        field_fabricante.setText(item.getFabricante());
        field_tamanho_embalagem.setText(item.getQuantidade());
        field_tratamento.setText(item.getTratamento());
        field_tarja.setText(item.getTarja());
        field_principio.setText(item.getPrincipioAtivo());
        checkbox_generico.setSelected(item.isGenerico());
    }


 

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}