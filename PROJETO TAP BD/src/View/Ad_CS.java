package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;
import Model.Consoles;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_CS extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CodFab;
	private JTextField textFieldModelo;
	private JTextField textField_Preco;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_CS frame = new Ad_CS();
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
	public Ad_CS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodfab = new JLabel("Cod_Fab");
		lblCodfab.setBounds(10, 47, 72, 14);
		contentPane.add(lblCodfab);

		textField_CodFab = new JTextField();
		textField_CodFab.setBounds(10, 72, 86, 20);
		contentPane.add(textField_CodFab);
		textField_CodFab.setColumns(10);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(106, 72, 86, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(106, 47, 46, 14);
		contentPane.add(lblModelo);

		textField_Preco = new JTextField();
		textField_Preco.setBounds(202, 72, 86, 20);
		contentPane.add(textField_Preco);
		textField_Preco.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(202, 47, 46, 14);
		contentPane.add(lblPreo);

		JButton btnAdcionar = new JButton("Adicionar");
		btnAdcionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador c = new Controlador();
				Consoles i = new Consoles();
				i.setCod_fab(Integer.parseInt(textField_CodFab.getText()));
				i.setModelo(textFieldModelo.getText());
				i.setPreco(Integer.parseInt(textField_Preco.getText()));
				c.CS_adcionar(i);
			}
		});
		btnAdcionar.setBounds(25, 130, 89, 23);
		contentPane.add(btnAdcionar);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(181, 130, 89, 23);
		contentPane.add(btnFechar);
	}
}
