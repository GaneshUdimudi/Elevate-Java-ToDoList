import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ToDoController {
    private final TaskModelInterface model;
    private final ToDoViewInterface view;

    public ToDoController(TaskModelInterface model, ToDoViewInterface view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        model.loadTasks();
        view.addAddTaskListener(e -> addTask());
        view.addDeleteTaskListener(e -> deleteTasks());

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                model.saveTasks();
            }
        });
    }

    private void addTask() {
        String task = view.getTaskInput();
        if (task.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
        } else {
            model.addTask(task);
            view.clearTaskInput();
        }
    }

    private void deleteTasks() {
        int[] selectedIndices = view.getSelectedIndices();
        if (selectedIndices.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select one or more tasks to delete.", "No Task Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + selectedIndices.length + " task(s)?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            model.removeTasks(selectedIndices);
        }
    }
}