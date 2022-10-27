package ArrayList;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class PojoArrayList {
    public static void main (String [] args) {
        ArrayList<Product> productArrayList = new ArrayList<Product>(); //Accepts only String Name List.add("person1")

        Product product1 = new Product();
        product1.setPrice(200.50);
        product1.setName("Nike");

        Product product2 = new Product();
        product2.setPrice(250.00);
        product2.setName("Adidas");

        Product product3 = new Product();
        product3.setPrice(280.50);
        product3.setName("Puma");

        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);

        Collections.sort(productArrayList, new PriceComparator());
        for (Product product : productArrayList) {
            System.out.println("Shoe Brand: " + product.getName() + " at the price of $" + product.getPrice());
        }
    }
}

class PriceComparator implements Comparator <Product> {
    @Override
    public int compare (Product s1, Product s2) {
        return Double.compare(s1.getPrice(), s2.getPrice());
    }
}
