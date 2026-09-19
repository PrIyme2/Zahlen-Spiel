package controller;

import model.GewinnModel;
import view.GewinnView;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model) {
        this.model = model;
    }

    public void setView(GewinnView view) {
        this.view = view;
    }

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

    public void verarbeiteNochEinmal() {
        if (this.view != null && this.model != null) {
            this.view.reset(this.model.getGesamtPunkte());
        }
    }
}