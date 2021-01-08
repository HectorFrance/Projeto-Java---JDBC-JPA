package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicail frame = new Inicail();
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
	public Inicail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(170, 356, 89, 23);
		contentPane.add(btnFechar);

		JLabel lblJdbc = new JLabel("JDBC");
		lblJdbc.setBounds(38, 11, 132, 37);
		lblJdbc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblJdbc.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblJpa = new JLabel("JPA");
		lblJpa.setBounds(255, 11, 118, 37);
		lblJpa.setHorizontalAlignment(SwingConstants.CENTER);
		lblJpa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.setLayout(null);
		contentPane.add(lblJdbc);
		contentPane.add(lblJpa);

		JButton btnImpressora = new JButton("Impressora");
		btnImpressora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImpressora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarImp().setVisible(true);
				dispose();
			}
		});
		btnImpressora.setBounds(38, 109, 116, 23);
		contentPane.add(btnImpressora);

		JButton btnFabricante = new JButton("Fabricante");
		btnFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaFabricante().setVisible(true);
				dispose();
			}
		});
		btnFabricante.setBounds(38, 75, 116, 23);
		contentPane.add(btnFabricante);

		JButton btnComputadores = new JButton("Computadores");
		btnComputadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela_Computadores().setVisible(true);
				dispose();
			}
		});
		btnComputadores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnComputadores.setBounds(38, 143, 116, 23);
		contentPane.add(btnComputadores);

		JButton btnConsoles = new JButton("Consoles");
		btnConsoles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tela_consoles().setVisible(true);
				dispose();
			}
		});
		btnConsoles.setBounds(38, 177, 116, 23);
		contentPane.add(btnConsoles);

		JButton btnNewButton = new JButton("Acessorios");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela_Acessorios().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(38, 211, 116, 23);
		contentPane.add(btnNewButton);

		JButton btnEndereco = new JButton("Endere\u00E7o");
		btnEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela_Endereco().setVisible(true);
				dispose();
			}
		});
		btnEndereco.setBounds(255, 75, 118, 23);
		contentPane.add(btnEndereco);

		JButton btnCLientes = new JButton("Cliente");
		btnCLientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tela_Cliente().setVisible(true);
				dispose();
			}
		});
		btnCLientes.setBounds(255, 109, 118, 23);
		contentPane.add(btnCLientes);

		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela_Funcionario().setVisible(true);
				dispose();
			}
		});
		btnFuncionario.setBounds(255, 143, 118, 23);
		contentPane.add(btnFuncionario);

		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tela_Pedido().setVisible(true);
				dispose();
			}
		});
		btnPedidos.setBounds(255, 177, 118, 23);
		contentPane.add(btnPedidos);

		JButton btnNewButton_1 = new JButton("Vendas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela_Vendas().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(255, 211, 118, 23);
		contentPane.add(btnNewButton_1);
	}
}
