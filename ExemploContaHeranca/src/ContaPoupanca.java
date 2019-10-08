
public class ContaPoupanca extends Conta {

	private double taxaJuros = 0.01f;
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public void renderJuros() {
		depositar(getSaldo() + (getSaldo() * getTaxaJuros()));
	}

}
