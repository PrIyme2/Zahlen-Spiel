package model;

/**
 * Modelliert die Spiellogik und verwaltet den Punktestand des Gewinnspiels.
 *
 * @author Fateh Arafa
 * @version 15.09
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    /**
     * Initialisiert ein neues Spiel mit 30 Startpunkten.
     */
    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    /**
     * Gibt den aktuellen Gesamtpunktestand zurück.
     *
     * @return der aktuelle Gesamtpunktestand
     */
    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }

    /**
     * Gibt die vom Computer gezogene Zufallszahl zurück.
     *
     * @return die gezogene Computerzahl
     */
    public int getComputerZahl() {
        return this.computerZahl;
    }

    /**
     * Gibt die vom Spieler eingegebene Zahl zurück.
     *
     * @return die eingegebene Spielerzahl
     */
    public int getSpielerZahl() {
        return this.spielerZahl;
    }

    /**
     * Gibt den Punktegewinn oder Punktverlust der letzten Runde zurück.
     *
     * @return das Rundenergebnis in Punkten
     */
    public int getRundenErgebnis() {
        return this.rundenErgebnis;
    }

    /**
     * Ermittelt eine neue Zufallszahl zwischen 1 und 9 für den Computer.
     */
    public void berechneComputerZahl() {
        int r = (int) (Math.random() * 9) + 1;
        this.computerZahl = r;
    }

    /**
     * Berechnet den Ausgang der Runde und passt die Gesamtpunkte an.
     */
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

    /**
     * Prüft, ob der Spieler mindestens 100 Punkte erreicht hat.
     *
     * @return true wenn das Spiel gewonnen ist, sonst false
     */
    public boolean hatGewonnen() {
        if (this.gesamtPunkte >= 100) {
            return true;
        }
        return false;
    }

    /**
     * Prüft, ob die Gesamtpunkte auf oder unter 0 Punkte gefallen sind.
     *
     * @return true wenn das Spiel verloren ist, sonst false
     */
    public boolean hatVerloren() {
        if (0 >= this.gesamtPunkte) {
            return true;
        }
        return false;
    }

}