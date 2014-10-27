package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Administrativo extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrativo frame = new Administrativo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Administrativo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmVeiculos = new JMenuItem("Ve\u00EDculos");
		mntmVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroVeiculos veiculosgui = new CadastroVeiculos();
				veiculosgui.setVisible(true);
			}
		});
		mnCadastros.add(mntmVeiculos);

		JMenuItem mntmProdutosEServicos = new JMenuItem(
				"Produtos e Servi\u00E7os");
		mntmProdutosEServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroProdutos produtosgui = new CadastroProdutos();
				produtosgui.setVisible(true);
			}
		});
		mnCadastros.add(mntmProdutosEServicos);

		JMenuItem mntmFuncionarios = new JMenuItem("Funcion\u00E1rios");
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroFuncionarios funcionariosgui = new CadastroFuncionarios();
				funcionariosgui.setVisible(true);
			}
		});

		setTitle("SysAuto - Administrativo");
		setResizable(false);

		mnCadastros.add(mntmFuncionarios);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);

		JMenuItem mntmHorasTrabalhadas = new JMenuItem("Horas Trabalhadas");
		mntmHorasTrabalhadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		mnRelatorios.add(mntmHorasTrabalhadas);

		JMenuItem mntmRelatorioDeSaida = new JMenuItem(
				"Relat\u00F3rio de Sa\u00EDda do Ve\u00EDculo");
		mntmRelatorioDeSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		mnRelatorios.add(mntmRelatorioDeSaida);

		JMenu mnFerramentas = new JMenu("Ferramentas");
		menuBar.add(mnFerramentas);

		JMenuItem mntmConfigurarServidor = new JMenuItem("Configurar Servidor");
		mntmConfigurarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO
			}
		});
		mnFerramentas.add(mntmConfigurarServidor);

		JMenu mnBackup = new JMenu("Backup");
		mnFerramentas.add(mnBackup);

		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		mnBackup.add(mntmCriar);

		JMenuItem mntmRestaurar = new JMenuItem("Restaurar");
		mntmRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		mnBackup.add(mntmRestaurar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblImagem = new JLabel("");
		lblImagem
				.setIcon(new ImageIcon(
						"C:\\Users\\Guilherme\\Projetos\\SysAuto\\SysAuto\\src\\Persistencia\\Arquivos\\Sysauto.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addGap(91)
						.addComponent(lblImagem)
						.addContainerGap(103, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(lblImagem)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
