import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JPanelConta extends JPanel {
	private JTextField txtNumeroDaConta;
	private JTextField txtValor;
	private JLabel lblR;
	private JButton btnSacar;
	private JButton btnDepositar;
	private JLabel lblTitulo;
	
	private Cliente titular;
	private Conta conta;
	
	public JPanelConta() {
		super();
		this.setLayout(null);
		
		lblTitulo = new JLabel("DADOS DA CONTA:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 450, 25);
		this.add(lblTitulo);
		
		JLabel labelNumeroDaConta = new JLabel("Numero da conta:");
		labelNumeroDaConta.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNumeroDaConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNumeroDaConta.setBounds(0, 53, 150, 30);
		this.add(labelNumeroDaConta);
		
		txtNumeroDaConta = new JTextField();
		txtNumeroDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroDaConta.setText("0");
		txtNumeroDaConta.setEnabled(false);
		txtNumeroDaConta.setBounds(38, 87, 112, 20);
		this.add(txtNumeroDaConta);
		txtNumeroDaConta.setColumns(10);
		
		JLabel labelSaldo = new JLabel("SALDO:");
		labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSaldo.setBounds(160, 53, 150, 30);
		this.add(labelSaldo);
		
		lblR = new JLabel("R$0.00");
		lblR.setVerticalAlignment(SwingConstants.TOP);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblR.setBounds(320, 56, 180, 40);
		this.add(lblR);
		
		JLabel labelMovimentacao = new JLabel("MOVIMENTA\u00C7\u00C3O:");
		labelMovimentacao.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMovimentacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMovimentacao.setBounds(0, 130, 150, 30);
		this.add(labelMovimentacao);
		
		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setColumns(10);
		txtValor.setBounds(68, 156, 140, 30);
		this.add(txtValor);
		
		btnSacar = new JButton("Sacar");
		btnSacar.setBounds(218, 156, 89, 30);
		this.add(btnSacar);
		
		btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(317, 156, 89, 30);
		this.add(btnDepositar);
		
		JLabel labelReais = new JLabel("R$");
		labelReais.setHorizontalAlignment(SwingConstants.RIGHT);
		labelReais.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelReais.setBounds(10, 154, 53, 30);
		this.add(labelReais);
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Conta getConta() {
		return this.conta;
	}
	
	public void setLblTitulo(String titulo) {
		this.lblTitulo.setText(titulo);
	}
	
	
}