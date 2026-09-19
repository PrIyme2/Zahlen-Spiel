package model;

/**
 * Das Model verwaltet die Daten und den Spielstand des Gewinnspiels.
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }

    public int getComputerZahl() {
        return this.computerZahl;
    }

    public int getSpielerZahl() {
        return this.spielerZahl;
    }

    public int getRundenErgebnis() {
        return this.rundenErgebnis;
    }
}