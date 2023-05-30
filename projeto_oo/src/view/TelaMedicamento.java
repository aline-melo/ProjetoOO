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
    private static JTextField nomeMedicamento = new JTextField ("Sertralina");

    public TelaMedicamento() {
        nomeMedicamento.setBounds(120, 50, 300, 30);
        salvar.setBounds(500, 50, 100, 30); 
        janelaMedicamento.setLayout(null);

        janelaMedicamento.add(nomeMedicamento);
        janelaMedicamento.add(salvar);
        janelaMedicamento.setSize(700, 500);
        janelaMedicamento.setVisible(true);
   }
    public static void main(String[] args) {
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