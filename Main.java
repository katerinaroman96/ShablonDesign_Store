package store;

import store.user.Buyer;
import store.user.Supplier;
import store.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supplier supplier = new Supplier("Катя ", "123");
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts = supplier.productsAdd(scanner, listOfProducts);
        Buyer buyer = new Buyer("Инна", "234");
        buyer.productsShow(listOfProducts);
        buyer.checkDate(listOfProducts);
        List<Product> newList = buyer.productsAdd(scanner, listOfProducts);
        System.out.println("Ваша корзина:");
        buyer.productsShow(newList);

    }


}
