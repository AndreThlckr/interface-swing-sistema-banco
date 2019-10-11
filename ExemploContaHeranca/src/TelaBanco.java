import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaBanco {

	private JFrame frame;
	private JPanel panel;
	private TelaGerenciarClientes panelCadastroClientes;
	private TelaGerenciarContas panelCadastroContas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBanco window = new TelaBanco();
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
	public TelaBanco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 706, 519);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panelCadastroClientes = new TelaGerenciarClientes();
		panelCadastroClientes.setBounds(0, 0, 706, 519);
		panelCadastroClientes.setLayout(null);
		panel.add(panelCadastroClientes);

		panelCadastroClientes.getBtnGerenciarContas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCadastroContas.setTitular(panelCadastroClientes.getClienteLogado());
				alternarCadastro();
				panelCadastroContas.atualizaCampos();
				panelCadastroContas.atualizaBotoes();
			}
		});

		panelCadastroContas = new TelaGerenciarContas();
		panelCadastroContas.setBounds(0, 0, 701, 491);
		panelCadastroContas.setLayout(null);
		panelCadastroContas.getBtnRetornar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alternarCadastro();
				panelCadastroClientes.setIndex(panelCadastroContas.getTitular());
				panelCadastroClientes.atualizaCampos();
				panelCadastroClientes.atualizaBotoes();
			}
		});
	}

	public void alternarCadastro() {
		if (panelCadastroClientes.isVisible()) {
			panelCadastroContas.setVisible(true);
			panelCadastroClientes.setVisible(false);
			panel.add(panelCadastroContas);
			panel.remove(panelCadastroClientes);
		} else {
			panelCadastroContas.setVisible(false);
			panelCadastroClientes.setVisible(true);
			panel.remove(panelCadastroContas);
			panel.add(panelCadastroClientes);
		}
	}
}
