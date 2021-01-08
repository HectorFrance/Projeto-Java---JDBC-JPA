package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;
import Model.Impressora;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdImp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCOD_FAB;
	private JTextField textFieldModelo;
	private JTextField textFieldPreco;
	private JTextField textFieldTipo;
	public static Controlador c = new Controlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdImp frame = new AdImp();
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
	public AdImp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldCOD_FAB = new JTextField();
		textFieldCOD_FAB.setBounds(10, 75, 86, 20);
		contentPane.add(textFieldCOD_FAB);
		textFieldCOD_FAB.setColumns(10);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(106, 75, 86, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(202, 75, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(298, 75, 86, 20);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);

		JButton btnAdcionar = new JButton("Adicionar");
		btnAdcionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Impressora i = new Impressora();
				i.setCod_fab(Integer.parseInt(textFieldCOD_FAB.getText()));
				i.setModelo(textFieldModelo.getText());
				i.setPreco(Double.parseDouble(textFieldPreco.getText()));
				i.setTipo(textFieldTipo.getText());
				c.adcionarIMP(i);
			}
		});
		btnAdcionar.setBounds(37, 128, 89, 23);
		contentPane.add(btnAdcionar);

		JLabel lblCod_fab = new JLabel("Cod Fabricante");
		lblCod_fab.setBounds(10, 50, 86, 14);
		contentPane.add(lblCod_fab);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(106, 50, 86, 14);
		contentPane.add(lblModelo);

		JLabel lblprec = new JLabel("Pre\u00E7o");
		lblprec.setBounds(202, 50, 86, 14);
		contentPane.add(lblprec);

		JLabel lbltipo = new JLabel("Tipo");
		lbltipo.setBounds(298, 50, 86, 14);
		contentPane.add(lbltipo);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(247, 128, 89, 23);
		contentPane.add(btnFechar);
	}
}
