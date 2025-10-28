import javax.swing.DefaultListModel;
import java.io.*;
import java.util.Collections;

public class TaskModel implements TaskModelInterface {
    private static final String TASKS_FILE = "tasks.txt";
    private final DefaultListModel<String> listModel;

    public TaskModel() {
        this.listModel = new DefaultListModel<>();
    }

    @Override
    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    @Override
    public void addTask(String task) {
        if (task != null && !task.trim().isEmpty()) {
            listModel.addElement(task.trim());
        }
    }

    @Override
    public void removeTasks(int[] indices) {
        for (int i = indices.length - 1; i >= 0; i--) {
            listModel.remove(indices[i]);
        }
    }

    @Override
    public void loadTasks() {
        File file = new File(TASKS_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TASKS_FILE))) {
            for (Object task : Collections.list(listModel.elements())) {
                writer.write((String) task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}