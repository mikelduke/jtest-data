package com.mikelduke.jtest.data;

public enum DataType {
    ADDRESS_TYPE("address-type.json"),
    ADJECTIVES("adjectives.json"),
    ADVERBS("adverbs.json"),
    NOUNS("nouns.json"),
    PREPOSITIONS("prepositions.json"),
    STREET_NAMES("street-names.json"),
    STREET_PREFIXES("street-prefixes.json"),
    VERBS("verbs.json"),
    FIRST_NAMES("first-names.json"),
    LAST_NAMES("last-names.json");

    private String fileName;

    private DataType(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}