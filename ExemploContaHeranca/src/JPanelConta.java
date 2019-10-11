import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JPanelConta extends JPanel {
	private JTextField txtNumeroDaConta;
	private JTextField txtMovimentacao;
	private JLabel lblSaldo;
	private JButton btnSacar;
	private JButton btnDepositar;
	private JLabel lblTitulo;

	protected Conta conta;

	public JPanelConta() {
		super();
		this.setLayout(null);

		lblTitulo = new JLabel("DADOS DA CONTA:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 450, 25);
		this.add(lblTitulo);

		JLabel labelCodigoDaConta = new JLabel("C\u00F3digo da conta:");
		labelCodigoDaConta.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCodigoDaConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCodigoDaConta.setBounds(0, 53, 150, 30);
		this.add(labelCodigoDaConta);

		txtNumeroDaConta = new JTextField();
		txtNumeroDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroDaConta.setEnabled(false);
		txtNumeroDaConta.setBounds(44, 87, 106, 20);
		this.add(txtNumeroDaConta);
		txtNumeroDaConta.setColumns(10);

		JLabel labelSaldo = new JLabel("SALDO:");
		labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSaldo.setBounds(160, 53, 150, 30);
		this.add(labelSaldo);

		lblSaldo = new JLabel("R$0.00");
		lblSaldo.setVerticalAlignment(SwingConstants.TOP);
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSaldo.setBounds(320, 56, 130, 40);
		this.add(lblSaldo);

		JLabel labelMovimentacao = new JLabel("MOVIMENTA\u00C7\u00C3O:");
		labelMovimentacao.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMovimentacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMovimentacao.setBounds(0, 178, 150, 30);
		this.add(labelMovimentacao);

		txtMovimentacao = new JTextField();
		txtMovimentacao.setEnabled(false);
		txtMovimentacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovimentacao.setColumns(10);
		txtMovimentacao.setBounds(68, 204, 140, 30);
		this.add(txtMovimentacao);

		btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarSaque();
				setDadosConta(getConta());
			}
		});
		btnSacar.setEnabled(false);
		btnSacar.setBounds(218, 204, 89, 30);
		this.add(btnSacar);

		btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarDeposito();
				setDadosConta(getConta());
			}
		});
		btnDepositar.setEnabled(false);
		btnDepositar.setBounds(317, 204, 89, 30);
		this.add(btnDepositar);

		JLabel labelReais = new JLabel("R$");
		labelReais.setHorizontalAlignment(SwingConstants.RIGHT);
		labelReais.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelReais.setBounds(10, 202, 53, 30);
		this.add(labelReais);
	}

	public JLabel getLblTitulo() {
		return this.lblTitulo;
	}

	public JLabel getLblSaldo() {
		return this.lblSaldo;
	}

	public JTextField getTxtMovimentacao() {
		return this.txtMovimentacao;
	}

	public JButton getBtnSacar() {
		return this.btnSacar;
	}

	public JButton getBtnDepositar() {
		return this.btnDepositar;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setDadosConta(Conta c) {
		txtNumeroDaConta.setText(String.valueOf(c.getCodigo()));
		lblSaldo.setText("R$" + c.getSaldo());
		txtMovimentacao.setText("");
	}

	public void atualizaCampos(boolean isEditable) {
		if (this instanceof JPanelContaCorrente) {
			((JPanelContaCorrente) this).getTxtLimite().setEnabled(!isEditable);
		} else if (this instanceof JPanelContaPoupanca) {
			((JPanelContaPoupanca) this).getTxtTaxaJuros().setEnabled(!isEditable);
			((JPanelContaPoupanca) this).getBtnRender().setEnabled(isEditable);
		}
		btnSacar.setEnabled(isEditable);
		btnDepositar.setEnabled(isEditable);
		txtMovimentacao.setEnabled(isEditable);
	}

	public void realizarSaque() {
		double saque = Double.parseDouble(txtMovimentacao.getText());
		this.conta.sacar(saque);
	}
	
	public void realizarDeposito() {
		double deposito = Double.parseDouble(txtMovimentacao.getText());
		this.conta.depositar(deposito);
	}

}