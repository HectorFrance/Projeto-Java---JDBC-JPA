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
import Model.Cliente;

import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;

public class Tela_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NOME;
	private JTable table;
	public static Controlador_JPA c = new Controlador_JPA();
	private JTextField textField_CPF;
	private JLabel lblFabricante;
	private JTextField txtCodigo;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btn_fab;
	private JTextField textFieldTELEFONE;
	private JButton btnModelo;
	private JLabel lblModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cliente frame = new Tela_Cliente();
					frame.setTitle("Cliente");
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
	public Tela_Cliente() {

		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_NOME = new JTextField();
		textField_NOME.setBackground(UIManager.getColor("TextField.light"));
		textField_NOME.setBounds(20, 50, 86, 20);
		contentPane.add(textField_NOME);
		textField_NOME.setColumns(10);
		textField_NOME.setText(null);

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
				new String[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });

		table.setModel(modelo);
		table.setBounds(10, 131, 719, 239);
		contentPane.add(table);

		modelo.setNumRows(0);
		modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
		for (Cliente i : c.CL_ListarTudo()) {
			modelo.addRow(new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
		}

		JButton btn_preco = new JButton("Buscar");
		btn_preco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_NOME.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
					for (Cliente i : c.CL_ListarTudo()) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
					for (Cliente i : c.CL_pesquisaNome(textField_NOME.getText())) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
					}
				}
			}
		});
		btn_preco.setBounds(20, 97, 89, 23);
		contentPane.add(btn_preco);

		JLabel lblPreco = new JLabel("Nome");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(20, 20, 107, 28);
		contentPane.add(lblPreco);

		textField_CPF = new JTextField();
		textField_CPF.setBackground(UIManager.getColor("TextField.light"));
		textField_CPF.setBounds(168, 50, 86, 20);
		contentPane.add(textField_CPF);
		textField_CPF.setColumns(10);
		textField_CPF.setText(null);

		lblFabricante = new JLabel("Cpf");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(168, 20, 107, 28);
		contentPane.add(lblFabricante);

		JButton btnADD = new JButton("Adicionar");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ad_CL().setVisible(true);
			}
		});
		btnADD.setBounds(458, 49, 89, 23);
		contentPane.add(btnADD);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.CL_remover(Integer.parseInt(txtCodigo.getText()));
				modelo.setNumRows(0);
				modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
				for (Cliente i : c.CL_ListarTudo()) {
					modelo.addRow(
							new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
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
				new Alt_CL().setVisible(true);
			}
		});
		btnAlterar.setBounds(557, 49, 89, 23);
		contentPane.add(btnAlterar);

		btn_fab = new JButton("Buscar");
		btn_fab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_CPF.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
					for (Cliente i : c.CL_ListarTudo()) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
					for (Cliente i : c.CL_pesquisaCpf(textField_CPF.getText())) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
					}
				}
			}
		});
		btn_fab.setBounds(168, 97, 89, 23);
		contentPane.add(btn_fab);

		textFieldTELEFONE = new JTextField();
		textFieldTELEFONE.setBackground(UIManager.getColor("TextField.light"));
		textFieldTELEFONE.setBounds(323, 50, 86, 20);
		contentPane.add(textFieldTELEFONE);
		textFieldTELEFONE.setColumns(10);

		btnModelo = new JButton("Buscar");
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldTELEFONE.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
					for (Cliente i : c.CL_ListarTudo()) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod End", "Cpf", "Nome", "Telefone" });
					for (Cliente i : c.CL_pesquisaTelefone(textFieldTELEFONE.getText())) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_end(), i.getCpf(), i.getNome(), i.getTelefone() });
					}
				}
			}
		});
		btnModelo.setBounds(323, 97, 89, 23);
		contentPane.add(btnModelo);

		lblModelo = new JLabel("Telefone");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(323, 20, 89, 23);
		contentPane.add(lblModelo);

	}
}
