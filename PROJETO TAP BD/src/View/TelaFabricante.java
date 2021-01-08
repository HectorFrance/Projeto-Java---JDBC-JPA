package View;

import java.awt.BorderLayout;
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
import DAO.Controlador_Impressora;
import Model.Fabricante;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class TelaFabricante extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nome;
	private JTable table;
	public static Controlador c = new Controlador();
	private JTextField txtCodigo;
	private JButton btnVoltar;
	private JScrollBar scrollBar;
	private JTextField textField_aDnome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFabricante frame = new TelaFabricante();
					frame.setTitle("Fabricantes");
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
	public TelaFabricante() {

		setTitle("Fabricantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_nome = new JTextField();
		textField_nome.setBackground(UIManager.getColor("TextField.light"));
		textField_nome.setBounds(20, 50, 86, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		textField_nome.setText(null);

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
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Cod", "Nome" });

		table.setModel(modelo);
		table.setBounds(10, 131, 719, 239);
		contentPane.add(table);

		modelo.setNumRows(0);
		modelo.addRow(new Object[] { "Cod", "Nome" });
		for (Fabricante i : c.FABlistarTudo()) {
			modelo.addRow(new Object[] { i.getCod(), i.getNome() });
		}

		JButton btn_preco = new JButton("Buscar");
		btn_preco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_nome.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "nome" });
					for (Fabricante i : c.FABlistarTudo()) {
						modelo.addRow(new Object[] { i.getCod(), i.getNome() });
					}
				} else {
					if (textField_nome.getText() != null) {
						int preco = Integer.parseInt(textField_nome.getText());
						modelo.setNumRows(0);
						modelo.addRow(new Object[] { "Cod", "Nome" });
						for (Fabricante i : c.FABlistarTudo()) {
							modelo.addRow(new Object[] { i.getCod(), i.getNome() });
						}
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

		JButton btnADD = new JButton("Adicionar");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fabricante i = new Fabricante();
				i.setNome(textField_aDnome.getText());
				c.adcionarFAB(i);
				modelo.setNumRows(0);
				modelo.addRow(new Object[] { "Cod", "Nome" });
				for (Fabricante m : c.FABlistarTudo()) {
					modelo.addRow(new Object[] { m.getCod(), m.getNome() });
				}
			}

		});
		btnADD.setBounds(458, 49, 89, 23);
		contentPane.add(btnADD);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.removerFAB(Integer.parseInt(txtCodigo.getText()));
				modelo.setNumRows(0);
				modelo.addRow(new Object[] { "Cod", "Nome" });
				for (Fabricante i : c.FABlistarTudo()) {
					modelo.addRow(new Object[] { i.getCod(), i.getNome() });
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

		textField_aDnome = new JTextField();
		textField_aDnome.setBounds(557, 50, 86, 20);
		contentPane.add(textField_aDnome);
		textField_aDnome.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(557, 29, 46, 14);
		contentPane.add(lblNome);

	}
}
