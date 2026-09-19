package view;

import controller.GewinnController;
import model.GewinnModel;

import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    private JLabel rundenTitelLabel;
    private JLabel punkteTitelLabel;
    private JLabel rundenWertLabel;
    private JLabel punkteWertLabel;

    private JLabel deineZahlLabel;
    private JLabel computerLabel;
    private JTextField spielerFeld;
    private JTextField computerFeld;

    private JButton nochEinmalButton;

    public GewinnView() {
        super("Zahlen-Gewinnspiel (v1.0)");
        baueGuiAuf();
    }

    private void baueGuiAuf() {
        Font labelFont = new Font("SansSerif", Font.PLAIN, 18);
        Font anzeigeFont = new Font("SansSerif", Font.BOLD, 22);
        Font zahlFont = new Font("SansSerif", Font.BOLD, 42);

        rundenTitelLabel = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        rundenTitelLabel.setFont(labelFont);
        punkteTitelLabel = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
        punkteTitelLabel.setFont(labelFont);

        rundenWertLabel = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        rundenWertLabel.setFont(anzeigeFont);
        rundenWertLabel.setOpaque(true);
        rundenWertLabel.setBackground(Color.WHITE);

        punkteWertLabel = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        punkteWertLabel.setFont(anzeigeFont);
        punkteWertLabel.setOpaque(true);
        punkteWertLabel.setBackground(Color.WHITE);

        deineZahlLabel = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        deineZahlLabel.setFont(labelFont);
        computerLabel = new JLabel("Computer:", SwingConstants.CENTER);
        computerLabel.setFont(labelFont);

        spielerFeld = new JTextField();
        spielerFeld.setFont(zahlFont);
        spielerFeld.setHorizontalAlignment(JTextField.CENTER);
        spielerFeld.setBackground(Color.WHITE);

        computerFeld = new JTextField();
        computerFeld.setFont(zahlFont);
        computerFeld.setHorizontalAlignment(JTextField.CENTER);
        computerFeld.setEditable(false);
        computerFeld.setBackground(Color.WHITE);

        nochEinmalButton = new JButton("Noch einmal!");
        nochEinmalButton.setEnabled(false);
        nochEinmalButton.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JPanel rasterPanel = new JPanel(new GridLayout(4, 2, 10, 8));
        rasterPanel.add(rundenTitelLabel);
        rasterPanel.add(punkteTitelLabel);
        rasterPanel.add(rundenWertLabel);
        rasterPanel.add(punkteWertLabel);
        rasterPanel.add(deineZahlLabel);
        rasterPanel.add(computerLabel);
        rasterPanel.add(spielerFeld);
        rasterPanel.add(computerFeld);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nochEinmalButton);

        JPanel hauptPanel = new JPanel(new BorderLayout(10, 10));
        hauptPanel.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        hauptPanel.add(rasterPanel, BorderLayout.CENTER);
        hauptPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(hauptPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520, 320);
        this.setLocationRelativeTo(null);
    }

    public String getEingabeText() {
        return spielerFeld.getText();
    }
    public void registriereController(GewinnController controller) {
        spielerFeld.addActionListener(e -> controller.verarbeiteEingabe());
        nochEinmalButton.addActionListener(e -> controller.verarbeiteNochEinmal());
    }

    public void aktualisiere(GewinnModel model) {
        computerFeld.setText("" + model.getComputerZahl());

        if (model.hatVerloren()) {
            rundenWertLabel.setText("Verloren");
        } else if (model.hatGewonnen()) {
            rundenWertLabel.setText("Gewonnen");
        } else {
            int ergebnis = model.getRundenErgebnis();
            if (ergebnis > 0) {
                rundenWertLabel.setText("+" + ergebnis);
            } else {
                rundenWertLabel.setText("" + ergebnis);
            }
        }
        if (model.hatGewonnen() || model.getRundenErgebnis() > 0) {
            rundenWertLabel.setBackground(Color.GREEN);
            punkteWertLabel.setBackground(Color.GREEN);
        } else if (model.hatVerloren() || model.getRundenErgebnis() < 0) {
            rundenWertLabel.setBackground(Color.RED);
            punkteWertLabel.setBackground(Color.RED);
        } else {
            rundenWertLabel.setBackground(Color.WHITE);
            punkteWertLabel.setBackground(Color.WHITE);
        }

        punkteWertLabel.setText("" + model.getGesamtPunkte());
        spielerFeld.setEnabled(false);
        nochEinmalButton.setEnabled(true);
    }
    public void reset(int gesamtPunkte) {
        spielerFeld.setText("");
        computerFeld.setText("");
        rundenWertLabel.setText("Tippe eine Zahl von 1 bis 9");
        punkteWertLabel.setText("Gesamtpunkte: " + gesamtPunkte);
        rundenWertLabel.setBackground(Color.WHITE);
        punkteWertLabel.setBackground(Color.WHITE);
        spielerFeld.setEnabled(true);
        nochEinmalButton.setEnabled(false);
    }

    public void zeigeFehler(String meldung) {
        rundenWertLabel.setText(meldung);
    }
}