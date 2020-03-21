package ua.kpi.arturo.patterns.seventh_factory_method;

import java.time.LocalDateTime;

public class Main {

    public static void main(String... args) {
        WatchMaker watchMaker = new DigitalWatchMaker();
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(LocalDateTime.now() + " - время сейчас");
    }
}

class MechanicalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + " - время сейчас");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class MechanicalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new MechanicalWatch();
    }
}
