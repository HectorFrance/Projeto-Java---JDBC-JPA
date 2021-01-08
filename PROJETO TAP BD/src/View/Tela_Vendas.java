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
import Model.Vendas;

import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;

public class Tela_Vendas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNOMECLIENTE;
	private JTable table;
	public static Controlador_JPA c = new Controlador_JPA();
	private JTextField textFieldCODVENDEDOR;
	private JLabel lblFabricante;
	private JTextField txtCodigo;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btn_fab;
	private JTextField textFieldCODENDEREÇO;
	private JButton btnModelo;
	private JLabel lblModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Vendas frame = new Tela_Vendas();
					frame.setTitle("Vendas");
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
	public Tela_Vendas() {

		setTitle("Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNOMECLIENTE = new JTextField();
		textFieldNOMECLIENTE.setBackground(UIManager.getColor("TextField.light"));
		textFieldNOMECLIENTE.setBounds(20, 50, 86, 20);
		contentPane.add(textFieldNOMECLIENTE);
		textFieldNOMECLIENTE.setColumns(10);
		textFieldNOMECLIENTE.setText(null);

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
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Cod", "Cod cliente",
				"Nome CLiente", "Cod Vendendor", "Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });

		table.setModel(modelo);
		table.setBounds(10, 131, 719, 239);
		contentPane.add(table);

		modelo.setNumRows(0);
		modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor", "Nome Vendendor",
				"Cod Endereço", "Cod Pedido", "Preço" });
		for (Vendas i : c.V_ListarTudo()) {
			modelo.addRow(new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
					i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
		}

		JButton btn_preco = new JButton("Buscar");
		btn_preco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldNOMECLIENTE.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor",
							"Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });
					for (Vendas i : c.V_ListarTudo()) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
										i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor",
							"Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });
					for (Vendas i : c.V_pesquisaCliente(textFieldNOMECLIENTE.getText())) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
										i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
					}
				}
			}
		});
		btn_preco.setBounds(20, 97, 89, 23);
		contentPane.add(btn_preco);

		JLabel lblPreco = new JLabel("Nome Cliente");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(20, 20, 107, 28);
		contentPane.add(lblPreco);

		textFieldCODVENDEDOR = new JTextField();
		textFieldCODVENDEDOR.setBackground(UIManager.getColor("TextField.light"));
		textFieldCODVENDEDOR.setBounds(168, 50, 86, 20);
		contentPane.add(textFieldCODVENDEDOR);
		textFieldCODVENDEDOR.setColumns(10);
		textFieldCODVENDEDOR.setText(null);

		lblFabricante = new JLabel("Cod Vendendor");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(168, 20, 107, 28);
		contentPane.add(lblFabricante);

		JButton btnADD = new JButton("Adicionar");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ad_V().setVisible(true);
			}
		});
		btnADD.setBounds(458, 49, 89, 23);
		contentPane.add(btnADD);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.V_remover(Integer.parseInt(txtCodigo.getText()));
				modelo.setNumRows(0);
				modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor", "Nome Vendendor",
						"Cod Endereço", "Cod Pedido", "Preço" });
				for (Vendas i : c.V_ListarTudo()) {
					modelo.addRow(
							new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
									i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
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
				new Alt_V().setVisible(true);
			}
		});
		btnAlterar.setBounds(557, 49, 89, 23);
		contentPane.add(btnAlterar);

		btn_fab = new JButton("Buscar");
		btn_fab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCODVENDEDOR.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor",
							"Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });
					for (Vendas i : c.V_ListarTudo()) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
										i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor",
							"Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });
					for (Vendas i : c.V_pesquisaCodVendendor(Integer.parseInt(textFieldCODVENDEDOR.getText()))) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
										i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
					}
				}
			}
		});
		btn_fab.setBounds(168, 97, 89, 23);
		contentPane.add(btn_fab);

		textFieldCODENDEREÇO = new JTextField();
		textFieldCODENDEREÇO.setBackground(UIManager.getColor("TextField.light"));
		textFieldCODENDEREÇO.setBounds(323, 50, 86, 20);
		contentPane.add(textFieldCODENDEREÇO);
		textFieldCODENDEREÇO.setColumns(10);

		btnModelo = new JButton("Buscar");
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCODENDEREÇO.getText().equalsIgnoreCase("")) {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor",
							"Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });
					for (Vendas i : c.V_ListarTudo()) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
										i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
					}
				} else {
					modelo.setNumRows(0);
					modelo.addRow(new Object[] { "Cod", "Cod cliente", "Nome CLiente", "Cod Vendendor",
							"Nome Vendendor", "Cod Endereço", "Cod Pedido", "Preço" });
					for (Vendas i : c.V_pesquisaCodEndereco(Integer.parseInt(textFieldCODENDEREÇO.getText()))) {
						modelo.addRow(
								new Object[] { i.getCod(), i.getCod_Cliente(), i.getNome_Cliente(), i.getCod_vendador(),
										i.getNome_Vendedor(), i.getCod_endereco(), i.getCod_pedido(), i.getPreco() });
					}
				}
			}
		});
		btnModelo.setBounds(323, 97, 89, 23);
		contentPane.add(btnModelo);

		lblModelo = new JLabel("Cod Endere\u00E7o");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(323, 20, 89, 23);
		contentPane.add(lblModelo);

	}
}
