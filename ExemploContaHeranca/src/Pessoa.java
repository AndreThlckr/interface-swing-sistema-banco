import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Pessoa {
	private String nome;
	private String cpf;
	private char sexo;
	private LocalDate dataDeNascimento;

	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void setNome(String nome) {
		nome = nome.trim();
		if (nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido!");
		}
	}

	public void setCpf(String cpf) {
		cpf = cpf.trim();
		if (isCpfValido(cpf)) {
			this.cpf = cpf;
		} else {
			System.out.println("CPF inválido!");
		}
	}

	public static boolean isCpfValido(String cpf) {
		cpf = cpf.trim();
		if (cpf.length() == 14) {
			return true;
		} else {
			return false;
		}
	}

	public void setSexo(char sexo) {
		if (sexo == 'm' || sexo == 'f') {
			this.sexo = sexo;
		} else {
			System.out.println("Sexo inválido!");
		}
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		if (!dataDeNascimento.isEmpty()) {
			this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formato);
		} else {
			System.out.println("Data inválida!");
		}
	}

	public static boolean isDataValida(String data) {
		try {
			LocalDate ld = LocalDate.parse(data, formato);
			String result = ld.format(formato);
			return result.equals(data);
		} catch (DateTimeParseException exp) {
		}

		return false;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getSexo() {
		if (sexo == 'm' || sexo == 'M') {
			return "MASCULINO";
		} else if (sexo == 'f' || sexo != 'F') {
			return "FEMININO";
		} else {
			return "INDEFINIDO";
		}
	}

	public LocalDate getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	public String getDataDeNascimentoFormatada() {
		if (dataDeNascimento != null) {
			return formato.format(this.dataDeNascimento);
		} else {
			return "";
		}

	}

	public int getIdade() {
		return Period.between(this.dataDeNascimento, LocalDate.now()).getYears();
	}

	public String toString() {
		String s = "";
		s += "Nome: " + getNome();
		s += "\nCPF: " + getCpf();
		s += "\nSexo: " + getSexo();
		s += "\nData de nascimento: " + getDataDeNascimentoFormatada();

		return s;
	}

}
