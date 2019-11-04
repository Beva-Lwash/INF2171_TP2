/*
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

	*//**
		 * @param args the command line arguments
		 *//*
			 * public static void main(String[] args) { // TODO code application logic here
			 * 
			 * String Bienvenue = "Bienvenue dans ce jeu de bataille navale!\n";
			 * Pep8.stro(Bienvenue);
			 * 
			 * String DEMANDE_D_ENTREE =
			 * "Entrer la description et la position des bateaux \r\n" +
			 * "selon le format suivant, separes par des espaces: \r\n" +
			 * "taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] \r\n" +
			 * "ex: ghC4 mvM2 phK9:\r\n";
			 * 
			 * String ERREUR_ENTREE =
			 * "Le format de l'entrée ne respecte pas les paramètres indiqués!";
			 * 
			 * String Colonnes = "  ABCDEFGHIJKLMNOPQR"; // Grandeur char p = 'p'; // petit
			 * char m = 'm'; // moyen char g = 'g'; // grand // Orientation char h = 'h'; //
			 * horizontal char v = 'v'; // vertical // TODO crÃ©Ã©r tableau char[][] matrice
			 * = new char[9][18];
			 * 
			 * for (int i = 0; i <= 8; i++) { for (int j = 0; j <= 17; j++) { matrice[i][j]
			 * = '~'; } }
			 * 
			 * Pep8.stro(Colonnes); Pep8.charo('\n'); for (int i = 0; i <= 8; i++) {
			 * Pep8.deco(i + 1); Pep8.charo('|'); for (int j = 0; j <= 17; j++) {
			 * Pep8.charo(matrice[i][j]); } Pep8.charo('|'); Pep8.charo('\n'); } // TODO
			 * ajouts des bateaux String entreeBateau = reccupererEntreeClavier(); //
			 * Extraire les 5 premiers caracteres // int lengthentree =0; if
			 * (entreeBateau.length() > 4) { verificationBateau(entreeBateau); } else {
			 * Pep8.stro(ERREUR_ENTREE); Pep8.stro(DEMANDE_D_ENTREE); } // Valider le format
			 * de l'entree // taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] puis
			 * un espace
			 * 
			 * // TODO ajouts des diffÃ©rents coups
			 * 
			 * // TODO gÃ©rer les ricochets
			 * 
			 * // TODO gÃ©rer la rÃ©cursivitÃ©
			 * 
			 * Pep8.stop();
			 * 
			 * }
			 * 
			 * public static void erreurEntrée() { System.err.
			 * println("Le format de l'entrée ne respecte pas les paramètres indiqués!");
			 * Pep8.charo('\n'); Pep8.stop(); }
			 * 
			 * public static void verificationBateau(String entreeBateau) { String bateau =
			 * entreeBateau.substring(0, 4); /// System.out.println("bateau = " + bateau);
			 * 
			 * // verifier si l entree correspond aux parametres demandes
			 * 
			 * char grandeurentree = bateau.charAt(0); char orientationentree =
			 * bateau.charAt(1); char colentree = bateau.charAt(2); char rangeentree =
			 * bateau.charAt(3);
			 * 
			 * if (!(grandeurentree == 'p' || grandeurentree == 'm' || grandeurentree ==
			 * 'g')) { erreurEntrée(); //Pep8.stro("pmg****"); } else if
			 * (!(orientationentree == 'h' || orientationentree == 'v')) {
			 * //Pep8.stro("g///////v"); erreurEntrée(); } else if (colentree < 'A' ||
			 * colentree > 'R') { //Pep8.stro("colonne"); erreurEntrée(); } else if
			 * (rangeentree < '1' || rangeentree > '9') { //Pep8.stro("rangée");
			 * erreurEntrée(); } }
			 * 
			 * }
			 */

public class batnav {

	//
	public static String recupererEntreeClavier() {

		String DEMANDE_D_ENTREE = "Entrer la description et la position des bateaux \r\n"
				+ "selon le format suivant, separes par des espaces: \r\n"
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangÃƒÂ©e[1-9] \r\n" + "ex: ghC4 mvM2 phK9:\r\n";

		Pep8.charo('\n');

		Pep8.stro(DEMANDE_D_ENTREE);
		char entreeUsercarc;
		String entreeBateau = "";
		do {
			entreeUsercarc = Pep8.chari();
			entreeBateau = entreeBateau + entreeUsercarc;
		} while (entreeUsercarc != '\n');

		System.out.println("JE SUIS dans recupererEntreeClavier!!!!!!!!!!!");
		return entreeBateau;
	}

