import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class TelaGerenciarContas extends JPanel {
	ButtonGroup bg;
	private JPanelContaCorrente contaCorrente;
	private JPanelContaPoupanca contaPoupanca;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnAdicionar;
	private JButton btnRemover;

	private int index;
	private Cliente titular;
	private Conta contaAtiva;
	private JRadioButton rdbtnContaCorrente;
	private JRadioButton rdbtnContaPoupanca;
	private JButton btnRetornar;

	public TelaGerenciarContas() {
		super();
		this.setLayout(null);
		this.setBounds(0, 0, 701, 491);

		rdbtnContaCorrente = new JRadioButton("Conta Corrente");
		rdbtnContaCorrente.setSelected(true);
		rdbtnContaCorrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnContaCorrente.isSelected()) {
					contaCorrente.setVisible(true);
					contaPoupanca.setVisible(false);
				} else {
					contaCorrente.setVisible(false);
					contaPoupanca.setVisible(true);
				}
			}
		});
		rdbtnContaCorrente.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnContaCorrente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnContaCorrente.setBounds(0, 7, 347, 23);
		this.add(rdbtnContaCorrente);

		rdbtnContaPoupanca = new JRadioButton("Conta Poupan\u00E7a");
		rdbtnContaPoupanca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				verificaTipoConta();
			}
		});
		rdbtnContaPoupanca.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnContaPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnContaPoupanca.setBounds(349, 7, 357, 23);
		this.add(rdbtnContaPoupanca);

		bg = new ButtonGroup();
		bg.add(rdbtnContaPoupanca);
		bg.add(rdbtnContaCorrente);

		contaPoupanca = new JPanelContaPoupanca();
		contaPoupanca.setBounds(103, 37, 500, 306);
		contaPoupanca.setVisible(false);
		contaPoupanca.getTxtTaxaJuros().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				atualizaBotoes();
			}
		});

		contaCorrente = new JPanelContaCorrente();
		contaCorrente.setBounds(103, 37, 500, 306);
		contaCorrente.getTxtLimite().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				atualizaBotoes();
			}
		});

		this.add(contaCorrente);
		this.add(contaPoupanca);

		btnAnterior = new JButton("<");
		btnAnterior.setEnabled(false);
		btnAnterior.setBounds(10, 433, 50, 50);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index--;
				atualizaCampos();
				atualizaBotoes();
			}
		});
		this.add(btnAnterior);

		btnProximo = new JButton(">");
		btnProximo.setEnabled(false);
		btnProximo.setBounds(641, 433, 50, 50);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				atualizaCampos();
				atualizaBotoes();
			}
		});
		this.add(btnProximo);

		btnAdicionar = new JButton("Adicionar conta");
		btnAdicionar.setForeground(new Color(0, 128, 0));
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdicionar.setEnabled(false);
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		btnAdicionar.setBounds(70, 433, 196, 50);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addConta();
				atualizaBotoes();
				atualizaCampos();
			}
		});
		this.add(btnAdicionar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titular.getContas().remove(index);
				if (index != 0) {
					index--;
					atualizaBotoes();
					atualizaCampos();
				} else {
					limpaCampos();
					atualizaBotoes();
					atualizaCampos();
				}
				atualizaBotoes();
			}
		});
		btnRemover.setForeground(new Color(165, 42, 42));
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemover.setEnabled(false);
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.setBounds(296, 433, 114, 50);
		this.add(btnRemover);

		btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBanco.alternarCadastro();
			}
		});
		btnRetornar.setForeground(Color.BLACK);
		btnRetornar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRetornar.setBackground(Color.LIGHT_GRAY);
		btnRetornar.setBounds(435, 433, 196, 50);
		add(btnRetornar);

	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	private void atualizaBotoes() {
		verificaTipoConta();

		btnAnterior.setEnabled(index >= 1);
		btnProximo.setEnabled(index < titular.getContas().size());

		if (rdbtnContaCorrente.isSelected() && contaCorrente.getLimite() > 0) {
			btnAdicionar.setEnabled(true);
		} else if (rdbtnContaPoupanca.isSelected() && contaPoupanca.getTaxaJuros() > 0) {
			btnAdicionar.setEnabled(true);
		} else {
			btnAdicionar.setEnabled(false);
		}

		btnRemover.setEnabled(titular.getContas().size() >= 1 && index != titular.getContas().size());
	}

	private void atualizaCampos() {
		verificaTipoConta();

		if (titular.getContas().size() >= 1 && index != titular.getContas().size()) {
			contaAtiva = titular.getContas().get(index);

			contaCorrente.setConta(contaAtiva);
			contaPoupanca.setConta(contaAtiva);

			contaCorrente.getLblTitulo().setText("CONTA N�" + (index + 1));
			contaPoupanca.getLblTitulo().setText("CONTA N�" + (index + 1));

			// preenche dados

			if (contaAtiva instanceof ContaCorrente) {
				rdbtnContaCorrente.setSelected(true);
				rdbtnContaPoupanca.setSelected(false);
				contaCorrente.setDadosConta(contaAtiva);
			} else {
				rdbtnContaCorrente.setSelected(false);
				rdbtnContaPoupanca.setSelected(true);
				contaPoupanca.setDadosConta(contaAtiva);
			}

		} else {
			limpaCampos();
		}

		// se for permitido editar os dados da conta, retorna true
		boolean isEditable = !(index < titular.getContas().size());

		rdbtnContaCorrente.setEnabled(isEditable);
		rdbtnContaPoupanca.setEnabled(isEditable);

		if (contaAtiva instanceof ContaCorrente) {
			contaCorrente.atualizaCampos(isEditable);
		} else {
			contaPoupanca.atualizaCampos(isEditable);
		}
	}

	private void limpaCampos() {
		contaCorrente.getLblTitulo().setText("CRIAR NOVA CONTA");
		contaPoupanca.getLblTitulo().setText("CRIAR NOVA CONTA");
		contaCorrente.getTxtLimite().setText("");

	}

	public void setCliente(Cliente cliente) {
		this.setTitular(cliente);
	}

	public void addConta() {
		Conta c;

		if (rdbtnContaCorrente.isSelected()) {
			c = new ContaCorrente(titular);
		} else {
			c = new ContaPoupanca(titular);
		}

		if (c instanceof ContaCorrente) {
			double limite = contaCorrente.getLimite();
			((ContaCorrente) c).setLimite(limite);

			this.titular.criarContaCorrente((ContaCorrente) c);
		}

		if (c instanceof ContaPoupanca) {
			double taxaJuros = contaPoupanca.getTaxaJuros();
			((ContaPoupanca) c).setTaxaJuros(taxaJuros);

			this.titular.criaContaPoupanca((ContaPoupanca) c);
		}

		index = titular.getContas().indexOf(c);
	}

	private void verificaTipoConta() {
		if (rdbtnContaCorrente.isSelected()) {
			contaCorrente.setVisible(true);
			contaPoupanca.setVisible(false);
		} else {
			contaCorrente.setVisible(false);
			contaPoupanca.setVisible(true);
		}
	}

}
