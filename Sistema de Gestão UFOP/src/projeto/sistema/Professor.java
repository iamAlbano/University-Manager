package projeto.sistema;

/**Classe que define os atributos de um professor, subclasse de Pessoa
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/

public class Professor extends Pessoa{
	
	private double salario;
	private String escolaridade;
	
	/**
	 * Método que retorna o salário do Professor
	 * @return double - salário
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Método que atribui salário ao Professor
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * Método que retorna a escolaridade do Professor
	 * @return String - escolaridade
	 */
	public String getEscolaridade() {
		return escolaridade;
	}

	/**
	 * Método que atribui escolaridade ao Professor
	 * @param escolaridade
	 */
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	/**
	 * Construtor vazio
	 */
	public Professor() { }
	
	/**
	 * Construtor definindo atributos
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param sexo
	 * @param salario
	 * @param escolaridade
	 */
	public Professor(String nome, String cpf, String rg, String sexo, double salario, String escolaridade) {
		super(nome, cpf, rg, sexo);
		this.salario = salario;
		this.escolaridade = escolaridade;
	}

}
