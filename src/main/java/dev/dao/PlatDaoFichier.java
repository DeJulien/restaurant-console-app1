package dev.dao;

import dev.entite.Plat;

import dev.exception.PlatException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import static java.util.stream.Collectors.toList;

@Repository
public class PlatDaoFichier implements IPlatDao {

    private String fichierStockage;

    public PlatDaoFichier(@Value("${dossierStockage}") String dossierStockage) {
        this.fichierStockage = dossierStockage;
        if (!Files.exists(Paths.get(fichierStockage))) {
            try {
                Files.createFile(Paths.get(fichierStockage));
            } catch (IOException e) {
                throw new PlatException("Impossible de créer le fichier " + fichierStockage, e);
            }
        }
        ;
    }

    @Override
    public List<Plat> listerPlats() {
        try {
            return Files.lines(Paths.get(fichierStockage))
                    .map(uneLigne -> {
                        String[] strings = uneLigne.split(";");
                        return new Plat(strings[0], Integer.valueOf(strings[1]));
                    })
                    .collect(toList());
        } catch (IOException e) {
            throw new PlatException("fichier non trouvé " + fichierStockage);
        }
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        String nouveauPlat = nomPlat + ";" + prixPlat;

        try {
            Files.write(Paths.get(fichierStockage), Collections.singletonList(nouveauPlat), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new PlatException("fichier non trouvé " + fichierStockage);
        }
    }
}
