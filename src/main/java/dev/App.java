package dev;

import dev.dao.PlatDaoFichier;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion1;
import dev.service.PlatServiceVersion2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();

        // TODO adapter le chemin du fichier (utiliser un répertoire existant)
        PlatDaoFichier platDaoFichier = new PlatDaoFichier("C:/Users/diginamic/Documents/workspace-sts-3.8.4.RELEASE/restaurant-console-app/src/main/resources/restaurant.txt");

        PlatServiceVersion1 platServiceVersion1 = new PlatServiceVersion1(platDaoFichier);
        PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);

        Menu menu = new Menu(scanner, platServiceVersion1);

        menu.afficher();

        scanner.close();


    }
}
