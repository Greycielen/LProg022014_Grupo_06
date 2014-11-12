package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SelecaoVeiculo extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					SelecaoVeiculo frame = new SelecaoVeiculo();
					frame.setVisible(true);

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

				}

			}

		});

	}

	public SelecaoVeiculo() {
		setResizable(false);

		setTitle("Sele\u00E7\u00E3o de Ve\u00EDculo");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblInstrucao = new JLabel("Selecione o ve\u00EDculo em que deseja trabalhar:");
		lblInstrucao.setFont(new Font("Arial", Font.BOLD, 12));

		final JComboBox<String> comboBox = new JComboBox<String>();

		JButton btnConfirma = new JButton("Confirmar");
		btnConfirma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// TODO

				setVisible(false);

			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblInstrucao).addContainerGap())
				.addComponent(comboBox, 0, 279, Short.MAX_VALUE)
				.addGroup(
						Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(94, Short.MAX_VALUE)
								.addComponent(btnConfirma, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(85)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addGap(6).addComponent(lblInstrucao).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnConfirma, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

}