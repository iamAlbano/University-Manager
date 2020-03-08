package projeto.sistema;

import javax.swing.JOptionPane;

/**
 * Classe responsável por criar e organizar os menus
 * @author Guilherme Lage Albano
 *
 */
public class Menu{
	
	GestorAluno GAluno = GestorAluno.getInstance();
	GestorProfessor GProfessor = GestorProfessor.getInstance();
	GestorCursos GCurso = GestorCursos.getInstance();
	GestorDisciplinas GDisciplina = GestorDisciplinas.getInstance();
	private static Menu menu = new Menu();
	
	
	private Menu() { }
	
	public static Menu getInstance() {
		return menu;
	}
	
	private Object[] crud = {"Cadastrar", "Imprimir", "Atualizar", "Excluir", "Voltar"};
	private Object[] opcoes = {"Alunos", "Professores", "Cursos", "Disciplinas", "Módulo Colegiado", "Sair"};
	private Object[] modulo = {"Matricular Aluno em Disciplina", "Imprimir Boletim", "Atualizar Notas e Faltas", "Trancar disciplina", "Gerar Relatório de Aprovações","Voltar"};
	
	/**
	 * O menu inicial executado ao iniciar o programa
	 * @return boolean - se retornar falso, o programa se encerra
	 */
	public boolean Menu_Principal(){
		
		
		String opcao = (String)JOptionPane.showInputDialog(null, "Escolha o Módulo", "Gestor Acadêmico", JOptionPane.PLAIN_MESSAGE, null, opcoes, "Aluno");
		
		if(opcao == null) {
			JOptionPane.showMessageDialog(null, "Obrigado por utilizar o Gestor Acadêmico!\nDesenvolvido por Guilherme Albano", "Gestor Acadêmico", JOptionPane.PLAIN_MESSAGE);
			return false; }
		
		if(opcao.equals("Alunos")) {
			Menu_CRUD(GAluno);
			} else if(opcao.equals("Professores")) {
			Menu_CRUD(GProfessor);
			} else if(opcao.equals("Cursos")) {
			Menu_CRUD(GCurso);
			} else if(opcao.equals("Disciplinas")) {
			Menu_CRUD(GDisciplina);
			} else if(opcao.equals("Módulo Colegiado")) {
			Menu_Colegiado();
			} else if(opcao.equals("Sair")){
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar o Gestor Acadêmico!\nDesenvolvido por Guilherme Albano", "Gestor Acadêmico", JOptionPane.PLAIN_MESSAGE);
				return false;
			} 
		return true;

	}
	
	/**
	 * Menu dos módulos CRUD
	 * @param modulo
	 */
	public void Menu_CRUD(CRUD modulo) {
		String opcao = (String)JOptionPane.showInputDialog(null, "Qual operação deseja realizar ?", "Gestor Acadêmico", JOptionPane.PLAIN_MESSAGE, null, crud, "Aluno");
		if(opcao == null) {
			return; }
		if(opcao.equals("Cadastrar")) {
				modulo.Cadastrar(); 
			} else if(opcao.equals("Imprimir")) {
				modulo.Imprimir();
			} else if(opcao.equals("Atualizar")) {
				modulo.Atualizar();
			} else if(opcao.equals("Excluir")) {
				modulo.Deletar();
			} else {
				return;
			}
		
	}
	
	/**
	 * Menu do módulo colegiado, com as funções correspondentes ao mesmo
	 */
	public void Menu_Colegiado(){
		String opcao = (String)JOptionPane.showInputDialog(null, "Qual operação deseja realizar ?", "Módulo Colegiado", JOptionPane.PLAIN_MESSAGE, null, modulo, "Cadastrar Aluno em Disciplina");
		if(opcao == null) {
			return; }
		if(opcao.equals("Matricular Aluno em Disciplina")) {
			GAluno.Cadastra_Materia();
			} else if(opcao.equals("Imprimir Boletim")) {
			GAluno.Imprimir_Boletim();
			} else if(opcao.equals("Atualizar Notas e Faltas")) {
			GAluno.Atualiza_Boletim();
			} else if(opcao.equals("Trancar disciplina")) {
			GAluno.Exclui_Materia();
			} else if(opcao.equals("Gerar Relatório de Aprovações")) {
				GAluno.Gerar_Relatorio();			
			} else {
				return;
			}
	}
	
	
	
}


