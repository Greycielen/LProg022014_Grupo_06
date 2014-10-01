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

import Modelos.ModeloVeiculo;
import Negocios.RegrasVeiculos;

@SuppressWarnings("serial")
public class CadastroVeiculos extends JFrame {

	ModeloVeiculo veiculo = new ModeloVeiculo();

	RegrasVeiculos regras = new RegrasVeiculos();

	private JPanel contentPane;
	private JTextField textModelo;
	private JTextField textProprietario;
	private JTextField textPlaca;
	private JTextField textAno;
	private JTextField textContato;
	private JTextField textCor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculos frame = new CadastroVeiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void preencherCombo(JComboBox<String> comboVeiculo) throws SQLException {

		comboVeiculo.addItem("<NOVO VEICULO>");

		for (int i = 0; i < regras.listaVeiculos().size(); i++) {

			comboVeiculo.addItem((String) regras.listaVeiculos().get(i).toString());
		}

	}

	public void preencheCampos(JComboBox<String> comboVeiculo) {

		String concatenado = (String) comboVeiculo.getSelectedItem();
		String placa = concatenado.substring(2, 9);

		try {

			ModeloVeiculo veiculo = new ModeloVeiculo();

			veiculo = regras.consultaVeiculo(placa);
			textPlaca.setText(veiculo.getPlaca());
			textModelo.setText(veiculo.getModelo());
			textCor.setText(veiculo.getCor());
			textAno.setText(veiculo.getAno());
			textProprietario.setText(veiculo.getProprietario());
			textContato.setText(veiculo.getContato());

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void lerCampos() {
		veiculo.setPlaca(textPlaca.getText());
		veiculo.setModelo(textModelo.getText());
		veiculo.setCor(textCor.getText());
		veiculo.setAno(textAno.getText());
		veiculo.setProprietario(textProprietario.getText());
		veiculo.setContato(textContato.getText());
	}

	public void limparCampos(JComboBox<String> comboVeiculo) {
		comboVeiculo.removeAllItems();
		try {
			preencherCombo(comboVeiculo);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		textPlaca.setText(null);
		textModelo.setText(null);
		textCor.setText(null);
		textAno.setText(null);
		textProprietario.setText(null);
		textContato.setText(null);
	}

	public CadastroVeiculos() {

		final JComboBox<String> comboVeiculo = new JComboBox<String>();
		comboVeiculo.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {

				String veiculo_selecionado = (String) comboVeiculo.getSelectedItem();

				if (veiculo_selecionado.equals("<NOVO VEICULO>")) {

					limparCampos(comboVeiculo);
					comboVeiculo.setSelectedItem((String) "<NOVO VEICULO>");

				} else {
					preencheCampos(comboVeiculo);
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
			preencherCombo(comboVeiculo);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cadastre ao menos um veiculo!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Cadastro/Altera\u00E7\u00E3o/Exclus\u00E3o");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 365);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textModelo = new JTextField();
		textModelo.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblProprietario = new JLabel("Nome do Propriet\u00E1rio");
		lblProprietario.setFont(new Font("Arial", Font.BOLD, 12));

		textProprietario = new JTextField();
		textProprietario.setColumns(10);

		textPlaca = new JTextField();
		textPlaca.setColumns(10);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Arial", Font.BOLD, 12));

		textAno = new JTextField();
		textAno.setColumns(10);

		textContato = new JTextField();
		textContato.setColumns(10);

		JLabel lblContato = new JLabel("Contato do Propriet\u00E1rio");
		lblContato.setFont(new Font("Arial", Font.BOLD, 12));

		textCor = new JTextField();
		textCor.setColumns(10);

		JLabel lblVeiculo = new JLabel("Selecione um veiculo:");
		lblVeiculo.setFont(new Font("Arial", Font.BOLD, 12));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {

				try {
					regras.desconecta();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				lerCampos();

				try {
					regras.cadastraVeiculo(veiculo);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limparCampos(comboVeiculo);

			}
		});

		JButton buttonAlterar = new JButton("Alterar");
		buttonAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lerCampos();

				try {
					regras.atualizaVeiculo(veiculo);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limparCampos(comboVeiculo);

			}
		});

		JButton buttonExcluir = new JButton("Excluir");
		buttonExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lerCampos();

				try {
					regras.excluiVeiculo(veiculo.getPlaca());
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				limparCampos(comboVeiculo);

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(91)
														.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addGap(48)
														.addComponent(textAno, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblProprietario, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContato, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(buttonCadastrar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE).addGap(6)
														.addComponent(buttonAlterar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(6)
														.addComponent(buttonExcluir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)).addComponent(lblVeiculo).addComponent(textContato)
										.addComponent(textProprietario).addComponent(textCor).addComponent(textModelo).addComponent(comboVeiculo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(15, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(5)
						.addComponent(lblVeiculo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGap(3)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addComponent(lblProprietario, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textProprietario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblContato, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(buttonCadastrar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonAlterar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonExcluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)).addContainerGap(12, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