	public static void verificationBateau(String entreeBateau) {
		String bateau = entreeBateau.substring(0, 4);

		// verifier si l entree correspond aux parametres demandes

		char grandeurentree = bateau.charAt(0);
		char orientationentree = bateau.charAt(1);
		char colentree = bateau.charAt(2);
		char rangeentree = bateau.charAt(3);
		System.out.println("JE SUIS dans verificationBateau!!!!!!!!!!!");
		if (!(grandeurentree == 'p' || grandeurentree == 'm' || grandeurentree == 'g')) {
			System.out.println("JE SUIS dans le if de la verification grandeur!!!!!!!!!!!");
			erreurEntree();
			traitementBateau();
		} else if (!(orientationentree == 'h' || orientationentree == 'v')) {
			erreurEntree();
			traitementBateau();
		} else if (colentree < 'A' || colentree > 'R') {
			erreurEntree();
			traitementBateau();
		} else if (rangeentree < '1' || rangeentree > '9') {
			erreurEntree();
			traitementBateau();
		}
	}

	public static String traitementBateau() {
		String entreeBateau = recupererEntreeClavier();
		// Extraire les 5 premiers caracteres
		// int lengthentree =0;
		if (entreeBateau.length() > 4) {
			verificationBateau(entreeBateau);
			System.out.println("JE SUIS dans traitementBateau!!!!!!!!!!!");
		} else {
			erreurEntree();
			// Pep8.stro(DEMANDE_D_ENTREE);

		}
		return entreeBateau.substring(0, 4);
	}

	public static void erreurEntree() {
		System.err.println("Le format de l'entrÃ©e ne respecte pas les paramÃ¨tres indiquÃ©s!");
		Pep8.charo('\n');
		// Pep8.stop();
		// recupererEntreeClavier();
	}

	public static void placementBateau(char[][] tableau, String bateau) {
    	int longueurBateau=0;
    	if(bateau.charAt(0)=='p') {
    		longueurBateau=1;
    	}else if(bateau.charAt(0)=='m'){
    		longueurBateau=3;
    	}else if(bateau.charAt(0)=='g') {
    		longueurBateau=5;
    	}
    	int témoinBateauPrésent=0;
    	int ligneBateau = bateau.charAt(3)-48;
		if(bateau.charAt(1)=='h') {
    		System.out.println(bateau);
    		int colonneBateau=bateau.charAt(2)-64;
    		if(bateau.charAt(2)-64+longueurBateau < 'R'-64) {
    			for(int i=0; i<longueurBateau;i++) {
    				if(tableau[ligneBateau-1][colonneBateau+i-1] == '>'|| tableau[ligneBateau-1][colonneBateau+i-1] == 'v') {
    					témoinBateauPrésent=1;
    				}
    			}
    			if(témoinBateauPrésent==0) {
    				for(int i=0; i<longueurBateau;i++) {
    					tableau[ligneBateau-1][colonneBateau+i-1]='>';
    				}
    			}
    		}
    	}else if(bateau.charAt(1)=='v'){
    		if(ligneBateau+longueurBateau < '9') {
    			int colonneBateau=bateau.charAt(2)-64;
    			
    			for(int i=0; i<longueurBateau;i++) {
    				if(tableau[ligneBateau-1+i][colonneBateau-1] == '>'|| tableau[ligneBateau-1+i][colonneBateau-1] == 'v') {
    					témoinBateauPrésent=1;
    				}
    			}
    			if(témoinBateauPrésent==0) {
    				for(int i=0; i<longueurBateau;i++) {
    					tableau[ligneBateau-1+i][colonneBateau-1]='v';
    				}
    			}
    		}
    	}
    	
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
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangÃƒÂ©e[1-9] \r\n" + "ex: ghC4 mvM2 phK9:\r\n";

		// String ERREUR_ENTREE = "Le format de l'entrÃ©e ne respecte pas les
		// paramÃ¨tres indiquÃ©s!";

		String Colonnes = "  ABCDEFGHIJKLMNOPQR";
		// Grandeur
		char p = 'p'; // petit
		char m = 'm'; // moyen
		char g = 'g'; // grand
		// Orientation
		char h = 'h'; // horizontal
		char v = 'v'; // vertical
		// TODO crÃƒÂ©ÃƒÂ©r tableau
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
		String bateau = traitementBateau();
		Pep8.stro(bateau);
		placementBateau(matrice,bateau);
		// Valider le format de l'entree
		// taille[p/m/g] orientation[h/v] colonne[A-R] rangÃƒÂ©e[1-9] puis un espace
//		Pep8.charo('\n');
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
		// TODO ajouts des diffÃƒÂ©rents coups

		// TODO gÃƒÂ©rer les ricochets

		// TODO gÃƒÂ©rer la rÃƒÂ©cursivitÃƒÂ©

		Pep8.stop();

	}
}
