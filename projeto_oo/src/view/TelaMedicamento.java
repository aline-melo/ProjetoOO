package view;

import modelo.*;

import java.awt.event.*;
import javax.swing.*;


/**
 * Interface gráfica para a classe {@link Medicamento}.
 *
 * @author Caio Pacheco
 * @version 1.0
 * @see TelaMedicamento#TelaMedicamento(Medicamento, Object)  TelaMedicamento
 * @see TelaMedicamento#actionPerformed(ActionEvent)
 * @see Dados
 * @since 06/2023
 */
public class TelaMedicamento implements ActionListener {
	private final Dados dados;
    private final JFrame janelaMedicamento = new JFrame("");
    private final JButton button_salvar = new JButton("Salvar");
    private final JButton button_apagar = new JButton("Apagar Produto");
    private final JTextField field_nome = new JTextField("Nome do comestico");
    private final JTextArea field_descricao = new JTextArea("field_descricao");
    private final JFormattedTextField field_preco = new JFormattedTextField("field_preco");
    private final JTextField field_estoque = new JTextField("field_estoque");
    private final JTextField field_fabricante = new JTextField("field_fabricante");
    private final JTextField field_tamanho_embalagem = new JTextField("field_tamanho_embalagem");
    private final JTextField field_tratamento = new JTextField("field_tratamento");
    private final JTextField field_principio = new JTextField("field_principio");
    private final JTextField field_tarja = new JTextField("field_tarja");
    private final JCheckBox checkbox_generico = new JCheckBox("Sim");
    private final JLabel label_nome = new JLabel("Nome do Medicamento:");
    private final JLabel label_descricao = new JLabel("Descrição:");
    private final JLabel label_preco = new JLabel("Preço:");
    private final JLabel label_estoque = new JLabel("Quantidade em Estoque:");
    private final JLabel label_fabricante = new JLabel("Fabricante:");
    private final JLabel label_tamanho_embalagem = new JLabel("Tamanho:");
    private final JLabel label_tratamento = new JLabel("Tratamento:");
    private final JLabel label_principio = new JLabel("Princípio Ativo:");
    private final JLabel label_tarja = new JLabel("Tarja:");
    private final JLabel label_generico = new JLabel("É genérico?");
    private Medicamento medicamentoPai;
    private String nomeAnterior;
    private Object telaPai;
    private long lastClick = 0;

    /**
     * Construtor da classe {@link TelaMedicamento}.
     *
     * @param item {@link Medicamento} que será editado.
     * @param pai  {@link Object} que chamou essa tela.
     */
    public TelaMedicamento(Medicamento item, Object pai) {

        this.dados = Dados.getDados();
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

        if ( nomeAnterior == null ) {
            button_apagar.setEnabled(false);
        } else {
            button_apagar.setEnabled(true);
        }
        button_apagar.revalidate();
        button_apagar.updateUI();
    }

    /**
     * Verifica se um evento de clique em um {@link TelaMedicamento#actionPerformed(ActionEvent) botão}
     * pode ser executado.
     * <br>
     * Checa se tempo suficiente passou desde o último clique para validar se o novo pode ser executado.
     * <br>
     * Usado para evitar acionar múltiplos cliques acidentais.
     *
     * @param currentClick tempo atual no instante do clique.
     * @return true se o clique for válido para execução, false se não for.
     * @see TelaMedicamento#actionPerformed(ActionEvent)
     * @since 06/2023
     */
    public boolean clickable(long currentClick) {
        boolean x = false;

        if ( currentClick - lastClick > 750 ) {
            lastClick = currentClick;
            x = true;
        }
        return x;
    }

    /**
     * Trata de eventos de clique em botões.<br><br>
     * Se {@link TelaMedicamento#clickable(long) clickable} retornar true então:<br><br>
     * Chama {@link Dados#salvarMedicamento(String, String, String, String, double, int, String, String, String, Boolean, String)}
     * salvarCosmetico} se o botão clicado for o de salvar e o campo de nome estiver preenchido.<br><br>
     * Chama {@link Dados#deletarProduto(Produto)  deletarProduto} se o botão clicado for o de apagar.<br><br>
     * <p>
     * Fecha a janela se alguma ação for executada.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if ( clickable(e.getWhen()) ) {
            if ( src == button_salvar ) {
                if ( field_nome.getText().equals("") ) {
                    JOptionPane.showMessageDialog(null, "O produto precisa de um nome!");
                } else {
                    if ( nomeAnterior != null ) {
                        dados.salvarMedicamento(

                                nomeAnterior,
                                field_nome.getText(),
                                field_descricao.getText(), 
                                field_fabricante.getText(), 
                                Double.parseDouble(field_preco.getText()), 
                                Integer.parseInt(field_estoque.getText()), 
                                field_tamanho_embalagem.getText(), 
                                field_tratamento.getText(),
                                field_tarja.getText(), 
                                checkbox_generico.isSelected(), 
                                field_principio.getText() 
                        		
                        		);
                    } else {
                        if ( telaPai.getClass() == TelaLoja.class ) {
                            dados.criarMedicamento(
                            		
                            		nomeAnterior, 
                                    field_nome.getText(),
                                    field_descricao.getText(), 
                                    field_fabricante.getText(), 
                                    Double.parseDouble(field_preco.getText()), 
                                    Integer.parseInt(field_estoque.getText()), 
                                    field_tamanho_embalagem.getText(), 
                                    field_tratamento.getText(),
                                    field_tarja.getText(), 
                                    checkbox_generico.isSelected(), 
                                    field_principio.getText() 
                            		
                            		, (Loja) ((TelaLoja) telaPai).getLojaPai());
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
                    dados.deletarProduto(medicamentoPai);
                    janelaMedicamento.dispose();
                }
            }
        }
    }
}