import controller.GewinnController;
import model.GewinnModel;
import view.GewinnView;

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