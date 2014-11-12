package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import modelos.ModeloFuncionario;
import negocios.RegrasFuncionarios;

@SuppressWarnings("serial")
public class Login extends JFrame {

	RegrasFuncionarios regras = new RegrasFuncionarios();

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordSenha;
	private JButton btnEntrar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				Login frame = new Login();
				frame.setVisible(true);

			}

		});

	}

	public Login() {

		try {

			regras.conecta();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

		setTitle("Login SysAuto");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 12));

		textLogin = new JTextField();
		textLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 12));

		passwordSenha = new JPasswordField();
		passwordSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				login();

			}

		});

		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				login();

			}

		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				try {

					regras.desconecta();

				} catch (SQLException ex) {

					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

				}

			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		contentPane.setLayout(gl_contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(0)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSenha)
										.addGroup(
												gl_contentPane
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblLogin).addGap(96))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(Alignment.TRAILING)
																						.addComponent(passwordSenha, Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
																						.addComponent(textLogin, GroupLayout.DEFAULT_SIZE, 117,
																								Short.MAX_VALUE))
																		.addPreferredGap(ComponentPlacement.UNRELATED))))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnEntrar).addGap(8)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(lblLogin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnEntrar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												Alignment.TRAILING,
												gl_contentPane
														.createSequentialGroup()
														.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblSenha)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))).addGap(38)));

	}

	private void login() {

		String login = textLogin.getText();
		@SuppressWarnings("deprecation")
		String senha = passwordSenha.getText();

		try {

			ModeloFuncionario funcionario = regras.consultaFuncionarioLogin(login);

			String nivel_acesso = funcionario.getNivel_acesso().toString().substring(0, 1);

			textLogin.setText(null);
			passwordSenha.setText(null);

			if (senha.equals(funcionario.getSenha())) {

				if (nivel_acesso.equals("1")) {

					Frente_de_Servico interface_operacional = new Frente_de_Servico();
					interface_operacional.setVisible(true);

				}

				if (nivel_acesso.equals("2")) {

					Administrativo interface_administrativo = new Administrativo();
					interface_administrativo.setVisible(true);

				}

			} else {

				JOptionPane.showMessageDialog(null, "Acesso Negado!");

			}

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Login incorreto", "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}

}