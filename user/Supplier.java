package store.user;

import store.Checkable;
import store.Cleaner;
import store.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Supplier extends User implements Checkable {
    private final String login;
    private final String pass;
    private final int MAX = 10;

    public Supplier(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Override
    public void productsShow(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public List<Product> productsAdd(Scanner scanner, List<Product> list){
        Random random = new Random();
        while (true) {
            System.out.println("Введите наименование продукта и его количество через запятую. " +
                    "Для выхода введите 0.");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                try {
                    String[] product = input.split(", ");
                    String name = product[0];
                    int amount = Integer.parseInt(product[1]);
                    if (list.size() < MAX) {
                        list.add(new Product(name, amount, random.nextBoolean()));
                    } else {
                        System.out.println("Количество позиций товара не может превышать максимального значения - " +
                                MAX);
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Вы ввели некорректное значение!");
                }



            }
        }

        return list;
    }

    @Override
    public void checkDate(List<Product> listOfAllProducts) {
        Cleaner cleaner = new Cleaner();
        List<Product> listForDelete = new ArrayList<>();
        for (Product listOfAllProduct : listOfAllProducts) {
            if (!listOfAllProduct.getDate()) {
                listForDelete.add(listOfAllProduct);
            }
        }
        if (listForDelete.size() > 0) {
            cleaner.deleteSpoiledProduct(listOfAllProducts, listForDelete);
        }
    }
}
