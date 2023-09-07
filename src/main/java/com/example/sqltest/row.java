package com.example.sqltest;

class Row {
    private double seuil;
    private double taux;
    private double decote;

    public Row(double seuil, double taux, double decote) {
        this.seuil = seuil;
        this.taux = taux;
        this.decote = decote;
    }

    public double getSeuil() {
        return seuil;
    }

    public double getTaux() {
        return taux;
    }

    public double getDecote() {
        return decote;
    }
}