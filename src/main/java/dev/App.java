package dev;

import dev.config.AppConfig;
import dev.dao.PlatDaoFichier;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion1;
import dev.service.PlatServiceVersion2;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

    	// Création du contexte Spring à partir d'une configuration Java
    	  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    	
    	/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
    			("application-config.xml");
    			  Scanner scanner = context.getBean(Scanner.class);

    	
        

        PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();

        // TODO adapter le chemin du fichier (utiliser un rÃ©pertoire existant)
        PlatDaoFichier platDaoFichier = new PlatDaoFichier("C:/Users/diginamic/Documents/workspace-sts-3.8.4.RELEASE/restaurant-console-app/src/main/resources/restaurant.txt");

        PlatServiceVersion1 platServiceVersion1 = new PlatServiceVersion1(platDaoFichier);
        PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);

        Menu menu = new Menu(scanner, platServiceVersion1);

        
        menu.afficher();*/

    			// récupération du bean Menu
    			  Menu menu = context.getBean(Menu.class);
    			  menu.afficher();
    			  // fermeture du Scanner
    			  context.getBean(Scanner.class).close();
    			  // fermeture du contexte Spring
    			  context.close();



    }
}
