package ua.kpi.arturo.patterns.five_builder_factory_method;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        Salad salad = SaladBuilder.Builder(new IngredientFactory(2, 2))
            .addIngredient("potato")
            .addIngredient("potato")
            .addIngredient("potato")
            .addIngredient("carrot")
            .addIngredient("carrot")
            .addIngredient("carrot")
            .addIngredient("carrot")
            .build();
        salad.showIngredients();
    }
}

interface Ingredient {
}

class Carrot implements Ingredient {

    @Override
    public String toString() {
        return "One carrot";
    }
}

class Potato implements Ingredient {

    @Override
    public String toString() {
        return "One potato";
    }
}

class IngredientFactory {

    private int carrotCount;
    private int potatoCount;

    public IngredientFactory(int carrotCount, int potatoCount) {
        this.carrotCount = carrotCount;
        this.potatoCount = potatoCount;
    }

    public Ingredient makeIngredient(String name) throws Exception {
        switch (name) {
            case "carrot":
                if (carrotCount > 0) {
                    carrotCount--;
                    return new Carrot();
                }
                throw new Exception("No carrots available");
            case "potato":
                if (potatoCount > 0) {
                    potatoCount--;
                    return new Potato();
                }
                throw new Exception("No potatoes available");
            default:
                throw new Exception("Unknown type");
        }
    }
}

class Salad {

    private List<Ingredient> ingredients = new ArrayList<>();

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void showIngredients() {
        System.out.println("Salad ingredients: ");
        ingredients.forEach(System.out::println);
    }
}

class SaladBuilder {

    private IngredientFactory factory;
    private List<Ingredient> ingredients = new ArrayList<>();

    private SaladBuilder(IngredientFactory factory) {
        this.factory = factory;
    }

    public static SaladBuilder Builder(IngredientFactory factory) {
        return new SaladBuilder(factory);
    }

    public SaladBuilder addIngredient(String name) {
        try {
            ingredients.add(factory.makeIngredient(name));
        } catch (Exception e) {
            System.out.println("No more ingredient : " + name);
        }
        return this;
    }

    public Salad build() {
        Salad salad = new Salad();
        salad.setIngredients(ingredients);
        return salad;
    }
}
