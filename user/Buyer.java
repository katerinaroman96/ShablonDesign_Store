package store.user;

import store.Checkable;
import store.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Buyer extends User implements Checkable {

    private final String login;
    private final String pass;

    public Buyer(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Override
    public void productsShow(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void checkDate(List<Product> list) {
        int counter = 0;
        for (Product product : list) {
            if (!product.getDate()) {
                System.out.println(product + " имеет истекший срок годности.");
                counter++;
            }
        }
        System.out.println(counter + " продуктов имеют истекший срок годности.");
    }

    @Override
    public List<Product> productsAdd(Scanner scanner, List<Product> list) {
        List<Product> newList = new ArrayList<>();
        while (true) {
            boolean count = false;
            Iterator<Product> iterator = list.iterator();
            System.out.println("Введите наименование товара, который хотите положить в корзину. " +
                    "Для выхода введите 0.");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(input)) {
                        newList.add(list.get(i));
                        count = true;
                    }
                }
            }
            if (!count) {
                System.out.println("Такого продукта нет в наличии.");
            }
        }
        return newList;
    }
}
