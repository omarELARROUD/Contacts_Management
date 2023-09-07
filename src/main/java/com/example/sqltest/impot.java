package com.example.sqltest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class impot {
    private double salaireAnnuel;
    private int nbEnfants;
    private boolean estMarie;

    public impot(double salaireAnnuel, int nbEnfants, boolean estMarie) {
        this.salaireAnnuel = salaireAnnuel;
        this.nbEnfants = nbEnfants;
        this.estMarie = estMarie;
    }

    public double calculerImpot() {
        double nbParts = (nbEnfants / 2.0) + (estMarie ? 2.0 : 1.0);
        if (nbEnfants >= 3) {
            nbParts += 0.5;
        }
        double revenuImposable = 0.72 * salaireAnnuel;
        double quotientFamilial = revenuImposable / nbParts;
        double impot = 0.0;
        for (Row row : getRows()) {
            if (quotientFamilial <= row.getSeuil()) {
                System.out.println(row.getSeuil());
                impot = row.getTaux() * revenuImposable - row.getDecote() * nbParts;
                break;
            }
        }
        return impot;
    }

    private List<Row> getRows() {
        DatabaseConnection conn = new DatabaseConnection();
        List<Row> rows = conn.getRows();
        conn.close();
        return rows;
    }
}
