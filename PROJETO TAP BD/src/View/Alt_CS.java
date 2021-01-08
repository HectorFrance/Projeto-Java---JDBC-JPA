package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alt_CS extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCod;
	private JTextField textFieldPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alt_CS frame = new Alt_CS();
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
	public Alt_CS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 221, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(10, 11, 46, 14);
		contentPane.add(lblCod);

		textFieldCod = new JTextField();
		textFieldCod.setBounds(10, 36, 86, 20);
		contentPane.add(textFieldCod);
		textFieldCod.setColumns(10);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(106, 36, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(106, 11, 46, 14);
		contentPane.add(lblPreco);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador c = new Controlador();
				c.CS_alterar(Integer.parseInt(textFieldPreco.getText()), Integer.parseInt(textFieldCod.getText()));
			}
		});
		btnAlterar.setBounds(7, 101, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(106, 101, 89, 23);
		contentPane.add(btnFechar);
	}

}
