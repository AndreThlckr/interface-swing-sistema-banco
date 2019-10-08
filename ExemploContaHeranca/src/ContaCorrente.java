
public class ContaCorrente extends Conta {

	private double limite;
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void sacar(double saque) {
		if(getSaldo() >= saque && saque <= getLimite()) {
			super.sacar(saque);
		}
	}
	
	public double getSaldo() {
		return super.getSaldo() + getLimite();
	}
}
