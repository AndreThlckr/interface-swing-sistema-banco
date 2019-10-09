import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		txtLimite.setText("");
		txtLimite.setHorizontalAlignment(SwingConstants.CENTER);
		txtLimite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLimite.setColumns(10);
		txtLimite.setBounds(329, 95, 78, 30);
		add(txtLimite);
	}

	public JTextField getTxtLimite() {
		return this.txtLimite;
	}

	public double getLimite() {
		try {
			return Double.parseDouble(txtLimite.getText());
		} catch (NumberFormatException entradaInvalida) {
			System.out.println("Entrada inválida!");
			return 0;
		}
	}

	public void setDadosConta(Conta c) {
		super.setDadosConta(c);
		this.txtLimite.setText(String.valueOf(((ContaCorrente) c).getLimite()));
	}
}
