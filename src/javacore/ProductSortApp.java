package javacore;
import java.util.*;

class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String productType;
    private String productCategory;
    private double productPrice;

    public Product(int productId, String productName, String productType, String productCategory, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "Product [id=" + productId + ", name=" + productName + ", type=" + productType + ", category=" + productCategory + ", price=" + productPrice + "]";
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
}

class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        int categoryComparison = p1.getProductCategory().compareTo(p2.getProductCategory());
        if (categoryComparison == 0) {
            return Double.compare(p1.getProductPrice(), p2.getProductPrice());
        }
        return categoryComparison;
    }
}

public class ProductSortApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Product> products = new TreeSet<>(new ProductComparator());

        while (true) {
            System.out.println("Enter the product details:");

            System.out.print("Enter product id: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter product type: ");
            String productType = scanner.nextLine();

            System.out.print("Enter product category: ");
            String productCategory = scanner.nextLine();

            System.out.print("Enter product price: ");
            double productPrice = scanner.nextDouble();

            Product product = new Product(productId, productName, productType, productCategory, productPrice);
            if (!products.contains(product)) {
                products.add(product);
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Product with the same ID already exists. Use a different ID.");
            }

            System.out.print("Do you want to enter another product? (yes/no): ");
            String continueInput = scanner.next();
            if (!continueInput.equalsIgnoreCase("yes")) {
                break;
            }
            scanner.nextLine(); // Consume newline
        }

        System.out.println("\nSorted Product List:");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.print("\nEnter the product ID to delete: ");
        int deleteProductId = scanner.nextInt();
        boolean removed = false;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getProductId() == deleteProductId) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Product with ID " + deleteProductId + " has been deleted.");
        } else {
            System.out.println("Product with ID " + deleteProductId + " not found.");
        }
        scanner.close();

    }
}
