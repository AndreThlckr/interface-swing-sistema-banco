import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JPanelContaPoupanca extends JPanelConta {
	private JTextField txtTaxaJuros;
	private JButton btnRender;

	public JPanelContaPoupanca() {
		super();

		JLabel labelTaxaJuros = new JLabel("TAXA DE JUROS:");
		labelTaxaJuros.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTaxaJuros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTaxaJuros.setBounds(161, 95, 150, 30);
		add(labelTaxaJuros);

		txtTaxaJuros = new JTextField();
		txtTaxaJuros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTaxaJuros.setHorizontalAlignment(SwingConstants.CENTER);
		txtTaxaJuros.setColumns(10);
		txtTaxaJuros.setBounds(321, 95, 78, 30);
		add(txtTaxaJuros);

		JLabel labelPorcentagem = new JLabel("%");
		labelPorcentagem.setVerticalAlignment(SwingConstants.TOP);
		labelPorcentagem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPorcentagem.setBounds(408, 94, 32, 40);
		add(labelPorcentagem);
		
		btnRender = new JButton("Render");
		btnRender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ContaPoupanca)conta).renderJuros();
			}
		});
		btnRender.setEnabled(false);
		btnRender.setBounds(321, 138, 78, 30);
		add(btnRender);
	}

	public JTextField getTxtTaxaJuros() {
		return this.txtTaxaJuros;
	}
	
	public JButton getBtnRender() {
		return this.btnRender;
	}
	
	public double getTaxaJuros() {
		try {
			return Double.parseDouble(txtTaxaJuros.getText());
		} catch (NumberFormatException entradaInvalida) {
			System.out.println("Entrada inválida!");
			return 0;
		}
	}

	public void setDadosConta(Conta c) {
		super.setDadosConta(c);
		this.txtTaxaJuros.setText(String.valueOf(((ContaPoupanca) c).getTaxaJuros() * 100));
	}
}
