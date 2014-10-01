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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import Modelos.ModeloProduto;
import Negocios.RegrasProdutos;

@SuppressWarnings("serial")
public class CadastroProdutos extends JFrame {

	ModeloProduto produto = new ModeloProduto();

	RegrasProdutos regras = new RegrasProdutos();

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textValor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void preencherCombo(JComboBox<String> comboProduto) throws SQLException {

		comboProduto.addItem("<NOVO PRODUTO>");

		for (int i = 0; i < regras.listaProdutos().size(); i++) {

			comboProduto.addItem((String) regras.listaProdutos().get(i).toString());
		}

	}

	public void preencheCampos(JComboBox<String> comboProduto, JComboBox<String> comboEnquadramento) {

		String concatenado = (String) comboProduto.getSelectedItem();
		String desconcatenado = concatenado.substring(1, 5);

		JOptionPane.showMessageDialog(null, desconcatenado);

		try {

			ModeloProduto produto = regras.consultaProduto(desconcatenado);
			textCodigo.setText(produto.getCodigo());
			textNome.setText(produto.getNome());
			comboEnquadramento.setSelectedItem(produto.getEnquadramento());
			textValor.setText("R$: " + produto.getValor());

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void lerCampos(JComboBox<String> comboEnquadramento) {

		produto.setCodigo(textCodigo.getText());
		produto.setNome(textNome.getText());
		produto.setEnquadramento(comboEnquadramento.getSelectedItem().toString());
		produto.setValor(textValor.getText());

	}

	public void limpaCampos(JComboBox<String> comboProduto, JComboBox<String> comboEnquadramento) {
		comboProduto.removeAllItems();
		try {
			preencherCombo(comboProduto);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		comboEnquadramento.setSelectedItem(null);
		textCodigo.setText(null);
		textNome.setText(null);
		textValor.setText(null);
	}

	public CadastroProdutos() {

		final JComboBox<String> comboEnquadramento = new JComboBox<String>();
		comboEnquadramento.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				lerCampos(comboEnquadramento);
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});

		final JComboBox<String> comboProduto = new JComboBox<String>();
		comboProduto.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {

				String produto_selecionado = (String) comboProduto.getSelectedItem().toString();

				if (produto_selecionado.equals("<NOVO PRODUTO>")) {

					limpaCampos(comboProduto, comboEnquadramento);
					comboProduto.setSelectedItem((String) "<NOVO PRODUTO>");

				} else {
					preencheCampos(comboProduto, comboEnquadramento);
				}

			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});

		try {
			regras.conecta();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		try {
			preencherCombo(comboProduto);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cadastre ao menos um produto!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Cadastro/Alteração/Exclusão");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 290, 230);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblProduto = new JLabel("Selecione o Produto ou Servi\u00E7o:");
		lblProduto.setFont(new Font("Arial", Font.BOLD, 12));

		textCodigo = new JTextField();
		textCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));

		textNome = new JTextField();
		textNome.setColumns(10);

		comboEnquadramento.addItem("Produto");
		comboEnquadramento.addItem("Serviço");

		JLabel lblEnquadramento = new JLabel("Enquadramento");
		lblEnquadramento.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Arial", Font.BOLD, 12));

		textValor = new JTextField();
		textValor.setColumns(10);

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

				lerCampos(comboEnquadramento);

				try {
					regras.cadastraProduto(produto);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limpaCampos(comboProduto, comboEnquadramento);

			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lerCampos(comboEnquadramento);

				try {
					regras.atualizaProduto(produto);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limpaCampos(comboProduto, comboEnquadramento);

			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lerCampos(comboProduto);

				try {
					regras.excluiProduto(produto.getCodigo());
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limpaCampos(comboProduto, comboEnquadramento);

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addComponent(lblCodigo))
														.addGap(18)
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNome).addGap(145))
																		.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING, false).addComponent(lblEnquadramento)
																		.addComponent(comboEnquadramento, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)).addGap(18)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(textValor).addComponent(lblValor)))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblProduto).addComponent(comboProduto, 0, 256, Short.MAX_VALUE)).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(lblProduto)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(7)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCodigo).addComponent(lblNome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEnquadramento).addComponent(lblValor))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboEnquadramento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}