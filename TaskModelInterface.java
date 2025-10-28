import javax.swing.DefaultListModel;

public interface TaskModelInterface {
    DefaultListModel<String> getListModel();
    void addTask(String task);
    void removeTasks(int[] indices);
    void loadTasks();
    void saveTasks();
}