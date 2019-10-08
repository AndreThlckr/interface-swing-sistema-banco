import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JPanelContaCorrente extends JPanelConta {
	private JTextField txtLimite;

	public JPanelContaCorrente() {
		super();

		JLabel labelLimite = new JLabel("LIMITE:");
		labelLimite.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLimite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLimite.setBounds(149, 95, 150, 30);
		add(labelLimite);

		JLabel labelRS = new JLabel("R$");
		labelRS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelRS.setBounds(309, 95, 26, 30);
		add(labelRS);

		txtLimite = new JTextField();
		txtLimite.setText("10000.00");
		txtLimite.setHorizontalAlignment(SwingConstants.CENTER);
		txtLimite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLimite.setColumns(10);
		txtLimite.setBounds(329, 95, 78, 30);
		add(txtLimite);
	}
	
	public double getLimite() {
		return Double.parseDouble(txtLimite.getText());
	}

	public void setTxtLimite(double valor) {
		this.txtLimite.setText(String.valueOf(valor));
	}
	
	public void setTxtLimiteStatus(boolean status) {
		this.txtLimite.setEnabled(status);
	}
}
