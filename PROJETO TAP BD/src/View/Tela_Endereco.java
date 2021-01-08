package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controlador_JPA;
import Model.Endereco;

import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;

public class Tela_Endereco extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Cidade;
	private JTable table;
	public static Controlador_JPA c = new Controlador_JPA();
	private JTextField textField_Bairro;
	private JLabel lblFabricante;
	private JTextField txtCodigo;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btn_fab;
	private JTextField textFieldRua;
	private JButton btnModelo;
	private JLabel lblModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Endereco frame = new Tela_Endereco();
					frame.setTitle("Endereço");
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
	public Tela_Endereco() {

		setTitle("Endreços");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_Cidade = new JTextField();
		textField_Cidade.setBackground(UIManager.getColor("TextField.light"));
		textField_Cidade.setBounds(20, 50, 86, 20);
		contentPane.add(textField_Cidade);
		textField_Cidade.setColumns(10);
		textField_Cidade.setText(null);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setToolTipText("");
		table.setRowSelectionAllowed(false);
		table.setName("kkk");
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		table.setBackground(UIManager.getColor("TabbedPane.highlight"));
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });

		table.setModel(modelo);
		table.setBounds(10, 131, 719, 239);
		contentPane.add(table);

		modelo.setNumRows(0);
		modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
		for (Endereco i : c.END_listarTudo()) {
			modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(), i.getRua(),
					i.getNumero(), i.getComplemento() });
		}

		JButton btn_preco = new JButton("Buscar");
		btn_preco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_Cidade.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
					for (Endereco i : c.END_listarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(),
								i.getRua(), i.getNumero(), i.getComplemento() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
					for (Endereco i : c.END_pesquisaCidade(textField_Cidade.getText())) {
						modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(),
								i.getRua(), i.getNumero(), i.getComplemento() });
					}
				}
			}
		});
		btn_preco.setBounds(20, 97, 89, 23);
		contentPane.add(btn_preco);

		JLabel lblPreco = new JLabel("Cidade");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(20, 20, 107, 28);
		contentPane.add(lblPreco);

		textField_Bairro = new JTextField();
		textField_Bairro.setBackground(UIManager.getColor("TextField.light"));
		textField_Bairro.setBounds(168, 50, 86, 20);
		contentPane.add(textField_Bairro);
		textField_Bairro.setColumns(10);
		textField_Bairro.setText(null);

		lblFabricante = new JLabel("Bairro");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(168, 20, 107, 28);
		contentPane.add(lblFabricante);

		JButton btnADD = new JButton("Adicionar");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ad_END().setVisible(true);
			}
		});
		btnADD.setBounds(458, 49, 89, 23);
		contentPane.add(btnADD);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.END_remover(Integer.parseInt(txtCodigo.getText()));
				modelo.setNumRows(0);
				modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
				for (Endereco i : c.END_listarTudo()) {
					modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(), i.getRua(),
							i.getNumero(), i.getComplemento() });
				}
			}
		});
		btnRemover.setBounds(458, 97, 89, 23);
		contentPane.add(btnRemover);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(557, 100, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(557, 85, 46, 14);
		contentPane.add(lblCodigo);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inicail().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(323, 397, 89, 23);
		contentPane.add(btnVoltar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Alt_END().setVisible(true);
			}
		});
		btnAlterar.setBounds(557, 49, 89, 23);
		contentPane.add(btnAlterar);

		btn_fab = new JButton("Buscar");
		btn_fab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Bairro.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
					for (Endereco i : c.END_listarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(),
								i.getRua(), i.getNumero(), i.getComplemento() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
					for (Endereco i : c.END_pesquisaBairro(textField_Bairro.getText())) {
						modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(),
								i.getRua(), i.getNumero(), i.getComplemento() });
					}
				}
			}
		});
		btn_fab.setBounds(168, 97, 89, 23);
		contentPane.add(btn_fab);

		textFieldRua = new JTextField();
		textFieldRua.setBackground(UIManager.getColor("TextField.light"));
		textFieldRua.setBounds(323, 50, 86, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);

		btnModelo = new JButton("Buscar");
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldRua.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
					for (Endereco i : c.END_listarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(),
								i.getRua(), i.getNumero(), i.getComplemento() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Complemento" });
					for (Endereco i : c.END_pesquisaRua(textFieldRua.getText())) {
						modelo.addRow(new Object[] { i.getCod(), i.getEstado(), i.getCidade(), i.getBairro(),
								i.getRua(), i.getNumero(), i.getComplemento() });
					}
				}
			}
		});
		btnModelo.setBounds(323, 97, 89, 23);
		contentPane.add(btnModelo);

		lblModelo = new JLabel("Rua");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(323, 20, 89, 23);
		contentPane.add(lblModelo);

	}
}
