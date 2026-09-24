import controller.GewinnController;
import model.GewinnModel;
import view.GewinnView;

/**
 * Startklasse für das Zahlen-Gewinnspiel.
 * Initialisiert Model, View sowie Controller und startet die Anwendung.
 *
 * @author Fateh Arafa
 * @version 15.09
 */
public class ZahlenSpiel {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnController controller = new GewinnController(model);
        GewinnView view = new GewinnView();
        controller.setView(view);
        view.registriereController(controller);
        view.setVisible(true);
    }
}