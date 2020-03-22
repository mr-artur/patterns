package ua.kpi.arturo.patterns.thirteen_delegate;

public class Main {

    public static void main(String... args) {
        // alternative - Visitor
        Human human = new Human();
        WritingDevice pen = new Pen();
        human.setDevice(pen);
        human.write("Kyiv is the capital of Ukraine");
    }
}

interface WritingDevice {

    void write(String text);
}

class Pen implements WritingDevice {

    @Override
    public void write(String text) {
        System.out.println("Ручка пишет текст : " + text);
    }
}

class Human {
    WritingDevice device;

    public void setDevice(WritingDevice device) {
        this.device = device;
    }

    public void write(String text) {
        System.out.println("Пишем с помощью девайса текст :");
        device.write(text);
    }
}
