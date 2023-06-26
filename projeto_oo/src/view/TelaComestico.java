package view;

import modelo.Controle;
import modelo.Cosmetico;
import modelo.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TelaComestico implements ActionListener {
    private final JFrame janelaComestico = new JFrame("");
    private final JButton button_salvar = new JButton("Salvar");
    private final JButton button_apagar = new JButton("Apagar Produto");
    private final JTextField field_nome = new JTextField("Nome do comestico");
    private final JTextArea field_descricao = new JTextArea("field_descricao");
    private final JFormattedTextField field_preco = new JFormattedTextField("field_preco");
    private final JTextField field_estoque = new JTextField("field_estoque");
    private final JTextField field_fabricante = new JTextField("field_fabricante");
    private final JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private final JTextField field_cor = new JTextField("field_cor");
    private final JTextField field_fragancia = new JTextField("field_fragancia");
    private final JCheckBox checkbox_hipoalergenico = new JCheckBox("Sim");
    private final JLabel label_nome = new JLabel("Nome do Cosmético:");
    private final JLabel label_descricao = new JLabel("Descrição:");
    private final JLabel label_preco = new JLabel("Preço:");
    private final JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private final JLabel label_fabricante = new JLabel("Fabricante:");
    private final JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private final JLabel label_cor = new JLabel("Cor:");
    private final JLabel label_fragancia = new JLabel("Fragância:");
    private final JLabel label_hipoalergenico = new JLabel("É hipoalergênico?");
    private Cosmetico cosmeticoPai;
    private String nomeAnterior;
    private Object telaPai;
    private long lastClick = 0;

    public TelaComestico(Cosmetico item, Object pai) {

        nomeAnterior = item.getNome();
        cosmeticoPai = item;
        telaPai = pai;


        button_salvar.addActionListener(this);
        button_apagar.addActionListener(this);

        field_nome.setBounds(40, 50, 300, 30);
        button_salvar.setBounds(350, 50, 145, 30);
        button_apagar.setBounds(350, 300, 145, 30);
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
        janelaComestico.add(button_apagar);

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

        if ( nomeAnterior == null ) {
            button_apagar.setEnabled(false);
        } else {
            button_apagar.setEnabled(true);
        }

    }
    public String getNomeAnterior() {
        return nomeAnterior;
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
            if ( src == button_salvar ) {
                if ( field_nome.getText().equals("") ) {
                    JOptionPane.showMessageDialog(null, "O produto precisa de um nome!");
                } else {
                    if ( nomeAnterior != null ) {
                        Controle.salvarCosmetico(
                        		nomeAnterior,
                                field_nome.getText(),
                                field_descricao.getText(),
                                field_fabricante.getText(),
                                Double.parseDouble(field_preco.getText()) ,
                        		Integer.parseInt(field_estoque.getText()),
                                field_tamanho_embalagem.getText(),
                                field_cor.getText(),
                                field_fragancia.getText(),
                                checkbox_hipoalergenico.isSelected()
                        		);
                    } else {
                        Controle.criarCosmetico(
                                nomeAnterior,
                                field_nome.getText(),
                                field_descricao.getText(),
                                field_fabricante.getText(),
                                Double.parseDouble(field_preco.getText()),
                                Integer.parseInt(field_estoque.getText()),
                                field_tamanho_embalagem.getText(),
                                field_cor.getText(),
                                field_fragancia.getText(),
                                checkbox_hipoalergenico.isSelected()
                                
                        		, (Loja) ((TelaLoja) telaPai).getLojaPai());
                    }

                    janelaComestico.dispose();

                    if ( telaPai instanceof TelaMenu ) {
                        ((TelaMenu) telaPai).atualizarJlistProdutos();
                    } else if ( telaPai instanceof TelaLoja ) {
                        ((TelaLoja) telaPai).atualizarJlistProdutos();
                        ((TelaLoja) telaPai).getTelaPai().atualizarJlistProdutos();
                    }
                }
            } else if ( src == button_apagar ) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Apagar Produto?", "Apagar", JOptionPane.YES_NO_OPTION);
                if ( option == 0 ) {
                    Controle.deletarProduto(cosmeticoPai);
                    janelaComestico.dispose();
                }
            }
        }
    }
}