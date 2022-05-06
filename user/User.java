package store.user;

import store.Available;
import store.Product;

import java.util.List;
import java.util.Scanner;

public abstract class User implements Available {
    private String login;
    private String pass;

    public User() {
    }

    public User(String login, String pass) {
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
    public abstract List<Product> productsAdd(Scanner scanner, List<Product> list);
}
