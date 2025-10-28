import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            TaskModelInterface model = new TaskModel();
            ToDoViewInterface view = new ToDoView(model.getListModel());
            new ToDoController(model, view);

            view.setVisible(true);
        });
    }
}