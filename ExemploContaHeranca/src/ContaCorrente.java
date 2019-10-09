
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
		if (saque <= getSaldo()) {
			this.saldo -= saque;
			System.out.println("Saque de R$" + saque + " realizado com sucesso!");
			setExtrato("Saque", saque);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public double getSaldo() {
		return super.getSaldo() + getLimite();
	}
}
