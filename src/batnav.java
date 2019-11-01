import java.util.Scanner;

public class batnav {

	public static void main(String[] args) {

		String Bienvenue = "Bienvenue dans ce jeu de bataille navale!\n";
		Pep8.stro(Bienvenue);

		String DEMANDE_D_ENTREE = "Entrer la description et la position des bateaux \r\n"
				+ "selon le format suivant, separes par des espaces: \r\n"
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9] \r\n";

		String Colonnes = "ABCDEFGHIJKLMNOPQR";
		// TODO créér tableau

		char[][] tableau = { { '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' ,'~', '~', '~', '~', '~'},
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' ,'~', '~', '~', '~', '~' },
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' },
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' },
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' },
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' },
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' ,'~', '~', '~', '~', '~' },
				{ '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~' } };
		
		Pep8.charo(' ');
		Pep8.charo(' ');
		Pep8.stro(Colonnes);
		Pep8.charo('\n');
		for (int i = 0; i <= 8; i++) {
			Pep8.deco(i+1);
			Pep8.charo('|');
			for (int j = 0; j <= 17; j++) {
				Pep8.charo(tableau[i][j]);
			}
			Pep8.charo('|');
			Pep8.charo('\n');
		}
		// TODO ajouts des bateaux
		Pep8.charo('\n');
		Pep8.stro(DEMANDE_D_ENTREE);

		// TODO ajouts des différents coups

		// TODO gérer les ricochets

		// TODO gérer la récursivité

		Pep8.stop();

	}

}
