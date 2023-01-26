package services;

import models.Order;
import models.Product;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<Order> getProductsByBabyCategory();
    List<Product> getProductsByCustomerLevelAndDates(int customerLevel, LocalDate startDate, LocalDate endDate);
    void fillOrderArrayList();
}
