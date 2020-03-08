package projeto.sistema;

/**
 * Classe responsável por armazenar as notas e faltas de um determinado aluno
 * @author Guilherme Lage Albano
 *
 */
public class Boletim {
	
	private String materia;
	private double nota1, nota2, nota3, nota4;
	private Integer faltas;
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}
		

}
