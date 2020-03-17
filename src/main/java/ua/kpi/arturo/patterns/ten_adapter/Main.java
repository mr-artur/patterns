package ua.kpi.arturo.patterns.ten_adapter;

public class Main {

    public static void main(String... args) {
        DVAConnectorInterface connector = new DVAAdapterFromSVGA();
        connector.sendMediaViaDVA();

        DVAConnectorInterface connector2 = new DVAAdapterFromSVGA2();
        connector2.sendMediaViaDVA();
    }
}

interface DVAConnectorInterface {
    void sendMediaViaDVA();
}

class SVGAConnector {
    void sendMediaViaSVGA() {
        System.out.println("Sending via SVGA");
    }
}

class DVAAdapterFromSVGA extends SVGAConnector implements DVAConnectorInterface {

    @Override
    public void sendMediaViaDVA() {
        sendMediaViaSVGA();
    }
}

class DVAAdapterFromSVGA2 implements DVAConnectorInterface {
    SVGAConnector svgaConnector = new SVGAConnector();

    @Override
    public void sendMediaViaDVA() {
        svgaConnector.sendMediaViaSVGA();
    }
}
