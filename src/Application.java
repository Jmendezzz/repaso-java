import services.imp.CustomerImp;
import services.imp.OrderImp;
import services.imp.ProductImp;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ProductImp productService = new ProductImp();
        productService.fillProductArrayList();

        OrderImp orderService = new OrderImp();


        CustomerImp customerService = new CustomerImp();


        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("Escoja una opción: \n" +
                    "1.Obtener una lista de productos pertenecientes a la categoría “Libros” con precio > 100\n" +
                    "2.Obtener una lista de pedidos con productos pertenecientes a la categoría 'Bebé' \n " +
                    "3.Obtenga una lista de productos con categoría = \"Juguetes\" y luego aplique un 10% de descuento\n" +
                    "4.Obtenga una lista de productos pedidos por el cliente del nivel 2 entre el 01 de febrero de 2021 y el 01 de abril de 2021\n" +
                    "5.Consigue los productos más baratos de la categoría “Libros”");
            option = sc.nextInt();
            switch (option){
                case 1:

                    break;

            }

        }while (option!=0)
        ;
    }
}