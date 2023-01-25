package services.imp;
import enums.CategoryEnum;
import services.ProductService;
import models.Product;
import java.util.List;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProductImp implements ProductService {
    private List<Product> productList = new ArrayList<>();
    @Override
    public void createProduct(String name, String category, double price) {

        Long id  = (long) (Math.round(Math.random()*100));
        System.out.println(id);
        while(isRepeatedId(id)){
            id  = (long) (Math.round(Math.random()*100));
        }
        productList.add(new Product(id,name,category,price));
        System.out.println("Producto añadido");


    }

    @Override
    public List<Product> filterBooks() {
        return productList.stream()
                .filter(product -> product.getCategory().equals(CategoryEnum.BOOKS.getNameCategory()))
                .filter( product ->  product.getPrice()>100)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getToysAndApplyDiscount() {
        return productList.stream()
                .filter(product -> product.getCategory().equals(CategoryEnum.TOYS.getNameCategory()))
                .map(product -> {
                    product.setPrice(product.getPrice()-product.getPrice()*0.1);
                    return product;
                })
                .collect(Collectors.toList());
    }

    boolean isRepeatedId (Long id ){

        for(Product product : productList){
            if(product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
