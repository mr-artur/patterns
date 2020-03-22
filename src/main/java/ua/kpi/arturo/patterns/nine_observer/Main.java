package ua.kpi.arturo.patterns.nine_observer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        Observable typography = new Typography();
        Observer mailbox1 = new Mailbox("Михаил");
        Observer mailbox2 = new Mailbox("Евгений");
        Observer mailbox3 = new Mailbox("Анатолий");
        typography.addObserver(mailbox1);
        typography.addObserver(mailbox2);
        typography.addObserver(mailbox3);
        typography.printRun();
    }
}

interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void printRun();
}

class Typography implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private List<String> newspapers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void printRun() {
        System.out.println("Печатаем тираж...");
        for (int i = 0; i < 10; i++) {
            newspapers.add("Новая газета #" + i);
        }
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            if (newspapers.isEmpty()) break;
            observers.get(i).getNewspaper(newspapers.remove(0));
        }
    }
}

interface Observer {

    void getNewspaper(String newspaper);
}

class Mailbox implements Observer {

    private String ownerName;

    public Mailbox(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public void getNewspaper(String newspaper) {
        System.out.println("Газета получена адресатом " + ownerName + ": " + newspaper);
    }
}
