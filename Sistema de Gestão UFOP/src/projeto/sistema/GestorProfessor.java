package projeto.sistema;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**Classe que faz o controle de professores da Universidade
* @author Guilherme Lage Albano
* @version 1.0
* @since Release 1.0
*/
public class GestorProfessor implements CRUD {
	
	private static GestorProfessor GProfessor = new GestorProfessor();
	ArrayList<Professor> Professores = new ArrayList<Professor>();
	
	private Object[] sexo = {"Masculino", "Feminino"};
	private Object[] escolaridade = {"Ensino Médio", "Ensino Superior", "Pós-Graduação", "Mestrado", "Doutorado"};	
	
	/**
	 * Construtor vazio e privado
	 */
	private GestorProfessor() {}
	
	/**
	 * Método para obter a instância única do padrão singleton
	 * @return GestorProfessor
	 */
	public static GestorProfessor getInstance() {
		return GProfessor;
	}
	
	
	/**
	 * Método que busca professor no array
	 * @return int - posição no array
	 */
	public int Busca_Professor() {
		
		int i;
		String cpf_auxiliar;
		
		try {
		cpf_auxiliar = (String) JOptionPane.showInputDialog(null, "Insira o CPF do Professor", "Procurar Professor", JOptionPane.PLAIN_MESSAGE, null, null , null);
		}catch(Exception e) {
			return -1;
		}
		for(i = 0; i<Professores.size(); i++) {
			if(Professores.get(i).getCpf().equals(cpf_auxiliar)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que busca um professor no array
	 * @param cpf_auxiliar - cpf do professor 
	 * @param Professores - Array de professores que será realizada a busca
	 * @return int - posição no array
	 */
	public static int Busca_Professor(String cpf_auxiliar, ArrayList<Professor> Professores) {
		
		int i;
		
		for(i = 0; i<Professores.size(); i++) {
			if(Professores.get(i).getCpf().equals(cpf_auxiliar)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método sobrescrito da interface, cadastra um novo professor.
	 */
	@Override
	public void Cadastrar() {
		Professores.add(new Professor());
		
		while(true) {
			Professores.get(Professores.size() -1).setNome((String) JOptionPane.showInputDialog(null, "Nome", "Cadastro de Professor", JOptionPane.PLAIN_MESSAGE));	
			if(Professores.get(Professores.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Professor", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Professores.remove(Professores.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
		
		while(true) {
			Professores.get(Professores.size() -1).setCpf(JOptionPane.showInputDialog(null, "CPF", "Cadastro de Professor", JOptionPane.PLAIN_MESSAGE));	
			if(Professores.get(Professores.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Professor", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Professores.remove(Professores.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
		
		while(true) {
			Professores.get(Professores.size() -1).setRg(JOptionPane.showInputDialog(null, "RG", "Cadastro de Professor", JOptionPane.PLAIN_MESSAGE));	
			if(Professores.get(Professores.size() -1).getNome() == null) {
						int j;
						j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o cadastro?", "Cadastro de Professor", JOptionPane.YES_NO_OPTION);
						if( j != 1) {
							Professores.remove(Professores.size() -1); 
							JOptionPane.showMessageDialog(null, "Cadastro cancelado !");
							return;
							} else {
								continue;
							} } else break;  }
		
		
		
		Professores.get(Professores.size() -1).setSexo((String) JOptionPane.showInputDialog(null, "Sexo", "Cadastro de Professor", JOptionPane.PLAIN_MESSAGE, null, sexo  , "Masculino"));
		Professores.get(Professores.size() -1).setEscolaridade((String)JOptionPane.showInputDialog(null, "Escolaridade", "Cadastro de Professor", JOptionPane.PLAIN_MESSAGE, null, escolaridade, "Ensino Médio"));
		
		while(true) {
		try {
		Professores.get(Professores.size() -1).setSalario(Double.parseDouble(JOptionPane.showInputDialog(null, "Salário", "Cadastro de Professor", JOptionPane.PLAIN_MESSAGE)));
		break;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
		}}
		
		JOptionPane.showMessageDialog(null, "Professor Cadastrado com Sucesso !");

	}

	/**
	 * Método sobrescrito da interface, imprime os dados de um professor
	 */
	@Override
	public void Imprimir() {
		int i;
		
		while(true) {
		i = Busca_Professor();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "O CPF inserido não corresponde a nenhum Professor, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		JOptionPane.showMessageDialog(null, "Nome: " + Professores.get(i).getNome() + "\nCPF: " +Professores.get(i).getCpf()
				+ "\nRG: " + Professores.get(i).getRg() + "\nSexo: " + Professores.get(i).getSexo()
				+ "\nSalário: R$" + Professores.get(i).getSalario() + "\nEscolaridade: " + Professores.get(i).getEscolaridade(),
				"Dados do Professor", JOptionPane.PLAIN_MESSAGE);

	}

	/**
	 * Método sobrescrito da interface, atualiza os dados de um professor
	 */
	@Override
	public void Atualizar() {
		int i;
		
		while(true) {
		i = Busca_Professor();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "O CPF inserido não corresponde a nenhum Professor, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		
		Professores.get(i).setNome((String) JOptionPane.showInputDialog(null, "Nome", "Alterar Professor", JOptionPane.PLAIN_MESSAGE, null, null, Professores.get(i).getNome()));		
		Professores.get(i).setCpf((String) JOptionPane.showInputDialog(null, "CPF", "Alterar Professor", JOptionPane.PLAIN_MESSAGE, null, null, Professores.get(i).getCpf()));
		Professores.get(i).setRg((String) JOptionPane.showInputDialog(null, "RG", "Alterar Professor", JOptionPane.PLAIN_MESSAGE, null, null, Professores.get(i).getRg()));
		Professores.get(i).setSexo((String) JOptionPane.showInputDialog(null, "Sexo", "Alterar Professor", JOptionPane.PLAIN_MESSAGE, null, sexo  , Professores.get(i).getSexo()));
		Professores.get(i).setEscolaridade((String) JOptionPane.showInputDialog(null, "Escolaridade", "Alterar Professor", JOptionPane.PLAIN_MESSAGE, null, escolaridade, Professores.get(i).getEscolaridade()));
		
		while(true) {
			try {
			Professores.get(i).setSalario(Double.parseDouble((String)JOptionPane.showInputDialog(null, "Salário", "Alterar Professorr", JOptionPane.PLAIN_MESSAGE, null, null, Professores.get(i).getSalario())));
			break;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Por Favor, Insira um valor válido");
			}}	
			
		JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !", ""+ Professores.get(i).getNome(), JOptionPane.PLAIN_MESSAGE);	

	}

	/**
	 * Método sobrescrito da interface, exclui um professor do array
	 */
	@Override
	public void Deletar() {
		int i;
		
		while(true) {
		i = Busca_Professor();
		if( i == -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "O CPF inserido não corresponde a nenhum Professor, deseja inserir novamente ?");
			if(opcao == 0) {
				continue;
			} else {
				return;
			}}else {
				break;
			}}
		
		Professores.remove(i);
		JOptionPane.showMessageDialog(null, "Professor excluído com sucesso !", "", JOptionPane.PLAIN_MESSAGE);		

	}
		
		
}
