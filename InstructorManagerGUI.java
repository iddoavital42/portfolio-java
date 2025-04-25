import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Instructor implements Serializable {
    private String name;
    private String id;
    private String specialization;

    public Instructor(String name, String id, String specialization) {
        this.name = name;
        this.id = id;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getSpecialization() { return specialization; }

    public String toString() {
        return name + " | " + id + " | " + specialization;
    }
}

class Head {
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private final String FILE_NAME = "instructors.dat";

    public void addInstructor(Instructor i) {
        instructors.add(i);
    }

    public boolean deleteById(String id) {
        return instructors.removeIf(i -> i.getId().equals(id));
    }

    public Instructor searchById(String id) {
        for (Instructor i : instructors) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }

    public ArrayList<Instructor> getAll() {
        return instructors;
    }

    public void saveToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(instructors);
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            instructors = (ArrayList<Instructor>) ois.readObject();
        } catch (Exception e) {
            instructors = new ArrayList<>();
        }
    }
}

public class InstructorManagerGUI extends JFrame {
    private Head head = new Head();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> instructorList = new JList<>(listModel);

    private JTextField nameField = new JTextField();
    private JTextField idField = new JTextField();
    private JTextField specField = new JTextField();

    public InstructorManagerGUI() {
        head.loadFromFile();
        setTitle("Instructor Manager");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("ID:"));
        form.add(idField);
        form.add(new JLabel("Specialization:"));
        form.add(specField);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete by ID");
        JButton saveButton = new JButton("Save");

        form.add(addButton);
        form.add(deleteButton);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(instructorList), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        refreshList();

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            String spec = specField.getText();
            if (!name.isEmpty() && !id.isEmpty() && !spec.isEmpty()) {
                head.addInstructor(new Instructor(name, id, spec));
                refreshList();
                nameField.setText("");
                idField.setText("");
                specField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter ID to delete:");
            if (id != null && head.deleteById(id)) {
                refreshList();
            } else {
                JOptionPane.showMessageDialog(this, "Instructor not found.");
            }
        });

        saveButton.addActionListener(e -> {
            try {
                head.saveToFile();
                JOptionPane.showMessageDialog(this, "Saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving.");
            }
        });

        setVisible(true);
    }

    private void refreshList() {
        listModel.clear();
        for (Instructor i : head.getAll()) {
            listModel.addElement(i.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InstructorManagerGUI::new);
    }
}
