package view;

import controle.ControleDados;
import modelo.Cosmetico;
import modelo.Loja;
import modelo.Medicamento;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TelaMedicamento implements ActionListener {
    private static final JFrame janelaMedicamento = new JFrame("");
    private static final JButton button_salvar = new JButton("Salvar");
    private static final JButton button_apagar = new JButton("Apagar Produto");
    private static final JTextField field_nome = new JTextField("Nome do comestico");
    private static final JTextArea field_descricao = new JTextArea("field_descricao");
    private static final JFormattedTextField field_preco = new JFormattedTextField("field_preco");
    private static final JTextField field_estoque = new JTextField("field_estoque");
    private static final JTextField field_fabricante = new JTextField("field_fabricante");
    private static final JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private static final JTextField field_tratamento = new JTextField("field_tratamento");
    private static final JTextField field_principio = new JTextField("field_principio");
    private static final JTextField field_tarja = new JTextField("field_tarja");
    private static final JCheckBox checkbox_generico = new JCheckBox("Sim");
    private static final JLabel label_nome = new JLabel("Nome do Medicamento:");
    private static final JLabel label_descricao = new JLabel("Descrição:");
    private static final JLabel label_preco = new JLabel("Preço:");
    private static final JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private static final JLabel label_fabricante = new JLabel("Fabricante:");
    private static final JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private static final JLabel label_tratamento = new JLabel("Tratamento:");
    private static final JLabel label_principio = new JLabel("Princípio Ativo:");
    private static final JLabel label_tarja = new JLabel("Tarja:");
    private static final JLabel label_generico = new JLabel("É genérico?");
    private Medicamento medicamentoPai;
    private static String nomeAnterior;
    private static Object telaPai;


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
        button_apagar.setBounds(350, 350, 145, 30);

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
        janelaMedicamento.add(button_apagar);

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

        janelaMedicamento.setSize(555, 450);
        janelaMedicamento.setVisible(true);
        nomeAnterior = item.getNome();
        medicamentoPai = item;
        telaPai = pai;


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

        button_apagar.addActionListener(this);
        button_salvar.addActionListener(this);
        janelaMedicamento.setTitle("Medicamento:  " + item.getNome());
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

    public static void main(String[] args) {
        new TelaMedicamento(new Medicamento(null, null, null, 0, 0, null, null,
                null, false, null), new Object());
    }

    public ArrayList<Object> getInfo() {
        ArrayList<Object> info = new ArrayList<>();
        info.add(nomeAnterior); //0
        info.add(field_nome.getText());//1
        info.add(field_descricao.getText()); //2
        info.add(field_fabricante.getText()); //3
        try {
            info.add(parseDouble(field_preco.getText())); //4
        } catch (NumberFormatException x) {
            info.add(3, 0.0);
        }
        try {
            info.add(parseInt(field_estoque.getText())); //5
        } catch (NumberFormatException x) {
            info.add(4, 0);
        }

        info.add(field_tamanho_embalagem.getText()); //6
        info.add(field_tratamento.getText()); //7
        info.add(field_tarja.getText()); //8
        info.add(checkbox_generico.isSelected()); //9
        info.add(field_principio.getText()); //10
        return info;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if ( src == button_salvar ) {
            if ( field_nome.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "O produto precisa de um nome!");
            } else {
                if ( nomeAnterior != null ) {
                    ControleDados.salvarProduto(getInfo());
                } else {
                    if ( telaPai.getClass() == TelaLoja.class ) {
                        ControleDados.criarMedicamento(getInfo(), (Loja) ((TelaLoja) telaPai).getLojaPai());
                    }

                }

                janelaMedicamento.dispose();

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
                ControleDados.deletarProduto(medicamentoPai);
                janelaMedicamento.dispose();
            }
        }
    }
}