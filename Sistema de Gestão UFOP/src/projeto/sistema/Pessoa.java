package projeto.sistema;

/**SuperClasse que define os atributos de uma Pessoa.
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/

public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
		
	/** M�todo para retorno do nome
	 * @return String - Nome da Pessoa*/
	public String getNome() {
		return nome;
	}

	/** M�todo para atribuir nome
	 * @param nome - nome da Pessoa*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/** M�todo para retorno do nome
	 * @return String - CPF da Pessoa*/
	public String getCpf() {
		return cpf;
	}

	/** M�todo para atribuir cpf
	 * @param nome - cpf da Pessoa*/
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	/** M�todo para retorno do rg
	 * @return String - rg da Pessoa*/
	public String getRg() {
		return rg;
	}

	
	/** M�todo para atribuir rg
	 * @param rg - rg da Pessoa*/
	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	
	/** M�todo para atribuir sexo
	 * @param sexo - sexo da Pessoa*/
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**Construtor vazio*/
	public Pessoa() { }
	
	/**
	 * Construtor definindo os atributos
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param sexo
	 */
	
	public Pessoa(String nome, String cpf, String rg, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
	}

}
