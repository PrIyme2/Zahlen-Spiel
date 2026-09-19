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

    public void berechneComputerZahl() {
        int r = (int) (Math.random() * 9) + 1;
        this.computerZahl = r;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();
        if (this.spielerZahl == this.computerZahl) {
            this.rundenErgebnis = 20;
        } else if (this.spielerZahl == this.computerZahl - 1 || this.spielerZahl == this.computerZahl + 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte = this.gesamtPunkte + this.rundenErgebnis;
    }
    public boolean hatGewonnen() {
        if (this.gesamtPunkte >= 100) {
            return true;
        }
        return false;
    }
    public boolean hatVerloren() {
        if (0 >= this.gesamtPunkte) {
            return true;
        }
        return false;
    }

}