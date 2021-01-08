package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;
import Model.Acessorios;
import Model.Consoles;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_AC extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CodFab;
	private JTextField textFieldModelo;
	private JTextField textField_Preco;
	private JButton btnFechar;
	private JLabel lblTipo;
	private JTextField textFieldTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_AC frame = new Ad_AC();
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
	public Ad_AC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodfab = new JLabel("Cod_Fab");
		lblCodfab.setBounds(25, 11, 72, 14);
		contentPane.add(lblCodfab);

		textField_CodFab = new JTextField();
		textField_CodFab.setBounds(25, 36, 86, 20);
		contentPane.add(textField_CodFab);
		textField_CodFab.setColumns(10);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(164, 36, 86, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(164, 11, 46, 14);
		contentPane.add(lblModelo);

		textField_Preco = new JTextField();
		textField_Preco.setBounds(164, 92, 86, 20);
		contentPane.add(textField_Preco);
		textField_Preco.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(164, 67, 46, 14);
		contentPane.add(lblPreo);

		JButton btnAdcionar = new JButton("Adicionar");
		btnAdcionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador c = new Controlador();
				Acessorios i = new Acessorios();
				i.setCod_fab(Integer.parseInt(textField_CodFab.getText()));
				i.setModelo(textFieldModelo.getText());
				i.setPreco(Integer.parseInt(textField_Preco.getText()));
				i.setTipo(textFieldTipo.getText());
				c.AC_adcionar(i);
			}
		});
		btnAdcionar.setBounds(39, 154, 89, 23);
		contentPane.add(btnAdcionar);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(164, 154, 89, 23);
		contentPane.add(btnFechar);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(25, 67, 46, 14);
		contentPane.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(25, 92, 86, 20);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
	}
}
