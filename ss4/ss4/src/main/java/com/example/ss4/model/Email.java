package com.example.ss4.model;

public class Email {
    private int id;
    private String languages;
    private int size;
    private boolean spamsFilter;
    private String signature;

    public Email() {
    }

    public Email(int id, String languages, int size, boolean spamsFilter, String signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
