import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JPanelContaPoupanca extends JPanelConta{
	private JTextField txtTaxaJuros;
	public JPanelContaPoupanca() {
		super();
		
		JLabel labelTaxaJuros = new JLabel("TAXA DE JUROS:");
		labelTaxaJuros.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTaxaJuros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTaxaJuros.setBounds(161, 95, 150, 30);
		add(labelTaxaJuros);
		
		txtTaxaJuros = new JTextField();
		txtTaxaJuros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTaxaJuros.setEnabled(false);
		txtTaxaJuros.setText("1");
		txtTaxaJuros.setHorizontalAlignment(SwingConstants.CENTER);
		txtTaxaJuros.setColumns(10);
		txtTaxaJuros.setBounds(321, 95, 78, 30);
		add(txtTaxaJuros);
		
		JLabel labelPorcentagem = new JLabel("%");
		labelPorcentagem.setVerticalAlignment(SwingConstants.TOP);
		labelPorcentagem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPorcentagem.setBounds(408, 94, 32, 40);
		add(labelPorcentagem);
	}
	
	public double getTaxaJuros() {
		return Double.parseDouble(txtTaxaJuros.getText());
	}
	
	public void setTxtTaxaJuros(double valor) {
		this.txtTaxaJuros.setText(String.valueOf(valor));
	}
	
	public void setTxtTaxaJurosStatus(boolean status) {
		this.txtTaxaJuros.setEnabled(status);
	}
}
