package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador_JPA;
import Model.Vendas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_V extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCODCL;
	private JTextField textFieldCODV;
	private JTextField textFieldCODP;
	private JTextField textFieldCODEND;
	private JTextField textFieldNOMECLIENTE;
	private JTextField textFieldNOMEVENDEDOR;
	private JTextField textFieldPRECO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_V frame = new Ad_V();
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
	public Ad_V() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEstado = new JLabel("Cod Cliente");
		lblEstado.setBounds(10, 11, 86, 14);
		contentPane.add(lblEstado);

		textFieldCODCL = new JTextField();
		textFieldCODCL.setBounds(10, 36, 86, 20);
		contentPane.add(textFieldCODCL);
		textFieldCODCL.setColumns(10);

		textFieldCODV = new JTextField();
		textFieldCODV.setBounds(106, 36, 86, 20);
		contentPane.add(textFieldCODV);
		textFieldCODV.setColumns(10);

		textFieldCODP = new JTextField();
		textFieldCODP.setText("");
		textFieldCODP.setBounds(202, 36, 86, 20);
		contentPane.add(textFieldCODP);
		textFieldCODP.setColumns(10);

		JLabel lblCidade = new JLabel("Cod Vendedor");
		lblCidade.setBounds(106, 11, 86, 14);
		contentPane.add(lblCidade);

		JLabel lblBairro = new JLabel("Cod Pedido");
		lblBairro.setBounds(202, 11, 86, 14);
		contentPane.add(lblBairro);

		JLabel lblRua = new JLabel("Cod endereco");
		lblRua.setBounds(10, 67, 86, 14);
		contentPane.add(lblRua);

		textFieldCODEND = new JTextField();
		textFieldCODEND.setBounds(10, 92, 86, 20);
		contentPane.add(textFieldCODEND);
		textFieldCODEND.setColumns(10);

		textFieldNOMECLIENTE = new JTextField();
		textFieldNOMECLIENTE.setBounds(106, 92, 86, 20);
		contentPane.add(textFieldNOMECLIENTE);
		textFieldNOMECLIENTE.setColumns(10);

		textFieldNOMEVENDEDOR = new JTextField();
		textFieldNOMEVENDEDOR.setText("");
		textFieldNOMEVENDEDOR.setBounds(202, 92, 86, 20);
		contentPane.add(textFieldNOMEVENDEDOR);
		textFieldNOMEVENDEDOR.setColumns(10);

		JLabel lblNumero = new JLabel("Nome Cliente");
		lblNumero.setBounds(106, 67, 86, 14);
		contentPane.add(lblNumero);

		JLabel lblComplemento = new JLabel("Nome Venderor");
		lblComplemento.setBounds(202, 67, 86, 14);
		contentPane.add(lblComplemento);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendas i = new Vendas();
				i.setCod_pedido(Integer.parseInt(textFieldCODP.getText()));
				i.setCod_vendador(Integer.parseInt(textFieldCODV.getText()));
				i.setNome_Vendedor(textFieldNOMEVENDEDOR.getText());
				i.setCod_Cliente(Integer.parseInt(textFieldCODCL.getText()));
				i.setNome_Cliente(textFieldNOMECLIENTE.getText());
				i.setCod_endereco(Integer.parseInt(textFieldCODEND.getText()));
				i.setPreco(Integer.parseInt(textFieldPRECO.getText()));
				Controlador_JPA c = new Controlador_JPA();
				c.V_Adicionar(i);

			}
		});
		btnAdicionar.setBounds(46, 196, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(166, 196, 89, 23);
		contentPane.add(btnFechar);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(106, 123, 46, 14);
		contentPane.add(lblPreo);

		textFieldPRECO = new JTextField();
		textFieldPRECO.setBounds(106, 148, 86, 20);
		contentPane.add(textFieldPRECO);
		textFieldPRECO.setColumns(10);
	}
}
