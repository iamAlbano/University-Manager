package projeto.sistema;

/**
 * Menu principal main
 * @author Guilherme Lage Albano
 *
 */
public class GestorAcademico{

	public static void main(String[] args){
		
		Menu menu = Menu.getInstance();
		
		boolean loop = true;
		while(loop) {
		loop = menu.Menu_Principal();	
		}
		
	}

}
