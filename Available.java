package store;

import java.util.List;
import java.util.Scanner;

public interface Available {
    void productsShow(List<Product> products);
    List<Product> productsAdd(Scanner scanner, List<Product> list);
}
