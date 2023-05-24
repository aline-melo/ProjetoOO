package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;


public class TelaProduto implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	//private JButton cadastroAluno;
	//private JButton refreshAluno;
	private JButton cadastroProduto;
	private JButton refreshProduto;
	private static ControleDados dados;
	private JList<String> listaProdutos;
	private String[] listaNomes = new String[50];

	public void mostrarDados(){
			listaNomes = new ControleProdutos().listarProdutos();
			listaProdutos = new JList<String>(listaNomes);
			janela = new JFrame("Alunos");
			titulo = new JLabel("Alunos Cadastrados");
			cadastroProduto = new JButton("Cadastrar");
			refreshProduto = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaProdutos.setBounds(20, 50, 350, 120);
			listaProdutos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaProdutos.setVisibleRowCount(10);

			cadastroProduto.setBounds(70, 177, 100, 30);
			refreshProduto.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaProdutos);
			janela.add(cadastroProduto);
			janela.add(refreshProduto);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroProduto.addActionListener(this);
			refreshProduto.addActionListener(this);
			listaProdutos.addListSelectionListener(this);

			//break;

	}



	//Captura eventos relacionados aos bot�es da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		//if(src == cadastroProduto)
			//new TelaProduto().inserirEditar(1, dados, this, 0);

		//Cadastro de novo professor
	//	if(src == cadastroProf)
		//	new TelaDetalhePessoa().inserirEditar(2, dados, this, 0);

		// Atualiza a lista de nomes de alunos mostrada no JList
	//	if(src == refreshAluno) {
		//	listaProdutos.setListData(new ControleProdutos(dados).getNomeAluno());			
			//listaProdutos.updateUI();
		//}

		// Atualiza a lista de nomes de professores mostrada no JList
		if(src == refreshProduto) {
			listaProdutosCadastrados.setListData(new ControleProdutos(dados).getListaProdutos());
			listaProfsCadastrados.updateUI();
		}

	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaProdutos) {
			new TelaDetalhePessoa().inserirEditar(3, dados, this, 
					listaProdutos.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaProfsCadastrados) {
			new TelaDetalhePessoa().inserirEditar(4, dados, this, 
					listaProfsCadastrados.getSelectedIndex());
		}
	}

}