package ua.kpi.arturo.patterns.one_state;

public class Main {

    public static void main(String... args) {
        Human human = new Human();
        human.showCurrentState();

        human.goHunting();
        human.showCurrentState();

        human.goFishing();
        human.showCurrentState();

        human.goPickMushrooms();
        human.showCurrentState();
    }
}

interface HumanState {

    void showState();
}

class Hunter implements HumanState {

    @Override
    public void showState() {
        System.out.println("Теперь я охотник");
    }
}

class Fisherman implements HumanState {

    @Override
    public void showState() {
        System.out.println("Теперь я рыбак");
    }
}

class Mushroomer implements HumanState {

    @Override
    public void showState() {
        System.out.println("Теперь я грибник");
    }
}

class Homebody implements HumanState {

    @Override
    public void showState() {
        System.out.println("Теперь я домосед");
    }
}

class Human {

    private HumanState state;

    public Human() {
        goHome();
    }

    public void setState(HumanState state) {
        this.state = state;
    }

    public void goHunting() {
        System.out.println("Пошел на охоту");
        setState(new Hunter());
    }

    public void goFishing() {
        System.out.println("Пошел на рыбалку");
        setState(new Fisherman());
    }

    public void goPickMushrooms() {
        System.out.println("Пошел за грибами");
        setState(new Mushroomer());
    }

    public void goHome() {
        System.out.println("Пошел домой");
        setState(new Homebody());
    }

    public void showCurrentState() {
        state.showState();
    }
}
