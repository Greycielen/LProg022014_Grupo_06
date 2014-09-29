package Interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import Modelos.ModeloFuncionario;
import Negocios.RegrasFuncionarios;

@SuppressWarnings("serial")
public class CadastroFuncionarios extends JFrame {

	ModeloFuncionario funcionario = new ModeloFuncionario();

	RegrasFuncionarios regras = new RegrasFuncionarios();

	private JTextField textLogin;
	private JLabel lblNome;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JTextField textEnquadramento_Funcional;
	private JLabel lblEnquadramentoFuncional;
	private JPasswordField passwordSenha;
	private JTextField textNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarios frame = new CadastroFuncionarios();
					frame.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void preencherCombo(JComboBox<String> comboFuncionario) throws SQLException {

		comboFuncionario.addItem("<NOVO FUNCIONARIO>");

		for (int i = 0; i < regras.listaFuncionarios().size(); i++) {

			comboFuncionario.addItem((String) regras.listaFuncionarios().get(i).toString());
		}
	}

	public void preencherCampos(JComboBox<String> comboFuncionario) {

		try {

			String nome_funcionario = (String) comboFuncionario.getSelectedItem().toString();

			ModeloFuncionario funcionario = regras.consultaFuncionario(nome_funcionario);

			textNome.setText(funcionario.getNome());
			textLogin.setText(funcionario.getLogin());
			passwordSenha.setText(funcionario.getSenha());
			textEnquadramento_Funcional.setText(funcionario.getEnquadramento_funcional());

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	@SuppressWarnings("deprecation")
	public void lerCampos() {
		funcionario.setLogin(textLogin.getText());
		funcionario.setNome(textNome.getText());
		funcionario.setSenha(passwordSenha.getText());
		funcionario.setEnquadramento_funcional(textEnquadramento_Funcional.getText());
	}

	public void limparCampos(JComboBox<String> comboFuncionario) {

		comboFuncionario.removeAllItems();

		try {
			preencherCombo(comboFuncionario);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		textLogin.setText(null);
		textNome.setText(null);
		passwordSenha.setText(null);
		textEnquadramento_Funcional.setText(null);

	}

	public CadastroFuncionarios() {

		final JComboBox<String> comboFuncionario = new JComboBox<String>();
		comboFuncionario.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

				String nome_selecionado = (String) comboFuncionario.getSelectedItem().toString();

				if (nome_selecionado == "<NOVO FUNCIONARIO>") {
					limparCampos(comboFuncionario);
					comboFuncionario.setSelectedItem((String) "<NOVO FUNCIONARIO>");
				} else {
					preencherCampos(comboFuncionario);
				}
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

			}
		});

		try {
			regras.conecta();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		try {
			preencherCombo(comboFuncionario);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cadastre ao menos um funcionário!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Cadastro/Altera\u00E7\u00E3o/Exclus\u00E3o");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 280);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));

		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 12));

		textLogin = new JTextField();
		textLogin.setColumns(10);

		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 12));

		textEnquadramento_Funcional = new JTextField();
		textEnquadramento_Funcional.setColumns(10);

		lblEnquadramentoFuncional = new JLabel("Enquadramento Funcional");
		lblEnquadramentoFuncional.setFont(new Font("Arial", Font.BOLD, 12));

		passwordSenha = new JPasswordField();

		textNome = new JTextField();
		textNome.setColumns(10);

		JLabel lblFuncionario = new JLabel("Selecione o funcionário:");
		lblFuncionario.setFont(new Font("Arial", Font.BOLD, 12));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {

				try {
					regras.desconecta();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				lerCampos();

				try {
					regras.cadastraFuncionario(funcionario);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limparCampos(comboFuncionario);

			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				lerCampos();

				try {
					regras.atualizaFuncionario(funcionario);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limparCampos(comboFuncionario);

			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					lerCampos();
					regras.excluiFuncionario(funcionario.getLogin());
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limparCampos(comboFuncionario);

			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblFuncionario).addContainerGap(168, Short.MAX_VALUE))
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(259, Short.MAX_VALUE))
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(lblEnquadramentoFuncional, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(144, Short.MAX_VALUE))
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addGroup(
																groupLayout
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(
																				Alignment.LEADING,
																				groupLayout.createSequentialGroup().addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
																						.addGap(23).addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE).addGap(18)
																						.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
																		.addComponent(textEnquadramento_Funcional, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
																		.addGroup(
																				Alignment.LEADING,
																				groupLayout
																						.createSequentialGroup()
																						.addGroup(
																								groupLayout.createParallelGroup(Alignment.LEADING)
																										.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
																										.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
																						.addGap(18)
																						.addGroup(
																								groupLayout.createParallelGroup(Alignment.LEADING)
																										.addComponent(passwordSenha, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
																										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
																		.addGroup(
																				Alignment.LEADING,
																				groupLayout.createParallelGroup(Alignment.TRAILING, false)
																						.addComponent(comboFuncionario, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(textNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))).addGap(8)))));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblFuncionario)
								.addGap(4)
								.addComponent(comboFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(3)
								.addComponent(lblNome)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblLogin).addComponent(lblSenha))
								.addGap(5)
								.addGroup(
										groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(textLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(5)
								.addComponent(lblEnquadramentoFuncional)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textEnquadramento_Funcional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(
										groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
												.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE).addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
								.addGap(23)));
		getContentPane().setLayout(groupLayout);

	}
}