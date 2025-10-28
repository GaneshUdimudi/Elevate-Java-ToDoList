import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class ToDoView extends JFrame implements ToDoViewInterface {
    private final JList<String> taskList;
    private final JTextField taskInputField;
    private final JButton addButton;
    private final JButton deleteButton;

    public ToDoView(DefaultListModel<String> model) {
        setTitle("To-Do App (Polished)");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        taskList = new JList<>(model);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        taskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        taskInputField = new JTextField();
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected");
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Your Tasks"));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(taskInputField, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public String getTaskInput() { return taskInputField.getText(); }

    @Override
    public void clearTaskInput() {
        taskInputField.setText("");
        taskInputField.requestFocusInWindow();
    }

    @Override
    public int[] getSelectedIndices() { return taskList.getSelectedIndices(); }

    @Override
    public void addAddTaskListener(ActionListener listener) {
        addButton.addActionListener(listener);
        taskInputField.addActionListener(listener);
    }

    @Override
    public void addDeleteTaskListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}