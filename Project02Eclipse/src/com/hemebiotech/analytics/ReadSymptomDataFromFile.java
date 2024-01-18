package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public TreeMap<String, Integer> GetSymptoms() {

		// Creation d'un Map pour stocker les Symptomes TreeMap pour un tri alphabétique naturel
		TreeMap<String, Integer> mapSymptoms = new TreeMap<>();

		// Lecture du fichier avec un try with ressources pour fermeture automatiquement du fichier
		try (Scanner scanner = new Scanner(new File("./symptoms.txt"))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				mapSymptoms
						.put(line, mapSymptoms.get(line) == null ?
								1 : mapSymptoms.get(line) + 1);
			}
		} catch (FileNotFoundException e) {
			// Gestion de l'exception si le fichier n'a pas été trouvé
			System.out.println("Le fichier n'a pas été trouvé.");
		}

		return mapSymptoms;
	}

}
