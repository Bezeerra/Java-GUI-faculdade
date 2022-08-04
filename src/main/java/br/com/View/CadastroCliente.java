package br.com.View;
import br.com.projectFinal.Connect;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente window = new CadastroCliente();
					window.frame.setVisible(true);
					//Connect newConnect = new Connect("chaledb", "root", "chale123");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroCliente() {
		initialize();  
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(48, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(48, 130, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("RG:");
		lblNewLabel_1_1.setBounds(48, 165, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endereco:");
		lblNewLabel_1_2.setBounds(48, 201, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Numero:");
		lblNewLabel_1_3.setBounds(48, 239, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Cidade");
		lblNewLabel_1_4.setBounds(48, 281, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("D Nasc:");
		lblNewLabel_1_5.setBounds(48, 352, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		textField = new JTextField();
		textField.setBounds(116, 93, 201, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 127, 201, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 162, 201, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 198, 201, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 236, 201, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(116, 278, 201, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(116, 349, 201, 20);
		frame.getContentPane().add(textField_6);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("CADASTRO CLIENTE");
		lblNewLabel_2.setBounds(178, 31, 108, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(116, 309, 201, 20);
		frame.getContentPane().add(textField_7);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("D Nasc:");
		lblNewLabel_1_5_1.setBounds(48, 312, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_5_1);
		
		
		JButton btnNewButton = new JButton("Cadastrar!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkCadastroClient(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_7.getText() , textField_6.getText());
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				} catch (NumberFormatException forMat) {
					JOptionPane.showMessageDialog(null, "Tenha certeza que nao tem nenhum coluna em branco");
				}
			}
		}
		);
		btnNewButton.setBounds(186, 392, 131, 35);
		frame.getContentPane().add(btnNewButton);
	}
	public void checkCadastroClient(String nome, String cpf, String rg, String endereco, String numClient, String cidade, String estado, String dataNascimento) {
		int num = Integer.parseInt(numClient);
		Connect newConnect = new Connect("chaledb", "root", "chale123"); //criando a conexao com o banco de dados
		newConnect.sendConnection("INSERT INTO client_chale (nameClient, cpfClient, rgClient, endereco, numClient, cidade, estado, dataClient) VALUES ('"+ nome + "','" + cpf + "','"+ rg + "','"+ endereco + "',"+ num + ",'"+ cidade + "','" + estado +"', " + dataNascimento +")");
	}
}
