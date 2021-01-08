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

public class AltIMP extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCod;
	private JTextField textFieldPrec;
	public static Controlador c = new Controlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltIMP frame = new AltIMP();
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
	public AltIMP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldCod = new JTextField();
		textFieldCod.setBounds(51, 79, 86, 20);
		contentPane.add(textFieldCod);
		textFieldCod.setColumns(10);

		textFieldPrec = new JTextField();
		textFieldPrec.setBounds(209, 79, 86, 20);
		contentPane.add(textFieldPrec);
		textFieldPrec.setColumns(10);

		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(51, 54, 46, 14);
		contentPane.add(lblCod);

		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(209, 54, 46, 14);
		contentPane.add(lblPreco);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.IMPmudarPreco(Integer.parseInt(textFieldCod.getText()), Integer.parseInt(textFieldPrec.getText()));
			}
		});
		btnAlterar.setBounds(48, 145, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(209, 145, 89, 23);
		contentPane.add(btnFechar);
	}

}
