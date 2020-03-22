package ua.kpi.arturo.patterns.eight_composite;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        Pizza pizza = new Pizza(2);
        Sellable ham = new Ham(300, 1);
        Sellable pineapples = new Pineapple(50, 2);
        pizza.addComponent(ham);
        pizza.addComponent(pineapples);
        System.out.println(pizza.getPrice());
    }
}

interface Sellable {

    int getPrice();
}

class Ham implements Sellable {

    private int grams;
    private int pricePerGram;

    public Ham(int grams, int pricePerGram) {
        this.grams = grams;
        this.pricePerGram = pricePerGram;
    }

    @Override
    public int getPrice() {
        return grams * pricePerGram;
    }
}

class Pineapple implements Sellable {

    private int pricePerOne;
    private int quantity;

    public Pineapple(int pricePerOne, int quantity) {
        this.pricePerOne = pricePerOne;
        this.quantity = quantity;
    }

    @Override
    public int getPrice() {
        return pricePerOne * quantity;
    }
}

class Pizza implements Sellable {

    private int markup;
    private List<Sellable> components = new ArrayList<>();

    public Pizza(int markup) {
        this.markup = markup;
    }

    public void addComponent(Sellable component) {
        components.add(component);
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (Sellable component : components) {
            price += component.getPrice();
        }
        return price * markup;
    }
}
