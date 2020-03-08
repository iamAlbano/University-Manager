package projeto.sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**Classe que faz o controle de alunos da Universidade
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/

public class GestorAluno implements CRUD{
	
	private static GestorAluno GAluno = new GestorAluno();
	ArrayList<Aluno> Alunos = new ArrayList<Aluno>();
	
	Object[] sexo = {"Masculino", "Feminino"};
	Object[] semestre = {"1", "2"};
	Object[] anos = {"15","16", "17", "18", "19", "20"};
	
	/**
	 * Construtor vazio privado
	 */
	private GestorAluno() {}
	
	/**
	 * Método para obter a instância única do padrão singleton
	 * @return GestorAluno
	 */
	public static GestorAluno getInstance() {
		return GAluno;
	}
	
	/**
	 * Método que gera aleatoriamente uma matrícula para o aluno cadastrado
	 * @param ano - ano de ínicio do aluno
	 * @param semestre - semestre de início do aluno
	 * @return String - matrícula
	 */
	private String Gerar_Matricula(int ano, int semestre) {
		
		int i;
		String matricula;
		
		while(true) {
		matricula =  Integer.toString(ano) +"."+ Integer.toString(semestre) +"."+ (int) (Math.random() * 10000);
		for(i = 0; i < GAluno.Alunos.size(); i++) {
			if(matricula.equals(GAluno.Alunos.get(i).getMatricula())) {
				continue;  }
		}	break;	}
		return matricula;
		}
			
	
	/**
	 * Método que busca no Array a posição do aluno informado pelo usuário, retorna -1 caso não encontre
	 * @return int - posição do aluno no array
	 */
	public int Busca_Aluno() {
		
		int i;
		String matricula_auxiliar;
		
		try {
		matricula_auxiliar = (String) JOptionPane.showInputDialog(null, "Insira a Matrícula do aluno", "Procurar Aluno", JOptionPane.PLAIN_MESSAGE, null, null , null);
		}catch(Exception e){
			return -1;
		}
		for(i = 0; i<Alunos.size(); i++) {
			if(Alunos.get(i).getMatricula().equals(matricula_auxiliar)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que busca no Array a posição do aluno informado pelo usuário, retorna -1 caso não encontre
	 * @param matricula_auxiliar - matrícula do aluno que se deseja procurar
	 * @param Alunos - o array em que se realizará a busca
	 * @return int - posição do aluno no array
	 */
	public static int Busca_Aluno(String matricula_auxiliar, ArrayList<Aluno> Alunos) {
		
		int i;
		
		for(i = 0; i<Alunos.size(); i++) {
			if(Alunos.get(i).getMatricula().equals( matricula_auxiliar)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que busca o boletim de um determinado aluno e uma determinada matéria informados pelo usuário
	 * @param aluno
	 * @return int - posição do boletim no array histórico escolar do aluno
	 */
	public static int Busca_Boletim(Aluno aluno) {
		int i;
		String aux;
		
		try {			
			aux = (String) JOptionPane.showInputDialog(null, "Insira o nome da Disciplina", "Procurar Boletim", JOptionPane.PLAIN_MESSAGE, null, null , null);
			}catch(Exception e){
				return -1;
			}			
			for(i = 0; i<aluno.getHistorico().size(); i++) {
				if(aluno.getHistorico().get(i).getMateria().equals(aux)) {
					return i;
				}
			}
			return -1;
	}

	/**
	 * Método sobrescrito da interface, cadastra um novo aluno
	 */
	@Override
	public void Cadastrar() {
		
		
		Alunos.add(new Aluno());
		Alunos.get(Alunos.size() -1).setNome((String) JOptionPane.showInputDialog(null, "Nome", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE));
		Alunos.get(Alunos.size() -1).setCpf((String) JOptionPane.showInputDialog(null, "CPF", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE));
		Alunos.get(Alunos.size() -1).setRg((String) JOptionPane.showInputDialog(null, "RG", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE));
		Alunos.get(Alunos.size() -1).setSexo((String) JOptionPane.showInputDialog(null, "Sexo", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE, null, sexo  , "Masculino"));
		
		
		while(true) {
		try {
		Alunos.get(Alunos.size() -1).setAno(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ano de início", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE, null, anos, "18")));
		break;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
		}}
		
		while(true) {
			try {
			Alunos.get(Alunos.size() -1).setSemestre(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Semestre de início", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE, null, semestre, "1")));
			break;
			
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido (1 ou 2) !");
			}}
		
		Alunos.get(Alunos.size() -1).setMatricula(Gerar_Matricula(Alunos.get(Alunos.size() -1).getAno(), Alunos.get(Alunos.size() -1).getSemestre()));
		
		while(true) {
		Alunos.get(Alunos.size() -1).setCurso((String) JOptionPane.showInputDialog(null, "Curso do Aluno", "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE));
		GestorCursos aux = GestorCursos.getInstance();
		int i = aux.Busca_Curso(Alunos.get(Alunos.size() -1).getCurso(), aux.Cursos);
		if(i == -1) {
			int j = JOptionPane.showConfirmDialog(null, "Curso não encontrado na base de dados! por favor, insira novamente.", "Cadastro de Aluno", JOptionPane.OK_CANCEL_OPTION);
			if(j != 0) {
				j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro do aluno ?", "Cadastro de Aluno", JOptionPane.YES_NO_OPTION);
				if( j != 1) {
					Alunos.remove(Alunos.size() -1); 
					JOptionPane.showMessageDialog(null, "Cadastro de aluno cancelado !");
					return;
					} else {
						continue;
					}
			}
		}else {
			break;
		}}
		
		
		
		
		JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso ! Matrícula: " + Alunos.get(Alunos.size() -1).getMatricula(), "Cadastro de Aluno", JOptionPane.PLAIN_MESSAGE);
		
		
	}

	/**
	 * Método sobrescrito da interface, imprime os dados de um aluno
	 */
	@Override
	public void Imprimir() {
		
		int i;
		
		while(true) {
		i = Busca_Aluno();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "A Matrícula inserida não corresponde a nenhum Aluno, deseja inserir outra matrícula ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break; }}
		
		JOptionPane.showMessageDialog(null, "Nome: " + Alunos.get(i).getNome() + "\nMatrícula: " + Alunos.get(i).getMatricula() + "\nCPF: " + Alunos.get(i).getCpf()
										+ "\nRG: " + Alunos.get(i).getRg() + "\nSexo: " + Alunos.get(i).getSexo() + "\nCurso: " + Alunos.get(i).getCurso(),
										"Dados do Aluno", JOptionPane.PLAIN_MESSAGE);	
	}

	/**
	 * Método sobrescrito da interface, edita os dados de um aluno
	 */
	@Override
	public void Atualizar() {
				
		int i;
		
		while(true) {
		i = Busca_Aluno();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "A Matrícula inserida não corresponde a nenhum Aluno, deseja inserir outra matrícula ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Alunos.get(i).setNome((String) JOptionPane.showInputDialog(null, "Nome", "Alterar aluno: " + Alunos.get(i).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(i).getNome()));
		Alunos.get(i).setCpf((String) JOptionPane.showInputDialog(null, "CPF", "Alterar aluno: " + Alunos.get(i).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(i).getCpf()));
		Alunos.get(i).setRg((String) JOptionPane.showInputDialog(null, "RG", "Alterar aluno: " + Alunos.get(i).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(i).getRg()));
		Alunos.get(i).setSexo((String) JOptionPane.showInputDialog(null, "Sexo", "Alterar aluno: " + Alunos.get(i).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, sexo  , Alunos.get(i).getSexo()));
			
		JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !", ""+ Alunos.get(i).getMatricula(), JOptionPane.PLAIN_MESSAGE);		
		
	}
	
	
	/**
	 * Método sobrescrito da interface, deleta um aluno do array
	 */
	@Override
	public void Deletar() {
		int i;
		
		while(true) {
		i = Busca_Aluno();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "A Matrícula inserida não corresponde a nenhum Aluno, deseja inserir outra matrícula ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Alunos.remove(i);
		JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso !", "", JOptionPane.PLAIN_MESSAGE);		
		
	}
	
	
/**
 * Método que cadastra uma matéria em um aluno informado pelo usuário
 * @author Guilherme Lage Albano	
 */
public void Cadastra_Materia() {
	
	int j;
	int i;
	
	while(true) {
	j = Busca_Aluno();
	if( j == -1) {
		int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum Aluno, deseja inserir novamente ?");
		if(opcao == 0) {
			continue;
		} else {
			return;
		}}else {
			break;
		}}	
			
		GestorDisciplinas aux = GestorDisciplinas.getInstance();
		while(true) {
		
		String nome_aux = (String) JOptionPane.showInputDialog(null, "Insira o nome da Disciplina que será adicionada a grade do aluno: ", "Procurar Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, null);
			
		i = GestorDisciplinas.Busca_Disciplina(nome_aux, aux.Disciplinas);
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		
		
		Alunos.get(j).Novo_Boletim(aux.Disciplinas.get(i));
		
		JOptionPane.showMessageDialog(null, "Disciplina adicionada na grade do aluno" , "Matricular Aluno em disciplina", JOptionPane.PLAIN_MESSAGE);	
	}


	/**
	 * Método que imprime o boletim de um aluno informado
	 * @author Guilherme Lage Albano
	 */
	public void Imprimir_Boletim() {
		int j;
		int i;
		
		while(true) {
		j = Busca_Aluno();
		if( j == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum Aluno, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}	
				
			while(true) {
				
			i = Busca_Boletim(Alunos.get(j));
			if( i == -1) {
				int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
				if(opcao == 0) {
					continue;
				} else {
					return;
				}}else {
					break;
				}}
			
			try {
			JOptionPane.showMessageDialog(null, "Nome: " + Alunos.get(j).getNome() + "\nMatrícula: " + Alunos.get(j).getMatricula()
											+ "\nCurso: " + Alunos.get(j).getCurso() + "\nDisciplina: " + Alunos.get(j).getHistorico().get(i).getMateria()
											+ "\nNota Prova 1: " + Alunos.get(j).getHistorico().get(i).getNota1()
											+ "\nNota Prova 2: " + Alunos.get(j).getHistorico().get(i).getNota2()
											+ "\nNota Prova 3: " + Alunos.get(j).getHistorico().get(i).getNota3()
											+ "\nNota Trabalho: " + Alunos.get(j).getHistorico().get(i).getNota4()
											+ "\nFaltas: " + Alunos.get(j).getHistorico().get(i).getFaltas(),
					"Boletim do Aluno", JOptionPane.PLAIN_MESSAGE);	
			}catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "O Aluno não possui nenhuma informação de boletim cadastrada", "Boletim do Aluno", JOptionPane.PLAIN_MESSAGE);	
			}
			
	}
	
	/**
	 * Método que atualiza notas e faltas do aluno
	 * @author Guilherme Lage Albano
	 */
	public void Atualiza_Boletim() {
		int j;
		int i;
		
		while(true) {
		j = Busca_Aluno();
		if( j == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum Aluno, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}	
				
			while(true) {	
				
			i = Busca_Boletim(Alunos.get(j));
			if( i == -1) {
				int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
				if(opcao == 0) {
					continue;
				} else {
					return;
				}}else {
					break;
				}}
			
			
			
			while(true) {
			try {
			
			Alunos.get(j).getBoletim(i).setFaltas(Integer.parseInt((String)JOptionPane.showInputDialog(null, "Número de Faltas", "Atualizar Boletim: " + Alunos.get(j).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(j).getHistorico().get(i).getFaltas())));
			break;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
			}}
			
			while(true) {
				try {
					Alunos.get(j).getHistorico().get(i).setNota1(Double.parseDouble((String) JOptionPane.showInputDialog(null, "Nota da 1ª Prova", "Atualizar Boletim: " + Alunos.get(j).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(j).getHistorico().get(i).getNota1())));
				break;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
				}}
			
			while(true) {
				try {
					Alunos.get(j).getHistorico().get(i).setNota2(Double.parseDouble((String) JOptionPane.showInputDialog(null, "Nota da 2ª Prova", "Atualizar Boletim: " + Alunos.get(j).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(j).getHistorico().get(i).getNota2())));
				break;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
				}}
			while(true) {
				try {
					Alunos.get(j).getHistorico().get(i).setNota3(Double.parseDouble((String) JOptionPane.showInputDialog(null, "Nota da 3ª Prova", "Atualizar Boletim: " + Alunos.get(j).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(j).getHistorico().get(i).getNota3())));
				break;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
				}}
			while(true) {
				try {
					Alunos.get(j).getHistorico().get(i).setNota4(Double.parseDouble((String) JOptionPane.showInputDialog(null, "Nota do Trabalho", "Atualizar Boletim: " + Alunos.get(j).getMatricula(), JOptionPane.PLAIN_MESSAGE, null, null, Alunos.get(j).getHistorico().get(i).getNota4())));
				break;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
				}}
			
			JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !", "Atualizar Boletim", JOptionPane.PLAIN_MESSAGE);	
			
			}
	
	
	/**
	 * Método que tranca uma matéria de um determinado aluno informado pelo usuário
	 */
	public void Exclui_Materia() {
				
		int j;
		int i;
		
		while(true) {
		j = Busca_Aluno();
		if( j == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum Aluno, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}	
		
		while(true) {
							
			i = Busca_Boletim(Alunos.get(j));
			if( i == -1) {
				int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
				if(opcao == 0) {
					continue;
				} else {
					return;
				}}else {
					break;
				}}
		
		
		Alunos.get(j).getHistorico().remove(i);
		JOptionPane.showMessageDialog(null, "Disciplina trancada", "Trancar disciplina", JOptionPane.PLAIN_MESSAGE);	
	}
	
	/**
	 * Método que cria um arquivo .txt em C:\ contendo o relatório de aprovações
	 */
	public void Gerar_Relatorio(){
		
		int d;
		String disciplina;
		
		while(true) {
			GestorDisciplinas aux = GestorDisciplinas.getInstance();
			disciplina = (String) JOptionPane.showInputDialog(null, "Insira o nome da Disciplina na qual deseja gerar o relatório de aprovações", "Relatório de Aprovações", JOptionPane.PLAIN_MESSAGE, null, null, null);
			d = GestorDisciplinas.Busca_Disciplina(disciplina, aux.Disciplinas);
			if( d == -1) {
				int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
				if(opcao == 0) {
					continue;
				} else {
					return;
				}}else {
					break;
				}}
	
		try {
		FileWriter relatorio = new FileWriter("c:\\Relatório de " +disciplina+".txt");
		PrintWriter escreve = new PrintWriter(relatorio);
		escreve.printf("\t\t\tRelatório de Aprovações:  %s\n", disciplina);
		escreve.printf("-------------------------------------------------------------------------------------------------------------------\n");
		for(int i = 0; i<Alunos.size(); i++) {
			
			for(int j = 0; j<Alunos.get(j).getHistorico().size(); j++) {
				if(Alunos.get(i).getHistorico().get(j).getMateria().equals(disciplina)) {
					double total = Alunos.get(i).getHistorico().get(j).getNota1() + Alunos.get(i).getHistorico().get(j).getNota2() + Alunos.get(i).getHistorico().get(j).getNota3() + Alunos.get(i).getHistorico().get(j).getNota4();
					escreve.printf("   %s       %s       P1: %.2f      P2: %.2f      P3: %.2f      T: %.2f     Faltas: %d   ", Alunos.get(i).getMatricula(),Alunos.get(i).getNome(), Alunos.get(i).getHistorico().get(j).getNota1(), Alunos.get(i).getHistorico().get(j).getNota2(), Alunos.get(i).getHistorico().get(j).getNota3(), Alunos.get(i).getHistorico().get(j).getNota4(), Alunos.get(i).getHistorico().get(j).getFaltas());
					
					if(total >= 60 && Alunos.get(i).getHistorico().get(j).getFaltas() < 18) {
						escreve.printf(" Aprovado  \n");
					} else if(Alunos.get(i).getHistorico().get(j).getFaltas() >= 18) {
						escreve.printf(" Reprovado por falta  \n");
					} else {
						escreve.printf(" Reprovado  \n"); }}
				escreve.printf("----------------------------------------------------------------------------------------------------------\n");
				}	
			
		}
		
		relatorio.close(); 
		JOptionPane.showMessageDialog(null, "Relatório gerado em C:", "Gerar Relatório de Aprovações", JOptionPane.PLAIN_MESSAGE);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi Possível gerar o relatório, tente executar o programa em modo administrador ", "Gerar Relatório de Aprovações", JOptionPane.PLAIN_MESSAGE);
		}
		}
	
	

}



