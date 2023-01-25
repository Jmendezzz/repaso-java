package services.imp;

import enums.CategoryEnum;
import models.Order;
import models.Product;
import services.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
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

    boolean isBabyCategory(List<Product> products){ // Determina si alguno de los productos de una orden tiene la categoria bebé.
        return  products.stream()
                .anyMatch(product -> product.getCategory().equals(CategoryEnum.BABYS.getNameCategory()));
    }
}
