package projeto.sistema;

/**Classe que define os atributos de um curso.
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/
public class Curso {
	
	private String nome;
	private String modalidade;
	private String campus;
	private int semestres;
	private int vagas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public int getSemestres() {
		return semestres;
	}
	public void setSemestres(int semestres) {
		this.semestres = semestres;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
	/**
	 * Construtor vazio
	 */
	public Curso() { }
	
	/**
	 * Construtor definindo os atributos
	 * @param nome
	 * @param modalidade
	 * @param campus
	 * @param semestres
	 * @param vagas
	 */
	public Curso(String nome, String modalidade, String campus, int semestres, int vagas) {
		this.nome = nome;
		this.modalidade = modalidade;
		this.campus = campus;
		this.semestres = semestres;
		this.vagas = vagas;
	}
}
