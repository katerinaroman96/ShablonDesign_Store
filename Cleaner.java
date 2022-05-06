package store;

import java.util.List;

public class Cleaner {

    public void deleteSpoiledProduct(List<Product> listOfAllProducts, List<Product> listForDelete) {
        for (Product product : listForDelete) {
            listOfAllProducts.remove(product);
        }
    }
}
