/*
public class batnav {

	//
	public static String recupererEntreeClavier() {

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
		System.err.println("Le format de l'entrée ne respecte pas les paramètres indiqués!");
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
    	int t�moinBateauPr�sent=0;
    	int ligneBateau = bateau.charAt(3)-48;
		if(bateau.charAt(1)=='h') {
    		System.out.println(bateau);
    		int colonneBateau=bateau.charAt(2)-64;
    		if(bateau.charAt(2)-64+longueurBateau < 'R'-64) {
    			for(int i=0; i<longueurBateau;i++) {
    				if(tableau[ligneBateau-1][colonneBateau+i-1] == '>'|| tableau[ligneBateau-1][colonneBateau+i-1] == 'v') {
    					t�moinBateauPr�sent=1;
    				}
    			}
    			if(t�moinBateauPr�sent==0) {
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
    					t�moinBateauPr�sent=1;
    				}
    			}
    			if(t�moinBateauPr�sent==0) {
    				for(int i=0; i<longueurBateau;i++) {
    					tableau[ligneBateau-1+i][colonneBateau-1]='v';
    				}
    			}
    		}
    	}
    	
    }

	*//**
	 * @param args the command line arguments
	 *//*
	public static void main(String[] args) {
		// TODO code application logic here
		String Bienvenue = "Bienvenue dans ce jeu de bataille navale!\n";
		Pep8.stro(Bienvenue);

		String DEMANDE_D_ENTREE = "Entrer la description et la position des bateaux \r\n"
				+ "selon le format suivant, separes par des espaces: \r\n"
				+ "taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] \r\n" + "ex: ghC4 mvM2 phK9:\r\n";

		// String ERREUR_ENTREE = "Le format de l'entrée ne respecte pas les
		// paramètres indiqués!";

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
		String bateau = traitementBateau();
		Pep8.stro(bateau);
		placementBateau(matrice,bateau);
		// Valider le format de l'entree
		// taille[p/m/g] orientation[h/v] colonne[A-R] rangÃ©e[1-9] puis un espace
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
		// TODO ajouts des diffÃ©rents coups

		// TODO gÃ©rer les ricochets

		// TODO gÃ©rer la rÃ©cursivitÃ©

		Pep8.stop();

	}
}
*/



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class batnav {
    
    /***********************************************************/
    public static String recupererEntreeClavier() {
    
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
    public static String[] verificationBateaux() {

        String entreeBateau = recupererEntreeClavier();
        final String ESPACE = " ";
        String bateaux[] = entreeBateau.split(ESPACE);
        
        for (int i = 0; i < bateaux.length; i++) {
            if (bateaux[i].length() == 4 || bateaux[i].length() == 5){
                validationBateau(bateaux[i]);
            }else{
                erreurEntree();
            }
        }
       return bateaux;
    }
    
    /***********************************************************/ 
    public static void erreurEntree() {
        System.err.println("Le format de l'entrée ne respecte pas les paramètres indiqués!");
        verificationBateaux();
    }

    /***********************************************************/
    public static void placementBateau(char[][] tableau, String[] bateau) {
        
        
        
        for (int i = 0; i < bateau.length; i++) {
            int longueurBateau=0;
            if(bateau[i].charAt(0)=='p') {
                    longueurBateau=1;
            }else if(bateau[i].charAt(0)=='m'){
                    longueurBateau=3;
            }else if(bateau[i].charAt(0)=='g') {
                    longueurBateau=5;
            }
            int temoinBateauPresent=0;
            int ligneBateau = bateau[i].charAt(3)-48;
                    if(bateau[i].charAt(1)=='h') {
                    System.out.println(bateau[i]);
                    int colonneBateau=bateau[i].charAt(2)-64;
                    if(bateau[i].charAt(2)-64+longueurBateau < 'R'-64) {
                            for(int j=0; j<longueurBateau;j++) {
                                    if(tableau[ligneBateau-1][colonneBateau+j-1] == '>'|| tableau[ligneBateau-1][colonneBateau+j-1] == 'v') {
                                            temoinBateauPresent=1;
                                    }
                            }
                            if(temoinBateauPresent==0) {
                                    for(int x=0; x<longueurBateau;x++) {
                                            tableau[ligneBateau-1][colonneBateau+x-1]='>';
                                    }
                            }
                    }
            }else if(bateau[i].charAt(1)=='v'){
                    if(ligneBateau+longueurBateau < '9') {
                            int colonneBateau=bateau[i].charAt(2)-64;

                            for(int y=0; y<longueurBateau;y++) {
                                    if(tableau[ligneBateau-1+y][colonneBateau-1] == '>'|| tableau[ligneBateau-1+y][colonneBateau-1] == 'v') {
                                            temoinBateauPresent=1;
                                    }
                            }
                            if(temoinBateauPresent==0) {
                                    for(int z=0; z<longueurBateau;z++) {
                                            tableau[ligneBateau-1+z][colonneBateau-1]='v';
                                    }
                            }
                    }
            }
        }
    }
    /*******************************************************************************************************/
    
    public static void coupTire(char[][] tableau,char[] coupTire) {
    	int cH=coupTire[0]-1;
    	char[] coupTireHaut= {cH,coupTire[1]};
    	if((coupTire.length== 2)&&(coupTire[0]<='A' && coupTire[0]>='R' )&& (coupTire[1]<='1' && coupTire[1]>='9') ) {
    		if(tableau[coupTire[1]-50-1][coupTire[0]-64-1]=='v' || tableau[coupTire[1]-50-1][coupTire[0]-64-1]=='>') {
    			tableau[coupTire[1]-50-1][coupTire[0]-64-1]='*';
    		}else if(tableau[coupTire[1]-50-1][coupTire[0]-64-1]=='~') {
    			tableau[coupTire[1]-50-1][coupTire[0]-64-1]='o';
    			char coupTireH=coupTire(tableau,coupTireHaut);
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
       
        //for (int i = 0; i < bateaux.length; i++) {
            //Pep8.stro(bateaux[0]);
            //String test = bateaux[0];
            // placer les bateaux
            placementBateau(matrice,bateaux);

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

        //}
        
        
        
        // TODO ajouts des diffÃ©rents coups

        // TODO gÃ©rer les ricochets

        // TODO gÃ©rer la rÃ©cursivitÃ©

        Pep8.stop();

    }	    
}
