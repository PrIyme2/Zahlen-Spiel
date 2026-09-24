package controller;

import model.GewinnModel;
import view.GewinnView;

/**
 * Controller zur Steuerung des Spielablaufs im Zahlen-Gewinnspiel.
 * Verarbeitet Benutzereingaben und koordiniert Model und View.
 *
 * @author Fateh Arafa
 * @version 15.09
 */
public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    /**
     * Erzeugt einen neuen Controller mit dem angegebenen Model.
     */
    public GewinnController(GewinnModel model) {
        this.model = model;
    }

    /**
     * Weist dem Controller die zu steuernde View zu.
     */
    public void setView(GewinnView view) {
        this.view = view;
    }

    /**
     * Validiert die eingegebene Zahl, startet die Spielrunde und aktualisiert die View.
     */
    public void verarbeiteEingabe() {
        if (this.view == null || this.model == null) {
            return;
        }

        if (this.model.hatGewonnen() || this.model.hatVerloren()) {
            return;
        }

        String text = this.view.getEingabeText();
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        int zahl = 0;
        try {
            zahl = Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            this.view.zeigeFehler("Bitte eine Zahl von 1 bis 9 eingeben!");
            return;
        }

        if (zahl < 1 || zahl > 9) {
            this.view.zeigeFehler("Bitte eine Zahl von 1 bis 9 eingeben!");
            return;
        }

        this.model.berechneRunde(zahl);
        this.view.aktualisiere(this.model);
    }

    /**
     * Setzt die Anzeige für den Start einer weiteren Spielrunde zurück.
     */
    public void verarbeiteNochEinmal() {
        if (this.view != null && this.model != null) {
            this.view.reset(this.model.getGesamtPunkte());
        }
    }
}