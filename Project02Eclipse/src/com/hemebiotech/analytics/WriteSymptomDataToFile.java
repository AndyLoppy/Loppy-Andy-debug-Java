package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     *
     * @param filepath a full or partial path to file where we write the symptom data
     */
    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void WriterSymptoms(TreeMap<String, Integer> mapSymptoms) {

        // Ecriture du resultat dans le fichier result.out
        try (FileWriter writer = new FileWriter(filepath)) {
            mapSymptoms.forEach((key, value) -> {
                try {
                    writer.write(key + " : " + value + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            // Exception si une erreur ce produit durant l'écriture
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier.");
        }
    }
}
