package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador_JPA;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alt_FUNC extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCOD;
	private JTextField textFieldTELEFONE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alt_FUNC frame = new Alt_FUNC();
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
	public Alt_FUNC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(10, 11, 46, 14);
		contentPane.add(lblCod);

		textFieldCOD = new JTextField();
		textFieldCOD.setBounds(10, 36, 86, 20);
		contentPane.add(textFieldCOD);
		textFieldCOD.setColumns(10);

		textFieldTELEFONE = new JTextField();
		textFieldTELEFONE.setBounds(106, 36, 86, 20);
		contentPane.add(textFieldTELEFONE);
		textFieldTELEFONE.setColumns(10);

		JLabel lblTelefone = new JLabel("Setor");
		lblTelefone.setBounds(106, 11, 46, 14);
		contentPane.add(lblTelefone);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Funcionario.c.FUNC_alterar(textFieldTELEFONE.getText(), Integer.parseInt(textFieldCOD.getText()));

			}
		});
		btnAlterar.setBounds(7, 67, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnFecher = new JButton("Fechar");
		btnFecher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecher.setBounds(106, 67, 89, 23);
		contentPane.add(btnFecher);
	}

}
