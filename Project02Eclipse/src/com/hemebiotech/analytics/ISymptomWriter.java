package com.hemebiotech.analytics;

import java.util.TreeMap;

public interface ISymptomWriter {
    /**
     * Ecris dans le fichier si la map contient des symtomes
     */
    void WriterSymptoms (TreeMap<String, Integer> mapSymptoms);
}
