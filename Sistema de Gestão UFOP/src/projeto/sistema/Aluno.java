package projeto.sistema;

import java.util.ArrayList;

/**Classe que define os atributos de um aluno, subclasse de Pessoa.
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/

public class Aluno extends Pessoa{
	
	private String matricula;
	private String curso;
	private int ano;
	private int semestre; /* 1 ou 2*/
	private ArrayList<Boletim> Historico_Escolar = new ArrayList<Boletim>();
	
	/**
	 * Método que retorna o histórico escolar do aluno
	 * @return
	 */
	public ArrayList<Boletim> getHistorico() {
		return Historico_Escolar;
	}
	
	/**
	 * Método que retorna um boletim dentro do Histórico do aluno
	 * @param n - posição do boletim dentro do array
	 * @return Boletim
	 */
	public Boletim getBoletim(int n) {
		return Historico_Escolar.get(n);
	}

	/**
	 * Cria um novo boletim no histórico do aluno
	 * @param materia - A matéria correspondente ao boletim
	 */
	public void Novo_Boletim(Disciplina materia) {
		Historico_Escolar.add(new Boletim());
		Historico_Escolar.get(Historico_Escolar.size() -1).setMateria(materia.getNome());
		Historico_Escolar.get(Historico_Escolar.size() -1).setFaltas(0);
		Historico_Escolar.get(Historico_Escolar.size() -1).setNota1(0);
		Historico_Escolar.get(Historico_Escolar.size() -1).setNota2(0);
		Historico_Escolar.get(Historico_Escolar.size() -1).setNota3(0);
		Historico_Escolar.get(Historico_Escolar.size() -1).setNota4(0);
	}

	
	/**
	 * Método para obter o nome do curso do aluno
	 * @return String - curso do aluno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Método para atribuir um curso ao aluno
	 * @param curso
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Método para retornar a matrícula do aluno
	 * @return String - matrícula
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Método para atribuir matrícula ao aluno
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * Método para retornar o ano de início do aluno
	 * @return int - ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Método para atribuir ano de ínicio do aluno
	 * @param ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Método que retorna o semestre de início do aluno
	 * @return int - semestre
	 */
	public int getSemestre() {
		return semestre;
	}

	/**
	 * Método para atribuir semestre de início do aluno
	 * @param semestre
	 */
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	/**
	 * Construtor Vazio
	 */
	public Aluno() { }
	
	
	/**
	 * Construtor definindo os atributos
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param sexo
	 * @param curso
	 * @param ano
	 * @param semestre
	 */
	public Aluno(String nome, String cpf, String rg, String sexo, String curso, int ano, int semestre) {
		super(nome, cpf, rg, sexo);
		this.curso = curso;
		this.ano = ano;
		this.semestre = semestre;	
		
	}
	

}
