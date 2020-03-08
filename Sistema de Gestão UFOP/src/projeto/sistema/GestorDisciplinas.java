package projeto.sistema;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**Classe que faz o controle de disciplinas da Universidade
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/
public class GestorDisciplinas implements CRUD {
	
	private static GestorDisciplinas GDisciplinas = new GestorDisciplinas();
	ArrayList<Disciplina> Disciplinas = new ArrayList<Disciplina>();
	
	private GestorDisciplinas() {}
	
	/**
	 * Método para obter a instância única do padrão singleton
	 * @return GestorDisciplinas
	 */
	public static GestorDisciplinas getInstance() {
		return GDisciplinas;
	}
	
	Object[] turnos = {"Matutino", "Vespertino", "Noturno"};
	
	
	/**
	 * Método que busca uma disciplina no array
	 * @return int - posição no array
	 */
	public int Busca_Disciplina() {
		
		int i;
		String nome_auxiliar;
		
		try {
		nome_auxiliar = (String) JOptionPane.showInputDialog(null, "Insira o nome da Disciplina: ", "Procurar Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}catch(Exception e) {
			return -1;
		}
		for(i = 0; i<Disciplinas.size(); i++) {
			if(Disciplinas.get(i).getNome().equals(nome_auxiliar)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que busca no array, a disciplina passada como parâmetro
	 * @param nome_auxiliar
	 * @param Disciplinas
	 * @return int - posição no array
	 */
	public static int Busca_Disciplina(String nome_auxiliar, ArrayList<Disciplina> Disciplinas) {
		
		int i;
		
		for(i = 0; i<Disciplinas.size(); i++) {
			if(Disciplinas.get(i).getNome().equals( nome_auxiliar)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método sobrescrito da interface, cadastra uma nova disciplina.
	 */
	@Override
	public void Cadastrar() {
		Disciplinas.add(new Disciplina());
		
		while(true) {
		Disciplinas.get(Disciplinas.size() -1).setNome((String)JOptionPane.showInputDialog(null, "Nome", "Cadastro de Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, null));	
		if(Disciplinas.get(Disciplinas.size() -1).getNome() == null) {
					int j;
					j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Disciplina", JOptionPane.YES_NO_OPTION);
					if( j != 1) {
						Disciplinas.remove(Disciplinas.size() -1); 
						JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
						return;
						} else {
							continue;
						} } else break;  }
		
		while(true) {
			Disciplinas.get(Disciplinas.size() -1).setDepartamento((String)JOptionPane.showInputDialog(null, "Departamento", "Cadastro de Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, null));
			if(Disciplinas.get(Disciplinas.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Disciplina", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Disciplinas.remove(Disciplinas.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
		
		while(true) {
			Disciplinas.get(Disciplinas.size() -1).setTurno((String)JOptionPane.showInputDialog(null, "Turno", "Cadastro de Disciplina", JOptionPane.PLAIN_MESSAGE, null, turnos, "Matutino"));
			if(Disciplinas.get(Disciplinas.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Disciplina", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Disciplinas.remove(Disciplinas.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
			
		int j;
		GestorProfessor aux = GestorProfessor.getInstance();
		
		while(true) {
		String prof_aux = (String)JOptionPane.showInputDialog(null, "CPF do Professor", "Cadastro de Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, null);
		j = GestorProfessor.Busca_Professor(prof_aux, aux.Professores);
		if(j == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "O CPF inserido não corresponde a nenhum Professor, deseja inserir novamente ?");
		if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Disciplinas.get(Disciplinas.size() -1).setProfessor(aux.Professores.get(j));
			
		
		JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso !", "Cadastrar Disciplina", JOptionPane.PLAIN_MESSAGE);
	
	}
	
	
	/**
	 * Método sobrescrito da interface, imprime os dados de uma disciplina.
	 */
	@Override
	public void Imprimir() {
		int i;
		
		while(true) {
		i = Busca_Disciplina();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}	
		JOptionPane.showMessageDialog(null, "Nome: " + Disciplinas.get(i).getNome() 
										 + "\nDepartamento: " + Disciplinas.get(i).getDepartamento()
										 + "\nTurno: " + Disciplinas.get(i).getTurno()
										 +"\nProfessor: " + Disciplinas.get(i).getProfessor().getNome(),
										 "Disciplina", JOptionPane.PLAIN_MESSAGE);
	}


	
	/**
	 * Método sobrescrito da interface, edita os dados de uma disciplina.
	 */
	@Override
	public void Atualizar() {
		int i;
		
		while(true) {
		i = Busca_Disciplina();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Disciplinas.get(i).setNome((String) JOptionPane.showInputDialog(null, "Nome", "Alterar Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, Disciplinas.get(i).getNome()));
		Disciplinas.get(i).setDepartamento((String) JOptionPane.showInputDialog(null, "Departamento", "Alterar Disciplina", JOptionPane.PLAIN_MESSAGE, null, null, Disciplinas.get(i).getDepartamento()));
		
			
			JOptionPane.showMessageDialog(null, "Disciplina alterada com sucesso !", "Alterar Disciplina", JOptionPane.PLAIN_MESSAGE);

	}

	
	/**
	 * Método sobrescrito da interface, exclui uma disciplina do array
	 */
	@Override
	public void Deletar() {
		int i;
		
		while(true) {
		i = Busca_Disciplina();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhuma Disciplina com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Disciplinas.remove(i);
		JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso !", "", JOptionPane.PLAIN_MESSAGE);	

	}

}
