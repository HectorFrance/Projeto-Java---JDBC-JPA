package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alt_COMP extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCod;
	private JTextField textFieldPreco;
	private JButton btnAlterar;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alt_COMP frame = new Alt_COMP();
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
	public Alt_COMP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldCod = new JTextField();
		textFieldCod.setBounds(80, 49, 86, 20);
		contentPane.add(textFieldCod);
		textFieldCod.setColumns(10);

		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(80, 24, 46, 14);
		contentPane.add(lblCod);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(257, 49, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(257, 24, 46, 14);
		contentPane.add(lblPreo);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador c = new Controlador();
				c.COMP_mudarPreco(Integer.parseInt(textFieldCod.getText()), Integer.parseInt(textFieldPreco.getText()));
			}
		});
		btnAlterar.setBounds(77, 110, 89, 23);
		contentPane.add(btnAlterar);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(254, 110, 89, 23);
		contentPane.add(btnFechar);
	}
}
