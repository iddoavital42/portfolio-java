 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InventoryManager extends JFrame {
    private Inventory inventory;
    private JTextField idField, nameField, quantityField, priceField;
    private JTextArea outputArea;

    public InventoryManager() {
        inventory = new Inventory();
        setTitle("Inventory Manager");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        add(inputPanel, BorderLayout.NORTH);
 
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton findButton = new JButton("Find");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(findButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.CENTER);

      
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

         
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            inventory.addProduct(new Product(id, name, quantity, price));
            showMessage("Product added.");
            clearFields();
        });

        removeButton.addActionListener(e -> {
            String id = idField.getText();
            Product p = inventory.getProduct(id);
            if (p != null) {
                inventory.removeProduct(p);
                showMessage("Product removed.");
            } else {
                showMessage("Product not found.");
            }
            clearFields();
        });

        findButton.addActionListener(e -> {
            String id = idField.getText();
            Product p = inventory.getProduct(id);
            if (p != null) {
                nameField.setText(p.getName());
                quantityField.setText(String.valueOf(p.getQuantity()));
                priceField.setText(String.valueOf(p.getPrice()));
                showMessage("Product found.");
            } else {
                showMessage("Product not found.");
            }
        });

        saveButton.addActionListener(e -> {
            inventory.saveToFile("products.txt");
            showMessage("Saved to file.");
        });

        loadButton.addActionListener(e -> {
            inventory.loadFromFile("products.txt");
            showAllProducts();
        });

        setVisible(true);
    }

    private void showMessage(String message) {
        outputArea.setText(message);
    }

    private void showAllProducts() {
        StringBuilder sb = new StringBuilder();
        for (Product p : inventory.getProducts()) {
            sb.append(p.toString()).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryManager());
    }
}
