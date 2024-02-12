package com.hemebiotech.analytics;

import java.util.TreeMap;

public class AnalyticsCounter {
	public static void main(String args[]) {

		//Entité qui posséde la méthode pour lire un fichier
		ReadSymptomDataFromFile symptoms = new ReadSymptomDataFromFile("./symptoms.txt");

		//Methode qui lit le fichier
		TreeMap<String, Integer> mapSymptoms = symptoms.GetSymptoms();

		//Entité qui posséde la méthode pour ecrire un fichier
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");

		//Methode qui ecrit le fichier
		writer.WriterSymptoms(mapSymptoms);
	}
}
