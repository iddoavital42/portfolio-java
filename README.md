# 📦 Inventory Manager (Java + Swing)

This is a simple desktop application built with **Java** and **Swing** to manage product inventory. It allows users to add, remove, search, and update products, as well as save and load data from a file.

---

## ✨ Features

- Add new products with ID, name, quantity, and price
- Remove existing products by ID
- Search for products by ID
- Update product details
- View all current products
- Save inventory to a `.txt` file
- Load inventory from a `.txt` file
- Clean and intuitive **Swing GUI**

---

## 🛠️ Technologies Used

- Java 19+
- Swing (Java GUI library)
- File I/O (Read/Write from `.txt`)

---

## 📁 File Structure

```bash
InventoryManager/
├── Product.java             # Represents a single product
├── Inventory.java           # Manages list of products and file operations
├── InventoryManager.java    # GUI application with Swing
├── products.txt             # Inventory data file (created at runtime)
└── README.md                # Project documentation
