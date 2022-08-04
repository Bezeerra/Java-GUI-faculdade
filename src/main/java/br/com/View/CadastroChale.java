package br.com.View;
import br.com.projectFinal.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroChale {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroChale window = new CadastroChale();
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
	public CadastroChale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Localização:");
		lblNewLabel_1.setBounds(48, 109, 95, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrição");
		lblNewLabel_1_1.setBounds(48, 143, 103, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Capacidade");
		lblNewLabel_1_1_1.setBounds(48, 175, 103, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Valor Alta:");
		lblNewLabel_1_1_1_1.setBounds(48, 207, 95, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Baixa:");
		lblNewLabel_2.setBounds(48, 238, 103, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRAMENTO CHALE");
		lblNewLabel_3.setBounds(162, 36, 160, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 104, 225, 25);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 138, 225, 25);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 170, 225, 25);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 202, 225, 25);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(128, 233, 225, 25);
		frame.getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("CADASTRAR!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					checkCadastroChale(textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				} catch (NumberFormatException forMat) {
					JOptionPane.showMessageDialog(null, "Tenha certeza que nao tem nenhum coluna em branco");
				}
			}
		});
		btnNewButton.setBounds(171, 293, 122, 37);
		frame.getContentPane().add(btnNewButton);
	}
	public void checkCadastroChale(String localizacao, String descricao, String capacidade, String valorAltaEstacao, String valorBaixaEstacao) {
		//event
		Integer capac = Integer.parseInt(capacidade);
		Double valorAlta = Double.parseDouble(valorAltaEstacao);
		Double valorBaixa = Double.parseDouble(valorBaixaEstacao); 
		Connect newConnect = new Connect("chaledb", "root", "chale123");
		newConnect.sendConnection("INSERT INTO chale (localizacao, description, capacidade, valorAltaEstacao, valorBaixaEstacao) VALUES ('"+ localizacao + "','" + descricao + "',"+ capac + ","+ valorAlta + ","+ valorBaixa +")");
	}
	
}
