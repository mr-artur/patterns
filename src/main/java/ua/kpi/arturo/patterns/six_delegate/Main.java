package ua.kpi.arturo.patterns.six_delegate;

public class Main {

    public static void main(String... args) {
        Secretary secretary = new Secretary();
        Subordinate subordinate = new Subordinate("Марк");
        secretary.setSubordinate(subordinate);

        secretary.makeSubordinateGoToDirector();
        secretary.makeSubordinateGoToAccountant();
        secretary.makeSubordinateGoToWarehouse();
        secretary.makeSubordinateGoToCurator();
    }
}

class Subordinate {

    private String name;

    public Subordinate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goToDirector() {
        System.out.println(name + " идет к директору");
    }

    public void goToAccountant() {
        System.out.println(name + " идет к бухгалтеру");
    }

    public void goToWarehouse() {
        System.out.println(name + " идет на склад");
    }

    public void goToCurator() {
        System.out.println(name + " идет к куратору");
    }
}

class Secretary {

    private Subordinate subordinate;

    public void setSubordinate(Subordinate subordinate) {
        this.subordinate = subordinate;
    }

    public void makeSubordinateGoToDirector() {
        System.out.println("Сказал подчиненному с именем " + subordinate.getName() + " идти к директору");
        subordinate.goToDirector();
    }

    public void makeSubordinateGoToAccountant() {
        System.out.println("Сказал подчиненному с именем " + subordinate.getName() + " идти к бухгалтеру");
        subordinate.goToAccountant();
    }

    public void makeSubordinateGoToWarehouse() {
        System.out.println("Сказал подчиненному с именем " + subordinate.getName() + " идти на склад");
        subordinate.goToWarehouse();
    }

    public void makeSubordinateGoToCurator() {
        System.out.println("Сказал подчиненному с именем " + subordinate.getName() + " идти к куратору");
        subordinate.goToCurator();
    }
}
