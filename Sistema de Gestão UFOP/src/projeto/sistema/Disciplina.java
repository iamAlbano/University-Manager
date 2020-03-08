package projeto.sistema;

/**Classe que define os atributos de uma disciplina.
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/
public class Disciplina {
	
	private String nome;
	private String departamento;
	private String turno; //Matutino, Vespertino ou Noturno
	private Professor professor;
	
	
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	/**
	 * Construtor vazio
	 */
	public Disciplina() { }
	
	/**
	 * Construtor definindo os atributos
	 * @param nome
	 * @param sala
	 * @param departamento
	 */
	public Disciplina(String nome, String sala, String departamento) {
		this.nome = nome;
		this.departamento = departamento;
	}

}
