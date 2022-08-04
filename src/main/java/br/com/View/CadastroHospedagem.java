package br.com.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.projectFinal.Connect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroHospedagem {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHospedagem window = new CadastroHospedagem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroHospedagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cod Chale:");
		lblNewLabel.setBounds(57, 80, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Cliente:");
		lblNewLabel_1.setBounds(57, 105, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Inicio:");
		lblNewLabel_1_1.setBounds(57, 130, 71, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data Fim:");
		lblNewLabel_2.setBounds(57, 155, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pessoas:");
		lblNewLabel_2_1.setBounds(57, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Desconto:");
		lblNewLabel_2_1_1.setBounds(57, 205, 71, 14);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Valor Final:");
		lblNewLabel_2_1_1_1.setBounds(57, 230, 71, 14);
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(127, 77, 208, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 102, 208, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 127, 208, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(127, 152, 208, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(127, 177, 208, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(127, 202, 208, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(127, 227, 208, 20);
		frame.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRAMENTO HOSPEDAGEM");
		lblNewLabel_3.setBounds(150, 11, 167, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton = new JButton("CADASTRAR!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkCadastroHospedagem(textField.getText(),textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText());
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				} catch (NumberFormatException forMat) {
					JOptionPane.showMessageDialog(null, "Tenha certeza que nao tem nenhum coluna em branco");
				}
			}
		});
		btnNewButton.setBounds(164, 277, 153, 40);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void checkCadastroHospedagem(String codChale, String idClient, String dataInicio, String dataFim, String qtdPessoas, String desconto, String valorFinal) {
		Double desc = Double.parseDouble(desconto);
		Double valorF = Double.parseDouble(valorFinal);
		Integer qntP = Integer.parseInt(qtdPessoas);
		Integer codC = Integer.parseInt(codChale);
		Integer idC = Integer.parseInt(idClient);
		Connect newConnect = new Connect("chaledb", "root", "chale123");
		newConnect.sendConnection("INSERT INTO hospedagem (codChale, idClient, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES ("+ codC + "," + idC + ",'"+ dataInicio + "','"+ dataFim + "',"+ qntP +","+ desc +","+ valorF +")");
	}

}
