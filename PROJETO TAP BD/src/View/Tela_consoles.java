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

import Controller.Controlador;
import Model.Consoles;

import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;

public class Tela_consoles extends JFrame {

	private JPanel contentPane;
	private JTextField textField_preco;
	private JTable table;
	public static Controlador c = new Controlador();
	private JTextField textField_fab;
	private JLabel lblFabricante;
	private JTextField txtCodigo;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btn_fab;
	private JTextField textFieldModelo;
	private JButton btnModelo;
	private JLabel lblModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_consoles frame = new Tela_consoles();
					frame.setTitle("Consoles");
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
	public Tela_consoles() {

		setTitle("Consoles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_preco = new JTextField();
		textField_preco.setBackground(UIManager.getColor("TextField.light"));
		textField_preco.setBounds(20, 50, 86, 20);
		contentPane.add(textField_preco);
		textField_preco.setColumns(10);
		textField_preco.setText(null);

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
				new String[] { "Cod", "Cod_Fab", "Modelo", "preco" });

		table.setModel(modelo);
		table.setBounds(10, 131, 719, 239);
		contentPane.add(table);

		modelo.setNumRows(0);
		modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
		for (Consoles i : c.CS_listarTudo()) {
			modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
		}

		JButton btn_preco = new JButton("Buscar");
		btn_preco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_preco.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
					for (Consoles i : c.CS_listarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
					for (Consoles i : c.CS_pesquisaPreco(Integer.parseInt(textField_preco.getText()))) {
						modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
					}
				}
			}
		});
		btn_preco.setBounds(20, 97, 89, 23);
		contentPane.add(btn_preco);

		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(20, 20, 107, 28);
		contentPane.add(lblPreco);

		textField_fab = new JTextField();
		textField_fab.setBackground(UIManager.getColor("TextField.light"));
		textField_fab.setBounds(168, 50, 86, 20);
		contentPane.add(textField_fab);
		textField_fab.setColumns(10);
		textField_fab.setText(null);

		lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(168, 20, 107, 28);
		contentPane.add(lblFabricante);

		JButton btnADD = new JButton("Adicionar");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ad_CS().setVisible(true);
			}
		});
		btnADD.setBounds(458, 49, 89, 23);
		contentPane.add(btnADD);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.CS_remover(Integer.parseInt(txtCodigo.getText()));
				modelo.setNumRows(0);
				modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
				for (Consoles i : c.CS_listarTudo()) {
					modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
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
				new Alt_CS().setVisible(true);
			}
		});
		btnAlterar.setBounds(557, 49, 89, 23);
		contentPane.add(btnAlterar);

		btn_fab = new JButton("Buscar");
		btn_fab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_fab.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
					for (Consoles i : c.CS_listarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
					for (Consoles i : c.CS_pesquisaCodFab(Integer.parseInt(textField_fab.getText()))) {
						modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
					}
				}
			}
		});
		btn_fab.setBounds(168, 97, 89, 23);
		contentPane.add(btn_fab);

		textFieldModelo = new JTextField();
		textFieldModelo.setBackground(UIManager.getColor("TextField.light"));
		textFieldModelo.setBounds(323, 50, 86, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		btnModelo = new JButton("Buscar");
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldModelo.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
					for (Consoles i : c.CS_listarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod_Fab", "Modelo", "preco" });
					for (Consoles i : c.CS_pessquisaModelo(textFieldModelo.getText())) {
						modelo.addRow(new Object[] { i.getCod(), i.getCod_fab(), i.getModelo(), i.getPreco() });
					}
				}
			}
		});
		btnModelo.setBounds(323, 97, 89, 23);
		contentPane.add(btnModelo);

		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(323, 20, 89, 23);
		contentPane.add(lblModelo);

	}
}
