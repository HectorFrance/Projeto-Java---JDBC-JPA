package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador_JPA;
import Model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_FUNC extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEND;
	private JTextField textFieldCPF;
	private JTextField textFieldNOME;
	private JTextField textFieldTELEFONE;
	private JTextField textFieldSetor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_FUNC frame = new Ad_FUNC();
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
	public Ad_FUNC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodEnd = new JLabel("Cod End");
		lblCodEnd.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodEnd);
		
		textFieldEND = new JTextField();
		textFieldEND.setBounds(10, 36, 86, 20);
		contentPane.add(textFieldEND);
		textFieldEND.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(106, 36, 86, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(106, 11, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 67, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNOME = new JTextField();
		textFieldNOME.setBounds(10, 92, 86, 20);
		contentPane.add(textFieldNOME);
		textFieldNOME.setColumns(10);
		
		textFieldTELEFONE = new JTextField();
		textFieldTELEFONE.setText("");
		textFieldTELEFONE.setBounds(106, 92, 86, 20);
		contentPane.add(textFieldTELEFONE);
		textFieldTELEFONE.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(106, 67, 46, 14);
		contentPane.add(lblTelefone);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_JPA c = new Controlador_JPA();
				Funcionario i =new Funcionario();
				i.setCod_end(Integer.parseInt(textFieldEND.getText()));
				i.setCpf(textFieldCPF.getText());
				i.setNome(textFieldNOME.getText());
				i.setTelefone(textFieldTELEFONE.getText());
				i.setSetor(textFieldSetor.getText());
				c.FUNC_Adicionar(i);
			}
		});
		btnAdicionar.setBounds(7, 198, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(120, 198, 89, 23);
		contentPane.add(btnFechar);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setBounds(10, 123, 46, 14);
		contentPane.add(lblSetor);
		
		textFieldSetor = new JTextField();
		textFieldSetor.setBounds(10, 148, 86, 20);
		contentPane.add(textFieldSetor);
		textFieldSetor.setColumns(10);
	}
}
