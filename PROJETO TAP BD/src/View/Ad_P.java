package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador_JPA;
import Model.Pedido;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_P extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMOD;
	private JTextField textFieldTIP;
	private JTextField textFieldQUANT;
	private JTextField textFieldPREC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_P frame = new Ad_P();
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
	public Ad_P() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodEnd = new JLabel("Modelo");
		lblCodEnd.setBounds(10, 11, 86, 14);
		contentPane.add(lblCodEnd);

		textFieldMOD = new JTextField();
		textFieldMOD.setBounds(10, 36, 86, 20);
		contentPane.add(textFieldMOD);
		textFieldMOD.setColumns(10);

		textFieldTIP = new JTextField();
		textFieldTIP.setBounds(106, 36, 86, 20);
		contentPane.add(textFieldTIP);
		textFieldTIP.setColumns(10);

		JLabel lblCpf = new JLabel("Tipo");
		lblCpf.setBounds(106, 11, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblNome = new JLabel("Quantidade");
		lblNome.setBounds(10, 67, 86, 14);
		contentPane.add(lblNome);

		textFieldQUANT = new JTextField();
		textFieldQUANT.setBounds(10, 92, 86, 20);
		contentPane.add(textFieldQUANT);
		textFieldQUANT.setColumns(10);

		textFieldPREC = new JTextField();
		textFieldPREC.setText("");
		textFieldPREC.setBounds(106, 92, 86, 20);
		contentPane.add(textFieldPREC);
		textFieldPREC.setColumns(10);

		JLabel lblTelefone = new JLabel("Pre\u00E7o");
		lblTelefone.setBounds(106, 67, 46, 14);
		contentPane.add(lblTelefone);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_JPA c = new Controlador_JPA();
				Pedido i = new Pedido();
				i.setModelo(textFieldMOD.getText());
				i.setTipo(textFieldTIP.getText());
				i.setQaunt_p(Integer.parseInt(textFieldQUANT.getText()));
				i.setPreco(Double.parseDouble(textFieldPREC.getText()));
				c.P_Adicionar(i);
			}
		});
		btnAdicionar.setBounds(10, 137, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(120, 137, 89, 23);
		contentPane.add(btnFechar);
	}
}
