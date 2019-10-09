import java.util.ArrayList;

public class Cliente extends Pessoa {
	
	//testando se o git salva
	private ArrayList<Conta> contas;
	
	public Cliente() {
		contas = new ArrayList<Conta>();
	}
	
	public void criaContaPoupanca(ContaPoupanca p) {
		contas.add(p);
	}
	public void criaContaPoupanca(double saldo, float txJuros) {
		ContaPoupanca p = new ContaPoupanca(this);
		p.depositar(saldo);
		p.setTaxaJuros(txJuros);
		
		contas.add(p);
	}
	public void criarContaCorrente(ContaCorrente c) {
		contas.add(c);
	}
	
	public void criarContaCorrente(double saldo, double limite) {
		ContaCorrente c = new ContaCorrente(this);
		c.setLimite(limite);
		c.depositar(saldo);
		contas.add(c);
	}
	
	public ArrayList<Conta> getContas() {
		return this.contas;
	}
}
