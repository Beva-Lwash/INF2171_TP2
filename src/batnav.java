
public class batnav {

	/***********************************************************/
	public static String recupererEntreeClavierBateau() {

		String DEMANDE_D_ENTREE = "Entrer la description et la position des bateaux \r\n"
				+ "selon le format suivant, separes par des espaces: \r\n"
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangee[1-9] \r\n" + "ex: ghC4 mvM2 phK9:\r\n";

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

	/***********************************************************/
	public static String recupererEntreeClavierCoups() {

		String DEMANDE_COUP = "Feu à volonté!  \n" + "(entrer les coups à tirer: colonne [A-R] rangée [1-9]) \n"
				+ "ex: A3 I5 M3 ";

		Pep8.charo('\n');

		Pep8.stro(DEMANDE_COUP);
		char entreeUsercarc;
		String entreeCoups = "";
		do {
			entreeUsercarc = Pep8.chari();
			entreeCoups = entreeCoups + entreeUsercarc;
		} while (entreeUsercarc != '\n');

		return entreeCoups;
	}

	/*********************************************************/
	public static void validationBateau(String unBateau) {

		char grandeurentree = unBateau.charAt(0);
		char orientationentree = unBateau.charAt(1);
		char colentree = unBateau.charAt(2);
		char rangeentree = unBateau.charAt(3);

		if (!(grandeurentree == 'p' || grandeurentree == 'm' || grandeurentree == 'g')) {
			erreurEntree();
		} else if (!(orientationentree == 'h' || orientationentree == 'v')) {
			erreurEntree();
		} else if (colentree < 'A' || colentree > 'R') {
			erreurEntree();
		} else if (rangeentree < '1' || rangeentree > '9') {
			erreurEntree();
		}
	}

	/***********************************************************/
	public static char[] validationCoup(String unCoup) {
		char[] coup = { ' ', ' ' };
		char colonne = unCoup.charAt(0);
		char rangee = unCoup.charAt(1);

		if (colonne >= 'A' && colonne <= 'R' && rangee >= '1' && rangee <= '9') {
			coup[0] = colonne;
			coup[1] = rangee;
		}
		return coup;
	}

	/**********************************************************/
	public static String[] verificationBateaux() {

		String entreeBateau = recupererEntreeClavierBateau();
		final String ESPACE = " ";
		String bateaux[] = entreeBateau.split(ESPACE);

		for (int i = 0; i < bateaux.length; i++) {
			if (bateaux[i].length() == 4 || bateaux[i].length() == 5) {
				validationBateau(bateaux[i]);
			} else {
				erreurEntree();
			}
		}
		return bateaux;
	}

	/***********************************************************/
	public static String[] verificationCoup() {
		String entreeCoups = recupererEntreeClavierCoups();
		final String ESPACE = " ";
		String coups[] = entreeCoups.split(ESPACE);

		for (int i = 0; i < coups.length; i++) {
			if (coups[i].length() == 2 || coups[i].length() == 3) {
				validationCoup(coups[i]);
			} else {
				erreurEntreeCoup();
			}
		}

		return coups;
	}

	/********************************************************/

	public static void erreurEntree() {
		System.err.println("Le format de l'entree ne respecte pas les parametres indiques!");
		verificationBateaux();
	}

	/*******************************************************/
	public static void erreurEntreeCoup() {
		System.err.println("Le format de l'entree ne respecte pas les parametres indiques!");
		verificationCoup();
	}

	/*******************************************************/
	public static void placementBateau(char[][] tableau, String[] bateau) {
		for (int i = 0; i < bateau.length; i++) {
			int longueurBateau = 0;
			if (bateau[i].charAt(0) == 'p') {
				longueurBateau = 1;
			} else if (bateau[i].charAt(0) == 'm') {
				longueurBateau = 3;
			} else if (bateau[i].charAt(0) == 'g') {
				longueurBateau = 5;
			}
			int temoinBateauPresent = 0;
			int ligneBateau = bateau[i].charAt(3) - 48;
			if (bateau[i].charAt(1) == 'h') {
				System.out.println(bateau[i]);
				int colonneBateau = bateau[i].charAt(2) - 64;
				if (bateau[i].charAt(2) - 64 + longueurBateau < 'R' - 64) {
					for (int j = 0; j < longueurBateau; j++) {
						if (tableau[ligneBateau - 1][colonneBateau + j - 1] == '>'
								|| tableau[ligneBateau - 1][colonneBateau + j - 1] == 'v') {
							temoinBateauPresent = 1;
						}
					}
					if (temoinBateauPresent == 0) {
						for (int x = 0; x < longueurBateau; x++) {
							tableau[ligneBateau - 1][colonneBateau + x - 1] = '>';
						}
					}
				}
			} else if (bateau[i].charAt(1) == 'v') {
				if (ligneBateau + longueurBateau < '9') {
					int colonneBateau = bateau[i].charAt(2) - 64;

					for (int y = 0; y < longueurBateau; y++) {
						if (tableau[ligneBateau - 1 + y][colonneBateau - 1] == '>'
								|| tableau[ligneBateau - 1 + y][colonneBateau - 1] == 'v') {
							temoinBateauPresent = 1;
						}
					}
					if (temoinBateauPresent == 0) {
						for (int z = 0; z < longueurBateau; z++) {
							tableau[ligneBateau - 1 + z][colonneBateau - 1] = 'v';
						}
					}
				}
			}
		}
	}

	/*******************************************************************************************************/

	public static void coupTire(char[][] tableau, char[] coupTire) {

		if ((coupTire.length == 2) && (coupTire[0] <= 'A' && coupTire[0] >= 'R')
				&& (coupTire[1] <= '1' && coupTire[1] >= '9')) {
			if (tableau[coupTire[1] - 50 - 1][coupTire[0] - 64 - 1] == 'v'
					|| tableau[coupTire[1] - 50 - 1][coupTire[0] - 64 - 1] == '>') {
				tableau[coupTire[1] - 50 - 1][coupTire[0] - 64 - 1] = '*';
				char cH = (char) (coupTire[1] - 1);
				char cG = (char) (coupTire[0] - 1);
				char cB = (char) (coupTire[1] + 1);
				char cD = (char) (coupTire[0] + 1);
				char[] coupTireHaut = { coupTire[0], cH };
				char[] coupTireBas = { coupTire[0], cB };
				char[] coupTireGauche = { cG, coupTire[1] };
				char[] coupTireDroit = { cD, coupTire[1] };
				if (cH >= '1') {
					coupTire(tableau, coupTireHaut);
				}
				if (cB <= '9') {
					coupTire(tableau, coupTireBas);
				}
				if (cG <= 'A') {
					coupTire(tableau, coupTireGauche);
				}
				if (cD >= 'R') {
					coupTire(tableau, coupTireDroit);
				}

			} else if (tableau[coupTire[1] - 50 - 1][coupTire[0] - 64 - 1] == '~') {
				tableau[coupTire[1] - 50 - 1][coupTire[0] - 64 - 1] = 'o';

			}
		}
	}


	public static void main(String[] args) {
		// TODO code application logic here
		String Bienvenue = "Bienvenue dans ce jeu de bataille navale!\n";
		Pep8.stro(Bienvenue);

		String Colonnes = "  ABCDEFGHIJKLMNOPQR";

		// TODO creer tableau
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

		String[] bateaux = verificationBateaux();
		System.out.println(bateaux.length);
		System.out.println(bateaux);
		for (int i = 0; i < bateaux.length; i++) {
		
		placementBateau(matrice, bateaux);
		}
		Pep8.stro(Colonnes);
		Pep8.charo('\n');

		for (int x = 0; x <= 8; x++) {
			Pep8.deco(x + 1);
			Pep8.charo('|');
			for (int y = 0; y <= 17; y++) {
				Pep8.charo(matrice[x][y]);
			}
			Pep8.charo('|');
			Pep8.charo('\n');
		}
		int tableaunonvide = 0;
		do {
			String[] coups = verificationCoup();
			for (int i = 0; i < coups.length; i++) {
				char[] coupActuel = { coups[i].charAt(0), coups[i].charAt(1) };
				coupTire(matrice, coupActuel);
				
				Pep8.stro(Colonnes);
				Pep8.charo('\n');
				for (int x = 0; x <= 8; x++) {
					Pep8.deco(x + 1);
					Pep8.charo('|');
					for (int y = 0; y <= 17; y++) {
						Pep8.charo(matrice[x][y]);

					}
					Pep8.charo('|');
					Pep8.charo('\n');
					Pep8.charo('\n');
				}
				
			}



			for (int x = 0; x <= 8; x++) {
				for (int y = 0; y <= 17; y++) {
					if (matrice[x][y] == 'v' || matrice[x][y] == '>') {
						tableaunonvide = 1;
					}

				}
			}

		} while (tableaunonvide == 0);

		
	Pep8.stro("Vous avez anéanti la flotte!!!!");

		Pep8.stop();

	}
}

