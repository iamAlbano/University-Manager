package projeto.sistema;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**Classe que faz o controle de cursos da Universidade
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/

public class GestorCursos implements CRUD {
	
	private static GestorCursos GCursos = new GestorCursos(); 
	ArrayList<Curso> Cursos = new ArrayList<Curso>();
	
	/**
	 * Construtor vazio e privado
	 */
	private GestorCursos() { }
	
	/**
	 * Método para obter a instância única do padrão singleton
	 * @return GestorCursos
	 */
	public static GestorCursos getInstance() {
		return GCursos;
	}
	
	Object[] modalidades = {"Bacharel", "Tecnólogo", "Licenciatura"};
	
	/**
	 * Método que busca no array um curso informado pelo usuário, retorna -1 se não encontrar
	 * @return
	 */
	public int Busca_Curso() {
		
		int i;
		String nome_auxiliar;
		
		try {
		nome_auxiliar = (String) JOptionPane.showInputDialog(null, "Insira o nome do curso: ", "Procurar Curso", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}catch(Exception e) {
			return -1;
		}
		for(i = 0; i<Cursos.size(); i++) {
			if(Cursos.get(i).getNome().equals(nome_auxiliar)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que busca no array passado, o curso passado por parâmetro
	 * @param nome_auxiliar - nome do curso
	 * @param Cursos - array que será realizada a busca
	 * @return int - posição no array
	 */
	public int Busca_Curso(String nome_auxiliar, ArrayList<Curso> Cursos) {
		
		int i;
		
		for(i = 0; i<Cursos.size(); i++) {
			if(Cursos.get(i).getNome().equals( nome_auxiliar)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método sobrescrito da interface, cadastra um novo curso.
	 */
	@Override
	public void Cadastrar() {
		Cursos.add(new Curso());
		
		while(true) {
			Cursos.get(Cursos.size() -1).setNome((String)JOptionPane.showInputDialog(null, "Nome", "Cadastro de Curso", JOptionPane.PLAIN_MESSAGE, null, null, null));	
			if(Cursos.get(Cursos.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Curso", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Cursos.remove(Cursos.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
		
		while(true) {
			Cursos.get(Cursos.size() -1).setCampus((String)JOptionPane.showInputDialog(null, "Campus", "Cadastro de Curso", JOptionPane.PLAIN_MESSAGE, null, null, null));	
			if(Cursos.get(Cursos.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Curso", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Cursos.remove(Cursos.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
		
		
		Cursos.get(Cursos.size() -1).setModalidade((String)JOptionPane.showInputDialog(null, "Modalidade", "Cadastro de Curso", JOptionPane.PLAIN_MESSAGE, null, modalidades, "Bacharel"));
		while(true) {
		try {
		Cursos.get(Cursos.size() -1).setSemestres(Integer.parseInt(JOptionPane.showInputDialog(null, "Semestres", "Cadastro de Curso", JOptionPane.PLAIN_MESSAGE)));
		break;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
		}}
		
		while(true) {
			try {
		Cursos.get(Cursos.size() -1).setVagas(Integer.parseInt(JOptionPane.showInputDialog(null, "Vagas", "Cadastro de Curso", JOptionPane.PLAIN_MESSAGE)));
		break;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso !", "Cadastro de Curso", JOptionPane.PLAIN_MESSAGE);

	}
	
	
	
	
	/**
	 * Método sobrescrito da interface, imprime os dados de um curso
	 */
	@Override
	public void Imprimir() {
		int i;
		
		while(true) {
		i = Busca_Curso();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum curso com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}	
		JOptionPane.showMessageDialog(null, "Nome: " + Cursos.get(i).getNome() + "\nCampus: "
													 + Cursos.get(i).getCampus() + "\nModalidade: "
													 + Cursos.get(i).getModalidade() + "\nSemestres: "
													 + Cursos.get(i).getSemestres()	+ "\nVagas: "
													 + Cursos.get(i).getVagas(),
													 "Curso", JOptionPane.PLAIN_MESSAGE);
	}

	
	/**
	 * Método sobrescrito da interface, atualiza os dados de um curso
	 */
	@Override
	public void Atualizar() {
		
		int i;
		
		while(true) {
		i = Busca_Curso();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum curso com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Cursos.get(i).setNome((String) JOptionPane.showInputDialog(null, "Nome", "Alterar Curso", JOptionPane.PLAIN_MESSAGE, null, null, Cursos.get(i).getNome()));
		Cursos.get(i).setCampus((String) JOptionPane.showInputDialog(null, "Campus", "Alterar Curso", JOptionPane.PLAIN_MESSAGE, null, null, Cursos.get(i).getCampus()));
		Cursos.get(i).setModalidade((String) JOptionPane.showInputDialog(null, "Modalidade", "Alterar Curso", JOptionPane.PLAIN_MESSAGE, null, modalidades, Cursos.get(i).getModalidade()));
		
		while(true) {
			try {
			Cursos.get(i).setSemestres(Integer.parseInt((String)JOptionPane.showInputDialog(null, "Semestres", "Alterar Curso", JOptionPane.PLAIN_MESSAGE,null, null, Cursos.get(i).getSemestres())));
			break;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
			}}
			
			while(true) {
				try {
			Cursos.get(i).setVagas(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Vagas", "Alterar Curso", JOptionPane.PLAIN_MESSAGE, null, null, Cursos.get(i).getVagas())));
			break;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
				}
			}
			
			JOptionPane.showMessageDialog(null, "Curso alterado com sucesso !", "Alterar Curso", JOptionPane.PLAIN_MESSAGE);

	}

	
	/**
	 * Método sobrescrito da interface, exclui um curso do array
	 */
	@Override
	public void Deletar() {
		int i;
		
		while(true) {
		i = Busca_Curso();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Não foi encontrado nenhum curso com este nome, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Cursos.remove(i);
		JOptionPane.showMessageDialog(null, "Curso excluído com sucesso !", "", JOptionPane.PLAIN_MESSAGE);		

	}

}
