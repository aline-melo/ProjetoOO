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
    private static JTextField field_atributo1 = new JTextField("field_atributo1");
    private static JTextField field_atributo2 = new JTextField("field_atributo2");
    private static JTextField field_atributo3 = new JTextField("field_atributo3");
    private static JTextField field_atributo4 = new JTextField("field_atributo4");
    private static JTextField field_atributo5 = new JTextField("field_atributo5");
    private static JTextField field_atributo6 = new JTextField("field_atributo6");
    private static JTextField field_atributo7 = new JTextField("field_atributo7");
    private static JTextField field_atributo8 = new JTextField("field_atributo8");
    private static JLabel label_atributo1 = new JLabel("label_atributo1");
    private static JLabel label_atributo2 = new JLabel("label_atributo2");
    private static JLabel label_atributo3 = new JLabel("label_atributo3");
    private static JLabel label_atributo4 = new JLabel("label_atributo4");
    private static JLabel label_atributo5 = new JLabel("label_atributo5");
    private static JLabel label_atributo6 = new JLabel("label_atributo6");
    private static JLabel label_atributo7 = new JLabel("label_atributo7");
    private static JLabel label_atributo8 = new JLabel("label_atributo8");


    public TelaMedicamento() {
        nomeMedicamento.setBounds(120, 50, 300, 30);
        salvar.setBounds(500, 50, 100, 30);
        field_atributo1.setBounds(120, 100, 100, 30);
        field_atributo2.setBounds(120, 150, 100, 30);
        field_atributo3.setBounds(120, 200, 100, 30);
        field_atributo4.setBounds(120, 250, 100, 30);
        field_atributo5.setBounds(220, 100, 100, 30);
        field_atributo6.setBounds(220, 150, 100, 30);
        field_atributo7.setBounds(220, 200, 100, 30);
        field_atributo8.setBounds(220, 250, 100, 30);

        label_atributo1.setBounds(120, 75, 100, 25);
        label_atributo2.setBounds(120, 125, 100, 25);
        label_atributo3.setBounds(120, 175, 100, 25);
        label_atributo4.setBounds(120, 225, 100, 25);
        label_atributo5.setBounds(220, 75, 100, 25);
        label_atributo6.setBounds(220, 125, 100, 25);
        label_atributo7.setBounds(220, 175, 100, 25);
        label_atributo8.setBounds(220, 225, 100, 25);

        janelaMedicamento.setLayout(null);
        janelaMedicamento.add(nomeMedicamento);
        janelaMedicamento.add(field_atributo1);
        janelaMedicamento.add(field_atributo2);
        janelaMedicamento.add(field_atributo3);
        janelaMedicamento.add(field_atributo4);
        janelaMedicamento.add(field_atributo5);
        janelaMedicamento.add(field_atributo6);
        janelaMedicamento.add(field_atributo7);
        janelaMedicamento.add(field_atributo8);
        janelaMedicamento.add(label_atributo1);
        janelaMedicamento.add(label_atributo2);
        janelaMedicamento.add(label_atributo3);
        janelaMedicamento.add(label_atributo4);
        janelaMedicamento.add(label_atributo5);
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