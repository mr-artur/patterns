package ua.kpi.arturo.patterns.four_state;

public class Main {

    public static void main(String... args) {
        Warplane warplane = new Warplane(new MachineGun(), AmmunitionState.NOT_AVAILABLE);
        warplane.shoot();
        warplane.addAmmunition();
        warplane.shoot();
        warplane.takeOff();
        warplane.shoot();
    }
}

interface Weapon {

    void shoot();
}

class MachineGun implements Weapon {

    @Override
    public void shoot() {
        System.out.println("Тататата из пулемета");
    }
}

class Rocket implements Weapon {

    @Override
    public void shoot() {
        System.out.println("Пупух ракета пошлаа");
    }
}

interface PlaneState {

    void showState();
}

class Flight implements PlaneState {

    @Override
    public void showState() {
        System.out.println("Самолет летит");
    }
}

class StayGround implements PlaneState {

    @Override
    public void showState() {
        System.out.println("Самолет находится на земле");
    }
}

enum AmmunitionState {
    AVAILABLE, NOT_AVAILABLE
}

class Warplane {

    private Weapon weapon;
    private PlaneState planeState;
    private AmmunitionState ammunitionState;

    public void setPlaneState(PlaneState planeState) {
        this.planeState = planeState;
    }

    public void setAmmunitionState(AmmunitionState ammunitionState) {
        this.ammunitionState = ammunitionState;
    }

    public Warplane(Weapon weapon, AmmunitionState ammunitionState) {
        setPlaneState(new StayGround());
        this.weapon = weapon;
        this.ammunitionState = ammunitionState;
    }

    public void shoot() {
        if (ammunitionState.equals(AmmunitionState.NOT_AVAILABLE)) {
            System.out.println("Нет боеприпасов, невозможно стрелять!");
            return;
        }
        if (planeState instanceof StayGround) {
            System.out.println("Самолет на земле, стрельба невозможна!");
            return;
        }
        weapon.shoot();
        useUpAmmunition();
    }

    public void takeOff() {
        setPlaneState(new Flight());
    }

    public void land() {
        setPlaneState(new StayGround());
    }

    private void useUpAmmunition() {
        setAmmunitionState(AmmunitionState.NOT_AVAILABLE);
    }

    public void addAmmunition() {
        setAmmunitionState(AmmunitionState.AVAILABLE);
    }
}
