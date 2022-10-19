/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jeuaventure;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author amadaryan
 */
public class JeuAventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jeuAventure_menuPrincipal(); // Appel de la fonction principale, permettant de lancer les jeux.
    }
    
    // Le processus affiche le menu, récupère la saisie du joueur quant aux options du menu.
    // Lance le jeu correspondant à la saisie, et stocke dans une variable le nombre de parties jouées.
    // Si la partie est gagnée, la valeur est également stockée dans une variable.
    static void jeuAventure_menuPrincipal() {
        int partiesGagnees = 0;
        int partiesJouees = 0;
        boolean jeuTermine = false;
        boolean resultat = false;
        int reponse = 0;
        
        do {
            afficherMenu();
            reponse = jeuAventure_saisirNombreIntervalle(1, 5);
            switch(reponse) {
                case 1: 
                    resultat = jeuSuite_principal();
                    break;
                case 2:
                    resultat = jeuTrain_principal();
                    break;
                case 3:
                    resultat = jeuCourse_principal();
                    break;
                case 4:
                    resultat = jeuDevin_principal();
            }
            if (resultat) {
                partiesGagnees++;
            }
            partiesJouees++;
        }
        while (reponse != 5);
        jeuTermine = true;
        afficherParties(partiesJouees, partiesGagnees);
    }
     
    // Processus qui affiche le menu avec les différentes options (4 jeux + quitter la partie).
    static void afficherMenu() {
        System.out.println("           \\\\\\||||||////\n"
                + "            \\\\  ~ ~  //\n"
                + "             (  @ @  )\n"
                + "    ______ oOOo-(_)-oOOo___________\n"
                + "\n"
                + "              \n"
                + "\t (1) trouver la suite " + "\n"
                + "\t (2) jeu du train " + "\n"
                + "\t (3) course en ligne " + "\n"
                + "\t (4) le devin " + "\n"
                + "\t (5) quitter " + "\n"
                + "\n"
                + "    _____________Oooo._____________\n"
                + "       .oooO     (   )\n"
                + "        (   )     ) /\n"
                + "         \\ (     (_/\n"
                + "          \\_)");
    }
    
    // Processu qui affiche le nombre parties jouées, ainsi que le nombre de parties gagnées.
    static void afficherParties(int partiesJouees, int partiesGagnees) {
    System.out.println("   .____________________.\n" +
        "   |.------------------.|\n" +
        "   ||                  ||\n" +
        "   ||    GAME OVER     ||\n" +
        "   ||Parties jouées:"+partiesJouees+"  ||\n" +
        "   ||                  ||\n" +
        "   ||Parties gagnées:"+partiesGagnees+" ||\n" +
        "   ||__________________||\n" +
        "   /.-.-.-.-.-.-.-.-.-.-\\\n" +
        "  /.-.-.-.-.-.-.-.-.-.-.-\\\n" +
        " /.-.-.-.-.-.-.-.-.-.-.-.-\\\n" +
        "/______/__________\\___o____\\    \n" +
        "\\__________________________"
                + "/");
    }
    
    // Fonction qui récupère la saisie de l'utilisateur.
    static int jeuAventure_saisirNombre(){
        int val;
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();
        return val;
    }
    
    // Cette fonction sera utilisée par tous les jeux. 
    // Elle demande à l'utilisateur de saisir un niveau de difficulté entre 1 et 3 et le retourne. 
    // Si le niveau n'est pas valide, l'utilisateur est invité à en saisir un autre.
    static int jeuAventure_saisirNombreIntervalle(int min, int max){
        int val;
        do {
            System.out.println("Saisir un nombre entre " + min + " et " + max);
            val = jeuAventure_saisirNombre();
        } while (!(val >= min && val <= max));
        return val;
    }
    
    // Cette fonction sera utilisée par tous les jeux. 
    // Elle demande à l'utilisateur de saisir un niveau de difficulté entre 1 et 3 et le retourne. 
    // Si le niveau n'est pas valide, l'utilisateur est invité à en saisir un autre.
    static int jeuAventure_saisirNiveauDifficulte() {
        int saisirNombre = 0;
        do {
            System.out.println("Niveau de difficulté entre 1 et 3 :");
            saisirNombre = jeuAventure_saisirNombre(); // Utilise un
        }
        while ((saisirNombre <= 0 || saisirNombre >= 4));
        return saisirNombre;
    }
    
    // Fonction qui génère un nombre aléatoire compris entre maxi et mini.
    static int jeuAventure_nombreAleatoire(int mini, int maxi) {
        Random random = new Random();
        int valeur = random.nextInt(maxi - mini + 1) + mini;
        return valeur;
    }

    /*
        *********
        JEU SUITE
        *********
    */
    
    // Cette fonction est la fonction principale du jeu Suite. 
    // Elle permet d'afficher les règles, de saisir le niveau de difficulté, de lancer le jeu et d'afficher les résultats. 
    // Elle retourne vrai si le jeu est réussi, faux sinon.
    static boolean jeuSuite_principal() {
        int niveauDifficulte = 0;
        char formeChoisie;
        boolean jeuReussi = false;
        
        jeuSuite_afficherRegles();
        niveauDifficulte = jeuAventure_saisirNiveauDifficulte();
        jeuSuite_partie(niveauDifficulte);
        formeChoisie = jeuSuite_saisirForme();
        if (formeChoisie == jeuSuite_formeCorrecte(niveauDifficulte)) {
            jeuReussi = true;
            System.out.println("Bravo, tu as trouvé la bonne forme !");
        }
        else {
            jeuReussi = true;
            System.out.println("Perdu, essaie encore.");            
        }
        return jeuReussi;
    }
    
    // Ce processus affiche les règles du jeu.
    static void jeuSuite_afficherRegles() {
        System.out.println("Les règles : comprendre la suite logique et indiquez quelle est la prochaine forme");
    }
    
    // En fonction du niveau de difficulté, 
    static boolean jeuSuite_partie(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 1:
                jeuSuite_afficherFormes('♣', '♥', '♣', '♥', ' ');
                break;
            case 2:
                jeuSuite_afficherFormes('♥', '♥', '♣', '♣', ' ');
                break;
            default:
                jeuSuite_afficherFormes('♣', '♥', '♠', '♣', ' ');
        }
        return false;
    }
    
    // Affiche un tableau contenant une suite de formes.
    static void jeuSuite_afficherFormes(char c1, char c2, char c3, char c4, char c5) {
        System.out.println(" " + "-" + " " + "-" + " " + "-" + " " + "-" + " " + "-" + " ");
        System.out.println("|" + c1 + "|" + c2 + "|" + c3 + "|" + c4 + "|" + c5 + "|" + " ");
        System.out.println(" " + "-" + " " + "-" + " " + "-" + " " + "-" + " " + "-" + " ");
    }
   
    // Demande au joueur d'insérer une lettre (t, c, ou p) et retourne la valeur saisie.
    static char jeuSuite_saisirForme() {
        System.out.println("Saisissez une lettre t(♣) ou c(♥) ou p(♠)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char saisie = str.charAt(0);
        return saisie;
    }
    
    // En fonction du niveau de difficulte (1 à 3), retourne la réponse attendue.
    static char jeuSuite_formeCorrecte(int niveauDifficulte) {
        char formeSaisie;
        switch(niveauDifficulte) {
            case 1:
                formeSaisie = 't';
                break;
            case 2:
                formeSaisie = 'c';
            break;
            default:
                formeSaisie = 'c';
        }
        return formeSaisie;
    }  
    
    /*
        *********
        JEU TRAIN
        *********
    */

    // Cette fonction est la fonction principale du jeu Train. 
    // Elle permet d'afficher les règles, de saisir le niveau de difficulté, de lancer le jeu. 
    // Elle retourne vrai si le jeu a été réussi, faux sinon.
    static boolean jeuTrain_principal() {
        boolean jeuReussi = false;
        jeuTrain_afficherRegles();
        
        System.out.println("Saisir un nombre entre 1 et 3 :");

        int niveauDifficulte = jeuAventure_saisirNiveauDifficulte();
        if (jeuTrain_partie(niveauDifficulte)) {
            jeuReussi = true;
        }
        
        return jeuReussi;
    }
    
    // Ce processus affiche les règles du jeu.
    static void jeuTrain_afficherRegles() {
        System.out.println("Voici les règles : comptez le nombre de passagers qui attendent le train et saisir le nombre de wagons.");
    }
    
    // Cette fonction tire aléatoirement le nombre d'usagers en fonction du niveau de difficulté.
    // Affiche autant de smileys qu'il y a d'usagers.
    // Demande à l'utilisateur de saisir le nombre de wagons à affecter (toutes les réponses sont valables, 
    // pas besoin de demander au joueur de resaisir une valeur s'il n'est pas dans l'intervalle désiré).
    // Affiche le résultat comme spécifié plus haut.
    // Retourne vrai si la réponse du joueur est bonne, faux sinon.
    static boolean jeuTrain_partie(int niveauDifficulte) {
        
        int nombreAleatoire = 0;
        int nombreChoisi = 0;
        

        switch(niveauDifficulte) {
            case 1:
                nombreAleatoire = jeuAventure_nombreAleatoire(1, 2);
                break;
            case 2:
                nombreAleatoire = jeuAventure_nombreAleatoire(1, 3);
                break;
            default:
                nombreAleatoire = jeuAventure_nombreAleatoire(1, 4);
        }
        
        jeuTrain_nombreDePassagers(nombreAleatoire);
        System.out.println("Combien de wagons faut-il ajouter ?");
        nombreChoisi = jeuAventure_saisirNombre();
        
        // Si le nombre de personnes est différent du nombre wagons choisis.
        if (nombreAleatoire != nombreChoisi) {
            jeuTrain_nombreDeWagons(nombreAleatoire, nombreChoisi);
        }
        else {
            System.out.println("Bravo !");
        }
        return false;
    }
    
    // Processus qui affiche le nombre de passagers sous forme de smileys.
    static void jeuTrain_nombreDePassagers(int nombreAleatoire) {
        char smileys = '☺';
        for (int i = 0; i < nombreAleatoire; i++) {
            System.out.print(smileys);
        }         
        System.out.println();
    }
    
    // Processus qui affiche la forme du wagon en fonction des valeurs saisis par le joueur.
    static void jeuTrain_nombreDeWagons(int nombreDePassagers, int nombreDeWagonsChoisi) {
        int resultat = nombreDeWagonsChoisi - nombreDePassagers;
        if (nombreDePassagers < nombreDeWagonsChoisi) {
            for (int i = 0; i < resultat; i++) {
                jeuTrain_wagonVide();
            }           
            for (int i = 0; i < nombreDePassagers; i++) {
                jeuTrain_wagonPlein();
            }
            jeuTrain_wagon();
            System.out.println("Perdu. Tu as mis trop de wagons. ");
        } else {
            resultat = nombreDePassagers - nombreDeWagonsChoisi;
            
            for (int i = 0; i < nombreDePassagers - resultat; i++) {
                jeuTrain_wagonPlein();
            }
            jeuTrain_wagon();
            
            System.out.print("Perdu, voici les usagers qui restent à quai : " );
            jeuTrain_nombreDePassagers(resultat);
        }
    }
    
    // Affiche forme du wagon vide.
    static void jeuTrain_wagonVide() {
        System.out.println(""
            + "  —————\n"
            + "  |   |\n"
            + "  |   |\n"
            + "  |   |\n"
            + "  —————\n"
            + "    |  "
        );
    }
    
    // Affiche forme du wagon plein.
    static void jeuTrain_wagonPlein() {
        System.out.println(""
            + "  —————\n"
            + "  |   |\n"
            + "  | ☺ |\n"
            + "  |   |\n"
            + "  —————\n"
            + "    |  "
        );
    }
    
    // Affiche forme de la tête du wagon.
    static void jeuTrain_wagon() {
        System.out.println("    |\n"
            + "   |||\n"
            + " .-----.\n"
            + " |o< >o|\n"
            + "//// \\\\\\\\\n"
            + "  /---\\ \n"
            + " /-----\\"
        );
    }
    
    /*
        **********
        JEU COURSE
        **********
    */
    
    // Cette fonction est la fonction principale du jeu Course. 
    // Elle permet d'afficher les règles, de saisir le niveau de difficulté, de lancer le jeu. 
    // Elle retourne vrai si le jeu a été réussi, faux sinon.
    static boolean jeuCourse_principal() {
        boolean jeuReussi = false;  
        jeuCourse_afficherRegles();
        jeuCourse_afficherCourse(1, 1, 1);
        return jeuReussi;
    }
        
    
    static void jeuCourse_afficherRegles() {
        System.out.println("Ce jeu se joue à deux. Le premier joueur qui fait passer la ligne d'arrivée à un joueur a gagné.");
        System.out.println("A chaque tour, un seul pion se déplace de 1, 2, ou 3 cases.");
        System.out.println("Excepté au démarrage, deux pions ne peuvent pas être positonnés au même endroit.");
    }
    
    static void jeuCourse_afficherCourse(int posJ1, int posJ2, int posJ3) {
        char c = '♥';
        char t = '♣';
        char p = '♠';
        char pos = ' ';
        
        System.out.println(" - - - - - - - - - ARRIVEE");
        // JOUEUR 1
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            if (i == posJ1) {
                System.out.print(c);
            } else {
                System.out.print(pos);
            }
        }
        System.out.println("|");
        // JOUEUR 2
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            if (i == posJ2) {
                System.out.print(t);
            } else {
                System.out.print(pos);
            }
        }
        System.out.println("|");
        // JOUEUR 3
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            if (i == posJ3) {
                System.out.print(p);
            } else {
                System.out.print(pos);
            }
        }
        System.out.println("|");
        System.out.println(" - - - - - - - - - ARRIVEE");
    }
    
    static int jeuCourse_joueurSuivant(int joueurActif) {
        
        return joueurActif;
    }
    
    
    
    // Cette fonction est la fonction principale du jeu Devin. 
    // Elle permet d'afficher les règles, de saisir le niveau de difficulté, de lancer le jeu. 
    // Elle retourne vrai si le jeu a été réussi, faux sinon.
    static boolean jeuDevin_principal() {
        int n = 0;
        boolean jeuReussi = false;
            
        jeuDevin_afficherRegles();
        n = jeuAventure_saisirNiveauDifficulte();  

        if (jeuDevin_partie(n)) {
            jeuReussi = true;
        }
        
        return jeuReussi;
    }
    
    // Cette fonction tire aléatoirement un intervalle de nombre, et détermine un combre de coups possibles en fonction du niveau de difficulté choisi.
    // Elle passe ses valeurs en paramètre de la fonction jeuDevin_chercherNombre()
    // Elle retourne vrai ou faux si la partie est réussie.
    static boolean jeuDevin_partie(int niveauDifficulte) {
        int c = 10;
        int nombreAleatoire = 0;
        int nombreMax = 0;
        boolean partieReussie = false;
        
        switch(niveauDifficulte) {
            case 1:
                c = 5;
                nombreMax = 10;
                nombreAleatoire = jeuAventure_nombreAleatoire(0, nombreMax);
                break;
            case 2:
                nombreMax = 50;
                nombreAleatoire = jeuAventure_nombreAleatoire(0, nombreMax);
                break;
            default:
                nombreMax = 100;
                nombreAleatoire = jeuAventure_nombreAleatoire(0, nombreMax);
        }
        partieReussie = jeuDevin_chercherNombre(nombreAleatoire, c, nombreMax, partieReussie);
        return partieReussie;
    }
    
    // Cette fonction permet au joueur de chercher le nombre aléatoire en un certain nombre de coups.
    // Elle guide le joueur en indiquant si le nombre cherché est plus petit ou plus grand que la valeur saisie.
    // Elle retourne vrai ou faux si la partie est réussie.
    static boolean jeuDevin_chercherNombre(int nombreAleatoire, int c, int nombreMax, boolean partieReussie) {
        int i = c;
        int nombreSaisi = 0;
        
        do {
            System.out.println("**********************");
            System.out.println("Vous devez saisir un nombre entre : 0 et " + nombreMax);
            System.out.println("Il vous reste " + i + " coups à jouer.");
            System.out.println("Veuillez saisir un nombre entre : 0 et " + nombreMax);
            nombreSaisi = jeuAventure_saisirNombre();

            if (nombreSaisi < nombreAleatoire) {
                System.out.println("Nombre proposé trop petit.");
            } else {
                System.out.println("Nombre proposé trop grand.");
            }
            i--;
        } while (nombreSaisi != nombreAleatoire && i > 0);
        
        if (nombreSaisi != nombreAleatoire) {
            System.out.println("Perdu !");
            partieReussie = false;
        } else {
            System.out.println("Gagné !");
            partieReussie = true;
        }
        return partieReussie;
    }

     // Ce processus affiche les règles du jeu.
    static void jeuDevin_afficherRegles() {
        System.out.println("Niveau de difficulté disponibles :");
        System.out.println("1 :  5 coups pour trouver un nombre entre 0 et 10.");
        System.out.println("2 : 10 coups pour trouver un nombre entre 0 et 50.");
        System.out.println("3 : 10 coups pour trouver un nombre entre 0 et 100.");
    }
}
