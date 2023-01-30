package services;

import models.Customer;
import models.Order;
import models.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getProductsByBabyCategory();
    List<Product> getProductsByCustomerLevelAndDates(int customerLevel, LocalDate startDate, LocalDate endDate);
    void fillOrderArrayList();
    List<Order> getMostRecentOrders();
    Double calculateTotalByDate(LocalDate date);
    Double calculateAveragePayByDate(LocalDate date);
    Map<Customer,List<Order>> mapOrdersGroupedByClient();
}
