import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public interface ToDoViewInterface {
    String getTaskInput();
    void clearTaskInput();
    int[] getSelectedIndices();
    void addAddTaskListener(ActionListener listener);
    void addDeleteTaskListener(ActionListener listener);
    void addWindowListener(WindowListener listener);
    void setVisible(boolean visible);
}