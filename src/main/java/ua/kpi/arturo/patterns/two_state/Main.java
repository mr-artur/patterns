package ua.kpi.arturo.patterns.two_state;

import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {
        Human human = new Human();
        human.setState(new Homebody());
        IntStream.range(0, 8).forEach(i -> human.doSomething());
    }
}

interface HumanState {

    void doSomething(Human context);
}

class Hunter implements HumanState {

    @Override
    public void doSomething(Human context) {
        showState();
        System.out.println("Пошел на рыбалку");
        context.setState(new Fisherman());
    }

    private void showState() {
        System.out.println("Теперь я охотник");
    }
}

class Fisherman implements HumanState {

    @Override
    public void doSomething(Human context) {
        showState();
        System.out.println("Пошел за грибами");
        context.setState(new Mushroomer());
    }

    private void showState() {
        System.out.println("Теперь я рыбак");
    }
}

class Mushroomer implements HumanState {

    @Override
    public void doSomething(Human context) {
        showState();
        System.out.println("Пошел домой");
        context.setState(new Homebody());
    }

    private void showState() {
        System.out.println("Теперь я грибник");
    }
}

class Homebody implements HumanState {

    @Override
    public void doSomething(Human context) {
        showState();
        System.out.println("Пошел на охоту");
        context.setState(new Hunter());
    }

    private void showState() {
        System.out.println("Теперь я домосед");
    }
}

class Human {

    private HumanState state;

    public void setState(HumanState state) {
        this.state = state;
    }

    public void doSomething(){
        state.doSomething(this);
    }
}
