 import java.util.*;
 import java.io.*;

 public class Inventory {
  private ArrayList<Product> products;

  public Inventory() {
    products = new ArrayList<Product>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void removeProduct(Product product) {
    products.remove(product);
  }

  public void updateProduct(Product product) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getId().equals(product.getId())) {
        products.set(i, product);
        break;
      }
    }
  }

  public Product getProduct(String id) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getId().equals(id)) {
        return products.get(i);
      }
    }
    return null;
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  public void saveToFile(String filename) {
    try {
      FileWriter writer = new FileWriter(filename);
      for (int i = 0; i < products.size(); i++) {
        writer.write(products.get(i).getId() + "," + products.get(i).getName() + "," + products.get(i).getQuantity() + "," + products.get(i).getPrice() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Error saving inventory to file: " + e.getMessage());
    }
  }
  public void loadFromFile(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        String id = parts[0];
        String name = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        double price = Double.parseDouble(parts[3]);
        Product product = new Product(id, name, quantity, price);
        products.add(product);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Error loading inventory from file: " + e.getMessage());
    }
  }
}