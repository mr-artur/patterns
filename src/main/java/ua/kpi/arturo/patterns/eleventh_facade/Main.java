package ua.kpi.arturo.patterns.eleventh_facade;

public class Main {

    public static void main(String... args) {
        Computer computer = new Computer();
        computer.switchOn();
        computer.switchOff();
    }
}

class Computer {

    Power power = new Power();
    ComputerSystem system = new ComputerSystem();
    Monitor monitor = new Monitor();

    void switchOn() {
        power.switchOn();
        system.load();
        monitor.switchOn();
        system.authorize();
    }

    void switchOff() {
        system.finishWork();
        monitor.switchOff();
        power.switchOff();
    }
}

class Power {

    void switchOn() {
        System.out.println("Power is on");
    }

    void switchOff() {
        System.out.println("Power is off");
    }
}

class ComputerSystem {

    void load() {
        System.out.println("System was loaded");
    }

    void authorize() {
        System.out.println("Auth was successful");
    }

    void finishWork() {
        System.out.println("Closing all applications");
    }
}

class Monitor {

    void switchOn() {
        System.out.println("Monitor is on");
    }

    void switchOff() {
        System.out.println("Monitor is off");
    }
}
