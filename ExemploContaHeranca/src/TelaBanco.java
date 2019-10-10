import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
				panelCadastroContas.setTitular(clienteLogado);
				alternarCadastro();
				panelCadastroContas.atualizaCampos();
				panelCadastroContas.atualizaBotoes();
			}
		});
		btnGerenciarContas.setEnabled(false);
		btnGerenciarContas.setForeground(Color.BLACK);
		btnGerenciarContas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerenciarContas.setBackground(Color.LIGHT_GRAY);
		btnGerenciarContas.setBounds(445, 193, 196, 50);
		panelCadastroCliente.add(btnGerenciarContas);

		panelCadastroContas = new TelaGerenciarContas();
		panelCadastroContas.setBounds(0, 0, 701, 491);
		panelCadastroContas.setLayout(null);
		panelCadastroContas.getBtnRetornar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alternarCadastro();
				index = clientes.indexOf(panelCadastroContas.getTitular());
				panelCadastroClientes.atualizaCampos();
				panelCadastroClientes.atualizaBotoes();
			}
		});
	}

	public void alternarCadastro() {
		if (panelCadastroCliente.isVisible()) {
			panelCadastroContas.setVisible(true);
			panelCadastroCliente.setVisible(false);
			panel.add(panelCadastroContas);
			panel.remove(panelCadastroCliente);
		} else {
			panelCadastroContas.setVisible(false);
			panelCadastroCliente.setVisible(true);
			panel.remove(panelCadastroContas);
			panel.add(panelCadastroCliente);
		}
	}
}
