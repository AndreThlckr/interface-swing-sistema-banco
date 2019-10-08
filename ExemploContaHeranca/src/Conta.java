import java.util.ArrayList;

public class Conta {
	private static int autoIncremento = 0;
	
	private int codigo;
	private Cliente titular;
	private double saldo = 0;
	private ArrayList<String> extrato = new ArrayList<String>();
	private String senha;
	
	public Conta(Cliente cliente) {
		autoIncremento++;
		this.codigo = autoIncremento;
		this.titular = new Cliente();
		titular = cliente;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setExtrato(String operacao, double valor) {
		this.extrato.add(operacao + " de R$" + valor);
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public String getExtrato() {
		String s = "";
		for(int i = 0; i < this.extrato.size(); i++) {
			s += "\n" + this.extrato.get(i);
		}
		return s;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificarSenha(String senha) {
		if (this.senha.equals(senha)) {
			return true;
		} else {
			return false;
		}
	}

	public void depositar(double deposito) {
		if (deposito > 0) {
			this.saldo += deposito;
			System.out.println("Depósito de R$" + deposito + " realizado com sucesso!");
			setExtrato("Depósito", deposito);
		} else {
			System.out.println("Valor de depósito inválido!");
		}

	}

	public void sacar(double saque) {
		if (saque <= this.saldo) {
			this.saldo -= saque;
			System.out.println("Saque de R$" + saque + " realizado com sucesso!");
			setExtrato("Saque", saque);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public boolean isPossivelSacar(float saque) {
		if (saque <= this.saldo) {
			return true;
		} else {
			return false;
		}
	}

}
