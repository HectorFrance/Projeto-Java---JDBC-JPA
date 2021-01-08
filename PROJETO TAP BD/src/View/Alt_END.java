package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador_JPA;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alt_END extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCod;
	private JTextField Complemento;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alt_END frame = new Alt_END();
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
	public Alt_END() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCod = new JTextField();
		textFieldCod.setBounds(48, 83, 86, 20);
		contentPane.add(textFieldCod);
		textFieldCod.setColumns(10);
		
		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(48, 50, 46, 14);
		contentPane.add(lblCod);
		
		Complemento = new JTextField();
		Complemento.setBounds(286, 83, 86, 20);
		contentPane.add(Complemento);
		Complemento.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(286, 50, 86, 14);
		contentPane.add(lblComplemento);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_JPA c= new Controlador_JPA();
				c.END_alterar(Complemento.getText(), Integer.parseInt(textFieldCod.getText()));
					
			}
		});
		btnAlterar.setBounds(48, 203, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(283, 203, 89, 23);
		contentPane.add(btnFechar);
	}

}
