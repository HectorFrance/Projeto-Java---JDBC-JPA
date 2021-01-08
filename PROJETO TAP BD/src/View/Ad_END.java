package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador_JPA;
import Model.Endereco;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_END extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldComplemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_END frame = new Ad_END();
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
	public Ad_END() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 11, 86, 14);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(10, 36, 86, 20);
		contentPane.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(106, 36, 86, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(202, 36, 86, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(106, 11, 86, 14);
		contentPane.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(202, 11, 86, 14);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 67, 86, 14);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(10, 92, 86, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(106, 92, 86, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setText("");
		textFieldComplemento.setBounds(202, 92, 86, 20);
		contentPane.add(textFieldComplemento);
		textFieldComplemento.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(106, 67, 86, 14);
		contentPane.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(202, 67, 86, 14);
		contentPane.add(lblComplemento);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco i = new Endereco();
				i.setBairro(textFieldBairro.getText());
				i.setCidade(textFieldCidade.getText());
				i.setComplemento(textFieldComplemento.getText());
				i.setEstado(textFieldEstado.getText());
				i.setNumero(textFieldNumero.getText());
				i.setRua(textFieldRua.getText());
				Controlador_JPA c =new Controlador_JPA();
				c.END_adicionar(i);
				
			}
		});
		btnAdicionar.setBounds(45, 149, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(165, 149, 89, 23);
		contentPane.add(btnFechar);
	}
}
