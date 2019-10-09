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
	private static JPanel panelCadastroCliente;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtData;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private ButtonGroup bg;
	private JLabel lblIndex;
	private JButton btnAdicionar;
	private JButton btnRemover;
	private JButton btnProximo;
	private JButton btnAnterior;
	private JLabel labelFormatoData;

	private int index;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente clienteLogado;
	private static JPanel panel;
	private static TelaGerenciarContas panelCadastroContas;
	private JButton btnGerenciarContas;

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
		
		bg = new ButtonGroup();

		panel = new JPanel();
		panel.setBounds(0, 0, 706, 519);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panelCadastroCliente = new JPanel();
		panelCadastroCliente.setBounds(0, 0, 706, 519);
		panelCadastroCliente.setLayout(null);
		panel.add(panelCadastroCliente);
		

		JLabel labelCliente = new JLabel("CLIENTE");
		labelCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCliente.setFont(new Font("Calibri", Font.PLAIN, 26));
		labelCliente.setBounds(212, 12, 138, 43);
		panelCadastroCliente.add(labelCliente);

		lblIndex = new JLabel("(NOVO)");
		lblIndex.setHorizontalAlignment(SwingConstants.LEFT);
		lblIndex.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblIndex.setBounds(363, 12, 138, 43);
		panelCadastroCliente.add(lblIndex);

		btnAnterior = new JButton("<");
		btnAnterior.setEnabled(false);
		btnAnterior.setBounds(10, 11, 50, 50);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index--;
				atualizaBotoes();
				atualizaCampos();
			}
		});
		panelCadastroCliente.add(btnAnterior);

		btnProximo = new JButton(">");
		btnProximo.setEnabled(false);
		btnProximo.setBounds(646, 11, 50, 50);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				atualizaBotoes();
				atualizaCampos();
			}
		});
		panelCadastroCliente.add(btnProximo);

		JLabel labelNome = new JLabel("Nome:*");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(new Font("Calibri", Font.BOLD, 18));
		labelNome.setBounds(73, 114, 88, 21);
		panelCadastroCliente.add(labelNome);

		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		labelCpf.setBounds(73, 149, 88, 21);
		panelCadastroCliente.add(labelCpf);

		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSexo.setFont(new Font("Calibri", Font.PLAIN, 18));
		labelSexo.setBounds(73, 190, 88, 21);
		panelCadastroCliente.add(labelSexo);

		JLabel labelDataDeNascimento = new JLabel("Data de nascimento:");
		labelDataDeNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDataDeNascimento.setFont(new Font("Calibri", Font.PLAIN, 18));
		labelDataDeNascimento.setBounds(10, 222, 151, 21);
		panelCadastroCliente.add(labelDataDeNascimento);

		labelFormatoData = new JLabel("(dd/MM/AAAA)");
		labelFormatoData.setHorizontalAlignment(SwingConstants.CENTER);
		labelFormatoData.setBounds(171, 250, 132, 14);
		panelCadastroCliente.add(labelFormatoData);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(171, 113, 470, 25);
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				atualizaBotoes();
			}
		});
		panelCadastroCliente.add(txtNome);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCpf.setColumns(10);
		txtCpf.setBounds(171, 149, 132, 25);
		panelCadastroCliente.add(txtCpf);

		rdbtnMasculino = new JRadioButton("M");
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.setActionCommand("m");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMasculino.setBounds(167, 190, 48, 23);
		panelCadastroCliente.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("F");
		rdbtnFeminino.setActionCommand("f");
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFeminino.setBounds(212, 189, 48, 23);
		panelCadastroCliente.add(rdbtnFeminino);
		
		bg.add(rdbtnMasculino);
		bg.add(rdbtnFeminino);

		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtData.setColumns(10);
		txtData.setBounds(171, 221, 132, 25);
		panelCadastroCliente.add(txtData);

		btnAdicionar = new JButton("Adicionar cliente");
		btnAdicionar.setForeground(new Color(0, 128, 0));
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdicionar.setEnabled(false);
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		btnAdicionar.setBounds(500, 458, 196, 50);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				addCliente(c);
				index = clientes.indexOf(c);
				atualizaBotoes();
				atualizaCampos();
			}
		});
		panelCadastroCliente.add(btnAdicionar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes.remove(index);
				if (index != 0) {
					index--;
					atualizaCampos();
				} else {
					limpaCampos();
					atualizaCampos();
				}
				atualizaBotoes();
			}
		});
		btnRemover.setForeground(new Color(165, 42, 42));
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemover.setEnabled(false);
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.setBounds(363, 458, 114, 50);
		panelCadastroCliente.add(btnRemover);

		btnGerenciarContas = new JButton("Gerenciar contas");
		btnGerenciarContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCadastroContas.setCliente(clienteLogado);
				alternarCadastro();
			}
		});
		btnGerenciarContas.setEnabled(false);
		btnGerenciarContas.setForeground(Color.BLACK);
		btnGerenciarContas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerenciarContas.setBackground(Color.LIGHT_GRAY);
		btnGerenciarContas.setBounds(445, 193, 196, 50);
		panelCadastroCliente.add(btnGerenciarContas);

		bg = new ButtonGroup();

		panelCadastroContas = new TelaGerenciarContas();
		panelCadastroContas.setBounds(0, 0, 701, 491);
		panelCadastroContas.setLayout(null);
	}

	private void atualizaBotoes() {
		btnAnterior.setEnabled(index >= 1);
		btnProximo.setEnabled(index < clientes.size());

		String nome = txtNome.getText();
		btnAdicionar.setEnabled(nome.length() > 3);

		btnRemover.setEnabled(clientes.size() >= 1 && index != clientes.size());
		btnGerenciarContas.setEnabled(clientes.size() >= 1 && index != clientes.size());
	}

	private void atualizaCampos() {
		lblIndex.setText(String.valueOf(index));

		if (clientes.size() >= 1 && index != clientes.size()) {
			clienteLogado = clientes.get(index);
			txtNome.setText(clienteLogado.getNome());
			txtCpf.setText(clienteLogado.getCpf());

			if (clienteLogado.getSexo().equalsIgnoreCase("MASCULINO")) {
				rdbtnMasculino.setSelected(true);
				rdbtnFeminino.setSelected(false);
			} else {
				rdbtnFeminino.setSelected(true);
				rdbtnMasculino.setSelected(false);
			}

			txtData.setText(clienteLogado.getDataDeNascimentoFormatada());
		} else {
			limpaCampos();
		}

		if (index < clientes.size()) {
			txtNome.setEnabled(false);
			txtCpf.setEnabled(false);
			rdbtnMasculino.setEnabled(false);
			rdbtnFeminino.setEnabled(false);
			txtData.setEnabled(false);
		} else {
			txtNome.setEnabled(true);
			txtCpf.setEnabled(true);
			rdbtnMasculino.setEnabled(true);
			rdbtnFeminino.setEnabled(true);
			txtData.setEnabled(true);
		}
	}

	private void limpaCampos() {
		lblIndex.setText("(NOVO)");
		txtNome.setText("");
		txtCpf.setText("");
		rdbtnMasculino.setSelected(true);
		rdbtnFeminino.setSelected(false);
		txtData.setText("");
	}

	public static void alternarCadastro() {
		if(panelCadastroCliente.isVisible()) {
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

	private void addCliente(Cliente c) {
		c.setNome(txtNome.getText());

		String cpf = txtCpf.getText();
		if (!cpf.equals("") && Cliente.isCpfValido(cpf)) {
			c.setCpf(cpf);
		}

		char sexo = bg.getSelection().getActionCommand().charAt(0);
		System.out.println(sexo);
		c.setSexo(sexo);

		String dataDeNascimento = txtData.getText();
		if (!dataDeNascimento.isEmpty() && Cliente.isDataValida(dataDeNascimento)) {
			c.setDataDeNascimento(dataDeNascimento);
		}

		clientes.add(c);
	}
}
