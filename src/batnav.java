
public class batnav {
	public static String reccupererEntreeClavier() {
		String DEMANDE_D_ENTREE = "Entrer la description et la position des bateaux \r\n"
				+ "selon le format suivant, separes par des espaces: \r\n"
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] \r\n" + "ex: ghC4 mvM2 phK9:\r\n";

		Pep8.charo('\n');

		Pep8.stro(DEMANDE_D_ENTREE);
		char entreeUsercarc;
		String entreeBateau = "";
		do {
			entreeUsercarc = Pep8.chari();
			entreeBateau = entreeBateau + entreeUsercarc;
		} while (entreeUsercarc != '\n');

		return entreeBateau;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		String Bienvenue = "Bienvenue dans ce jeu de bataille navale!\n";
		Pep8.stro(Bienvenue);

		String DEMANDE_D_ENTREE = "Entrer la description et la position des bateaux \r\n"
				+ "selon le format suivant, separes par des espaces: \r\n"
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] \r\n" + "ex: ghC4 mvM2 phK9:\r\n";

		String ERREUR_ENTREE = "Le format de l'entrée ne respecte pas les paramètres indiqués!";

		String Colonnes = "  ABCDEFGHIJKLMNOPQR";
		// Grandeur
		char p = 'p'; // petit
		char m = 'm'; // moyen
		char g = 'g'; // grand
		// Orientation
		char h = 'h'; // horizontal
		char v = 'v'; // vertical
		// TODO crÃ©Ã©r tableau
		char[][] matrice = new char[9][18];

		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 17; j++) {
				matrice[i][j] = '~';
			}
		}

		Pep8.stro(Colonnes);
		Pep8.charo('\n');
		for (int i = 0; i <= 8; i++) {
			Pep8.deco(i + 1);
			Pep8.charo('|');
			for (int j = 0; j <= 17; j++) {
				Pep8.charo(matrice[i][j]);
			}
			Pep8.charo('|');
			Pep8.charo('\n');
		}
		// TODO ajouts des bateaux
		String entreeBateau = reccupererEntreeClavier();
		// Extraire les 5 premiers caracteres
		// int lengthentree =0;
		if (entreeBateau.length() > 4) {
			verificationBateau(entreeBateau);
		} else {
			Pep8.stro(ERREUR_ENTREE);
			Pep8.stro(DEMANDE_D_ENTREE);
		}
		// Valider le format de l'entree
		// taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] puis un espace

		// TODO ajouts des diffÃ©rents coups

		// TODO gÃ©rer les ricochets

		// TODO gÃ©rer la rÃ©cursivitÃ©

		Pep8.stop();

	}

	public static void erreurEntrée() {
		System.err.println("Le format de l'entrée ne respecte pas les paramètres indiqués!");
		Pep8.charo('\n');
		Pep8.stop();
	}
	
	public static void verificationBateau(String entreeBateau) {
		String bateau = entreeBateau.substring(0, 4);
		/// System.out.println("bateau = " + bateau);

		// verifier si l entree correspond aux parametres demandes

		char grandeurentree = bateau.charAt(0);
		char orientationentree = bateau.charAt(1);
		char colentree = bateau.charAt(2);
		char rangeentree = bateau.charAt(3);

		if (!(grandeurentree == 'p' || grandeurentree == 'm' || grandeurentree == 'g')) {
			erreurEntrée();
			//Pep8.stro("pmg****");
		} else if (!(orientationentree == 'h' || orientationentree == 'v')) {
			//Pep8.stro("g///////v");
			erreurEntrée();
		} else if (colentree < 'A' || colentree > 'R') {
			//Pep8.stro("colonne");
			erreurEntrée();
		} else if (rangeentree < '1' || rangeentree > '9') {
			//Pep8.stro("rangée");
			erreurEntrée();
		}
	}

}
