package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class configurarServidor extends JFrame {

	private JPanel contentPane;
	private JTextField textIP;
	private JTextField textUsuario;
	private JPasswordField passwordSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configurarServidor frame = new configurarServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public configurarServidor() {
		setResizable(false);
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblIP = new JLabel("IP do Servidor");
		lblIP.setFont(new Font("Arial", Font.BOLD, 12));

		textIP = new JTextField();
		textIP.setColumns(10);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 12));

		textUsuario = new JTextField();
		textUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 12));

		passwordSenha = new JPasswordField();

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblUsuario)
														.addComponent(
																textUsuario,
																GroupLayout.PREFERRED_SIZE,
																100,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblIP))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblSenha,
																Alignment.LEADING)
														.addComponent(
																passwordSenha,
																Alignment.LEADING,
																90, 90, 90))
										.addGap(9))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(textIP,
												GroupLayout.DEFAULT_SIZE, 199,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 199,
												Short.MAX_VALUE)
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(lblIP)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(textIP,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblUsuario)
														.addComponent(lblSenha))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textUsuario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																passwordSenha,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// TODO

			}
		});
		panel.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// TODO

			}
		});
		panel.add(btnCancelar);
		contentPane.setLayout(gl_contentPane);
	}
}