package services.imp;

import enums.CategoryEnum;
import models.Order;
import models.Product;
import models.Customer;
import services.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderImp implements OrderService {

    private List<Order> orderList = new ArrayList<>();
    @Override
    public List<Order> getProductsByBabyCategory() {
        return orderList.stream()
                .filter(order -> isBabyCategory(order.getProducts()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCustomerLevelAndDates(int customerLevel, LocalDate startDate, LocalDate endDate) {
        return orderList.stream()
                .filter(order -> order.getCustomer().getTier()==customerLevel)
                .filter(order ->order.getDeliveryDate().isAfter(startDate) && order.getDeliveryDate().isBefore(endDate))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
    }

    @Override
    public void fillOrderArrayList() {
        List<Product> productosOrden1 = new ArrayList<>();
        productosOrden1.add(new Product(1L,"Ropa bebé",CategoryEnum.BABYS.getNameCategory(),50));
        productosOrden1.add(new Product(2L,"Tetero",CategoryEnum.BABYS.getNameCategory(),20));
        Customer customer1 = new Customer(1L,"Juan",2);
        orderList.add(new Order(1,"1", LocalDate.of(2021,2,1), LocalDate.of(2021,2,1),productosOrden1,customer1 ));


    }

    @Override
    public List<Order> getMostRecentOrders() {
        return orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderDate))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Double calculateTotalByDate(LocalDate date) {
        return orderList.stream()
                .filter(order -> order.getOrderDate().equals(date))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.summingDouble(Product::getPrice));
    }

    boolean isBabyCategory(List<Product> products){ // Determina si alguno de los productos de una orden tiene la categoria bebé.
        return  products.stream()
                .anyMatch(product -> product.getCategory().equals(CategoryEnum.BABYS.getNameCategory()));
    }

}
