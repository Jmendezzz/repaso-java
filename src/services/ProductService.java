package services;

import models.Product;
import java.util.List;

public interface ProductService {
    void createProduct (String name, String category, double price);
    List<Product> filterBooks();
    List<Product> getToysAndApplyDiscount();
    List<Product> getMostEconomicBooks();
    void fillProductArrayList();
    List<Product> getProductsMostExpensiveByCategory();
}
