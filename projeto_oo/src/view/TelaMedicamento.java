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
    private static JTextField nomeMedicamento = new JTextField ("Nome do medicamento");
    private static JTextField atributo1 = new JTextField ("atributo1");
    private static JTextField atributo2 = new JTextField ("atributo2");
    private static JTextField atributo3 = new JTextField ("atributo3");
    private static JTextField atributo4 = new JTextField ("atributo4");
    private static JTextField atributo5 = new JTextField ("atributo5");
    private static JTextField atributo6 = new JTextField ("atributo6");
    private static JTextField atributo7 = new JTextField ("atributo7");
    private static JTextField atributo8 = new JTextField ("atributo8");



    public TelaMedicamento() {
        nomeMedicamento.setBounds(120, 50, 300, 30);
        salvar.setBounds(500, 50, 100, 30);
        atributo1.setBounds(120, 100, 100, 30);
        atributo2.setBounds(120, 150, 100, 30);
        atributo3.setBounds(120, 200, 100, 30);
        atributo4.setBounds(120, 250, 100, 30);
        atributo5.setBounds(220, 100, 100, 30);
        atributo6.setBounds(220, 150, 100, 30);
        atributo7.setBounds(220, 200, 100, 30);
        atributo8.setBounds(220, 250, 100, 30);

        janelaMedicamento.setLayout(null);
        janelaMedicamento.add(nomeMedicamento);
        janelaMedicamento.add(atributo1);
        janelaMedicamento.add(atributo2);
        janelaMedicamento.add(atributo3);
        janelaMedicamento.add(atributo4);
        janelaMedicamento.add(atributo5);
        janelaMedicamento.add(atributo6);
        janelaMedicamento.add(atributo7);
        janelaMedicamento.add(atributo8);
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