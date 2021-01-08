package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;
import Model.Computadores;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_COMP extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldModelo;
	private JTextField textFieldRAM;
	private JTextField textFieldHD;
	private JTextField textFieldPreco;
	private JTextField textFieldFAB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_COMP frame = new Ad_COMP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ad_COMP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(30, 53, 46, 14);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(30, 79, 86, 20);
		textFieldModelo.setColumns(10);

		textFieldRAM = new JTextField();
		textFieldRAM.setBounds(126, 79, 86, 20);
		textFieldRAM.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblModelo);
		contentPane.add(textFieldModelo);
		contentPane.add(textFieldRAM);

		JLabel lblRam = new JLabel("RAM");
		lblRam.setBounds(126, 53, 46, 14);
		contentPane.add(lblRam);

		textFieldHD = new JTextField();
		textFieldHD.setBounds(222, 79, 86, 20);
		contentPane.add(textFieldHD);
		textFieldHD.setColumns(10);

		JLabel lblHd = new JLabel("HD");
		lblHd.setBounds(222, 53, 46, 14);
		contentPane.add(lblHd);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(318, 79, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(318, 53, 46, 14);
		contentPane.add(lblPreo);

		textFieldFAB = new JTextField();
		textFieldFAB.setBounds(414, 79, 86, 20);
		contentPane.add(textFieldFAB);
		textFieldFAB.setColumns(10);

		JLabel lblCodFab = new JLabel("Cod Fab");
		lblCodFab.setBounds(414, 53, 46, 14);
		contentPane.add(lblCodFab);

		JButton btnAdcionar = new JButton("Adicionar");
		btnAdcionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador c = new Controlador();
				Computadores i = new Computadores();
				i.setCod_fab(Integer.parseInt(textFieldFAB.getText()));
				i.setHD(Integer.parseInt(textFieldHD.getText()));
				i.setModelo(textFieldModelo.getText());
				i.setPreco(Double.parseDouble(textFieldPreco.getText()));
				i.setRAM(Integer.parseInt(textFieldRAM.getText()));
				c.COMP_adcionar(i);
			}
		});
		btnAdcionar.setBounds(126, 151, 89, 23);
		contentPane.add(btnAdcionar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(315, 151, 89, 23);
		contentPane.add(btnFechar);
	}
}
