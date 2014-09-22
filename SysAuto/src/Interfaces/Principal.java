package Interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JMenuItem mntmProdutosEServicos = new JMenuItem("Produtos e Servi\u00E7os");
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

		mnCadastros.add(mntmFuncionarios);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);

		JMenuItem mntmHorasTrabalhadas = new JMenuItem("Horas Trabalhadas");
		mnRelatorios.add(mntmHorasTrabalhadas);

		JMenuItem mntmRelatorioDeSaida = new JMenuItem("Relat\u00F3rio de Sa\u00EDda do Ve\u00EDculo");
		mnRelatorios.add(mntmRelatorioDeSaida);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 252, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

}
